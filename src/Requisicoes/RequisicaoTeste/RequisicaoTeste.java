package Requisicoes.RequisicaoTeste;

import Requisicoes.Salvar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequisicaoTeste {
    Map<String, String> atributos = new HashMap<>();

    //String spec = "https://api.github.com/users/IgorTerriaga/repos";
    public void fazerrquisicaoGithub(String urls) {
        try {
            URL url = new URL(urls);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line = br.readLine();
                    while (line != null) {
                        //atributos.put(line, line);
                        String[] fields = line.split(" ");
                        atributos.put(fields[0], fields[1]);
                        line = br.readLine();
                    }
                    new Salvar().criarJson(atributos);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
