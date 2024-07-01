package com.example.demo.Hikidasi.Repository;

import org.springframework.stereotype.Repository;

import com.example.demo.Hikidasi.Entity.HikidasiEntity;

@Repository
public interface HikidasiDao {
	 HikidasiEntity findUserByUserName(String userName);
}
