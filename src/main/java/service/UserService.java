package service;

import entity.User;
import entity.UserExample;
import mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    public User get(User user){
        UserExample userExample = new UserExample();
        userExample.setDistinct(true);
        List<User> users = userMapper.selectByExample(userExample);
        logger.debug("userService.get()");
        return users.get(0);
    }

}
