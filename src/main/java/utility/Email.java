package utility;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.jsoup.Jsoup;

//import com.mysql.fabric.xmlrpc.base.Array;
//import com.sun.mail.util.MailSSLSocketFactory;

public class Email {

	public static void main(String[] args) throws Exception{

		

	}

	public static String[] GetEmailBody(String user, String password) throws Exception {
		String body = null;
		Properties props = new Properties();
		String[] result = null;

		try {
//			MailSSLSocketFactory sf = new MailSSLSocketFactory();
//			sf.setTrustAllHosts(true);
//			props.put("mail.imap.ssl.trust", "*");
//			props.put("mail.imap.ssl.socketFactory", sf);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "993");
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", user, password);

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_WRITE);
			Flags seen = new Flags(Flags.Flag.SEEN);
			FlagTerm unseenFlagTerm = new FlagTerm(seen, true); // TODO Should be false;
			SubjectTerm subjectTerm = new SubjectTerm("GOMO Order Confirmation");
			SearchTerm searchTerm = new AndTerm(unseenFlagTerm, subjectTerm);
			Message[] messages = inbox.search(searchTerm);
			int messageCount = messages.length;
			result = new String[messages.length];
			System.out.println("Total Messages:- " + messageCount);
			// for (int i = messageCount - 1; i >= 0; i--) {
			for (int i = 0; i < messages.length; i++) {
				String subject = messages[i].getSubject();
				String contentType = messages[i].getContentType();
				Address[] fromAdd = messages[i].getFrom();
				String from = fromAdd[0].toString();
//				System.out.println(from);
				if (from.equals("no-reply@gomo.ph") & subject.equals("GOMO Order Confirmation")) {
					if (contentType.contains("TEXT/PLAIN")) {
						Object content = messages[i].getContent();
						if (content != null)
							body = content.toString();
					} else if (contentType.contains("TEXT/HTML")) {
						Object content = messages[i].getContent();
						if (content != null)
							body = Jsoup.parse((String) content).text();
					} else if (contentType.contains("multipart")) {
						StringBuilder bodyBuilder = new StringBuilder(1024);
						Multipart mp = (Multipart) messages[i].getContent();
						int numParts = mp.getCount();
						for (int count = 0; count < numParts; count++) {
							MimeBodyPart part = (MimeBodyPart) mp.getBodyPart(count);
							if (MimeBodyPart.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
								continue;
							}

							String content = part.getContent().toString();
							if (part.getContentType().contains("TEXT/HTML")) {
								bodyBuilder.append(Jsoup.parse(content).text());
							} else {
								bodyBuilder.append(content);
							}
						}
						body = bodyBuilder.toString();
					}
				}
				result[i] = body;
			}

			inbox.close(true);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
