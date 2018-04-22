package com.example.testexample;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//防止activiti-rest验证用户名
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.activiti.spring.boot.SecurityAutoConfiguration.class
})
public class TestExampleApplication {

	@Bean
	public RestTemplate restTemplate() {
		// auth
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("kermit", "kermit");
		credentialsProvider.setCredentials(AuthScope.ANY, credentials);

		// request factory
		HttpClient httpClient = HttpClientBuilder
				.create()
				.setDefaultCredentialsProvider(credentialsProvider)
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestExampleApplication.class, args);
	}
}
