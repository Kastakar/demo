package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.model.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer> {

	//@Query("select * from UserDetails where username=?")
	//public List<UserDetails> findByuserName(String userName);

	public List<UserDetails> findByuserName(String userName);
	//public List<UserDetails> findByUsernameAndUserid(String userName,Integer userId);
	public List<UserDetails> findByUserNameEquals(String userName);
	public List<UserDetails> findByUserNameLike(String userName);
	
	
	@Query("select u from UserDetails u")
	public List<UserDetails> getAllUser();
	
	@Query("select u from UserDetails u where u.userName =:n")
	public List<UserDetails> getUserByName(@Param("n") String userName);
	
	
	@Query("select u from UserDetails u where u.userName =:n and u.city =:c")
	public List<UserDetails> getUserByNameAndCity(@Param("n") String userName,@Param("c") String userName1);
	
	public List<UserDetails> findByCityLike(String start);
	
	public List<UserDetails> findByCityIn(List<String> str);
	
	//public List<UserDetails> findByCityEqualIgnoreCaseOrderedBy(String start);
	
	
	//public List<UserDetails> findByStatusIsTrueAndCityEquals(String st);

	
	
	
	
	
	
}
