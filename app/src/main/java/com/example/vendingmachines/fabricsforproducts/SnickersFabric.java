package com.example.vendingmachines.fabricsforproducts;

import com.example.vendingmachines.products.IProduct;
import com.example.vendingmachines.products.Snickers;

public class SnickersFabric extends IFabricForProduct{
    @Override
    public IProduct create() {
        return new Snickers();
    }
}
