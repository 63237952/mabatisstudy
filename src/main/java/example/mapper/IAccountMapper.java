package example.mapper;

import example.entity.Account;

import java.util.List;

public interface IAccountMapper {
    //查询所有账户信息，关联查询账户下的用户的username和address
    List<Account> findAccountUser();
    List<Account> findByUid(Integer uid);
}
