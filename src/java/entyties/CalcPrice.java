/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entyties;

import java.util.List;

/**
 *
 * @author PVA
 */
public class CalcPrice {
    
    private int totalPrice;
    private int balance;
    
    
    public CalcPrice(List<OrderLine> cartList, User user){
        
        this.balance = user.getBalance();
        calculatePrice(cartList);
        calcUserBalance();
        user.setBalance(balance);
    }
    private void calculatePrice(List<OrderLine> cartList){
        
        totalPrice = 0;
        for (OrderLine orderLine : cartList)
        {
            totalPrice += orderLine.getPrice();
            
        }
    }
    
    private void calcUserBalance() {
        
        balance = getBalance() - getTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getBalance() {
        return balance;
    }
    
    
    
}
