package codegym.vn.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<String,String> map ;
    static {
        map = new HashMap<>();
        map.put("cat","Con mèo");
        map.put("dog","Con chó");
        map.put("Tiger","Con hổ");
        map.put("fisH","Con cá");
    }


    @Override
    public Map<String, String> findAll() {
        return map;
    }
}
