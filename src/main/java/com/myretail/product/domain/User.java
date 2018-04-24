package com.myretail.product.domain;

import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.myretail.product.constants.MyRetailConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = MyRetailConstants.COLL_USER)
public class User {

	@Id
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private transient String password;
	
	@DBRef
	private List<Role> roles;

	@Override
	public String toString() {
		return "User [username=" + username + ", roles=" + roles + "]";
	}
	
	
}
