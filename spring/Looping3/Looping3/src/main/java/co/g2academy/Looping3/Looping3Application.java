package co.g2academy.Looping3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Looping3Application {

	public static void main(String[] args) {
		SpringApplication.run(Looping3Application.class, args);
		int a= 3;
		for (int i=1 ; i<=5 ; i++){
			a=(a*2)+1;
			System.out.println(a);
		}
	}

}
