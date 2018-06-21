package com.munifec.carpool.util;

import java.util.Random;

public class OTPGenerator {

	public static Integer generateOTP(){
		Random r = new Random(99000);
		Integer r2 = 100000 + r.nextInt();
		return r2;
	}
}
