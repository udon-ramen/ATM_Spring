package com.example.demo.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Menu2Controller {
		
	@PostMapping("/hikidasi")
    public String Hikidasi(){
        return "hikidasi";
    }
	
	@PostMapping("/azukeire")
    public String Azukeire(){
        return "azukeire";
    }
	
	@PostMapping("/hurikomi")
    public String Hurikomi(){
        return "hurikomi";
    }
	
	@PostMapping("/menu")
    public String Menu(){
        return "menu";
    }
	
}
