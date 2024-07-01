package com.example.demo.Hurikomi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Hikidasi.UserInfoHolder.Parameter;
import com.example.demo.Hurikomi.Repository.HurikomiDaoImpl;

@Service
public class HurikomiService {
	
	@Autowired
    private HurikomiDaoImpl hurikomiDaoImpl;
	
	private int zanndaka_amount;
	
	Parameter parameter = new Parameter();
	
    public boolean judjeZanndaka(String UserID, int Hurikomigaku, String HurikomiID) {
    	
    	//Controllerに残高の結果返す
		boolean zanndakaTrueorFalse;
		//HikidasiDaoImpl から引き出しの計算結果を取得
		this.zanndaka_amount = hurikomiDaoImpl.
				CalculateZanndaka(UserID, Hurikomigaku);
		
		if (this.zanndaka_amount < 0) {
			zanndakaTrueorFalse = false;
			return zanndakaTrueorFalse;
		} else {
			zanndakaTrueorFalse = true;
			hurikomiDaoImpl.Hurikomi(UserID, zanndaka_amount, Hurikomigaku, HurikomiID);
			return zanndakaTrueorFalse;
		}
		
	}
    
    public int getZanndaka_amount() {
		return this.zanndaka_amount;
	}

}
