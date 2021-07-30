package com.codegym.model.dto;

import com.codegym.model.bean.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BlogDto {
    private Long id;
    private String name;
    private String content;
    private String datePublication;
    private Category category;
}
