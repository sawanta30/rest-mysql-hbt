package com.hbmdemo.util;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

public class EmployeeIdGenerator implements ValueGenerator<Long> {

	@Override
	public Long generateValue(Session session, Object owner) {
		
		return null;
	}

}
