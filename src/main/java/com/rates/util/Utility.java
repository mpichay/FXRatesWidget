package com.rates.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class Utility {

	public static String readRESTAPI(String apiLink, JSONObject requestData, String method) throws IOException {
		try {
			URL url = new URL(apiLink);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			// conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			if (method.equals("POST")) {
				conn.setDoOutput(true);
				OutputStream wr = conn.getOutputStream();
				byte[] postData = requestData.toString().getBytes(StandardCharsets.UTF_8);
				wr.write(postData);
				wr.flush();
			}

			if (conn.getResponseCode() != 200) {
				return null;
			}
			StringBuilder content;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			content = new StringBuilder();
			while ((line = in.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}
			conn.disconnect();
			return content.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
