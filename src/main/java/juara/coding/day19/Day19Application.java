package juara.coding.day19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Day19Application {

	public static void main(String[] args) {
		SpringApplication.run(Day19Application.class, args);
	}

}
