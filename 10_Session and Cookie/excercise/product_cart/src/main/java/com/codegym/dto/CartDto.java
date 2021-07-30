package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Map<ProductDto, Integer> productDtoIntegerMap = new HashMap<>();

    public void addProductDtoIntoSession(ProductDto productDto) {
        if (productDtoIntegerMap.containsKey(productDto)) {
            Integer numberProductCurrent = productDtoIntegerMap.get(productDto);
            productDtoIntegerMap.put(productDto, numberProductCurrent + 1);
        } else {
            productDtoIntegerMap.put(productDto, 1);
        }
    }

    public void delete(ProductDto productDto) {
        Integer value = productDtoIntegerMap.get(productDto);
        productDtoIntegerMap.remove(productDto, value);
    }

    public int countTotal() {
        int payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
