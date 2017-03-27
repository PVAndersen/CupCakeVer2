/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cake;

import java.io.Serializable;

/**
 *
 * @author PVA
 */
public class CupCake implements Serializable{
    
    private CakeTopping topping;
    private CakeBottom bottom;
    private int price;
    
    public CupCake(CakeTopping topping, CakeBottom bottom){
        
        this.topping = topping;
        this.bottom = bottom;
        price = cupCakesCalcPrice(topping, bottom);
                  
    }
    @Override
    public String toString()
    {
        return "Cupcake with a " + topping.getName() + " Glazing and a " + bottom.getName() + " base";
        
    }
    
    private int cupCakesCalcPrice(CakeTopping topping, CakeBottom bottom)
    {
        int sum = (topping.getPrice()+ bottom.getPrice());
        return sum;
        
    }

    public CakeTopping getTopping() {
        return topping;
    }

    public CakeBottom getBottom() {
        return bottom;
    }

    public int getPrice() {
        return price;
    }
    
}
