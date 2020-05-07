package client.network;

import client.BossFrame;
import client.components.MyButton;
import client.components.MyLabel;
import client.components.MyPasswordField;
import client.components.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaPage extends JPanel {
    private MyLabel label1, label2,label3 , label4,label5;
    private MyTextField text1,text2,text3,text4;
    private MyButton back=null,save=null;
    private BossFrame frame = null;
    public MaPage(BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        label1=new MyLabel("My Page",100,10);
        add(label1);
        label2=new MyLabel("Name ",10,200);
        add(label2);
        label3=new MyLabel("Surname",10,250);
        add(label3);
        label4=new MyLabel("Card number",10,300);
        add(label4);
        label5=new MyLabel("balance",10,350);
        add(label5);
        text1=new MyTextField(110,200);
        add(text1);
        text2=new MyTextField(110,250);
        add(text2);
        text3=new MyTextField(110,300);
        add(text3);
        text4=new MyTextField(110,350);
        add(text4);
        back=new MyButton("Back",10,400);
        add(back);
        save= new MyButton("Save",400,400);
        add(save);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.m.setVisible(false);
                frame.menu.setVisible(true);
            }
        });

    }
}

