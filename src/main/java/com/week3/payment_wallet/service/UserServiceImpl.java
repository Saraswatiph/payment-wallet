package com.week3.payment_wallet.service;

import com.week3.payment_wallet.dto.UserDto;
import com.week3.payment_wallet.entity.User;
import com.week3.payment_wallet.entity.Wallet;
import com.week3.payment_wallet.repository.CurrencyRepository;
import com.week3.payment_wallet.repository.UserRepository;
import com.week3.payment_wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private WalletRepository walletRepo;
    @Autowired
    private CurrencyRepository currencyRepo;

    public User registerUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user = userRepo.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(0);
        wallet.setCurrency(currencyRepo.findById(1).orElseThrow()); // default currency
        walletRepo.save(wallet);

        return user;
    }
}

