package com.example.demo.Azukeire.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Azukeire.Repository.AzukeireRepository;
import com.example.demo.Hikidasi.UserInfoHolder.Parameter;

@Controller
public class AzukeireController {
	
	@Autowired
	private AzukeireRepository A_Repository;
	Parameter parameter = new Parameter();
	
	private String UserID;
	private int zanndaka;
	
	public AzukeireController() {
		this.UserID = null;
		this.zanndaka = 0;
	}

	@PostMapping("/nyuukinn")
    public ModelAndView Azukeire(@RequestParam("azukeiregaku") 
    								String money){
		
		ModelAndView mod = new ModelAndView();
		int azukeiregaku = Integer.parseInt(money);
		
		//引き出し額の限度額10万円を判定
		if (500000 <= azukeiregaku) {
			mod.setViewName("azukeire");
			mod.addObject("message", "限度額を超えています");
			return mod;
			
		} else {
			//ログイン中のユーザID
			UserID = parameter.getUserId();			
			this.zanndaka = A_Repository.CalculateZanndaka(UserID, azukeiregaku);				
			mod.setViewName("zanndaka");
			mod.addObject("zanndaka", this.zanndaka);
			return mod;

		}
	}
}
