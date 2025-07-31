package com.week3.payment_wallet.controller;

import com.week3.payment_wallet.dto.AddAmountDTO;
import com.week3.payment_wallet.dto.TransferRequestDTO;
import com.week3.payment_wallet.entity.Wallet;
import com.week3.payment_wallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/basePath/v1/users/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PatchMapping
    public ResponseEntity<Wallet> addAmount(@Valid @RequestBody AddAmountDTO dto) {
        return new ResponseEntity<>(walletService.addAmount(dto.getUserId(), dto.getAmount()), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Double> getBalance(@PathVariable int userId) {
        Wallet wallet = walletService.findByUserId(userId);
        return ResponseEntity.ok(wallet.getBalance());
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@Valid @RequestBody TransferRequestDTO dto) {
        walletService.transfer(dto);
        return ResponseEntity.ok("Transfer successful");
    }


}
