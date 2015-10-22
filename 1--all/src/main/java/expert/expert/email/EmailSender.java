package expert.expert.email;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	/**
	 * 注意：发送邮件需要邮件 服务器  163 qq 都有
	 * 
	 * @param pro 配置文件
	 * @param subject 台头,标题
	 * @param body 内容
	 * @param contentType 编码类型
	 *            "text/plain; charset=UTF-8", "text/html; charset=UTF-8" ...
	 * @throws Exception
	 */
	public static void sendEmail(Properties pro, String subject, String body,
			String contentType) throws Exception {
		Transport transport = null;
		try {
			Session session = Session.getDefaultInstance(pro);
			transport = session.getTransport();
			transport.connect(pro.getProperty("mail.username"),
					pro.getProperty("mail.password"));
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress(
					pro.getProperty("mail.username"),
					pro.getProperty("mail.from"), "UTF-8"); //发件人 姓名 
			msg.setFrom(from);
			List<InternetAddress> recipents = new LinkedList<InternetAddress>();
			String recipentsStr = pro.getProperty("mail.recipients");
			for (String recipent : recipentsStr.split(";"))
				recipents.add(new InternetAddress(recipent));
			msg.setRecipients(Message.RecipientType.TO,
					recipents.toArray(new InternetAddress[] {}));
			msg.setSubject(subject, "UTF-8");
			msg.setContent(body, contentType);
			msg.saveChanges();
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {
			throw e;
		} finally {
			if (transport != null)
				transport.close();
		}
	} 
}
