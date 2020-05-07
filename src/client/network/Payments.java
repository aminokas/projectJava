package client.network;

import client.BossFrame;
import client.components.MyButton;
import client.components.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payments extends JPanel {
    private MyLabel label;
    private MyButton back ;
    private JTextArea opl;
    private BossFrame frame = null;
    public Payments(BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        label=new MyLabel("Payments",100,10);
        add(label);
        back=new MyButton("Back",10,400);
        add(back);
        opl=new JTextArea();
        opl.setBounds(10,50,500,320);
        add(opl);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.pay.setVisible(false);
                frame.menu.setVisible(true);
            }
        });
    }
}


