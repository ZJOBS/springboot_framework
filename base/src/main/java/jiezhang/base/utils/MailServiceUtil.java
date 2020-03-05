package jiezhang.base.utils;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 邮箱服务
 *
 * @author jiezhang
 */
public class MailServiceUtil {
    private static final String HOST = "smtp.163.com";
    private static final Integer PORT = 25;
    private static final String USERNAME = "zhangjiexyx";
    private static final String PASSWORD = "1q2w3e4r5t";
    private static final String FROM = "zhangjiexyx@163.com";
    private static JavaMailSenderImpl mailSender = createMailSender();

    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("UTF-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        p.setProperty("mail.host", HOST);
        // 发送邮件协议名称
        p.setProperty("mail.transport.protocol", "smtp");
        sender.setJavaMailProperties(p);
        return sender;
    }

//    /**
//     * 发送邮件
//     *
//     * @param to      接受人
//     * @param subject 主题
//     * @param html    发送内容
//     * @throws MessagingException           异常
//     * @throws UnsupportedEncodingException 异常
//     */
//    public static void sendHtmlMail(String to, String subject, String html) throws MessagingException, UnsupportedEncodingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        // 设置utf-8或GBK编码，否则邮件会有乱码
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//        messageHelper.setFrom(new InternetAddress(FROM));
//        messageHelper.setTo(to);
//        messageHelper.setSubject(subject);
//        messageHelper.setText(html, true);
//        mailSender.send(mimeMessage);
//    }

}
