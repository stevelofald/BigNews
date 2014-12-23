package com.big.news.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class SearchGoogle {

	public void doSearch(String searchString) throws IOException {
		URL url = new URL(
				"https://ajax.googleapis.com/ajax/services/search/news?"
						+ "v=1.0&q=barack%20obama&userip=INSERT-USER-IP");
		URLConnection connection = url.openConnection();
		connection.addRequestProperty("Referer", "www.google.com");

		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}

		JSONObject json = new JSONObject(builder.toString());
		System.out.println(json.toString());
		
	}

	public static void main(String args[]) {
		SearchGoogle theSearch = new SearchGoogle();
		try {
			theSearch.doSearch("apple");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
