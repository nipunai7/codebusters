package intergrative.mit.codebusters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CodebustersApplication{

	public static void main(String[] args) {
		SpringApplication.run(CodebustersApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/auth/login").allowedOrigins("*");
				registry.addMapping("/auth/register").allowedOrigins("*");
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}

}