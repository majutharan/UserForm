package com.userForm.userform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserformApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserformApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipart = new CommonsMultipartResolver();
//		multipart.setMaxUploadSize(3 * 1024 * 1024);
//		return multipart;
//	}

//	@Bean
//	@Order(0)
//	public MultipartFilter multipartFilter() {
//		MultipartFilter multipartFilter = new MultipartFilter();
//		multipartFilter.setMultipartResolverBeanName("multipartResolver");
//		return multipartFilter;
//	}
}
