package Requisicoes;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Salvar {

    public void SalvarJson(List<Object> lista) {

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("\\home"));
        int returnval = fc.showSaveDialog(new JFrame());

        if (returnval == JFileChooser.APPROVE_OPTION) {
            try {
                PrintStream ps = new PrintStream(fc.getSelectedFile() + ".json");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(ps);
                for (Object obj : lista) {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                }
                objectOutputStream.close();

                //FileWriter fw = new FileWriter(new File(nomearq));

                //BufferedWriter bufferedWriter = new BufferedWriter(fw);
                //bufferedWriter.write(String.valueOf(lista));

                // JOptionPane.showMessageDialog(null, "Arquivo Salvo com sucesso ", "Messagem Save", JOptionPane.INFORMATION_MESSAGE);

                //  bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (returnval == JFileChooser.CANCEL_OPTION) {
            //JOptionPane.showMessageDialog(null, "Impossivel salvar resposta, "", JOptionPane.WARNING_MESSAGE);

        }

        //if (nomearq.isEmpty()) {
        //  JOptionPane.showMessageDialog(null, "Nome do Arquivo não informado", "Messagem de alerta Save", JOptionPane.WARNING_MESSAGE);

        //}


    }
}
