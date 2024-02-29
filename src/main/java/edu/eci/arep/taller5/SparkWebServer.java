package edu.eci.arep.taller5;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.nio.file.Files;
import java.nio.file.Paths;

import spark.Spark;

import static spark.Spark.get;

public class SparkWebServer {

    public static void main(String[] args) {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("/coseno", (req, res) -> {
            try {
                return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/cos.html")));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        });
        get("/seno", (req, res) -> {
            try {
                return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/sin.html")));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        });
        get("/magnitud", (req, res) -> {
            try {
                return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/magnitud.html")));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        });
        get("/palindromo", (req, res) -> {
            try {
                return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/palindromo.html")));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        });

        get("/result", (req, res) -> {
            try {
                String op = req.queryParams("op"), resp = "", chain = req.queryParams("chain");
                Double param1 = req.queryParams("num1") != null ? Double.parseDouble(req.queryParams("num1")) : null;

                Double param2 = req.queryParams("num2") != null ? Double.parseDouble(req.queryParams("num2")) : null;
                switch (op) {
                    case "sin":
                        resp += Math.sin(param1);
                        return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/result.html")))
                                .replace("{operation}", op).replace("{result}", resp);
                    case "cos":
                        resp += Math.cos(param1);
                        return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/result.html")))
                                .replace("{operation}", op).replace("{result}", resp);
                    case "mag":
                        resp += Math.sqrt(param1*param1+param2*param2);
                        return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/result.html")))
                                .replace("{operation}", op).replace("{result}", resp);
                    case "palindromo":
                        resp += chain.equals(new StringBuilder(chain).reverse().toString());
                        return new String(Files.readAllBytes(Paths.get("/usrapp/bin/classes/public/static/result.html")))
                                .replace("{operation}", op).replace("{result}", resp);

                    default:
                        resp = "";
                        break;
                }
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
