package cn.lilicat.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("host","dasjdnja");
        return "index";
    }
}
