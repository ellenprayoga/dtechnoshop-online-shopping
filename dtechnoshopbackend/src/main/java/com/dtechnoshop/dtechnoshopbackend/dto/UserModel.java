package com.dtechnoshop.dtechnoshopbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
@DynamicUpdate
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Tolong masukkan nama Anda!")
	/*@Pattern(regexp="[^0-9]+", message = "Nama Anda tidak valid!")*/
	private String name;
	
	@Column(name = "phone_number")
	@NotEmpty(message = "Tolong masukkan no telp Anda!")
	/*@Pattern(regexp="[^A-Z]+[^a-z]+", message = "No telp Anda tidak valid!")*/
	private String phoneNumber;
	
	@NotEmpty(message = "Tolong pilih provinsi !")
	@Transient
	private String province;
	
	@NotEmpty(message = "Tolong pilih kota !")
	@Transient
	private String city;
	
	@NotEmpty(message = "Tolong pilih kecamatan !")
	@Transient
	private String subdistrict;
	
	@NotEmpty(message = "Tolong masukkan alamat lengkap Anda !")
	@Transient
	private String specificAddress;
	
	@NotEmpty(message = "Silahkan masukkan kode pos !")
	@Transient
	private String postalCode;
	
	private String address;
	
	@NotEmpty(message = "Tolong masukkan email Anda!")
	@Email(message = "Email tidak valid !")
	private String email;
	
	@NotEmpty(message = "Tolong masukkan password Anda!")
	private String password;
	
	private String role;
	
	@Transient
	@NotEmpty(message = "Tolong ulangi password Anda!")
	private String validatePassword;
	
	@Transient
	@AssertTrue(message = "Anda belum menyetujui persyaratan kami!")
	private boolean agreement;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getSpecificAddress() {
		return specificAddress;
	}

	public void setSpecificAddress(String specificAddress) {
		this.specificAddress = specificAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getValidatePassword() {
		return validatePassword;
	}

	public void setValidatePassword(String passwordRepeat) {
		this.validatePassword = passwordRepeat;
	}

	public boolean isAgreement() {
		return agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
