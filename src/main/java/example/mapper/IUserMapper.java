package example.mapper;

import example.entity.Account;
import example.entity.Role;
import example.entity.User;
import example.entity.vo.AccountUser;
import example.entity.vo.QueryVo;

import java.util.List;

public interface IUserMapper {
    /*使用延时加载的方式来完成用户的加载，当需要时可以完成对账户加载，因为一个用户下可能有多个账户，当需要账户信息时在加载
    * 可以有效的减小对数据库的开销
    * */
    List<User> findAll();

    User findById(int userId);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(int userid);
    List<User> findByName(String name);
    List<User> findByConditions(User user);
    List<User> findByVo(QueryVo queryVo);
//    //查询所有账户信息，关联查询账户下的用户的username和address
//    List<Account> findAccountUser();
    //查询所有用户以及用户下的账户信息，多表查询之 一对多
    List<User> findUserAcount();
    //查询所有角色，以及角色的用户信息，属于一对多关系
    List<Role> findRoleUser();



}
