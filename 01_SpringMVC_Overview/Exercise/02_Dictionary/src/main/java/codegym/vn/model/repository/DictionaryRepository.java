package codegym.vn.model.repository;



import java.util.Map;

public interface DictionaryRepository {
    public Map<String,String> findAll();
}
