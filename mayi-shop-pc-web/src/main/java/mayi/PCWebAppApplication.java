package mayi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class PCWebAppApplication {

	 public static void main(String[] args) {
		 SpringApplication.run(PCWebAppApplication.class, args);
	}
	
}
