package com.week3.payment_wallet.repository;

import com.week3.payment_wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
