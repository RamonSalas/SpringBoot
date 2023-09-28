package com.example.SpringBoot4;

import com.example.SpringBoot4.Controller.LaptopController;
import com.example.SpringBoot4.Entidades.Laptop;
import com.example.SpringBoot4.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringBoot4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		Laptop laptop= new Laptop(null,"nuevo", "2023","lenovo",1999.22);

		repository.save(laptop);
	}

}


