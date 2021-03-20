package com.example.vendingmachines.fabricsforproducts;

import com.example.vendingmachines.products.CocaCola;
import com.example.vendingmachines.products.IProduct;

public class CocaColaFabric extends IFabricForProduct{
    @Override
    public IProduct create() {
        return new CocaCola();
    }
}
