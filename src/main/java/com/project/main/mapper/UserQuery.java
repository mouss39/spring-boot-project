package com.project.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.main.model.AuthUser;
import com.project.main.model.User;

@Mapper
public interface UserQuery {

	@Select("Select * from users where email=#{email} and password=#{password}")
	User checkUser(AuthUser user);

}
