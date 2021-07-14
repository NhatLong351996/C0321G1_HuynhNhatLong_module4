package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @GetMapping (value = "/translate")
    public String getTranslateForm(){
        return "translate";
    }
    @GetMapping (value = "/result")
    public String result(@RequestParam String english, Model model){
        model.addAttribute("english",english);
        return "result";
    }
}
