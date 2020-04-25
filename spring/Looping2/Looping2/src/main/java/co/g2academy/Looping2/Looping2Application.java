package co.g2academy.Looping2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Looping2Application {
	public static void main(String[] args) {
		SpringApplication.run(Looping2Application.class, args);
		for (int i=1 ; i<=9 ; i+=2)
			System.out.println(i);
	}

}
