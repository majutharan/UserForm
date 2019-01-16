package com.userForm.userform.Controller;

import com.userForm.userform.Model.UserModel;
import com.userForm.userform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static String uploadFilePath = "/home/majutharan/Documents/projects/userform/server/userform/src/main/resources/uploads/";



    @GetMapping(path = "/message")
    public String HelloUser() {
        return "Welcome to user controller";
    }

    @PostMapping(path = "/addUser", consumes = "multipart/form-data")
    public @ResponseBody String addUser(@RequestParam UserModel user, @RequestParam("image") MultipartFile image) throws IOException {
        UserModel userExists = userRepository.findByUsername(user.getUsername());
        if (userExists != null) {
            return "username already exist";
        }
        if (image.isEmpty()) {
            return "empty image";
        }
        byte [] bytes = image.getBytes();
        Path path = Paths.get(uploadFilePath + image.getOriginalFilename());
        Files.write(path, bytes);
        user.setImage(image.getOriginalFilename());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserModel save = userRepository.save(user) ;
        return "successfully Registered";
    }

    @GetMapping(path = "/getUser")
    public Iterable<UserModel> getUser() {
        Iterable<UserModel> allUser = userRepository.findAll();
        return allUser;
    }
}
