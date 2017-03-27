/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entyties;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PVA
 */
public class Order {
    
    private int ono;
    private int userId;
    private List<OrderLine> orderList;
    private int price;
    private String date;
    
    public Order(int ono, int userId, int price, String date)
    {
        this.ono = ono;
        this.userId = userId;
        this.price = price;
        this.date = date;
        orderList = new ArrayList<>();
             }

    public int getOno() {
        return ono;
    }

    public int getUserId() {
        return userId;
    }

    public List<OrderLine> getOrderList() {
        return orderList;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
    
    
}
