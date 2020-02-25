package com.project.qa.Selenium;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void mailsend(String file1) throws IOException {

		final String username = "from@mail.com";
		final String password = "Password";

		String MAIL_RECEPIENT = "to@mail.com"; //For smoke test

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tomail@gmail.comm"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MAIL_RECEPIENT));
			message.setSubject("Test Result");
			message.setText("Test result generated at :" + timeStamp);

			// MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			// messageBodyPart = new MimeBodyPart();

			//String file1 = "./com.project.qa.Cucumber-reports/report.html";

			String fileName1 = "Automation.html";

			addAttachment(multipart, file1, fileName1);

			// message.setContent(multipart);
			message.setContent(multipart, "text/html");

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static void addAttachment(Multipart multipart, String file, String filename) throws MessagingException {
		DataSource source = new FileDataSource(file);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);
	}
}
