/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import cake.CakeBottom;
import cake.CakeTopping;
import com.sun.xml.ws.rx.rm.runtime.transaction.TransactionException;
import crashandburn.TransactionFailureException;
import entyties.CalcPrice;
import entyties.OrderLine;
import entyties.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PVA
 */
public class DataMapper {

    private DBConnector dbc = new DBConnector();
    private Connection conn = dbc.connectDB();

    public User validateUser(String email, String password) {
        String sql = "select * from user where email = ? && password = ?;";

        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, email);
            preStmt.setString(2, password);
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("userID");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");

                return new User(id, email, name, balance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<CakeBottom> getAllCakeBottoms() {
        List<CakeBottom> bottomList = new ArrayList<>();
        String name;
        int price;

        String sql = "select * from bottom;";
        try {
            PreparedStatement preStmt = conn.prepareCall(sql);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("botName");
                price = rs.getInt("botPrice");
                bottomList.add(new CakeBottom(name, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bottomList;
    }

    public List<CakeTopping> getAllCakeToppings() {
        List<CakeTopping> toppingList = new ArrayList<>();
        String name;
        int price;

        String sql = "select * from topping;";
        try {
            PreparedStatement preStmt = conn.prepareCall(sql);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("topName");
                price = rs.getInt("topPrice");
                toppingList.add(new CakeTopping(name, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toppingList;
    }

    public int getOidForAddOrder(User user) {
        String sql = "select * from orders where userID = ? order by ono desc;";
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, user.getId());
            ResultSet rs = preStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("ono");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void addOrderToDatabase(List<OrderLine> cartList, User user) throws TransactionFailureException {

        CalcPrice calc = new CalcPrice(cartList, user);
        String insertOrder = "insert into orders (userID, price) values (?,?);";
        String insertOdetails = "insert into odetails values (?, ?, ?, ?);";
        String updateBalance = "update users set balance = ? where userID = ?;";
        try {
            PreparedStatement preStmtOrder = conn.prepareStatement(insertOrder);
            preStmtOrder.setInt(1, user.getId());
            preStmtOrder.setInt(2, calc.getTotalPrice());
            preStmtOrder.executeUpdate();

            int ono = getOidForAddOrder(user);
            for (OrderLine orderLine : cartList) {
                PreparedStatement preStmtDetail = conn.prepareStatement(insertOdetails);
                preStmtDetail.setInt(1, ono);
                preStmtDetail.setString(2, orderLine.getToppingName());
                preStmtDetail.setString(3, orderLine.getBottomName());
                preStmtDetail.setInt(4, orderLine.getQuantity());
                preStmtDetail.executeUpdate();
            }
            PreparedStatement preStmtBalance = conn.prepareStatement(updateBalance);
            preStmtBalance.setInt(1, calc.getBalance());
            preStmtBalance.setInt(2, user.getId());
            preStmtBalance.executeUpdate();

        } catch (SQLException ex) {
            throw new TransactionFailureException("No cake for you!");
        }
    }

}
