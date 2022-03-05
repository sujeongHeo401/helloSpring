package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http:localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path="/hi", method = RequestMethod.GET) // get / post / put / delete
    public String hi(){
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("Path Variable : " + pathName);
        return pathName;
    }
    //http://localhost:9090/api/get/query-param?
    //s earch?q=intellij&oq=intellij
    // &aqs=chrome.0.69i59l3j35i39j69i59j0i512l2j69i61.1580j0j7
    // &sourceid=chrome
    // &ie=UTF-8
    //?key=value&key2=value2
    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gamil.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam  Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                    System.out.println("\n");

                    sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
                });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }


    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){ // 객체들어오면 쿼리 파람에 있는 주소들 값들을 스프링부트에서 판단함. 변수와 이름을 알아서 매칭을 해줌
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
