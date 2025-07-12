// ***************************************************************************
// 
//   Joel John Thomas 
//   Z2004783
//   CSCI 470 - PE1 
// 
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GuessNumberClient {
    public static void main(String[] args) throws IOException {
        // Connect to the server running on localhost and port 5000
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        // Set up input/output streams for communication
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        // Read welcome message
        System.out.println(input.readLine());

        while (true) {
            // Ask the user to enter a guess
            System.out.print("Your guess: ");
            String guess = scanner.nextLine();
            output.println(guess); // Send the guess to the server

            // Get response from server
            String response = input.readLine();
            System.out.println(response);

            // Break if the guess was correct
            if (response.equals("Correct!")) break;
        }

        // Clean up
        socket.close();
        scanner.close();
        System.out.println("Disconnected from server.");
    }
}