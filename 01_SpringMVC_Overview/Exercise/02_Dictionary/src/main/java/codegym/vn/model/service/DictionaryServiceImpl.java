package codegym.vn.model.service;

import codegym.vn.model.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Override
    public Map<String, String> findAll() {
        return dictionaryRepository.findAll();
    }
}
