package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import validator.User;
import web.JsonResult;
import web.ResultCode;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    // todo ExceptionHandler
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public JsonResult<User> get(@RequestBody User u) {
//        if (errors.hasErrors()) {
//            throw new ValidateException(u, errors.getFieldError().getDefaultMessage());
//        }
        System.out.println("hehehehe");
        log.debug("hahahahaha");
//        User user = new User();
//        user.name = "links";
//        user.age = 23;
//        throw new RuntimeException();
        return new JsonResult<>(ResultCode.SUCCESS, null, u);
    }
}
