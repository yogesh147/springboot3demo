package com.springboot.demo.MethodReplacerDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Component
public class ReImplement implements MethodReplacer {

    public static ObjectMapper oMapper = new ObjectMapper();

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        Map<String, String> map = oMapper.convertValue(obj, new TypeReference<>() {});
        map.put("1", (String) args[0]);
        return map;
    }

}
