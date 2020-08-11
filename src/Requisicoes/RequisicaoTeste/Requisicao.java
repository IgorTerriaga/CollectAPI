package Requisicoes.RequisicaoTeste;

import Requisicoes.Salvar;

import javax.swing.*;
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

    public void fazerrquisicaoGithub(String urls) {
        try {
            URL url = new URL(urls);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                String encoded = "Basic " + Base64.getEncoder().encodeToString(("flussonic:flussonic").getBytes(StandardCharsets.UTF_8));
                conn.setRequestProperty("Authorization", encoded);
                conn.setRequestMethod("GET");
                conn.connect();
                if(conn.getResponseCode()==401){
                    JOptionPane.showMessageDialog(null, "Usuario não autorizado - ERROR 401", "Sem permissão!", JOptionPane.WARNING_MESSAGE);

                }else if (conn.getResponseCode()==404){
                    JOptionPane.showMessageDialog(null, "Não encontrado - ERROR 404", "Não foi possível encontrar!", JOptionPane.WARNING_MESSAGE);

                }
                JOptionPane.showMessageDialog(null, "Êxito na requisição - 200", "Status da requisição!", JOptionPane.WARNING_MESSAGE);

                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line = br.readLine();
                    while (line != null) {
                        resposta.add(line);
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
