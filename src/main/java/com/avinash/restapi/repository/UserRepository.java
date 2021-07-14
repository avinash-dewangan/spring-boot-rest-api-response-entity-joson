package com.avinash.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avinash.restapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findByName(String name);
	
	public List<User> findByCityAndName(String city, String name);
	
	
	// JPQL OR HQL
	@Query("select u FROM User u")
	public List<User> getAllUser();
	
	//parameterized query JPQL OR HQL
	@Query("select u FROM User u WHERE u.name =:n and u.city =:c")
	public List<User> getUserByName(@Param("n") String name, @Param("c") String city);
	
	//Native Query
	@Query(value="select * from User", nativeQuery = true)
	public List<User> getUsers();
	
	
}
