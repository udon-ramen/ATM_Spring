package com.example.demo.Zanndaka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Hikidasi.UserInfoHolder.Parameter;
import com.example.demo.Zanndaka.Repository.ZanndakaDao;

@Controller
public class ZanndakaController {
	
	@Autowired
	private ZanndakaDao Z_Dao;
	Parameter parameter = new Parameter();
	
	private String UserID;
	private int zanndaka;
	
	public ZanndakaController() {
		this.UserID = null;
		this.zanndaka = 0;
	}

	@PostMapping("/zanndaka")
    public ModelAndView Azukeire(){
		
		ModelAndView mod = new ModelAndView();
		
		//ログイン中のユーザID
		UserID = parameter.getUserId();
		
		this.zanndaka = Z_Dao.CalculateZanndaka(UserID);				
		mod.setViewName("zanndaka");
		mod.addObject("zanndaka", this.zanndaka);
		return mod;

	}

}
