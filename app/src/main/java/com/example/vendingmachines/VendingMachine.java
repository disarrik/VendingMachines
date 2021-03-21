package com.example.vendingmachines;

import com.example.vendingmachines.products.IProduct;

import java.util.ArrayList;

public class VendingMachine {
    private String name;
    private ArrayList<IProduct> products;
    private Status status;
    private long clientNumber;
    private long haveToPay;

    private long cash;

    VendingMachine(String name) {
        this.name = name;
        products = new ArrayList<IProduct>();
        status = Status.DOINGNOTHING;
        cash = 0;
        haveToPay = 0;
        clientNumber = 0;
    }

    public void addProducts(ArrayList<IProduct> newProducts) {
        if (status == status.DOINGNOTHING)
            products.addAll(newProducts);
    }

    public void IsWorkingWithAClient() {
        status = status.ISWORKINGWITHACLIENT;
    }

    public void isPaying() {
        status = status.ISPAYING;
    }

    public void doingNothing() {
        status = status.DOINGNOTHING;
    }

    public void isDelivering() {
        status = status.ISDELIVERING;
    }

    public void PrepareToSell(int id) {
        haveToPay += products.get(id).getCost();
    }
}

enum Status {
    ISWORKINGWITHACLIENT,
    DOINGNOTHING,
    ISPAYING,
    ISDELIVERING
}
