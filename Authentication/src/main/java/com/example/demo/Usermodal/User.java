package com.example.demo.Usermodal;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Authenticate_User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "User_id")
		private Long id;
		
		@Column(name = "User_name")
		private String userName;

		@Column(name = "EmailID")
		private String email;

		@Column(name = "Password")
		private String password;

		@Column(name = "Mobile_Number")
		private String mobile;

		@Column(name = "Status")
		private boolean isEnabled;
		
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "Auth_user_role", joinColumns = @JoinColumn(name = "User_id"), inverseJoinColumns = @JoinColumn(name = "Role_id"))
		private Set<UserRole> roles;
		
}
