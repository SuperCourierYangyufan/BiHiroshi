package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	/*
	 * 发送人 tom@yangemailservice.com   接收人 lucy@yangemailservice.com   /发送人 yangyufan199691@163.com    接收人18827421758@163.com
	 * sendEmailName:发送邮件人的名字 -->tom/yangyufan199691
	 * sendEmailPassword:发送邮件人的密码-->12345/yang199691
	 * sendserviceAddress:发送邮件服务器得地址-->localhost/smtp.163.com
	 * sendService:发送邮件的服务器-->yangemailservice.com/163.com
	 * receiveEmailName:接收邮件人的名字-->lucy/18827421758
	 * receiveService:接收邮件人的服务器-->yangemailservice.com/163.com
	 * subject:邮件的标题
	 * emailMsg:邮件的内容
	 */
	public static void sendMail(String sendEmailName,String sendEmailPassword,String sendserviceAddress,String sendService,String 
										receiveEmailName,String receiveService,String subject,String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");//发邮件的协议
		props.setProperty("mail.host", sendserviceAddress);//发送邮件的服务器地址
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendEmailName, sendEmailPassword); //发送邮件的账号密码
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(sendEmailName+"@"+sendService)); // 接收人的账号

		message.setRecipient(RecipientType.TO, new InternetAddress(receiveEmailName+"@"+receiveService)); // 设置发送方式与接收者

		message.setSubject(subject);
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}
