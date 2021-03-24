package test.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import test.one.service.ServiceDAOImpl;

@SpringBootApplication
@EnableWebMvc
@EnableAspectJAutoProxy
public class OneApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/static/css/");
	}
}
