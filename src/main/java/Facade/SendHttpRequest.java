package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendHttpRequest {
    public String sendRequest(String urlString) throws IOException {
        // Ensure the URL has a protocol (http:// or https://)
        if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
            throw new MalformedURLException("Invalid URL: missing http:// or https:// protocol");
        }

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Set timeout
        con.setConnectTimeout(5000); // 5 seconds
        con.setReadTimeout(5000);    // 5 seconds

        // Check if response code is successful
        int statusCode = con.getResponseCode();
        if (statusCode != 200) {
            con.disconnect();
            throw new IOException("HTTP request failed with status code: " + statusCode);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }
}
