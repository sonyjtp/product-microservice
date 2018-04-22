package com.myretail.product.domain;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.myretail.product.constants.MyRetailConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection=MyRetailConstants.COLL_ROLE)
public class Role {
	
	@Id
	private String roleName;
	
	@NotNull
	private String roleDescription;


}
