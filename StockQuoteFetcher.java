// ***************************************************************************
// 
//   Joel John Thomas 
//   Z2004783
//   CSCI 470 - PE1 
// 
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

// Import necessary classes for HTTP and JSON handling
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class StockQuoteFetcher {
    public static void main(String[] args) {
        // Stock symbol to retrieve
        String symbol = "WING";

        // Personal Alpha Vantage API key
        String apiKey = "GS1RFNNU02RIXLJQ";

        // Construct the API endpoint URL for getting a global quote
        String urlString = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="
                            + symbol + "&apikey=" + apiKey;

        try {
            // Create a URL object and open an HTTP connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Create a BufferedReader to read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            // Read each line from the API response and append it to the response string
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Close the reader and the connection
            reader.close();
            conn.disconnect();

            // Parse the entire response into a JSON object
            JSONObject json = new JSONObject(response.toString());

            // Access the "Global Quote" object within the response
            JSONObject quote = json.getJSONObject("Global Quote");

            // Output specific stock information from the JSON
            System.out.println("Stock Symbol: " + quote.getString("01. symbol"));
            System.out.println("Current Price: $" + quote.getString("05. price"));
            System.out.println("Change: " + quote.getString("09. change"));
            System.out.println("Change Percent: " + quote.getString("10. change percent"));

        } catch (Exception e) {
            // Print error details if something goes wrong
            e.printStackTrace();
        }
    }
}