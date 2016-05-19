package com.oums.junit.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oums.util.OrderUtil;

public class TestOrderUtil {

	@Test
	public void testCreateOrderNumber() {
		System.out.println(OrderUtil.createOrderNumber());
	}

}
