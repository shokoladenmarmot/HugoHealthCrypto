package com.shokoladenmarmot.HugoHealth.core;
import java.text.DecimalFormat;

import org.json.JSONArray;

public final class Checker {

	static final String API = "https://api.coinmarketcap.com/v1/ticker/";
	static final String PRICE_PROP = "price_usd";
	static final String MARKET_CAP_PROP = "market_cap_usd";
	static final double ONE_B = 1000000000;
	static final double ONE_M = 1000000;

	private static final DecimalFormat decimalThreeSymbols = new DecimalFormat("0.000");

	public static boolean printPriceCap(String currency) {
		synchronized (Checker.class) {

			if (currency == null || currency.isEmpty()) {
				System.out.println("Please supply a crypto currency symbol.");
				return false;
			}

			StringBuilder sb = new StringBuilder();
			JSONArray request_JSON = JSONFactory.getJSONArray(API + currency);

			if (request_JSON == null) {
				System.out.println("Currency '" + currency + "' is not available on CoinMarketCap");
				return false;
			}
			double val = 0;
			for (int i = 0; i < request_JSON.length(); i++) {
				sb.append("\n\n").append(currency.toUpperCase()).append("\nPrice: ")
						.append(request_JSON.getJSONObject(i).getString(PRICE_PROP)).append("$")
						.append("\nMarket Cap: ");
				val = request_JSON.getJSONObject(i).getDouble(MARKET_CAP_PROP);

				if (val > ONE_B) {
					val /= ONE_B;
					sb.append(decimalThreeSymbols.format(val) + 'B');
				} else if (val > ONE_M) {
					val /= ONE_M;
					sb.append(decimalThreeSymbols.format(val) + 'M');
				} else
					sb.append(decimalThreeSymbols.format(val));
				sb.append('$');
			}

			System.out.println(sb.toString());
			return true;
		}
	}
}
