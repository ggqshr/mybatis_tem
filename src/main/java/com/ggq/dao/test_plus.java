package com.ggq.dao;

import com.ggq.test_casc;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

public interface test_plus {
    @MapKey("money")
    Map<Integer, test_casc> getMoreOnone(Integer money);
}
