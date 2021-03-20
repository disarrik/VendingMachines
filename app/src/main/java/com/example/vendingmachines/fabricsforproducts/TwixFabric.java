package com.example.vendingmachines.fabricsforproducts;

import com.example.vendingmachines.products.IProduct;
import com.example.vendingmachines.products.Twix;

public class TwixFabric extends IFabricForProduct{
    @Override
    public IProduct create() {
        return new Twix();
    }
}
