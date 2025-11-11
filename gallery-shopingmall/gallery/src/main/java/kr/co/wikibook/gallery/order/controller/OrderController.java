package kr.co.wikibook.gallery.order.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.account.helper.AccountHelper;
import kr.co.wikibook.gallery.order.dto.OrderRead;
import kr.co.wikibook.gallery.order.dto.OrderRequest;
import kr.co.wikibook.gallery.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final AccountHelper accountHelper;

    @GetMapping("/api/orders")
    public ResponseEntity<?> readAll(HttpServletRequest request) {
        //로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);
        //주문 목록
        List<OrderRead> orders = orderService.findAll(memberId);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<?> read(HttpServletRequest request, @PathVariable Integer id) {
        //로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);
        //주문 조회
        OrderRead order = orderService.find(id, memberId);

        if(order == null){ //주문 데이터가 없는 경우
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<?> add(HttpServletRequest request, @RequestBody OrderRequest  orderRequest) {
        //로그인 회원아이디
        Integer memberId = accountHelper.getMemberId(request);
        // 주문 입력
        orderService.order(orderRequest, memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
