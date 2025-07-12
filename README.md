# Java Networking Demos

This project showcases two Java applications that demonstrate fundamental networking concepts:
1. **Stock Quote Fetcher** – A client that calls a REST API and parses JSON responses.
2. **Guess the Number Game** – A simple socket-based client-server application.

Developed as part of an academic project to reinforce concepts in network programming, client-server architecture, and RESTful API consumption using Java.

---

## 📌 Overview

| Module                  | Description |
|-------------------------|-------------|
| **StockQuoteFetcher.java** | Connects to [Alpha Vantage](https://www.alphavantage.co) REST API to retrieve real-time stock quotes and parse JSON data using core Java libraries. |
| **GuessNumberServer.java** | A server-side socket program that hosts a number guessing game for connected clients. |
| **GuessNumberClient.java** | A client-side program that connects to the server, accepts user guesses, and receives real-time feedback. |

---

## 🔧 Technologies Used

- Java 8+
- Sockets (`java.net`)
- HTTP URL Connections
- JSON Parsing (manually or via string processing)
- Terminal/Console I/O
