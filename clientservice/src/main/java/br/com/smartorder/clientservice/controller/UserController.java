package br.com.smartorder.clientservice.controller;


import br.com.smartorder.clientservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;




}
