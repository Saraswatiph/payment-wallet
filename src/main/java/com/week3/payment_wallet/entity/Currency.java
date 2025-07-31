package com.week3.payment_wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Currency {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String abbreviation;

    @OneToMany(mappedBy = "currency")
    private List<Wallet> wallets;

    public Currency(int id, String name, String abbreviation, List<Wallet> wallets) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.wallets = wallets;
    }
}
