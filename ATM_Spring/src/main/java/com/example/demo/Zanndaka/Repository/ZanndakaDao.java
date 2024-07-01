package com.example.demo.Zanndaka.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZanndakaDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
    public int CalculateZanndaka(String UserID) {
    	
//    	System.out.println(UserID);
    	String sql1 = "SELECT zandaka FROM table1 WHERE id = ?";
    	int zanndaka_now = jdbcTemplate.queryForObject(sql1, new Object[] { UserID }, Integer.class);

    	return zanndaka_now;
    }

}
