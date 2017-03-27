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
public class CakeBottom implements Serializable{

    private String name;
    private int price;

    public CakeBottom(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
