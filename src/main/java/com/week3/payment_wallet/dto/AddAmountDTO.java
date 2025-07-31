package com.week3.payment_wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddAmountDTO {
    @NotNull
    private Integer userId;
    @NotNull
    @Positive
    private Double amount;

    public @NotNull Integer getUserId() {
        return userId;
    }

    public @NotNull @Positive Double getAmount() {
        return amount;
    }
}

