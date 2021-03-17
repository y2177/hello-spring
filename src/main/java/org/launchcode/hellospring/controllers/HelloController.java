package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody //if put ResponseBody here, don't need it above each method
@RequestMapping("hello")
//Can remove value = 'hello' and "hello/ portion of @GetMapping("hello/{name}")
public class HelloController {

    //@GetMapping("hello")
    //@ResponseBody
    ////It lives at root path /hello
    //public String hello() {
    //    return "Hello, Spring!";
    //}

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //live /hello/hello
    //Dynamically request of the form /hello?name=Launchcode with "Launchcode" being replaceable
    //Name in url matches Queryparameter/method parameter. Will populate method parameter name
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //Form has input called name (input type's name = 'name') that also matches String in hello method
    //which also has that form action
    //Inserting method = 'post' makes it a post request instead of default get request
    //lives at hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + // submit a request to /hello
                "<input type='text' name = 'name'>" +
                "<input type = 'submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
