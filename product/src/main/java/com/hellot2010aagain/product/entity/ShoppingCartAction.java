package com.hellot2010aagain.product.entity;

import java.util.ArrayList;

public interface ShoppingCartAction {
    void add(Product product, int quantity); // thêm số lượng sản phẩm vào cart.
    void update(Product product, int quantity); // thay đổi số lượng của sản phẩm trong cart.
    void remove(Product product); // remove sản phẩm khỏi cart.
    ArrayList<CartItem> getListItems();
}