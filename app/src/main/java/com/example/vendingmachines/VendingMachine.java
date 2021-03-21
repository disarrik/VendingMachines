package com.example.vendingmachines;

import com.example.vendingmachines.products.IProduct;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VendingMachine {
    private String name;
    private ArrayList<IProduct> products;
    private Status status;
    private Student client;
    private long clientNumber;
    private int haveToPay;
    private int[] choose;
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

    public void startToWork(Student client) {
        this.client = client;
        this.clientNumber = client.getNumber();
        status = Status.ISWORKINGWITHACLIENT;
    }

    public void workingWithAClient() {
        choose = client.choose(products);
        haveToPay = 0;
        for (int i = 0; i < 3; i++) {
            haveToPay += products.get(choose[i]).getCost();
        }
        status = status.ISPAYING;
    }

    public void paying() {
        client.pay(haveToPay);
        cash += haveToPay;
        haveToPay = 0;
        status = status.ISDELIVERING;
    }

    public void delivering() {
        for (int i = 0; i < 3; i++) {
            products.remove(choose[i]);
            try {
                TimeUnit.SECONDS.sleep(1); // Секунда на удаление товара
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        haveToPay = 0;
        clientNumber = 0;
        status = status.DOINGNOTHING;
    }
}

enum Status {
    ISWORKINGWITHACLIENT,
    DOINGNOTHING,
    ISPAYING,
    ISDELIVERING
}
