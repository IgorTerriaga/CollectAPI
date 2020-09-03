package TelaInicial;

import Requisicoes.RequisicaoTeste.Requisicao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFrame extends JFrame implements ActionListener {

    List<String> listaapis = new ArrayList<>();

    private JFrame jFramePrincipal;
    private JMenuBar mnBarra;
    private JMenu mnInformacoes;
    private JMenu mnSairdaaplicacao;
    private JMenu mnAbrir;
    private Image iconeTitulo;
    private ImageIcon iconeFlussic;
    private JLabel labelFlussonic, labelhistorico;
    private JLabel TituloStreaming;
    private JMenuItem miSair;
    private JMenuItem miInformacoes;
    private JMenuItem miAbrir;
    private static JComboBox apis;

    private JLabel titulorequisição;
    private JButton jrequisição;
    private JTextField jTextFieldurl;
    private JTextField jTextFieldcaminhoSalvar;
    private JTextArea jTextFieldlistarequisicoes;
    //private JLabel labelcamiho;


    public MainFrame() {
        jFramePrincipal = new JFrame("Collect APIs");

        mnBarra = new JMenuBar();
        mnInformacoes = new JMenu("Informações");
        mnAbrir = new JMenu("Abrir Arquivo salvo");
        mnSairdaaplicacao = new JMenu("Sair");
        miSair = new JMenuItem("Sair da aplicação");
        miInformacoes = new JMenuItem("Consultar informações");
        miAbrir = new JMenuItem("Abrir");
        labelFlussonic = new JLabel();

        titulorequisição = new JLabel("Insira o endpoint da API");
        jrequisição = new JButton("Ir");
        jTextFieldurl = new JTextField();
        jTextFieldlistarequisicoes = new JTextArea();


        TituloStreaming = new JLabel("Lista de APIs testadas");
        labelhistorico = new JLabel("Histórico de Requisições");
        //listaapis.add("Flussonic");
        //listaapis.add("Alpha OTT");
        listaapis.add("Flussonic");
        listaapis.add("Poke API");
        listaapis.add("Github");
        listaapis.add("Stripe");

        apis = new JComboBox();
        apis.setModel(new javax.swing.DefaultComboBoxModel(listaapis.toArray()));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(apis);
        mnBarra.add(mnAbrir);
        mnAbrir.add(miAbrir);
        mnBarra.add(mnInformacoes);
        mnBarra.add(mnSairdaaplicacao);
        mnInformacoes.add(miInformacoes);
        mnSairdaaplicacao.add(miSair);
        jFramePrincipal.add(titulorequisição);
        titulorequisição.setBounds(300, 110, 200, 200);
        titulorequisição.setFont(new Font("arial", Font.CENTER_BASELINE, 16));

        jFramePrincipal.add(jTextFieldlistarequisicoes);
        jTextFieldlistarequisicoes.setEditable(false);
        jFramePrincipal.add(jrequisição);
        jrequisição.setBounds(700, 250, 50, 30);
        TituloStreaming.setBounds(300, 20, 250, 100);
        jFramePrincipal.add(jTextFieldurl);
        jTextFieldurl.setBounds(300, 250, 400, 30);
        jTextFieldlistarequisicoes.setBounds(10, 90, 240, 200);

        jTextFieldurl.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (focusEvent.getSource().equals(jTextFieldurl)) {

                }
                jTextFieldurl.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

                jTextFieldlistarequisicoes.append(jTextFieldurl.getText() + "\n");
            }
        });


        TituloStreaming.setFont(new Font("arial", Font.BOLD, 20));
        apis.setBounds(300, 120, 200, 30);
        labelhistorico.setFont(new Font("arial", Font.BOLD, 20));
        labelhistorico.setBounds(10, 59, 240, 20);

        jFramePrincipal.add(labelhistorico);
        URL path = this.getClass().getResource("icone.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);
        // ImageIcon imgFLussonic = new ImageIcon(ClassLoader.getSystemResource("flussonic.png"));
        jFramePrincipal.getContentPane().setBackground(Color.WHITE);
        jFramePrincipal.setIconImage(iconeTitulo);
        jFramePrincipal.add(TituloStreaming);
        miInformacoes.addActionListener(this);
        jrequisição.addActionListener(this);
        miSair.addActionListener(this);
        apis.addActionListener(this);
        miAbrir.addActionListener(this);
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new Dimension(1280, 720));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);
        jFramePrincipal.getRootPane().setDefaultButton(jrequisição);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(miSair)) {
            System.exit(0);

        } else if (actionEvent.getSource().equals(apis)) {
            jTextFieldurl.setText("Insira o endpoint do " + apis.getSelectedItem().toString());

        } else if (actionEvent.getSource().equals(jrequisição)) {

            String requisicao = jTextFieldurl.getText();
            new Requisicao().fazerRequisicao(requisicao);

        } else if (actionEvent.getSource().equals(miInformacoes)) {
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("github.png"));
            String[] opcao = {"OK"};
            JOptionPane.showOptionDialog(null,
                    "Develop by Terriaga"
                    ,
                    "Sobre", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    img, opcao, opcao[0]);

            Toolkit.getDefaultToolkit().beep();
        } else if (actionEvent.getSource().equals(miAbrir)) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setVisible(true);
            int returnValue = jFileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File f = jFileChooser.getSelectedFile();
                try {
                    //Runtime r = Runtime.getRuntime();
                    //r.exec("C:\\Program Files (x86)\\Notepad++\\notepad++ " + f);
                    java.awt.Desktop.getDesktop().open(f);
                } catch (java.io.IOException e) {
                    JOptionPane.showMessageDialog(null, "Caminho do Arquivo esta errado, contate os Desenvolvedores", "Resultado" , JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainFrame().jFramePrincipal.show();

    }
}