/* UserAccount.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package security;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

@Document(collection = "userAccount")
public class UserAccount implements UserDetails {

	// Constructors -----------------------------------------------------------

	private static final long serialVersionUID = 7254823034213841482L;

	public UserAccount() {
		super();

		this.authorities = new ArrayList<Authority>();
	}

	// Attributes -------------------------------------------------------------

	// UserDetails interface --------------------------------------------------

	@Id
	private String id;
	private String username;
	private String password;
	private Collection<Authority> authorities;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Size(min = 5, max = 32)
	@Column(unique = true)
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty
	@Valid
	@ElementCollection
	@Override
	public Collection<Authority> getAuthorities() {
		// WARNING: Should return an unmodifiable copy, but it's not possible
		// with hibernate!
		return authorities;
	}

	public void setAuthorities(Collection<Authority> authorities) {
		this.authorities = authorities;
	}

	public void addAuthority(Authority authority) {
		Assert.notNull(authority);
		Assert.isTrue(!authorities.contains(authority));

		authorities.add(authority);
	}

	public void removeAuthority(Authority authority) {
		Assert.notNull(authority);
		Assert.isTrue(authorities.contains(authority));

		authorities.remove(authority);
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}

}
