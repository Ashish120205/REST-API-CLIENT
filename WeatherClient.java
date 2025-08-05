import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherClient {

    // OpenWeatherMap API key (used for authenticating requests)
    private static final String API_KEY = "49af3e1856b500f2454fcb59819dcc20";
    
    // Base URL of the OpenWeatherMap API endpoint
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        // Scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Ask user to input city name
        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();  // Read and clean up whitespace

        try {
            // Construct the full API URL with query parameters: city name and API key
            String apiUrl = BASE_URL + "?q=" + city + "&appid=" + API_KEY;

            // Create a connection object to make HTTP GET request
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET"); // Set HTTP method to GET

            // Read the API response from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;

            // Read each line from the response and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            // Close the reader after reading all response data
            reader.close();

            // Convert the response string into a JSON object
            JSONObject obj = new JSONObject(json.toString());

            // Extract and print basic city weather information
            System.out.println("\n=== Weather Info ===");
            System.out.println("City: " + obj.getString("name"));

            // Extract main weather data like temperature, pressure, humidity
            JSONObject main = obj.getJSONObject("main");
            System.out.println("Temperature: " + main.getDouble("temp") + "K");
            System.out.println("Pressure: " + main.getInt("pressure") + " hPa");
            System.out.println("Humidity: " + main.getInt("humidity") + "%");

            // Extract wind information like speed
            JSONObject wind = obj.getJSONObject("wind");
            System.out.println("Wind Speed: " + wind.getDouble("speed") + " m/s");

        } catch (Exception e) {
            // Catch and print any error that occurs (e.g., city not found, connection error)
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Always close the scanner to release resources
            scanner.close();
        }
    }
}


