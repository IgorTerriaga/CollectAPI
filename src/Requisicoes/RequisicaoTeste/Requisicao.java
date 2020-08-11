package Requisicoes.RequisicaoTeste;

import Requisicoes.Salvar;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Requisicao {
    List<Object> resposta = new ArrayList<>();
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
