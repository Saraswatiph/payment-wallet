package com.week3.payment_wallet.service;

import com.week3.payment_wallet.dto.UserDto;
import com.week3.payment_wallet.entity.User;

public interface UserService {
    User registerUser(UserDto userDto);
}
