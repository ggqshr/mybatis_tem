package com.ggq.dao;

import com.ggq.test_casc;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    test_casc getTestByMoney(Integer money);

    Map<String, Object> getTestByMap(Integer money);

    //返回多条记录封装成一个map.且key是money，value是一个test_casc的对象
    @MapKey("money")
    Map<Integer, test_casc> getTestByMoneyReturnMap(Integer money);

    long insertTest(test_casc tt);

    void updateTest(test_casc tt);

    void deleteTest(Integer id);

    List<test_casc> getTestLike(Integer money);
}
