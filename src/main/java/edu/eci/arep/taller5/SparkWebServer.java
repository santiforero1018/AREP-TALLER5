package edu.eci.arep.taller5;

import static spark.Spark.port;

import edu.eci.arep.taller5.server.WebServer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.get;

public class SparkWebServer {

    public static void main(String[] args) {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("/coseno", (req, res) -> {
            try {
                return new String(Files.readAllBytes(Paths.get("target/classes/public/static/cos.html")));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
