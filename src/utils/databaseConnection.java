package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roman
 */
public class databaseConnection {
    //
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/student";
    
    final static String USER = "root";
    final static String PASS = "";
    
    public static Connection connection(){ //call function method without createing object
        try{
            Class.forName(JDBC_DRIVER);
            Connection conn;
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ooops.. It looks like connection was lost(\n\n"
                    + "1. Be sure you are connected to the internet.\n2. Try login a bit later.\n"
                    + "3. If problem be the same, contact us via email - \n romanuliashyn@gmail.com");
            System.exit(0);
            return null;
        }
    }
}

