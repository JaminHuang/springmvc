package com.imooc.controller;

import com.imooc.object.Admin;
import com.imooc.object.User;
import com.imooc.object.UserListForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class TestController {

    //基础类的处理 http://localhost:8080/springmvc/baseType.do?xage=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age) {
        return "age:"+ age;
    }

    //包装类的处理 http://localhost:8080/springmvc/baseType2.do?age=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age:"+ age;
    }

    //数组类的处理 http://localhost:8080/springmvc/array.do?name=Jamin&name=Tony&name=Lucy
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for (String item : name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //简单对象的处理       http://localhost:8080/springmvc/object.do?name=Tome&age=10
    //多层级数据对象的绑定 http://localhost:8080/springmvc/object.do?name=Tome&age=10&contactInfo.phone=10086
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String Object(User user) {
        return user.toString();
    }

    //关于List、Set、Map的数据绑定
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return userListForm.toString();
    }

    //关于Json的数据绑定 {"name":"BeJson","age":10,"contactInfo":{"phone":18868808315,"address":"10011"}}
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
        return user.toString();
    }

    //关于Xml的数据绑定 <?xml version="1.0" encoding="UTF-8" ?><admin><name>BeJson</name><age>10</age></admin>
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }

    //关于Converter转换 http://localhost:8080/springmvc/converter.do?bool=yes
    @RequestMapping(value = "converter.do")
    @ResponseBody
    public String converter(Boolean bool) {
        return bool.toString();
    }

    //关于Converter转换 http://localhost:8080/springmvc/date1.do?date1=2018-01-01
    @RequestMapping(value = "date1.do")
    @ResponseBody
    public String date1(Date date1) { return date1.toString(); }

    //关于Converter转换 http://localhost:8080/springmvc/date2.do?date2=2018-01-01
    @RequestMapping(value = "date2.do")
    @ResponseBody
    public String date2(Date date2) { return date2.toString(); }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return "book.default";
        }else if (contentType.equals("txt")) {
            return "book.txt";
        }else if (contentType.equals("html")) {
            return "book.html";
        }
        return "book.default";
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.GET)
    @ResponseBody
    public String subjectGet(@PathVariable("subjectId") String subjectId){
        return "this is a get method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.POST)
    @ResponseBody
    public String subjectPost(@PathVariable("subjectId") String subjectId){
        return "this is a post method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String subjectDelete(@PathVariable("subjectId") String subjectId){
        return "this is a delete method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.PUT)
    @ResponseBody
    public String subjectPut(@PathVariable("subjectId") String subjectId){
        return "this is a put method,subjectId:"+subjectId;
    }
}
