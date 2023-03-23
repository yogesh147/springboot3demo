package com.springboot.demo.SpelExpression;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Inventor {

    public String name;

    public Date birthday;

    public String nationality;

    public String getNameAndNationality() {
        return name + "<->" + nationality;
    }

}
