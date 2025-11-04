package kr.co.wikibook.gallery.cart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CartRead {
    private Integer id;
    private Integer itemId;
}
