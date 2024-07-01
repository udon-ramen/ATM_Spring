package com.example.demo.Hurikomi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Hikidasi.UserInfoHolder.Parameter;
import com.example.demo.Hurikomi.Service.HurikomiService;

@Controller
public class HurikomiController {
	
	Parameter parameter = new Parameter();
	@Autowired
	private HurikomiService h_Service;
	
	private boolean judge_zanndaka;
	private String UserID;
	private int zanndaka;
	
	public HurikomiController() {
		this.judge_zanndaka = false; 
		this.UserID = null;
		this.zanndaka = 0;
	}

	@PostMapping("/ohurikomi")
    public ModelAndView Hurikomi(@RequestParam("hurikomigaku") String money, 
    							 @RequestParam("hurikomisaki") String HurikomiID){
		
		ModelAndView mod = new ModelAndView();
		int hurikomigaku = Integer.parseInt(money);
		
		//引き出し額の限度額10万円を判定
		if (100000 <= hurikomigaku) {
			mod.setViewName("hurikomi");
			mod.addObject("message", "限度額を超えています");
			return mod;
			
		} else {
			//ログイン中のユーザID
			UserID = parameter.getUserId();
			//残高が0円以上か判定
			judge_zanndaka = h_Service.judjeZanndaka(UserID, hurikomigaku, HurikomiID); 
			
			if (judge_zanndaka) {
				this.zanndaka = h_Service.getZanndaka_amount();				
				mod.setViewName("zanndaka");
				mod.addObject("zanndaka", this.zanndaka);
				return mod;
				
			} else {
				mod.setViewName("hurikomi");
				mod.addObject("message", "残高が不足しています");
				return mod;
			}
		}
    }
	
}
