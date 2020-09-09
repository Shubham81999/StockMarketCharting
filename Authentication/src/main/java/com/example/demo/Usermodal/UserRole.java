package com.example.demo.Usermodal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Authenticate_User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Role_id")
	private int id;

	@Column(name = "Role_name")
	private String role;
	
}
