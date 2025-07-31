package com.week3.payment_wallet.service;

import com.week3.payment_wallet.dto.TransferRequestDTO;
import com.week3.payment_wallet.entity.Wallet;

public interface WalletService {

    Wallet addAmount(int userId, double amount);

    Wallet findByUserId(int userId);

    void transfer(TransferRequestDTO dto);
}

