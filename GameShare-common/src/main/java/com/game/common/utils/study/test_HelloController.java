//package com.game.controller;
//
//import com.game.entity.User;
//import io.swagger.v3.oas.annotations.Operation;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class test_HelloController {
//
//    //localhost:8080/hello?name=Pikachu
//    @Operation(summary = "获取用户信息接口", description = "通过用户ID获取用户信息")
//    @RequestMapping(value="/hello",method= RequestMethod.GET)
//    public String hello(String name, String psw, HttpServletRequest request) {
//        String path=request.getServletContext().getRealPath("/upload/");
//        System.out.println("/upload 地址为："+path);
//        return "Hello World! "+name;
//    }
//    //localhost:8080/hello?name=Pikachu
//    @RequestMapping(value="/hello2",method= RequestMethod.POST)
//    public String hello2(@RequestParam(value="name",required = true) String name_Plus) {     //注解声明url参数name和这里的形参name_Plus映射，且预设该参为必需项
//        return "Hello World!"+"这里是Post请求、必选参数为name。name="+name_Plus;
//    }
//    @RequestMapping(value="/hello3",method= RequestMethod.POST)
//    public String hello3(User user) {   //传递对象
//        return "Hello World!"+"这里是Post请求。user="+user;
//    }
//    @RequestMapping(value="/hello4",method= RequestMethod.POST)
//    public String hello4(@RequestBody User user) {   //传递json
//        return "Hello World!"+"这里是Post请求。user="+user;
//    }
//    //localhost:8080/allMatch/layer1/later2/layer3
//    @GetMapping("/allMatch/**")
//    public String allMatch() {
//        return "全匹配：无论几层都会被匹配";
//    }
//}
