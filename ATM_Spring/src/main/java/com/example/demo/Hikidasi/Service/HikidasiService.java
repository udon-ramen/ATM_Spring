package com.example.demo.Hikidasi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Hikidasi.Repository.HikidasiDaoImpl;
import com.example.demo.Hikidasi.UserInfoHolder.Parameter;

@Service
public class HikidasiService {
	
	@Autowired
    private HikidasiDaoImpl hikidasiDaoImpl;
	
	private int zanndaka_amount;
	
	Parameter parameter = new Parameter();
	
    public boolean judjeZanndaka(String UserID, int Hikidasigaku) {
    	
    	//Controllerに残高の結果返す
		boolean zanndakaTrueorFalse;
		//HikidasiDaoImpl から引き出しの計算結果を取得
		this.zanndaka_amount = hikidasiDaoImpl.
				CalculateZanndaka(UserID, Hikidasigaku);
		
		if (this.zanndaka_amount < 0) {
			zanndakaTrueorFalse = false;
			return zanndakaTrueorFalse;
		} else {
			zanndakaTrueorFalse = true;
			hikidasiDaoImpl.UpdateZanndaka(UserID, zanndaka_amount);
			return zanndakaTrueorFalse;
		}
		
	}
    
    public int getZanndaka_amount() {
		return this.zanndaka_amount;
	}

}
