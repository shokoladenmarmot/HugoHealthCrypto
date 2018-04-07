package com.shokoladenmarmot.HugoHealth.start;

import com.shokoladenmarmot.HugoHealth.core.Checker;

public class Main {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(
					"\n!Missing Argument!\nThis requires cyrpto currency symbol as an argument (bitcoin, ethereum, etc.)\n");
			return;
		}
		Checker.printPriceCap(args[0]);
	}
}
