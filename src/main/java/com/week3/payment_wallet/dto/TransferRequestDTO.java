package com.week3.payment_wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransferRequestDTO {
    @NotNull
    private Integer fromUserId;
    @NotNull private Integer toUserId;
    @NotNull @Positive
    private Double amount;

    public @NotNull Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(@NotNull Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public @NotNull Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(@NotNull Integer toUserId) {
        this.toUserId = toUserId;
    }

    public @NotNull @Positive Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull @Positive Double amount) {
        this.amount = amount;
    }
}

