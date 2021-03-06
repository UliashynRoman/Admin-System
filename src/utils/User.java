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
public class  User {
    //All final attributes
    private final String id; //only for queries
    private final String name; // make required
    private final String email; // optional
    private final String clas; // optional
    private final String phone; // optional
    private final String city; // optional
    private final String status;
    private final String password;
    private final String credit;
 
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.clas = builder.clas;
        this.phone = builder.phone;
        this.city = builder.city;
        this.status = builder.status;
        this.password = builder.password;
        this.credit = builder.credit;
    }
    
    //All getter, and NO setter to provde immutability
    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getClas() {
        return clas;
    }
    public String getPhone() {
        return phone;
    }
    public String getCity() {
        return city;
    }
    public String getStatus(){
        return status;
    }
    public String getPassword(){
        return password;
    }
    public String getCredit(){
        return credit;
    }
 
    @Override
    public String toString() {
        return "User: "+this.id+", "+this.name+", "+this.email+", "+this.clas+", "+this.phone+", "+this.city + ", "+ this.password;
    }
 
    
    
    
    
    
    public static class UserBuilder 
    {
        private String id;
        private String name;
        private String email;
        private String clas;
        private String phone;
        private String city;
        private String status;
        private String password;
        private String credit;
        private User user;
 
        public UserBuilder() {
        }
        
        
        //Override parsed
        public UserBuilder id(String id){
            this.id = id;
            return this;
        }
        
        public UserBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        
        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        public UserBuilder clas(String clas) {
            this.clas = clas;
            return this;
        }
        

        
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }
        public UserBuilder(String status){
            this.status = status;
        }
        
        public UserBuilder password(String pass){
            this.password = pass;
            return this;
        }
        public UserBuilder status(String status){
            this.status = status;
            return this;
        }
        public UserBuilder credit(String credit){
            this.credit = credit;
            return this;
        }
        
        
        
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            return user;
        }
    }
}
