package com.week3.payment_wallet.service;

import com.week3.payment_wallet.dto.UserDto;
import com.week3.payment_wallet.entity.User;
import com.week3.payment_wallet.entity.Currency;
import com.week3.payment_wallet.repository.CurrencyRepository;
import com.week3.payment_wallet.repository.UserRepository;
import com.week3.payment_wallet.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository userRepo;
    @Mock
    private WalletRepository walletRepo;
    @Mock
    private CurrencyRepository currencyRepo;

    @Test
    public void testRegisterUser() {
        UserDto dto = new UserDto();
        dto.setUsername("user1");
        dto.setEmail("user1@example.com");
        dto.setPassword("pass");

        Currency currency = new Currency(1, "INR", "₹", List.of());

        when(currencyRepo.findById(1)).thenReturn(Optional.of(currency));
        when(userRepo.save(any())).thenAnswer(i -> i.getArgument(0));
        when(walletRepo.save(any())).thenAnswer(i -> i.getArgument(0));

        User user = service.registerUser(dto);
        assertEquals("user1", user.getUsername());
    }
}

