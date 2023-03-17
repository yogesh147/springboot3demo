package com.springboot.demo.I18N;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class I18NDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(I18NDemoApplication.class, args);
        System.out.println(":::::::::::::::::::::::::::::: I18N Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("pl-PL"));
        String message = bundle.getString("label");

		final Locale locale = LocaleContextHolder.getLocale();
		ResourceBundle bundle2 = ResourceBundle.getBundle("messages", locale);
		String message2 = bundle2.getString("label");

        System.out.println(locale);

        final Locale hinIndiaLocal = new Locale("hi", "IN");
        System.out.println(Currency.getInstance(hinIndiaLocal).getSymbol());

        final Locale engIndiaLocal = new Locale("EN", "IN");
        System.out.println(Currency.getInstance(engIndiaLocal).getSymbol());

        log.info("polish local Message :: {}", message);
		log.info("Local local Message ::  {}", message2);

        System.out.println(":::::::::::::::::::::::::::::: NumberFormat Demo :::::::::::::::::::::::::::::::::::");

        double d = 123456.789;
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
        NumberFormat nf2 = NumberFormat.getInstance(Locale.CHINA);
        NumberFormat nf3 = NumberFormat.getInstance(engIndiaLocal);

        System.out.println("ITALY representation of " + d + " : " + nf.format(d));
        System.out.println("US representation of " + d + " : " + nf1.format(d));
        System.out.println("CHINA representation of " + d + " : " + nf2.format(d));
        System.out.println("INDIA representation of " + d + " : " + nf3.format(d));


        System.out.println(":::::::::::::::::::::::::::::: currency format Demo :::::::::::::::::::::::::::::::::::");

        Locale localee = Locale.UK;
        Currency curr = Currency.getInstance(localee);
        System.out.println("UK Currency symbol is: " + curr.getSymbol(localee));

        Currency currency = Currency.getInstance(locale);
        System.out.println("Local Currency symbol is: " + currency.getSymbol(locale));

        printCurrency(Locale.UK);
        printCurrency(Locale.US);
        printCurrency(Locale.FRANCE);
        printCurrency(hinIndiaLocal);
        printCurrency(engIndiaLocal);

    }

    static void printCurrency(Locale locale) {
        double dbl = 10500.3245;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String currency = formatter.format(dbl);
        System.out.println( currency + " for the locale " + locale);
    }

}
