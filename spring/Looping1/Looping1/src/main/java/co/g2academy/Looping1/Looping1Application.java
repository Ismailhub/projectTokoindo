package co.g2academy.Looping1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Looping1Application {

	public static void main(String[] args) {
		SpringApplication.run(Looping1Application.class, args);
		for (int i=1 ; i<=9; i++)
		System.out.println(i);
	}

}
