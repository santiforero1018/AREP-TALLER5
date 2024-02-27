package edu.eci.arep.taller5.server;

import edu.eci.arep.taller5.services.WebService;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.math.*;

import edu.eci.arep.taller5.services.*;
import java.util.*;

import org.eclipse.jetty.client.util.OutputStreamContentProvider;

import com.google.gson.*;

import java.io.*;

public class WebServer {
    private static Map<String, WebService> services = new HashMap<String, WebService>();

    // Variable para patron singleton
    private static WebServer _instance = getInstace();

    /**
     * Defautl Constructor
     */
    public WebServer() {

    }

    /**
     * method that returns the instance of this class
     * 
     * @return the instance of this class
     */
    public static WebServer getInstace() {
        return _instance;
    }

    /**
     * Method that start the web server
     * 
     * @throws IOException throws IOException if something fails
     */
    public static void startSever() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Integer.parseInt(System.getenv("PORT")));
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine = "";
            boolean readingFirst = true;
            String petition = "";
            String method = "";
            Boolean isOperation = false;

            while ((inputLine = in.readLine()) != null) {

                if (readingFirst) {
                    if (inputLine.contains("GET")) {
                        method = "GET";
                        petition = inputLine.split(" ")[1];
                        break;
                    } else if (inputLine.contains("POST")) {
                        method = "POST";
                        petition = inputLine.split(" ")[1];
                        break;
                    }
                }
                if (!in.ready()) {
                    break;
                }
            }
            System.out.println("Metodo de petición: " + method);
            // System.out.println("Asi llego la petición: " + petition);

            try {
                URI requestUri = new URI(petition);
                String path = requestUri.getPath();
                String query = requestUri.getQuery();

                query = (query != null) ? query.split("=")[1] : "";

                // if (path.startsWith("/service")) {
                // String webUri = path.replace("/service", "");
                // // System.out.println("webUri obtenida despues del replace de /serivce: " +
                // webUri);

                // outputLine = (services.containsKey(webUri))
                // ? petitionPage(services.get(webUri).handle(query),
                // clientSocket.getOutputStream()).replace("{query}", query)
                // : ((webUri.contains("css") || webUri.contains("jpg") ||
                // webUri.contains("js"))
                // ? petitionPage(webUri, clientSocket.getOutputStream())
                // : errorPage("/NotFound.html", clientSocket.getOutputStream()));
                // } else {
                // outputLine = (isOperation)
                // ? doOperation(query, clientSocket.getOutputStream())
                // : petitionPage(petition, clientSocket.getOutputStream());
                // }

            } catch (Exception e) {
                System.out.println("An error happened: " + e.getMessage());
            }

            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    private static String SinorCos(String operation, Double number1, Double number2) {
        return null;
    }

    

}
