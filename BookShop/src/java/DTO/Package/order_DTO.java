/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Package;

/**
 *
 * @author D00133809
 */
public class order_DTO {
    
    private int orderID;
    private int userID;
    private int lineID;
    private int bookID;
    private int quantity;

    public order_DTO(int orderID, int userID, int lineID, int bookID, int quantity) {
        this.orderID = orderID;
        this.userID = userID;
        this.lineID = lineID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    public order_DTO(int lineID, int orderID, int bookID, int quantity) {
        this.lineID = lineID;
        this.orderID = orderID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    public order_DTO() {
    }
    
    
    

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getLineID() {
        return lineID;
    }

    public int getBookID() {
        return bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "  orderID=" + orderID + ", userID=" + userID + ", lineID=" + lineID + ", bookID=" + bookID + ", quantity=" + quantity + '}';
    }
    
    
}
