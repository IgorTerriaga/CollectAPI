package Requisicoes.RequisicaoTeste;

import Requisicoes.Salvar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Requisicao {
    List<Object> resposta = new ArrayList<>();

    //String spec = "https://api.github.com/users/IgorTerriaga/repos";
    public void fazerrquisicaoGithub(String urls) {
        try {
            URL url = new URL(urls);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                String encoded = "Basic " + Base64.getEncoder().encodeToString(("flussonic:flussonic").getBytes(StandardCharsets.UTF_8));
                conn.setRequestProperty("Authorization", encoded);
                conn.setRequestMethod("GET");
                conn.connect();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line = br.readLine();
                    while (line != null) {
                        resposta.add(line);
                        //atributos.put(line, line);
                        //String[] fields = line.split(" ");
                        //atributos.put(line, "");
                        line = br.readLine();
                    }
                    new Salvar().SalvarJson(resposta);
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
