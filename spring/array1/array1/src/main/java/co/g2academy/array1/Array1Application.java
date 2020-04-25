package co.g2academy.array1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Array1Application {

	public static void main(String[] args) {
		SpringApplication.run(Array1Application.class, args);
		List<String> listBuah = new ArrayList<String>();
		listBuah.add("Mangga");
		listBuah.add("Durian");
		listBuah.add("Rambutan");
		System.out.println("Buah yang tersedia = " + listBuah);
		System.out.println("Buah dengan kulit keras = " + listBuah.get(1));
	}

}
