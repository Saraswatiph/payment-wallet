package com.week3.payment_wallet.service;

import com.week3.payment_wallet.dto.TransferRequestDTO;
import com.week3.payment_wallet.entity.Transaction;
import com.week3.payment_wallet.entity.Wallet;
import com.week3.payment_wallet.repository.TransactionRepository;
import com.week3.payment_wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepo;

    @Autowired
    private TransactionRepository txnRepo;

    public Wallet addAmount(int userId, double amount) {
        Wallet wallet = walletRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        wallet.setBalance(wallet.getBalance() + amount);
        return walletRepo.save(wallet);

    }

    public Wallet findByUserId(int userId) {
        return walletRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    public void transfer(TransferRequestDTO dto) {
        Wallet fromWallet = walletRepo.findByUserId(dto.getFromUserId())
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));
        Wallet toWallet = walletRepo.findByUserId(dto.getToUserId())
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (fromWallet.getBalance() < dto.getAmount())
            throw new RuntimeException("Insufficient funds");

        fromWallet.setBalance(fromWallet.getBalance() - dto.getAmount());
        toWallet.setBalance(toWallet.getBalance() + dto.getAmount());

        walletRepo.save(fromWallet);
        walletRepo.save(toWallet);

        Transaction txn = new Transaction();
        txn.setWallet(fromWallet);
        txn.setAmount(dto.getAmount());
        txn.setStatus("COMPLETED");
        txn.setDate(LocalDate.now());
        txn.setTime(LocalTime.now());
        txnRepo.save(txn);
    }

}
