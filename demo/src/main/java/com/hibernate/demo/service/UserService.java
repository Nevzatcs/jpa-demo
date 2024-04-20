package com.hibernate.demo.service;

import com.hibernate.demo.model.User;
import com.hibernate.demo.model.UserDto;
import com.hibernate.demo.repository.IUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private final IUserRepo userRepository;

    public UserService(IUserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setGender(userDto.getGender());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
