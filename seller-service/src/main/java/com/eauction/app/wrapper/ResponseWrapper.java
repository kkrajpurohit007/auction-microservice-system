package com.eauction.app.wrapper;

import com.eauction.app.model.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseWrapper {
    private Product product;
    private Seller seller;
}
