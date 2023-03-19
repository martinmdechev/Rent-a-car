package com.example.demo.services.impl;

import com.example.demo.convertors.UserConvertor;
import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.UserRequest;
import com.example.demo.entities.User;
import com.example.demo.exceptions.MyException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserConvertor userConvertor;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserConvertor userConvertor) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userConvertor = userConvertor;
    }

    @Override
    public User addUser(User user) {
        User userToBeSaved = new User();
        userToBeSaved.setFirstName(user.getFirstName());
        userToBeSaved.setLastName(userToBeSaved.getLastName());
        userToBeSaved.setEmail(user.getEmail());
        userToBeSaved.setPhoneNumber(user.getPhoneNumber());
        return (User) userRepository.save(userToBeSaved);
    }

    @Override
    public User findById(Long id) throws Throwable {
    return (User) userRepository.findById(id)
            .orElseThrow(()-> new MyException("No user with such id found"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User findByEmail(String email) {

       return userRepository.findByEmail(email)
               .orElseThrow(() -> new MyException("No user with such email found"));

    }

    @Override
    public void updatePassword(String password) {
        User userToBeUpdated = new User();
        userToBeUpdated.setPassword(password);
    }

    @Override
    public UserRequest login(LoginRequest loginRequest) {
        Optional<User>user =userRepository.findByEmail(loginRequest.getEmail());
        if (user.isEmpty()){
            throw new MyException("User not found or invalid credentials");
        } else if (bCryptPasswordEncoder.matches((loginRequest.getPassword(), user.get().getPassword())) {
            throw new MyException("User not found or password is wrong");
        }
        return userConvertor.toResponse(user.get());
    }
}
