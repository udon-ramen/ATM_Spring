package com.example.demo.Login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table1")
public class MyUser {
	@Id
	private String id;
	private String password;
}
