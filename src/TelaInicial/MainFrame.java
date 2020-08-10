package TelaInicial;

import Requisicoes.RequisicaoTeste.RequisicaoTeste;
import Requisicoes.Salvar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener {

    List<String> listaapis = new ArrayList<>();

    private JFrame jFramePrincipal;
    private JMenuBar mnBarra;
    private JMenu mnInformacoes;
    private JMenu mnSairdaaplicacao;
    private Image iconeTitulo;
    private ImageIcon iconeFlussic;
    private JLabel labelFlussonic;
    private JLabel TituloStreaming;
    private JMenuItem miSair;
    private JMenuItem miInformacoes;
    private static JComboBox apis;

    private JLabel titulorequisição;
    private JButton jrequisição;
    private JTextField jTextFieldurl;
    private JTextField jTextFieldcaminhoSalvar;
    //private JLabel labelcamiho;


    public MainFrame() {
        jFramePrincipal = new JFrame("Collect APIs");

        mnBarra = new JMenuBar();
        mnInformacoes = new JMenu("Informações");
        mnSairdaaplicacao = new JMenu("Sair");
        miSair = new JMenuItem("Sair da aplicação");
        miInformacoes = new JMenuItem("Consultar informações");
        labelFlussonic = new JLabel();

        titulorequisição = new JLabel("Insira o endpoint da API");
        jrequisição = new JButton("Ir");
        jTextFieldurl = new JTextField();
        //jTextFieldcaminhoSalvar = new JTextField();
        //labelcamiho = new JLabel("Informe o nome do arquivo a ser gravado");


        //iconeFlussic = new ImageIcon(getClass().getResource("//TelaInicial//flussonic.png"));
        TituloStreaming = new JLabel("Selecione a API");
        listaapis.add("Flussonic");
        listaapis.add("Alpha OTT");
        listaapis.add("Mware");
        listaapis.add("Chargebee");
        listaapis.add("Github");

        apis = new JComboBox();
        apis.setModel(new javax.swing.DefaultComboBoxModel(listaapis.toArray()));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(apis);
        //jFramePrincipal.add(labelcamiho);
        //jFramePrincipal.add(jTextFieldcaminhoSalvar);
        mnBarra.add(mnInformacoes);
        mnBarra.add(mnSairdaaplicacao);
        mnInformacoes.add(miInformacoes);
        mnSairdaaplicacao.add(miSair);
        jFramePrincipal.add(titulorequisição);
        titulorequisição.setBounds(400, 220, 200, 200);
        titulorequisição.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        //labelcamiho.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        jFramePrincipal.add(jrequisição);
        jrequisição.setBounds(680, 450, 50, 30);
        TituloStreaming.setBounds(400, 20, 200, 100);
        jFramePrincipal.add(jTextFieldurl);
        jTextFieldurl.setBounds(330, 350, 400, 30);
        //labelcamiho.setBounds(380, 410, 400, 30);
        //jTextFieldcaminhoSalvar.setBounds(340, 450, 350, 30);

        jTextFieldurl.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (focusEvent.getSource().equals(jTextFieldurl)) {

                }
                jTextFieldurl.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });

       /* jTextFieldcaminhoSalvar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                jTextFieldcaminhoSalvar.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });*/
        TituloStreaming.setFont(new Font("arial", Font.BOLD, 20));
        apis.setBounds(380, 120, 200, 30);

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
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new Dimension(900, 650));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //jTextFieldurl.setText("");
        if (actionEvent.getSource().equals(miSair)) {
            System.exit(0);
        } else if (actionEvent.getSource().equals(miInformacoes)) {
            System.out.println("...");
        } else if (actionEvent.getSource().equals(apis)) {
            jTextFieldurl.setText("Insira o endpoint do " + apis.getSelectedItem().toString());

        } else if (actionEvent.getSource().equals(jrequisição)) {
            //System.out.println("ok");
            //new RequisicaoTeste();
            String requisicao = jTextFieldurl.getText();


            new RequisicaoTeste().fazerrquisicaoGithub(requisicao);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MainFrame().jFramePrincipal.show();

    }
}
