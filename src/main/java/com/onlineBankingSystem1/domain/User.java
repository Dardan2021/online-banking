package com.onlineBankingSystem1.domain;



import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlineBankingSystem1.domain.security.Authority;
import com.onlineBankingSystem1.domain.security.UserRole;


@Entity
public class User implements UserDetails  {
	
	
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId",nullable=false, updatable=false)
	private Long userId;
	
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String phone;
	@Column(name="email",nullable=false, updatable=false)
	private String email;
	private boolean enabled=true;
	@OneToOne
    @JoinColumn(name = "primary_account_id")
	    private PrimaryAccount primaryAccount;

	@OneToOne
	@JoinColumn(name = "savings_account_id")
	private SavingsAccount savingsAccount;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonIgnore
	    private List<Appointment> appointmentList;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Recipient> recipientList;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole>  userRole=new HashSet<>();
	
	
	public Set<UserRole> getUserRole() {
		return userRole;
}
public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
}
	

	public PrimaryAccount getPrimaryAccount() {
	return primaryAccount;
}
public void setPrimaryAccount(PrimaryAccount primaryAccount) {
	this.primaryAccount = primaryAccount;
}
public SavingsAccount getSavingsAccount() {
	return savingsAccount;
}
public void setSavingsAccount(SavingsAccount savingsAccount) {
	this.savingsAccount = savingsAccount;
}
public List<Appointment> getAppointmentList() {
	return appointmentList;
}
public void setAppointmentList(List<Appointment> appointmentList) {
	this.appointmentList = appointmentList;
}
public List<Recipient> getRecipientList() {
	return recipientList;
}
public void setRecipientList(List<Recipient> recipientList) {
	this.recipientList = recipientList;
}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
	@Override
    public String toString() {
       return "User{" +
              "userId=" + userId +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
               ", appointmentList=" + appointmentList +
               ", recipientList=" + recipientList +
                ", userRole=" + userRole +
               '}';}
@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorites= new HashSet<>();
		userRole.forEach(ur -> authorites.add(new Authority(ur.getRole().getName())));
		
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		 //TODO Auto-generated method stub
	return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
	return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
@Override
	public boolean isEnabled() {
	//	// TODO Auto-generated method stub
		return enabled;
	}



}
