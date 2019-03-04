import com.ggq.dao.TestMapper;
import com.ggq.dao.test_plus;
import com.ggq.test_casc;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void testtt() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            test_casc blog = session.selectOne("selecttest", 1);
            System.out.println(blog);
        } finally {
            session.close();
        }

    }

    @Test
    public void testMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            TestMapper tt = session.getMapper(TestMapper.class);
            System.out.println(tt.getTestByMoney(1));
        } finally {
            session.close();
        }
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            test_casc tt = new test_casc("ggq1", 1, 2000);
//            long l = mapper.insertTest(tt);
//            mapper.updateTest(tt);
            mapper.deleteTest(2000);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testList() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            List<test_casc> testLike = mapper.getTestLike(1);
            for (test_casc test_casc : testLike) {
                System.out.println(test_casc);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            Map<String, Object> testByMap = mapper.getTestByMap(1);
            for (Map.Entry<String, Object> stringObjectEntry : testByMap.entrySet()) {
                System.out.println(stringObjectEntry.getKey() + stringObjectEntry.getValue());
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void TestmanyInOneMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            test_plus mapper = sqlSession.getMapper(test_plus.class);
            Map<Integer, test_casc> testByMap = mapper.getMoreOnone(1);
            for (Map.Entry<Integer, test_casc> stringObjectEntry : testByMap.entrySet()){
                System.out.println(stringObjectEntry.getKey().toString() + stringObjectEntry.getValue());
            }
        } finally {
            sqlSession.close();
        }
    }

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
