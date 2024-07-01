package com.example.demo.Hikidasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Hikidasi.Service.HikidasiService;
import com.example.demo.Hikidasi.UserInfoHolder.Parameter;

@Controller
public class HikidasiController {
	
	Parameter parameter = new Parameter();
	@Autowired
	private HikidasiService h_Service;
	
	private boolean judge_zanndaka;
	private String UserID;
	private int zanndaka;
	
	public HikidasiController() {
		this.judge_zanndaka = false; 
		this.UserID = null;
		this.zanndaka = 0;
	}

	@PostMapping("/syukkinn")
    public ModelAndView Hikidasi(@RequestParam("hikidasigaku") 
    								String money){
		
		ModelAndView mod = new ModelAndView();
		int hikidasigaku = Integer.parseInt(money);
		
		//引き出し額の限度額10万円を判定
		if (100000 <= hikidasigaku) {
			mod.setViewName("hikidasi");
			mod.addObject("message", "限度額を超えています");
			return mod;
			
		} else {
			//ログイン中のユーザID
			UserID = parameter.getUserId();
			//残高が0円以上か判定
			judge_zanndaka = h_Service.judjeZanndaka(UserID, hikidasigaku); 
			
			if (judge_zanndaka) {
				this.zanndaka = h_Service.getZanndaka_amount();				
				mod.setViewName("zanndaka");
				mod.addObject("zanndaka", this.zanndaka);
				return mod;
				
			} else {
				mod.setViewName("hikidasi");
				mod.addObject("message", "残高が不足しています");
				return mod;
			}
		}
    }
	
}