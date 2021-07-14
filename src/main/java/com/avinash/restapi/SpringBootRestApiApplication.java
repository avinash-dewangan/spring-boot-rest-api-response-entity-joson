package com.avinash.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);

		// ApplicationContext context =
		// SpringApplication.run(SpringBootRestApiApplication.class, args);
		// UserRepository userRepository = context.getBean(UserRepository.class);

		// User user = new User();
		// user.setName("avinash");
		// user.setCity("delhi");
		// user.setStatus("java developer");
		// User user1 = userRepository.save(user);
		// System.out.println(user1);

		// List<User> user2 =userRepository.findByName("avinash");
		// user2.forEach((user3)->{
		// System.out.println(user3.getName());
		// });
		//
		// List<User> user4 = userRepository.findByCityAndName("raipur", "avinash");
		// user4.forEach(user5->System.out.println(user5));
		//
		// //JPQL Query
		// List<User> allUser = userRepository.getAllUser();
		// allUser.forEach(allUserObj->System.out.println(allUserObj));
		//
		// System.out.println("------Parameterized Query------");
		//
		// //Parameterized Query
		// List<User> userByName = userRepository.getUserByName("avinash", "raipur");
		// userByName.forEach(u->System.out.println(u));
		//
		// System.out.println("-----------Native Query----------");
		//
		// userRepository.getUsers().forEach(e->System.out.println(e));

	}

}
