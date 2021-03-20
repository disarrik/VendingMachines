package com.example.vendingmachines.fabricsforproducts;

import com.example.vendingmachines.products.IProduct;
import com.example.vendingmachines.products.Lays;

public class LaysFabric extends IFabricForProduct{
    @Override
    public IProduct create() {
        return new Lays();
    }
}
