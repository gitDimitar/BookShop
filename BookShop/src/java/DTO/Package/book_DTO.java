/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Package;

/**
 *
 * @author D00133809
 */
public class book_DTO {
    
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String genre;
    private double price;
    private String img;

    public book_DTO(int id, String name, String author, int quantity, String genre, double price, String img) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.genre = genre;
        this.price = price;
        this.img = img;
    }
    
    

    public book_DTO() {
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }
    
    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", author=" + author + ", quantity=" + quantity + ", genre=" + genre + ", price=" + price + '}';
    }
    
    
    
    
}
