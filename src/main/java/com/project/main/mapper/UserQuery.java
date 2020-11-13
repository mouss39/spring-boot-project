package com.project.main.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.main.model.AuthUser;
import com.project.main.model.User;

@Mapper
public interface UserQuery {

	@Select("Select * from users where email=#{email} and password=#{password}")
	User authUser(AuthUser user);

	@Select("Select * from users where email=#{email}")
	User checkUser(String email);

	@Insert("INSERT INTO users" + "( first_name, last_name, email, password,tel_number, sex,age) "
			+ "VALUES ( #{firstName}, #{lastName} , #{email},#{password}, #{telNumber},#{sex},#{age} )")
	void addUser(User user);

//	@Insert("INSERT INTO users" + "( first_name, last_name) " + "VALUES ('mohamad','last' )")
//	void addUser(User user);

}
