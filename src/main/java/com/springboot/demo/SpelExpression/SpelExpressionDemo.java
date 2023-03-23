package com.springboot.demo.SpelExpression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class SpelExpressionDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpelExpressionDemo.class, args);
        ExpressionParser parser = new SpelExpressionParser();

        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, Calendar.AUGUST, 9);

        var tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        System.out.println("class name ::" + tesla.getClass().getName());

        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String nameFromContext = (String) exp.getValue(context);
//                          or
        String nameFromObj = (String) exp.getValue(tesla);

        System.out.println("nameFromContext :: " + nameFromContext);
        System.out.println("nameFromObj :: " + nameFromObj);

        Expression bolExp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = Boolean.TRUE.equals(bolExp.getValue(context, Boolean.class));
        System.out.println("boolean result :: " + result);

        final Expression methodExp = parser.parseExpression("getNameAndNationality()");
        final String methodExpValue = methodExp.getValue(context, String.class);
        System.out.println("methodResolver :: " + methodExpValue);

    }

}
