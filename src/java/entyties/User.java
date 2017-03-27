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
public class User {

    private int id;
    private String email;
    private String name;
    private int balance;
    private List<OrderLine> cart;

    public User(int id, String email, String name, int balance) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.balance = balance;
        cart = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public List<OrderLine> getCart() {
        return cart;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public String getForBal()
    {
        String str = "" + balance;
        return str;
    }
}
