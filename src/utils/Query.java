/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import utils.Next_Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.proteanit.sql.DbUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import forms.Logs;
import forms.StudentPayments;
import forms.showAdmins;
import forms.showStudents;
/**
 *
 * @author roman
 */
public class Query {
    
    public User user;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    
    showStudents show_window_stud;
    showAdmins show_window_adm;
    Logs show_logs;
    StudentPayments student_logs;

    private String db_name;
  
    //Create SQL Statement
    private String SQL_Statement;
    
    public Query(){
        conn = databaseConnection.connection();
    }
    public Query(User user){
        conn = databaseConnection.connection();
        this.user = user;
        user.toString();
    }
    //set Table
    public Query(showStudents window){
        conn = databaseConnection.connection();
        this.show_window_stud = window;
    }
    public Query(showAdmins window){
        conn = databaseConnection.connection();
        this.show_window_adm = window;
    }
    public Query(Logs window){
        conn = databaseConnection.connection();
        this.show_logs = window;
    }
    
    public Query(StudentPayments window){
        conn = databaseConnection.connection();
        this.student_logs = window;
    }
    
    
    
    
    /////METHODS
    ///Update Students
    public void update_query(String sql_command){
        try{
           stmt = conn.createStatement();
           stmt.executeUpdate(sql_command);
           
           
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean SQL_Login(){
        try{
            stmt = conn.createStatement();
            this.SQL_Statement = "SELECT id,name,email,password,admin_status FROM admin WHERE email='"+user.getEmail()+"' && password = '"+user.getPassword()+"'";
            rs = stmt.executeQuery(SQL_Statement);
            
            if(rs.next()){
                CurrentUser current_user = CurrentUser.getInstance();
                current_user.setStatus(rs.getString("admin_status"));
                current_user.setEmail(rs.getString("email"));
                current_user.setName(rs.getString("name"));
                current_user.setPassword(rs.getString("password"));
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    //Show ALl Students to Table
    public void Select_All_FromDB(){
        try{
            stmt = conn.createStatement();
            
            switch(getDb_name()){
                case "student":
                    rs = stmt.executeQuery("SELECT id,name,email,phone,city,class,credit FROM "+getDb_name());
                    show_window_stud.tableStudent.setModel(DbUtils.resultSetToTableModel(rs));
                break;
                case "admin":
                    rs = stmt.executeQuery("SELECT name,email,admin_status FROM "+getDb_name());
                    show_window_adm.tableAdmins.setModel(DbUtils.resultSetToTableModel(rs));
                break;
                case "month_payment":
                    rs = stmt.executeQuery("SELECT counter_name,date FROM "+getDb_name());
                    show_logs.tbMonth.setModel(DbUtils.resultSetToTableModel(rs));
                    
                break;
                case "payment_logs":
                    rs = stmt.executeQuery("SELECT admin_name,transfer_info,date FROM "+getDb_name());
                    show_logs.tbPayment.setModel(DbUtils.resultSetToTableModel(rs));
                break;

                default:
                    System.out.println("err");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    //Get By ID
    public boolean GetById(String id){
        switch(getDb_name()){
            case "student":
               this.SQL_Statement =  "SELECT id,name,email,credit,city,class,phone FROM "+getDb_name()+" WHERE id ='"+id+"'";
                        try{
                        stmt = conn.createStatement();            
                        rs = stmt.executeQuery(SQL_Statement);
                                
                        if(rs.next()){
                            user = new User.UserBuilder()
                                    .id(id)
                                    .name(rs.getString("name"))
                                    .email(rs.getString("email"))
                                    .city(rs.getString("city"))
                                    .clas(Integer.toString(rs.getInt("class")))
                                    .credit(Integer.toString(rs.getInt("credit")))
                                    .phone(rs.getString("phone"))
                                    .build();
                            return true;
                        }
                     }catch(Exception e){
                         System.out.println(e);
                     }
                        
             break;
            case "admin":
               this.SQL_Statement =  "SELECT id,name,email,admin_status FROM "+getDb_name() + " WHERE id ='"+id+"'";
               
               
               try{
                    stmt = conn.createStatement();            
                    rs = stmt.executeQuery(SQL_Statement);

                    if(rs.next()){
                        user = new User.UserBuilder()
                                .id(id)
                                .name(rs.getString("name"))
                                .email(rs.getString("email"))
                                .status(rs.getString("admin_status"))
                                .build();
                        return true;
                    }
                    }catch(Exception e){
                        System.out.println(e);
                    }
             break;
            default:
                System.out.println("Err");
        }
        return false;
    }
    
 
    
    
    public boolean emailExist(String email){
        System.out.println("Check point "+ getDb_name());
        this.SQL_Statement =  "SELECT email FROM "+ getDb_name() + " WHERE email ='"+email+"'";
         try{
            stmt = conn.createStatement();            
            rs = stmt.executeQuery(SQL_Statement);
            
            if(rs.next()){
                System.out.println("User exist");
                return false;
            }
            }catch(Exception e){
                System.out.println(e);
            }
        return true;
    }
    
    


    //INSERT to BD. All fields are required
    public boolean Insert_Student(){
        boolean isError=false;
        if(user.getName().equals("")||user.getCity().equals("")||user.getPhone().equals("")||user.getEmail().equals("")){
            isError = true;
        }
        else{
            this.SQL_Statement = "INSERT INTO "+getDb_name()+" (name,email,phone,city,class) "
                    + "VALUES('"+user.getName()+ "','"+user.getEmail()+"','"
                    + user.getPhone()+ "','"+user.getCity()+"','"+user.getClas()+"')";
        }
        System.out.println(this.SQL_Statement);
        
        return isError;
    }
    
//    INSERT TO ADMINS TABLE
    public boolean Insert_Admin(){
        boolean isError=false;
        if(user.getName().equals("")||user.getEmail().equals("")){
            isError = true;
        }
        else{
            this.SQL_Statement = "INSERT INTO "+getDb_name()+" (name,email,password,admin_status) "
                    + "VALUES('"+user.getName()+ "','"+user.getEmail()+"','"
                    + user.getPassword()+"','"+user.getStatus().toLowerCase()+"')";
        }
        
        return isError;
}
    
    public boolean Insert_Logs(String ID){
        boolean isError=true;
        if(CurrentUser.getInstance().getName().equals("")||Payment.getInstance().getDate().equals("")){
            isError = false;
        }
        else{
            this.SQL_Statement = "INSERT INTO "+getDb_name()+" (admin_name,transfer_info,date) "
                    + "VALUES('"+CurrentUser.getInstance().getName()+"','"
                    +Integer.toString(Payment.getInstance().getAmount())+" pln credited to the student with ID: "+ID+"','"+Payment.getInstance().getDate()+"')";
        }
        
        return isError;
    }
    
    public boolean Insert_Month_Log(){
        if(!Exist_Log()){
           this.SQL_Statement = "INSERT INTO month_payment (date,counter_name) VALUES ('"+Payment.getInstance().getLogDate()+"','"+CurrentUser.getInstance().getName()+"')";
           System.out.println("Set insert");
           return true;
        }else{
            return false;
        }
    }
    
    public boolean Exist_Log(){
        DateFormat dayFormat = new SimpleDateFormat("dd");
        Date withdraw_day;
        
        try{
            withdraw_day = new SimpleDateFormat("yyyy-MM-dd").parse(Payment.getInstance().getLogDate()); 
            
            if(dayFormat.format(withdraw_day).equals("10")){
                System.out.println("Payment data is equal to 10");
                
                stmt = conn.createStatement();
                this.SQL_Statement = "SELECT * FROM month_payment WHERE date='"+Payment.getInstance().getLogDate()+"'";
                rs = stmt.executeQuery(SQL_Statement);
                
                if(rs.next()){
                    System.out.println(rs.getString("date"));
                    return true;
                }else{
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Payment occurs only on the 10th of each month\n");
                return true;
            }
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
            
        return false;
    }
    
    //SELECT ALL SET AND GET
    public void Set_Select_All(){
        this.SQL_Statement = "SELECT * FROM "+getDb_name();
    }
    
    public String get_SQL_Statement(){
        return SQL_Statement;
    }
    
    public boolean SetSQL_Update(Next_Statement nxt){
        
        if(!Prev_Next(user.getId(),nxt.getId())){
                return false;
            }

        if(GetById(nxt.getId())){
           this.SQL_Statement = "UPDATE "+getDb_name()+" SET id = '"+user.getId()+"'";
        
            

            if(!Prev_Next(user.getName(),nxt.getName())){
                this.SQL_Statement += ", name = '"+nxt.getName()+"'";
            }
            switch(getDb_name()){
                case "admin":
                    if(!Prev_Next(user.getEmail(),nxt.getEmail())){
                            this.SQL_Statement += ", email = '"+nxt.getEmail()+"'";
                        }
                    if(!Prev_Next(user.getStatus(),nxt.getStatus().toLowerCase())){
                            this.SQL_Statement += ", admin_status = '"+nxt.getStatus().toLowerCase()+"'";
                    }
                    break;
                case "student":
                        if(!Prev_Next(user.getCity(),nxt.getCity())){
                            this.SQL_Statement += ", city = '"+nxt.getCity()+"'";
                        }
                        if(!Prev_Next(user.getPhone(),nxt.getPhone())){
                            this.SQL_Statement += ", phone = '"+nxt.getPhone()+"'";
                        }
                        if(!Prev_Next(user.getEmail(),nxt.getEmail())){
                            this.SQL_Statement += ", email = '"+nxt.getEmail()+"'";
                        }
                        if(Prev_Next(user.getClas(),nxt.getClas())){
                            this.SQL_Statement += ", class = '"+nxt.getClas()+"'";
                        }
                        
                    break;
            }
              
            this.SQL_Statement +=" WHERE id ='"+user.getId()+"'";
        }
                
        return true;
    }
    
    public String GetSQL_Statement(){
        return SQL_Statement;
    }
    
    
    public String SQL_Delete_Student(){
        this.SQL_Statement = "DELETE FROM "+getDb_name()+" WHERE id = '"+user.getId()+"'";
        return this.SQL_Statement ;
    }
    
    
    public void Update_Credit(){
        System.out.println(getDb_name());

        Payment payment = Payment.getInstance();
        this.SQL_Statement = "UPDATE "+getDb_name()+" SET credit = credit + "+Integer.toString(payment.getAmount())+" WHERE id = '"+user.getId()+"'";
    }
    
    public boolean Update_Credit_Month_Debt(){
       
        this.SQL_Statement = "UPDATE "+getDb_name()+" SET "
                + "credit = credit - "+Integer.toString(Payment.getInstance().getAmount())+" ";
        return true;
    }
    
   public void Update_Password(){
       this.SQL_Statement = "UPDATE "+getDb_name()+ " SET password = '"+ CurrentUser.getInstance().getPassword()+"' WHERE email = '"+CurrentUser.getInstance().getEmail()+"'";
   }
    
    public ArrayList<String> Select_All_ID(){
        
        ArrayList<String> list = new ArrayList<>();
        switch(getDb_name()){
            case "student":
               this.SQL_Statement =  "SELECT id,name FROM "+getDb_name();
               executeQuery(list);
             break;
            case "admin":
               this.SQL_Statement =  "SELECT id,name FROM "+getDb_name();
               executeQuery(list);
             break;
            case "payment_logs":
               this.SQL_Statement =  "SELECT * FROM "+getDb_name();
               executeQuery(list);
             break;
            default:
                System.out.println("Err");
        }
        return list;
    }
    
    public void SQL_JOIN(User user){
        try{
            stmt = conn.createStatement();
            System.out.println(user.getId());
            this.SQL_Statement = "SELECT transfer_info,date FROM "+getDb_name()+" WHERE SUBSTRING(transfer_info, LENGTH(transfer_info)-1,2) = '"+user.getId()+"'";
            
            rs = stmt.executeQuery(SQL_Statement);
            student_logs.tbPayment.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            
        }catch(Exception e){
                System.out.println(e);
        }
        System.out.println(user);
    }
    
    
    public ArrayList<String> Select_All_ADMIN_ID(){
        
        ArrayList<String> list = new ArrayList<>();
       
        this.SQL_Statement =  "SELECT id,name FROM admin";
        executeQueryAdmin(list);
       
        System.out.println(list);
        return list;
    }
    
    
    private void executeQueryAdmin(ArrayList<String> list){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_Statement);
            while(rs.next()){
                list.add(rs.getString("name"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    private void executeQuery(ArrayList<String> list){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_Statement);
            while(rs.next()){
                list.add(rs.getString("id")+" - "+ rs.getString("name"));
                user = new User.UserBuilder()
                                .id(rs.getString("id"))
                                .name(rs.getString("name"))
                                .build();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
   
    
    private boolean Prev_Next(String prev,String next){
        boolean IsTrue;
        if(prev.equals(next)){
//            System.out.println(prev +"=="+next);
            IsTrue = true;
        }else{
//            System.out.println(prev +"=="+next);
            IsTrue = false;
        }
        return IsTrue;
    }


    /**
     * @return the db_name
     */
    public String getDb_name() {
        return db_name;
    }

    /**
     * @param db_name the db_name to set
     */
    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }
    
}
