package codegym.vn.controller;

import codegym.vn.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TranslateController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping (value = "/translate")
    public String getTranslateForm(){
        return "translate";
    }
    @GetMapping (value = "/result")
    public String result(@RequestParam String english, Model model){
       Map<String,String> map = dictionaryService.findAll();
       String result = map.get(english);
        model.addAttribute("result",result);
        return "result";
    }
}
