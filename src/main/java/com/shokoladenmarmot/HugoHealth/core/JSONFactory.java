package com.shokoladenmarmot.HugoHealth.core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONPointerException;

public final class JSONFactory {

	public static JSONArray getJSONArray(String url) {
		synchronized (JSONFactory.class) {
			InputStream input;
			try {

				URLConnection conn = new URL(url).openConnection();
				conn.setConnectTimeout(60000);
				input = conn.getInputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")), 8);
				try {

					// Build up the JSON as string and create JSONObject
					StringBuilder sb = new StringBuilder();
					String line = null;

					while ((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}

					return new JSONArray(sb.toString());

				} catch (JSONPointerException | IOException | IllegalArgumentException e) {
					// e.getMessage();
				} finally {
					reader.close();
				}
			} catch (MalformedURLException e) {
				// e.getMessage();
			} catch (IOException e) {
				// e.getMessage();
			}
		}
		return null;
	}
}
