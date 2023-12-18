package Utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Models.User;

public class Email {

	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
	
	public boolean sendEmail(User user) {
		boolean test = false;
		
		String toEmail = user.getEmail();
		String fromEmail = "minhngltt@gmail.com";
		String password = "mjth fapu cvat rrwa";
		
		try {
			Properties pr = configEmail(new Properties());
			
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			}); 
			
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");

			mess.setFrom(new InternetAddress(fromEmail));

			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			mess.setSubject("Confirm Code");

			mess.setText("Your code is: " + user.getCode());
			
			Transport.send(mess);
			
			test = true;
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		return test;
	}
	
	public boolean EmailSend(User user) {
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail = "minhngltt@gmail.com";
		String password = "mjth fapu cvat rrwa";
		
		try {
			// your host email smtp server details
			Properties pr = configEmail(new Properties());
			
			//get session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
			
			mess.setFrom(new InternetAddress(fromEmail));
			
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			
			mess.setSubject("Yours Password");
			
			mess.setText("Password: "+user.getPassword());
			
			Transport.send(mess);
			
			test= true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}

	private Properties configEmail(Properties pr) {
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		return pr;
	}
	
}
