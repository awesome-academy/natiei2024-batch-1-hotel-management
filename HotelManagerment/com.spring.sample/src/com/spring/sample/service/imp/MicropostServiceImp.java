package com.spring.sample.service.imp;

import org.springframework.stereotype.Service;

import com.spring.sample.service.MicropostService;

@Service
public class MicropostServiceImp extends BaseServiceImpl implements MicropostService {

	private MicropostServiceImp() {
	}

	@Override
	public Long loadCCountRecord() {
		return micropostDAO.getCountRecord();
	}

}
