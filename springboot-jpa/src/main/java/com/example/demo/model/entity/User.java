package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
Table name: room
+---------+-----------+---------------+-----------+-----------+-----------+---------+
| user_id | username  | password_hash | salt      | email     | active    | role    |  
+---------+-----------+---------------+-----------+-----------+-----------+---------+
|    1    |   john    |   Qwd1234..   | $ED...    | A@gmail   |  true     | admin   |
|    2    |   mary    |   Qwd5434..   | $aw...    | b@gmail   |  false    | user    |
+---------+-----------+---------------+-----------+-----------+-----------+---------+
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 id
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(name = "password_hash", nullable =  false)
	private String passwordHash;
	
	@Column(name = "salt", nullable =  false)
	private String salt;
	
	@Column(name = "email", nullable =  false)
	private String email;
	
	@Column(name = "active")
	private Boolean active;

	
	@Column(name = "role")
	private String role;
}
