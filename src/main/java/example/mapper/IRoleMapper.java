package example.mapper;

import example.entity.Role;

import java.util.List;

public interface IRoleMapper {

    //查询所有账户信息，关联查询账户下的用户的username和address
    List<Role> findRoleUser();
}
