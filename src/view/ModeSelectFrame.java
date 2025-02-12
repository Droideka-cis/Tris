/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 5BT_2024_2025
 */
public class ModeSelectFrame extends JFrame{
    private final int WIDTH = 300;
    private final int HEIGHT = 250;
    private final JButton joinBtn = new JButton("JOIN MATCH");
    private final JButton soloBtn = new JButton("SOLO");
    private final JLabel textLbl = new JLabel("TRIS FORMATO JAVA");
    private final JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    
    private void prepare(){
        SoloListener sl = new SoloListener(this);
        Font f = new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,20);
        this.setLocationRelativeTo(null);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        pan1.setLayout(null);
        pan1.add(textLbl);
        pan1.add(joinBtn);
        pan1.add(soloBtn);
        textLbl.setFont(f);
        textLbl.setBounds(40, 50, 250, 30);
        joinBtn.setBounds(30, 150, 110, 30);
        soloBtn.setBounds(190, 150, 70, 30);
        soloBtn.addActionListener(sl);
        this.add(pan1);
    }
    
    private void prepareSolo(){
        pan2.setLayout(new GridLayout(3,3,5,5));
        JButton[] buttons = new JButton[9];
        char[] vals = new char[9];
        for (int i = 0; i < 9; i++){
            vals[i] = '?';
            buttons[i] = new JButton();
            pan2.add(buttons[i]);
        }
        this.add(pan2);
        this.setVisible(true);
    }
    
    private void toggleSolo(){
        this.setVisible(false);
        this.remove(pan1);
        prepareSolo();
        
    }
    
    class ClickListener implements ActionListener{
        ModeSelectFrame rf;
        
        public ClickListener(ModeSelectFrame rf){
            this.rf = rf;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            rf.toggleSolo();
        }
    }
    
    class SoloListener implements ActionListener{
        ModeSelectFrame rf;
        
        public SoloListener(ModeSelectFrame rf){
            this.rf = rf;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            rf.toggleSolo();
        }
    }
    
    public ModeSelectFrame(){
        prepare();
    }
}
