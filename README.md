# REST-API-CLIENT

*COMPANY*: CODETECH IT SOLUTIONS

*NAME*: ASHISH KUMAR

*INTERN ID*: CT04DH1575

*DOMAIN*: JAVA PROGRAMMING 

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTHOSH KUMAR

**DESCRIPTION OF TASK** :
       This Java program is designed to fetch and display real-time weather information for a given city using the OpenWeatherMap API. The application demonstrates how to perform an HTTP GET request in Java, parse JSON responses, and extract relevant weather data to present to the user. The main objective of this code is to offer a simple yet functional console-based weather client that takes a city name as input and returns current weather metrics like temperature, humidity, pressure, and wind speed.

At the beginning of the program, necessary classes such as BufferedReader, InputStreamReader, HttpURLConnection, and URL are imported to manage network communication. Additionally, org.json.JSONObject is used for parsing the JSON response received from the weather API. The API key used is a demo key, and it is passed along with the city name in the request URL. This key is essential for authentication and authorizing the request to the OpenWeatherMap server.

The user interface of the program is simple and text-based. The program begins by prompting the user to enter the name of a city. Once the input is taken, it is sanitized using trim() to remove any leading or trailing whitespaces.

Key features and steps of the program:
API Setup: The base API URL (https://api.openweathermap.org/data/2.5/weather) is used to query weather data. This is combined with user input and the API key to build a complete request URL.
HTTP Connection: A HttpURLConnection object is created using the constructed URL. The request method is explicitly set to "GET", as the program is retrieving data, not sending it.
Reading Response: The API’s response is read using a BufferedReader, which processes the incoming stream of data line by line. The data is appended to a StringBuilder for efficient string handling.
Parsing JSON: The response string is converted into a JSONObject for easier access to nested values. The JSON structure includes several sections, such as "main" for temperature-related data and "wind" for wind speed.

Extracted Information:
City Name: Retrieved from the top-level JSON.
Temperature: Displayed in Kelvin, as returned by the API.
Pressure: Measured in hPa.
Humidity: Percentage value.
Wind Speed: Shown in meters per second.

Exception Handling: A try-catch block is used to catch any exceptions that may occur during execution, such as invalid city names, connection issues, or API errors.

Resource Management: The Scanner used for user input is properly closed in the finally block to ensure resource cleanup.

This project serves as a foundational exercise in Java for understanding how to perform HTTP operations, handle JSON, and create interactive command-line applications. It is ideal for beginners aiming to bridge the gap between simple input/output Java programs and real-world data integration. The program could be further enhanced by formatting temperature in Celsius, adding support for more detailed forecasts, or allowing repeated queries within a single session.
