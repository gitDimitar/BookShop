/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Package;

/**
 *
 * @author D00133809
 */
public class User_DTO {
    
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String phone;
    private String dob;
    private int admin;

    public User_DTO(int userID, String userName, String password, String firstName, String lastName, String address1, String address2, String city, String country, String phone, String dob, int admin) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.dob = dob;
        this.admin = admin;
    }

    public User_DTO() {
    }
    
    

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }

    public int getAdmin() {
        return admin;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String county) {
        this.country = county;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "userInfo{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", country=" + country + ", phone=" + phone + ", dob=" + dob + ", admin=" + admin + '}';
    }
    
    
    
}
