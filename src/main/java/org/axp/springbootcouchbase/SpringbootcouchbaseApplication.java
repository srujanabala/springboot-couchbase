package org.axp.springbootcouchbase;

import org.axp.springbootcouchbase.mvc.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootcouchbaseApplication {

	@Autowired
	private UserRepository userRepo;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootcouchbaseApplication.class, args);
	}
}
