package com.example.SpringBootRestful.controller;

import com.example.SpringBootRestful.entity.User;
import com.example.SpringBootRestful.exception.BusinessException;
import com.example.SpringBootRestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="")     // 通过这里配置使下面的映射都在/users下
//ToDo:在上一行代码("")中填写合适的RestfulApi
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping(value="/user")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value="/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity updateUserById(@PathVariable int userId, @RequestBody User user) throws BusinessException {
        userService.updateUserById(userId, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity deleteUserById(@PathVariable int userId) throws BusinessException {
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
