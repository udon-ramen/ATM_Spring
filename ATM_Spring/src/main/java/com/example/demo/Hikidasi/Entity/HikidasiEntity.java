package com.example.demo.Hikidasi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "table1")
public class HikidasiEntity {
	@Id
	private String id;
	private String password;
}
