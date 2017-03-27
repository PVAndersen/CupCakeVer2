/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entyties;

import cake.CupCake;

/**
 *
 * @author PVA
 */
public class OrderLine {

    private CupCake cupCake;
    private int quantity;
    private int price;

    public OrderLine(CupCake cupCake, int quantity) {
        this.cupCake = cupCake;
        this.quantity = quantity;
        this.price = cupCake.getPrice() * (int) quantity;

    }

    public String getInfo() {
        return getToppingName() + getBottomName() + quantity + "" + price;
    }

    @Override
    public String toString() {
        return cupCake + ". Quantity: " + quantity + ". Price " + price;
    }
 
    public void setQuantity(int quantity){
        this.quantity = quantity;
                
    }
    public void calculatePrice()
    {
        this.price = cupCake.getPrice() * (int) quantity;
    }
    

    public String getToppingName() {
        return cupCake.getTopping().getName();
    }

    public String getBottomName() {
        return cupCake.getBottom().getName();
    }

    public CupCake getCupCake() {
        return cupCake;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

}
