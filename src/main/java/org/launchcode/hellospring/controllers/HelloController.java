package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody
//@RequestMapping("hello")
public class HelloController {



    // lives/hello/goodbye because of RequestMapping annotation above class
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    //@RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }


    //@ResponseBody
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //submit a request to /hello
//                //"<form action='hello'>" + //submit a request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @RequestMapping(method=RequestMethod.GET, value = "hello")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form method='post'>" +
                "<input type='text' name='name'/>" +
                "<select name='language'>" +
                "<option value=''>--Please choose an option--</option>" +
                "<option value='French'>French</option>" +
                "<option value='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='Flemish'>Flemish</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    @RequestMapping(method=RequestMethod.POST, value = "hello")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        String message = "Hello";
        if(language.equals("French")) {
            message = "<i>Bonjour </i>";
        }
        if(language.equals("English ")){
            message = "<i>Hello </i>";
        }
        if(language.equals("Spanish")){
            message = "<i>Hola </i>";
        }
        if(language.equals("Italian")){
            message = "<i>Ciao </i>";
        }
        if(language.equals("Flemish")){
            message = "<i>Hallo </i>";
        }
        return message + name + "!";
    }

}
