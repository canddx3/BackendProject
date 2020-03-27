package com.volapp.charityuser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
 
    private String charityTitle;
    private String charityName;
    private String charityCat;
    private String charityStreet;
    private String charityCity;
    private String charityState;
    private Long charityZip;
    private Long charityPhone;
    
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCharityTitle() {
		return charityTitle;
	}

	public void setCharityTitle(String charityTitle) {
		this.charityTitle = charityTitle;
	}

	public String getCharityName() {
		return charityName;
	}

	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}

	public String getCharityCat() {
		return charityCat;
	}

	public void setCharityCat(String charityCat) {
		this.charityCat = charityCat;
	}

	public String getCharityStreet() {
		return charityStreet;
	}

	public void setCharityStreet(String charityStreet) {
		this.charityStreet = charityStreet;
	}

	public String getCharityCity() {
		return charityCity;
	}

	public void setCharityCity(String charityCity) {
		this.charityCity = charityCity;
	}

	public String getCharityState() {
		return charityState;
	}

	public void setCharityState(String charityState) {
		this.charityState = charityState;
	}

	public Long getCharityZip() {
		return charityZip;
	}

	public void setCharityZip(Long charityZip) {
		this.charityZip = charityZip;
	}

	public Long getCharityPhone() {
		return charityPhone;
	}

	public void setCharityPhone(Long charityPhone) {
		this.charityPhone = charityPhone;
	}
	
	
}

