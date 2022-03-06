package example.mapper;

import example.entity.User;

import java.util.List;

public interface IUserMapper {

    List<User> findAll();
}
