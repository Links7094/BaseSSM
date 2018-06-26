package web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import web.JsonResult.ResultCode;
import web.JsonResult;
import web.validator.User;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger loger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public JsonResult<User> get(@Valid @RequestBody User u) {
        userService.get();
        return new JsonResult<>(ResultCode.SUCCESS, u);
    }
}
