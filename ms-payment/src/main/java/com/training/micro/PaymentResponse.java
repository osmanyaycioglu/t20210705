package com.training.micro;

import java.math.BigDecimal;

public class PaymentResponse {

    private Boolean    success;
    private BigDecimal amount;
    private String     uid;

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(final Boolean successParam) {
        this.success = successParam;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(final String uidParam) {
        this.uid = uidParam;
    }


}
