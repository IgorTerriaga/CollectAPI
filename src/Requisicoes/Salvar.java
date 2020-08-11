package Requisicoes;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.List;

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
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (returnval == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Resolveu não salvar", "Não salvou!", JOptionPane.WARNING_MESSAGE);

        }

    }
}
