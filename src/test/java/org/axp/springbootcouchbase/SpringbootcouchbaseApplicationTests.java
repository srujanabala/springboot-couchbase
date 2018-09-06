package org.axp.springbootcouchbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootcouchbaseApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private String sp;

	@Test
	public void contextLoads() {
	}

	@Test
	public void exampleTest(){
		String body = restTemplate.getForObject("/get", String.class);
		System.out.println(body);
		Assert.assertNotNull(body); //.isEqualTo("Hello World");
	}
}
