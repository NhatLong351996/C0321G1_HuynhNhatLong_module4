package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping(value = "/convert")
    public String convert(){
        return "convert";
    }
    @GetMapping(value = "/result")
    public String result(@RequestParam int usd, Model model){
        int result =usd*22000;
        model.addAttribute("result",result);
        return "result";
    }
}
