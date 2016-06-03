package com.baculsoft.gcm.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class GcmServices {

	public static void post(String apiKey, Content content) {
		try {
			// 1. URL
			URL url = new URL(IConstants.GCM_ENDPOINT);

			// 2. Open connection
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();

			// 3. Specify POST method
			httpUrlConnection.setRequestMethod("POST");

			// 4. Set the headers
			httpUrlConnection.setRequestProperty("Content-Type", IConstants.CONTENT_TYPE);
			httpUrlConnection.setRequestProperty("Authorization", "key=".concat(apiKey));
			httpUrlConnection.setDoOutput(true);

			// 5.1 Use Jackson object mapper to convert Content object into JSON
			ObjectMapper objectMapper = new ObjectMapper();

			// 5.2 Get connection output stream
			DataOutputStream dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());

			// 5.3 Copy Content "JSON"
			objectMapper.writeValue(dataOutputStream, content);

			// 5.4 Send the request
			dataOutputStream.flush();

			// 5.5 close
			dataOutputStream.close();

			// 6. Get the response
			int responseCode = httpUrlConnection.getResponseCode();
			System.out.println(String.format("Sending POST request to URL: %s", String.valueOf(url)));
			System.out.println(String.format("Response Code: %d", responseCode));

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
			StringBuffer response = new StringBuffer();

			String inputLine;
			while ((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferedReader.close();

			// 7. Print result
			System.out.println(response.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}