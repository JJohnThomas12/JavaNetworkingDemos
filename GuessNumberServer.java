import java.io.*;
import java.net.*;
import java.util.Random;

public class GuessNumberServer {
    public static void main(String[] args) throws IOException {
        // Generate a random secret number between 1 and 100
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1; // (0–99) + 1 → (1–100)

        // Open a server socket on port 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running on port 5000. Waiting for a client...");

        // Accept an incoming client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        // Set up input and output streams for the socket
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

        // Send welcome message
        output.println("Welcome to Guess a Number! Enter a number between 1 and 100:");

        while (true) {
            try {
                // Read the client's guess
                String guessStr = input.readLine();
                int guess = Integer.parseInt(guessStr);

                // Compare the guess to the secret number and send response
                if (guess < secretNumber) {
                    output.println("Too low");
                } else if (guess > secretNumber) {
                    output.println("Too high");
                } else {
                    output.println("Correct!");
                    break;
                }
            } catch (Exception e) {
                output.println("Invalid input. Please enter a number.");
            }
        }

        // Close the connections
        input.close();
        output.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Game over. Server shut down.");
    }
}
