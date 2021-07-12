package org.launchcode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@ResponseBody // for plain text responses, all handlers.
public class SkillsController {

    // Responds to 8080 since @GetMapping has mo params
    @GetMapping  // Responds to an http "get" request.
    public String skillsPreamble() {
        System.out.println("InSkills");
        return "<html>" +
                "<body style='margin-left:15%'>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like you to learn. Here is the list!</h2>" +
                "<h3><ol>" +
                "<li>Java</li>" +
                "<li>Python</li>" +
                "<li>JavaScript</li>" +
                "</ol></h3>";
    }


    @GetMapping("form")
    public String skillsForm() {   //default get method
        System.out.println("InSkillsForm");
        return "<html>" +
                "<body>" +
                "<h2>" +    //Refactor below to DRY asap.
                "<form action='' method='post' style='margin-left:15%'>" +  // submit a request to /form
                "<label>Name: </label><br>" +
                "<input type='text' name='name'><br>" +
                "<label for='languages'>My favorite language:</label>" +
                "<br><select name='language1' >" +     //name takes the selected result
                "<option value='Java'>Java</option>" +  // value gives result if chosen, label is Java.
                "<option value='Python'>Python</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "</select>" +
                "<br><label for='languages'>My second favorite language:</label>" +
                "<br><select name='language2' id='languages'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "</select>" +
                "<br><label for='languages'>My third favorite language:</label>" +
                "<br><select name='language3' id='languages'>" +
                "<option value='Java'>Java</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "</select>" +
                "<br><input type='submit' value='Submit'>" +
                "</form>" +
                "</h2>" +
                "</body>" +
                "</html>";
    }
    // Handles requests of the form /form?name=Fred,language1=java,language2=javaScript,language3=python
    @PostMapping("form")
    public String skillsFormHandler(@RequestParam String name, @RequestParam String language1, @RequestParam String language2,
                                      @RequestParam String language3) {
               return "<html>" +
                "<body style='margin-left:40%'>" +
                "<h1>" + name + "</h1>" +
                "<h2 style='margin-left:3%'><ol>" +
                "<li>" + language1 + "</li>" +
                "<li>" + language2 + "</li>" +
                "<li>" + language3 + "</li>" +
                "</ol></h2>" +
                "</body>" +
                "</html>";
    }
}
