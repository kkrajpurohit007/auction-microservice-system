package com.eauction.app.wrapper;

import com.eauction.app.model.Buyer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ResponseWrapper {
    private Buyer buyer;
    private ProductBid productBid;
    private List<ProductBid> productBids;
}
