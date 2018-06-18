package iac.schobshop.Schobshop.model;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ShoppingCartLine> items;
    private double totalPrice;

    public ShoppingCart(){
        this.items = new ArrayList<>();
    }

    public ShoppingCart(ArrayList<ShoppingCartLine> items) {
        this.items = items;
    }

    public ArrayList<ShoppingCartLine> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShoppingCartLine> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
