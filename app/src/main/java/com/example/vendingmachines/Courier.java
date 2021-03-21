package com.example.vendingmachines;

import com.example.vendingmachines.fabricsforproducts.IFabricForProduct;
import com.example.vendingmachines.products.IProduct;

import java.util.ArrayList;

public class Courier {
    private Courier instance = null;

    private Courier() {

    }

    public Courier getInstance() {
        if (instance == null)
            instance = new Courier();
        return instance;
    }

    public void addProducts(IFabricForProduct fabric, VendingMachine machine, int amount) {
        ArrayList<IProduct> newProducts= new ArrayList<IProduct>();
        for (int i = 0; i < amount; i++) {
            newProducts.add(fabric.create());
        }
        machine.addProducts(newProducts);
    }
}
