package mapper;

import entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User get(int id);

    List<User> getList();
}
