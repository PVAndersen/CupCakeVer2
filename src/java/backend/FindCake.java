/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import cake.CakeBottom;
import cake.CakeTopping;
import entyties.OrderLine;
import java.util.List;

/**
 *
 * @author PVA
 */
public class FindCake {

    public CakeBottom findCakeBottom(String name, List<CakeBottom> botList) {

        for (CakeBottom cakeBottom : botList) {
            if (name.equals(cakeBottom.getName())) {
                return cakeBottom;
            }
        }
        return null;
    }

    public CakeTopping findCakeTopping(String name, List<CakeTopping> topList) {
        for (CakeTopping cakeTopping : topList) {
            if (name.equals(cakeTopping.getName())) {
                return cakeTopping;
            }
        }
        return null;
    }

    public void addToCart(List<OrderLine> cartList, OrderLine orderLine) {
        for (OrderLine line : cartList) {

            if (orderLine.getBottomName().equals(line.getBottomName()) && orderLine.getToppingName().equals(line.getToppingName())) {
                line.setQuantity(line.getQuantity() + orderLine.getQuantity());
                line.calculatePrice();
                return;
            }

        }
        cartList.add(orderLine);
    }

    public void removeOrderLine(List<OrderLine> cartList, String orderInfo) {
        for (OrderLine line : cartList) {
            if (orderInfo.equals(line.getInfo()))
            {
                cartList.remove(line);
                return;
            }
        }

    }

}
