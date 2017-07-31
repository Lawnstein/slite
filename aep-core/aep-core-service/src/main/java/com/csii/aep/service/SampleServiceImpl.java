package com.csii.aep.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csii.aep.facade.SampleService;

public class SampleServiceImpl implements SampleService {

	private static final Logger logger = LoggerFactory.getLogger(InnerLendServiceImpl.class);

	@Override
	public String message(String name) {
		logger.info("Thread[{}], try to call SampleServiceImpl.message(), name: {}", Thread.currentThread().getName(),
				name);

		String out = "Hello, " + name + ", Service slitecore, " + new Date();
		logger.info("Thread[{}], return hint : {}", Thread.currentThread().getName(), out);
		return out;
	}
}
