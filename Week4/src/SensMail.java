import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SensMail {
	public static void main(String... args) {
		try {
			sendMail();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static boolean sendMail() throws EmailException {
		EmailAttachment attach = new EmailAttachment();
		attach.setPath("src/kon.gif");
		attach.setDisposition(EmailAttachment.ATTACHMENT);
		attach.setDescription("Picture of Horse biting me");
		attach.setName("Bad bad Horse");

		MultiPartEmail mail = new MultiPartEmail();
		mail.setHostName("smtp.googlemail.com");
		mail.setAuthenticator(new DefaultAuthenticator(MailAddress.name,
				MailAddress.password));
		mail.setSSLOnConnect(true);
		
		mail.setDebug(true);
		mail.setFrom("martin2754@gmail.com");
		mail.setSubject("TestMail");
		mail.setMsg("This is a horse mail :-)");
		mail.addTo("bwl_2014@abv.bg");
		mail.attach(attach);
		mail.send();
		
		return false;

	}
}
