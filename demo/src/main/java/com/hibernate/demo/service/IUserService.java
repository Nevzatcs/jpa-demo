package com.hibernate.demo.service;

import com.hibernate.demo.model.User;
import com.hibernate.demo.model.UserDto;

public interface IUserService {

    User getById(Long id);
    void create(UserDto userDto);
    void delete(Long id);

}
