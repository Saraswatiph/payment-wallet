package com.week3.payment_wallet.repository;

import com.week3.payment_wallet.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
