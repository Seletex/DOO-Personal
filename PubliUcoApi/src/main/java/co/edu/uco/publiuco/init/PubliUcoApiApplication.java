package co.edu.uco.publiuco.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "co.edu.uco.publiuco"})
public class PubliUcoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubliUcoApiApplication.class, args);
	}

}
