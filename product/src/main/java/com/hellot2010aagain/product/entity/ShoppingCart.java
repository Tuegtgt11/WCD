package com.hellot2010aagain.product.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart implements ShoppingCartAction{

    private int userId; // ai đặt
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private double totalPrice;
    private HashMap<String, CartItem> items;

    public ShoppingCart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashMap<String, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<String, CartItem> items) {
        this.items = items;
    }

    @Override
    public void add(Product product, int quantity) {

    }

    @Override
    public void update(Product product, int quantity) {

    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public ArrayList<CartItem> getListItems() {
        return null;
    }
}