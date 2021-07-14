package codegym.vn.model.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService{
    @Override
    public int calculate(int number) {
        return number*22000;
    }
}
