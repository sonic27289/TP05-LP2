/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class TP05 extends Frame implements ActionListener{

    Label labelMax, labelP1, labelP2, fim1, fim2;
    JTextField textFieldMax, textFieldP1, textFieldP2;
    Button iniciar, limpar;
    List lista1, lista2;
    Panel panelEntrada, panelEntrada2, panelEntradaTotal, panelSaida, panelEsqSaida, panelDirSaida, panelIniciar, panelLimpar;

    public void GUI() {
        Frame frame = new Frame();
        labelMax = new Label("Máximo:");
        textFieldMax = new JTextField();
        labelP1 = new Label("Prioridade 1: ");
        textFieldP1 = new JTextField();
        labelP2 = new Label("Prioridade 2: ");
        textFieldP2 = new JTextField();
        iniciar = new Button("Iniciar");
        lista1 = new List();
        lista2 = new List();
        fim1 = new Label("");
        fim2 = new Label("");
        limpar = new Button("Limpar");
        panelEntrada = new Panel();
        panelEntradaTotal = new Panel();
        panelEntrada2 = new Panel();
        panelSaida = new Panel();
        panelEsqSaida = new Panel();
        panelDirSaida = new Panel();
        panelLimpar = new Panel();
        panelIniciar = new Panel();
        panelSaida.setPreferredSize(new Dimension(50, 50));

        panelEntrada.setLayout(new GridLayout(3, 2));
        panelEntrada.add(labelMax);
        panelEntrada.add(textFieldMax);
        panelEntrada.add(labelP1);
        panelEntrada.add(textFieldP1);
        panelEntrada.add(labelP2);
        panelEntrada.add(textFieldP2);
        panelIniciar.add(iniciar, BorderLayout.CENTER);

        panelDirSaida.setLayout(new GridLayout(2, 1));
        panelDirSaida.add(lista1, BorderLayout.CENTER);
        panelDirSaida.add(fim1, BorderLayout.CENTER);

        panelEsqSaida.setLayout(new GridLayout(2, 1));
        panelEsqSaida.add(lista2);
        panelEsqSaida.add(fim2);

        panelLimpar.add(limpar, BorderLayout.CENTER);
        panelSaida.setLayout(new GridLayout(1, 2));
        panelSaida.add(panelDirSaida);
        panelSaida.add(panelEsqSaida);
        iniciar.addActionListener(this);
        limpar.addActionListener(this);

        panelEntradaTotal.setLayout(new GridLayout(1, 2));
        panelEntradaTotal.add(panelEntrada);
        panelEntradaTotal.add(panelEntrada2);
        frame.setLayout(new GridLayout(4, 2));
        frame.setTitle("Trabalho Pratico 05");
        frame.setSize(500, 500);
        frame.add(panelEntradaTotal);
        frame.add(panelIniciar);
        frame.add(panelSaida);
        frame.add(panelLimpar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TP05 form = new TP05();
        form.GUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == iniciar) {
            int max = Integer.parseInt(textFieldMax.getText());
            int p1 = Integer.parseInt(textFieldP1.getText());
            int p2 = Integer.parseInt(textFieldP2.getText());
            Threads t1 = new Threads();
            t1.setPriority(p1);
            Threads t2 = new Threads();
            t2.setPriority(p2);
            t1.run(max, lista1, lista2);
            fim1.setText("Final");
            // t2.run(max, lista2);
            fim2.setText("Final");
        }
        if (ae.getSource() == limpar) {
            textFieldMax.setText("");
            textFieldP1.setText("");
            textFieldP2.setText("");
            lista1.removeAll();
            lista2.removeAll();
            fim1.setText("");
            fim2.setText("");
        }
    }

    class Threads extends Thread {

        public void run(int max, List lista01, List lista02) {
            for (int i = 0; i <= max; i++) {
                lista01.add(String.valueOf(i));
                lista02.add(String.valueOf(i));
            }
        }
    }
}
