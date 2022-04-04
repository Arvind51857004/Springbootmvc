package com.example.crud.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.crud.model.User;

public interface UserDAO extends CrudRepository<User,Integer> {

	List<User> findByage(int age);     //findBy is pre-built
	List<User> findByageGreaterThan(int age);
	
	@Query("from User where age=?1 order by name")   // This is JPQL(hql)
	List<User>  findByagesorted(int age);
	
       
}
