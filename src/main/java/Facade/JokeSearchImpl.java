package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;

public class JokeSearchImpl implements JokeSearch {

    private static final String API_URL = "https://api.chucknorris.io/jokes/random"; // Joke API URL

    private final SendHttpRequest sendHttpRequest = new SendHttpRequest();

    @Override
    public void startSearch() {
        try {
            // Fetch and display the joke
            String joke = getJoke(API_URL, "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Unable to find the specified attribute in the JSON response.");
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the API or retrieve a valid response.");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    // Fetches the joke attribute from the API
    public String getJoke(String urlString, String attributeName) throws IOException {
        // Step 1: Send the HTTP request
        String jsonResponse = sendHttpRequest.sendRequest(urlString);

        // Step 2: Extract the attribute value
        return extractAttributeFromJson(jsonResponse, attributeName);
    }

    // Extracts the value of the specified attribute from the JSON response
    private String extractAttributeFromJson(String jsonResponse, String attributeName) {
        try {
            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            // Check if the attribute exists in the JSON object
            if (jsonObject.containsKey(attributeName)) {
                return jsonObject.get(attributeName).toString();
            } else {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the JSON response.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing the JSON response or extracting the attribute.", e);
        }
    }
}
