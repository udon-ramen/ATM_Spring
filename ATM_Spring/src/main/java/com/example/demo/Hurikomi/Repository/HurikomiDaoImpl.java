package com.example.demo.Hurikomi.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HurikomiDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// UserID -> ログイン中ユーザID
	// Hurikomigaku -> 振り込み額
	// HurikomiID -> 振込先ID
	public int CalculateZanndaka(String UserID, int Hurikomigaku) {
    	
    	System.out.println(UserID);
    	String sql1 = "SELECT zandaka FROM table1 WHERE id = ?";
    	int zanndaka_now = jdbcTemplate.queryForObject(
    			sql1, new Object[] { UserID }, Integer.class);
//    	System.out.println(zanndaka_now);
    	int zanndaka_new = zanndaka_now - Hurikomigaku;
    	System.out.println(zanndaka_new);
//    	System.out.println(result);
    	return zanndaka_new;
    }
	
	public void Hurikomi(String UserID, int zanndaka_amount, 
			int Hurikomigaku, String HurikomiID) {
		
		//ログインユーザの残高更新
		String sql2 = "UPDATE table1 SET zandaka = ? where id = ?";
    	jdbcTemplate.update(sql2, new Object[] { zanndaka_amount, UserID });
    	//振込先の残高更新
    	String sql3 = "SELECT zandaka FROM table1 WHERE id = ?";
    	int zanndaka_hurikomisaki = jdbcTemplate.queryForObject(
    			sql3, new Object[] { HurikomiID }, Integer.class);
    	System.out.println(zanndaka_hurikomisaki);
    	int zanndaka_Hurikomisaki_new = zanndaka_hurikomisaki + Hurikomigaku;
    	System.out.println(zanndaka_Hurikomisaki_new);
    	String sql4 = "UPDATE table1 SET zandaka = ? where id = ?";
    	jdbcTemplate.update(sql4, new Object[] { zanndaka_Hurikomisaki_new, HurikomiID });
    	
	}

}
