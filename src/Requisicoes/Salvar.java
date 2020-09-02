package Requisicoes;


import netscape.javascript.JSObject;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Salvar {

    public void SalvarJson(List<String> lista) {

        String caminho = "";
        JFileChooser fc = new JFileChooser();
        File file = null;
        fc.setCurrentDirectory(new File("\\home"));
        int returnval = fc.showSaveDialog(new JFrame());

        if (returnval == JFileChooser.APPROVE_OPTION) {
            try {
                caminho = fc.getSelectedFile().getAbsolutePath();

                if (!caminho.equals("")) {
                    file = new File(caminho + ".json");
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);

                    for (String obj : lista) {
                        bw.write(obj);
                    }
                    bw.close();
                    fw.close();
                }
            } catch (Exception e) {

            }
        } else if (returnval == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Resolveu não salvar", "Não salvou!", JOptionPane.WARNING_MESSAGE);

        }

    }
}
