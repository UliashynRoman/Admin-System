/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.sun.mail.smtp.SMTPTransport;
import static com.sun.org.glassfish.external.amx.AMXUtil.prop;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author roman
 */
public class MailSender {
    //All final attributes
    private final String smtp_server; // make required
    private final String email; // optional
    private final String email_from; // optional
    private final String email_to; // optional
    private final String email_subject;
    private final String email_text;
    private MimeMessage msg; 
    private Session session;
    
    
    
    private MailSender(UserBuilder builder) {
        this.smtp_server = builder.smtp_server;
        this.email = builder.email;
        this.email_from = builder.email_from;
        this.email_to = builder.email_to;
        this.email_subject = builder.email_subject;
        this.email_text = builder.email_text;
        
        
        
    }
    
    //All getter, and NO setter to provde immutability
    
    public String getServer() {
        return smtp_server;
    }
    public String getEmail() {
        return email;
    }
    
    public String getFrom() {
        return email_from;
    }
    public String getTo() {
        return email_to;
    }
    public String getSubject(){
        return email_subject;
    }
    public String getText(){
        return email_text;
    }
 
    @Override
    public String toString() {
        return "User: "+this.smtp_server+", "+this.email+", "+this.email_from+", "+this.email_to + ", "+ this.email_text;
    }
 
    
    public void initMessage(){
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", smtp_server); //optional, defined in SMTPTransport
        prop.put("mail.smtp.port", "25"); // default port 25
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.debug", "true");

        session = Session.getInstance(prop, null);
        msg = new MimeMessage(session);
    }
    
    public void send(){
        System.out.println(getFrom() + " " +getSubject()+" ," +getText()+" "+getTo());
        try{
            //From
           if(!getFrom().equals(null)){
               msg.setFrom(new InternetAddress(getFrom())); 
            } 
           //Subject
           if(!getSubject().equals(null)){
               msg.setText(getText());
           }
           //Text
           if(!getText().equals(null)){
               msg.setText(getText());
           }
           //To
           if(!getTo().equals(null)){
               msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getTo(), false));
           }
           msg.setSentDate(new Date());
           // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			
			// connect
            t.connect(smtp_server, "", "");
           // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();
           
        }catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        
        
    }
    
    
    
    public static class UserBuilder 
    {
        private  String smtp_server; // make required
        private  String email; // optional
        private  String email_from; // optional
        private  String email_to; // optional
        private  String email_subject;
        private  String email_text;
 
        public UserBuilder() {
        }
        
        
        
        public UserBuilder smtp_server(String smtp_server)
        {
            this.smtp_server = smtp_server;
            return this;
        }
        
        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        
        
        public UserBuilder email_from(String email_from) {
            this.email_from = email_from;
            return this;
        }
        
        public UserBuilder email_to(String email_to) {
            this.email_to = email_to;
            return this;
        }
        public UserBuilder email_subject(String email_subject){
            this.email_subject = email_subject;
            return this;
        }
        
        public UserBuilder email_text(String email_text){
            this.email_text = email_text;
            return this;
        }
        
        
        
        public MailSender build() {
            MailSender message =  new MailSender(this);
            return message;
        }
        
    }
}
