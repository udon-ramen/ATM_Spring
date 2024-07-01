package com.example.demo.Login.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Login.entity.MyUser;

@Repository
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * userNameを検索条件にSELECT文を実行して、DBに登録されているユーザを検索する
     * @param userName
     * @return User
     */
    @Override
    public MyUser findUserByUserName(String userName) {
    	
    	System.out.println(userName);
    	
        String sql = "SELECT id, password FROM table1 WHERE id = ?";
        
        System.out.println(sql);

        //ユーザを一件取得
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, userName);
        
        System.out.println(result);

        // Entityクラス(User型)に変換
        MyUser user = convMapToUser(result);
        
        System.out.println(user);

        return user;
    }

    /**
     * SQL SELECT文を実行した結果(Map<String, Object>)をUser型に変換する
     * @param Map<String, Object>
     * @return User
     */
    private MyUser convMapToUser(Map<String, Object> map) {
        MyUser user = new MyUser();

        user.setId((String) map.get("username"));
        user.setPassword((String) map.get("password"));
        
        System.out.println(user);

        return user;
    }
}
