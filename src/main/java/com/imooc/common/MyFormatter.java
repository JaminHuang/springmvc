package com.imooc.common;

import org.springframework.format.number.CurrencyFormatter;

import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

//格式化转换
public class MyFormatter {

    public static void main(String[] args) throws ParseException {
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        currencyFormatter.setFractionDigits(2);//保留小数点后几位
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);//舍入模式 ceiling 表示四舍五入
        System.out.println(currencyFormatter.parse("$123.125", Locale.US));
    }
}
