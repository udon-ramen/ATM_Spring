package com.example.demo.Azukeire.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AzukeireRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
    public int CalculateZanndaka(String UserID, int Hikidasigaku) {
    	
//    	System.out.println(UserID);
    	String sql1 = "SELECT zandaka FROM table1 WHERE id = ?";
    	int zanndaka_now = jdbcTemplate.queryForObject(sql1, new Object[] { UserID }, Integer.class);
//    	System.out.println(zanndaka_now);
    	int zanndaka_new = zanndaka_now + Hikidasigaku;
    	System.out.println(zanndaka_new);
    	String sql2 = "UPDATE table1 SET zandaka = ? where id = ?";
    	jdbcTemplate.update(sql2, new Object[] { zanndaka_new, UserID });
//    	System.out.println(result);
    	return zanndaka_new;
    }

}
