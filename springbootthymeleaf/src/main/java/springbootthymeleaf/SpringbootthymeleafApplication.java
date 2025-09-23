package springbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootthymeleafApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootthymeleafApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
	}

}
