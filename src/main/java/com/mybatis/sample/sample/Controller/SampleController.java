package com.mybatis.sample.sample.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/")
    public String sampleList(Model model, @RequestParam(name = "ids[]", required = false) List<Integer> ids){
        System.out.println("ids : "+ ids);
        model.addAttribute("data", "text");
        return "index";
    }

}
