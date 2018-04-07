package com.shokoladenmarmot.HugoHealth.tests;

import org.junit.Test;

import com.shokoladenmarmot.HugoHealth.core.Checker;

import static org.junit.Assert.*;

public class SimpleUnit {
	@Test
	public void testBitcoin() {

		assertTrue("Check 'bitcoin' symbol", Checker.printPriceCap("bitcoin"));
	}

	@Test
	public void testEthereum() {

		assertTrue("Check 'ethereum' symbol", Checker.printPriceCap("ethereum"));
	}

	@Test
	public void testEncyclopedia() {

		assertFalse("Check 'encyclopedia' symbol", Checker.printPriceCap("encyclopedia"));
	}
}
