package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class ExchangeRateImpl implements ExchangeRate {
    private static final String API_URL = "https://api.fxratesapi.com/latest?base=USD";
    private static final String DEFAULT_CURRENCY = "EUR";

    SendHttpRequest sendHttpRequest = new SendHttpRequest();

    @Override
    public void startExchange() {
        try {
            // Fetch JSON response from API
            String jsonResponse = sendHttpRequest.sendRequest(API_URL);

            // Extract the exchange rate for the default currency (EUR)
            String rate = getAttributeValueFromJson(jsonResponse, DEFAULT_CURRENCY);

            // Display the result
            System.out.println("Exchange rate (USD to " + DEFAULT_CURRENCY + "): " + rate);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Unable to find the specified attribute in the JSON response.");
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the API or retrieve a valid response.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    // Extracts an attribute from the "rates" object in the JSON response
    private String getAttributeValueFromJson(String jsonResponse, String attributeName) throws IllegalArgumentException {
        try {
            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            // Ensure "rates" object exists
            if (jsonObject.containsKey("rates")) {
                JSONObject rates = (JSONObject) jsonObject.get("rates");

                // Find the specified attribute in "rates"
                if (rates.containsKey(attributeName)) {
                    return rates.get(attributeName).toString(); // Return the attribute value
                } else {
                    throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the 'rates' object.");
                }
            } else {
                throw new IllegalArgumentException("'rates' object not found in the JSON response.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing the JSON response or extracting the attribute.", e);
        }
    }
}
