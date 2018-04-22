package com.example.testexample;

import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("qq")
public class TestExampleApplicationTests {

	@Autowired
	private JavaMailSender mailSender; //自动注入的Bean

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;  //自动注入

	@Value("${spring.mail.username}")
	private String Sender; //读取配置文件中的参数

	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(Sender);
		message.setTo(Sender); //自己给自己发送邮件
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);

	}
	//发送html 邮件
	@Test
	public void sendHtmlMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(new String[]{"821636510@qq.com","2455119494@qq.com","909169252@qq.com","872452158@qq.com"});
			helper.setSubject("标题：测试邮件发送内容");

			StringBuffer sb = new StringBuffer();
			sb.append("<h1>大标题-h1</h1>")
					.append("<p style='color:#F00'>你个大傻子</p>")
					.append("<p style='color:#F00'>不好好上班玩什么邮箱</p>")
					.append("<p style='text-align:right'>致：傻子</p>");
			helper.setText(sb.toString(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}
	//发送带静态附件的邮件
	@Test
	public void sendAttachmentsMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(Sender);
			helper.setSubject("主题：带附件的邮件");
			helper.setText("带附件的邮件内容");
			//注意项目路径问题，自动补用项目路径
			FileSystemResource file = new FileSystemResource(new File("/Users/wangdingfeng/Downloads/IMG_3209.JPG"));
			//加入邮件
			helper.addAttachment("图片.jpg", file);
		} catch (Exception e){
			e.printStackTrace();
		}
		mailSender.send(message);
	}
	//发送带模板的邮件
	@Test
	public void sendTemplateMail(){
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(Sender);
			helper.setTo(Sender);
			helper.setSubject("主题：模板邮件");

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("username", "wangdingfeng");

			//修改 application.properties 文件中的读取路径
//            FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//            configurer.setTemplateLoaderPath("classpath:templates");
			//读取 html 模板
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			helper.setText(html, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}


}
