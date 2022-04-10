package example.thread;

import example.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyThread implements Runnable {
    public void run() {
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("application.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resource);
        SqlSession sqlSession = build.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        System.out.println(sqlSession+"---"+Thread.currentThread().getName());
    }
}
