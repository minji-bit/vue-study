package kr.co.wikibook.gallery.order.service;

import kr.co.wikibook.gallery.cart.service.CartService;
import kr.co.wikibook.gallery.item.dto.ItemRead;
import kr.co.wikibook.gallery.item.service.ItemService;
import kr.co.wikibook.gallery.order.dto.OrderRead;
import kr.co.wikibook.gallery.order.dto.OrderRequest;
import kr.co.wikibook.gallery.order.entity.Order;
import kr.co.wikibook.gallery.order.entity.OrderItem;
import kr.co.wikibook.gallery.order.repository.OrderItemRepository;
import kr.co.wikibook.gallery.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemService itemService;
    private final CartService cartService;
    private final OrderItemService orderItemService;

    @Override
    public List<OrderRead> findAll(Integer memberId) {
        return orderRepository.findAllByMemberIdOrderByIdDesc(memberId).stream().map(Order::toRead).toList();
    }

    @Override
    public OrderRead find(Integer id, Integer memberId) {
        Optional<Order> orderOptional = orderRepository.findByIdAndMemberId(id,memberId);

        if(orderOptional.isPresent()){
            OrderRead order = orderOptional.get().toRead();
            //주문 상품 목록 조회
            List<OrderItem> orderItems = orderItemService.findAll(order.getId());

            //주문 상품 목록의 상품 아이디를 추출
            List<Integer> orderItemIds = orderItems.stream().map(OrderItem::getItemId).toList();
            //주문 상품 리스트의 상품 ID에 해당하는 상품 목록의 조회
            List<ItemRead>  items = itemService.findAll(orderItemIds);
            //응답 값에 상품 리스트 데이터를 설정
            order.setItems(items);

            return order;
        }
        return null;
    }
    //주문 내용 저장
    @Override
    public void order(OrderRequest orderRequest, Integer memberId) {
        //주문 상품의 최종 결제 금액을 계산
        List<ItemRead> items = itemService.findAll(orderRequest.getItemIds());

        long amount =0L;
        for (ItemRead item : items) {
            amount +=item.getPrice() - item.getPrice().longValue()*item.getDiscountPer()/100;
        }
        //주문 요청에 최종 결제 금액 입력
        orderRequest.setAmount(amount);
        //주문 저장
        Order order = orderRepository.save(orderRequest.toEntity(memberId));
        //주문 상품 데이터 생성
        List<OrderItem> newOrderItems = new ArrayList<>();
        //상품 아이디만큼 주문 상품 추가
        orderRequest.getItemIds().forEach((itemId) -> {
            OrderItem orderItem = new OrderItem(order.getId(),itemId);
            newOrderItems.add(orderItem);
        });
        //주문 상품 데이터 저장
        orderItemService.saveAll(newOrderItems);
        //장바구니 데이터 삭제(특정회원)
        cartService.removeAll(order.getMemberId());
    }
}
