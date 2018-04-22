package com.myretail.product.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.Pricing;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.repository.PricingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PricingService implements MyRetailService<Pricing, Long> {

	private PricingRepository pricingRepository;

	@Autowired
	public PricingService(PricingRepository pricingRepository) {
		this.pricingRepository = pricingRepository;
	}

	@Override
	public List<Pricing> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pricing find(Long id) throws MyRetailException {
		Pricing pricing = null;
		try {
			pricing = pricingRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			String errorMessage = String.format("Invalid product id: %d", id);
			log.error(e.getMessage(), e);
			throw new MyRetailException(e, errorMessage);
		} catch (DataAccessException e) {
			String errorMessage = "Unable to access database";
			log.error(e.getMessage(), e);
			throw new MyRetailException(e, errorMessage);
		}
		return pricing;
	}

	@Override
	public void create(Pricing t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pricing save(Pricing t) throws MyRetailException {
		try {
			t = pricingRepository.save(t);
		} catch (DataAccessException e) {
			String errorMessage = "Unable to access database";
			log.error(e.getMessage(), e);
			throw new MyRetailException(e, errorMessage);
		}
		return t;
	}

	@Override
	public void delete(Pricing t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
