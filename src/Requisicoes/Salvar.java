package Requisicoes;


import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Salvar {

    public void criarJson(Map<String, String> listaatributos) {
        JSONObject jsonObject = new JSONObject();
        FileWriter fileWriter = null;
        jsonObject.putAll(listaatributos);

        try {
            fileWriter = new FileWriter("saida.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
    }


}
