package codegym.vn.controller;

import codegym.vn.model.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    ConvertService convertService ;
    @GetMapping(value = "/convert")
    public String convert(){
        return "convert";
    }
    @GetMapping(value = "/result")
    public String result(@RequestParam int usd, Model model){
        int result =convertService.calculate(usd);
        model.addAttribute("result",result);
        return "result";
    }
}
