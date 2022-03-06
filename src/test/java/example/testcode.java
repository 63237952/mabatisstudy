package example;

import example.entity.User;
import example.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testcode {
    public static void main(String[] args) throws IOException {

            InputStream resource = Resources.getResourceAsStream("application.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resource);
            SqlSession sqlSession = build.openSession();
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
            List<User> all = mapper.findAll();
        for (User user :all) {
            System.out.println(user);
        }
        //7.释放资源
        sqlSession.close();
        resource.close();
    }
}
