package com.training.micro;

import java.math.BigDecimal;

public class PaymentRequest {

    private String     name;
    private Long       requestId;
    private String     uid;
    private BigDecimal amount;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public Long getRequestId() {
        return this.requestId;
    }

    public void setRequestId(final Long requestIdParam) {
        this.requestId = requestIdParam;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(final String uidParam) {
        this.uid = uidParam;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
    }


}
