package com.myretail.product.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.myretail.product.constants.MyRetailConstants;
import com.myretail.product.vo.PricePair;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document(collection=MyRetailConstants.COLL_PRICING)
public class Pricing {
	
	@Id
	private Long id;
	
	private PricePair currentPrice;
	
	

}
