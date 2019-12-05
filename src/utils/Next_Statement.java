/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author roman
 */
public class Next_Statement {
    
    public Next_Statement(){
        
    }
    //Inserting values
    private int id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private int clas;
    private String status;
    private int credit;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the Email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nphone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param nphone the nphone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the clas
     */
    public int getClas() {
        return clas;
    }

    /**
     * @param clas the clas to set
     */
    public void setClas(int clas) {
        this.clas = clas;
    }
    public void setClas(String clas) {
        this.clas = Integer.parseInt(clas);
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    String getCredit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void setCredit(String credit) {
        this.credit = Integer.parseInt(credit);
    }
}