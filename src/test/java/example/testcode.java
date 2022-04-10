package example;

import com.alibaba.fastjson.JSON;
import example.entity.Account;
import example.entity.Role;
import example.entity.User;
import example.entity.vo.AccountUser;
import example.entity.vo.QueryVo;
import example.mapper.IUserMapper;
import example.thread.MyThread;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testcode {
    public static void main(String[] args) throws IOException {
//            MyThread myThread = new MyThread();
//            new Thread(myThread, "mythread").start();
            InputStream resource = Resources.getResourceAsStream("application.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resource);
            SqlSession sqlSession = build.openSession();
            System.out.println(sqlSession+"---"+Thread.currentThread().getName());
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

/*
            List<User> all = mapper.findAll();
        for (User user :all) {
            System.out.println(user);
        }
*/

/*        User user = mapper.findById(41);
        System.out.println(user);*/

/*       User user = new User();
        user.setAddress("haikou");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("wuli");
        mapper.saveUser(user);
        System.out.println(user);
        //增删改操作需要提交事务，否则不会成功
        sqlSession.commit();*/

/*        //更新操作
        User user = mapper.findById(62);
        user.setAddress("shanghai");
        mapper.updateUser(user);
        sqlSession.commit();
        System.out.println(mapper.findById(63));*/

        //删除操作
/*        mapper.deleteUser(63);
        sqlSession.commit();
        User user = mapper.findById(63);
        System.out.println(user);*/

/*        //模糊查询
        List<User> userList = mapper.findByName("%王%");
        for(User user:userList){
            System.out.println(user);
        }*/

/*        //根据条件查询
        User userdemo = new User();
        userdemo.setAddress("haikou");
        userdemo.setUsername("wuli");
        List<User> users = mapper.findByConditions(userdemo);
        for(User user:users) {
            System.out.println(user);
        }*/

/*        //根据条件查询之使用foreach标签
        QueryVo queryVo = new QueryVo();
        List<Integer> ids= new ArrayList();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        queryVo.setIds(ids);
        List<User> users = mapper.findByVo(queryVo);
        for(User user:users) {
            System.out.println(user);
        }*/

/*        //多表查询之一对一，查询所有账户以及账户下的员工信息
        List<Account> accounts = mapper.findAccountUser();
        for(Account account:accounts) {
            //测试用此方法转化的json字符转格式，结果如下{"address":"北京","id":1,"money":1000.0,"uid":46,"username":"老王"}
            //说明会将子类以及父类的属性，以属性名：属性值的方式转化为json
            String json = JSON.toJSONString(account);
            System.out.println(json);
        }*/

/*        //多表查询之一对多，查询所有用户信息以及用户下的账户信息
        List<User> userAcount = mapper.findUserAcount();
        for(User user:userAcount) {
            //测试用此方法转化的json字符转格式，结果如下{"address":"北京","id":1,"money":1000.0,"uid":46,"username":"老王"}
            //说明会将子类以及父类的属性，以属性名：属性值的方式转化为json
            String json = JSON.toJSONString(user);
            System.out.println(json);
        }*/

/*        //多表查询之多对多关系的查询（一对多），查询所有角色信息，以及扮演角色的用户信息
        List<Role> roleUser = mapper.findRoleUser();
        for(Role role:roleUser) {
            //测试用此方法转化的json字符转格式，结果如下{"address":"北京","id":1,"money":1000.0,"uid":46,"username":"老王"}
            //说明会将子类以及父类的属性，以属性名：属性值的方式转化为json
            String json = JSON.toJSONString(role);
            System.out.println(role);
        }*/

/*        //使用延时加载的方式加载用户，当需要加载账户（调用getAccounts（）或者setAccounts（））时才会加载
        List<User> users = mapper.findAll();
        for (User user:users) {
            //调用这条语句，不要去加载acounts
            System.out.println(user.getAddress());
            //调用这条语句，会去加载account，即每次调用时，会去调用example.mapper.IAccountMapper.findByUid方法
            System.out.println(user.getAccounts());
        }*/

/*        //测试一级缓存，一级缓存存在的级别时sqlsession级别，每次查询完成后，会将查询的结果存入sqlsession中，下一次查询操作发生时首先回去查询缓存，如果存在的话，直接从缓存中去，不存在才会去查询数据库
        User user1 = mapper.findById(41);
        user1.setUsername("lisi");
        mapper.updateUser(user1);
        User user2 = mapper.findById(41);
        System.out.println(user1==user2);*/
        //7.释放资源
       sqlSession.close();
        resource.close();
    }
}
