package com.oums.junit.util;

import static org.junit.Assert.*;

import org.junit.Test;


import com.oums.util.ValidateUtil;

public class TestValidateUtil {

	@Test
	public void test1() {
		String num = "12213123a";
		System.out.println("b:" + ValidateUtil.stringIsNum(num));
	}

}
