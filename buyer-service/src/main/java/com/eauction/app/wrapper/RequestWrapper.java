package com.eauction.app.wrapper;

import com.eauction.app.model.Buyer;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestWrapper {
    private Buyer buyer;
    private ProductBid productBid;
}
