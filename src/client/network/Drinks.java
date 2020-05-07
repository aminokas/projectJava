package client.network;

import client.BossFrame;
import client.components.MyButton;
import client.components.MyLabel;
import client.components.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drinks extends JPanel {
    private MyLabel label,label2,label3,label4;
    private String bav[] = {"Cocoa","Hot chocolate","Milk","Ginger ale", "Kvass", "Milkshake", "Iced tea", "Coke" , "Cocktail" };
    private String cofee[] = {"Cappuccino", "Latte", "Espresso", "Americano","Iced coffee","Caffeinated coffee","Instant coffee"};
    private JComboBox mealbox;
    private JComboBox backeryckbox;
    private MyButton button1,button2,button3,button4;
    private MyTextField text;
    private BossFrame frame = null;
    public String[] getBav() {
        return bav;
    }

    public String[] getCofee() {
        return cofee;
    }

    public JComboBox getMealbox() {
        return mealbox;
    }

    public void setMealbox(JComboBox mealbox) {
        this.mealbox = mealbox;
    }

    public JComboBox getBackeryckbox() {
        return backeryckbox;
    }

    public void setBackeryckbox(JComboBox backeryckbox) {
        this.backeryckbox = backeryckbox;
    }

    public Drinks(BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        label=new MyLabel("Drinks",200,10);
        add(label);
        label2=new MyLabel("Cofee",10,50);
        add(label2);
        label3=new MyLabel("Bavereges",10,110);
        add(label3);
        label4=new MyLabel("count",10,220);
        add(label4);
        mealbox=new JComboBox(cofee);
        mealbox.setBounds(120,50,100,30);
        add(mealbox);
        backeryckbox=new JComboBox(bav);
        backeryckbox.setBounds(120,110,100,30);
        add(backeryckbox);
        button1=new MyButton("add",230,50);
        add(button1);
        button2=new MyButton("add",230,110);
        add(button2);
        button3=new MyButton("next",400,300);
        add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dr.setVisible(false);
                frame.bye.setVisible(true);
            }
        });
        button4=new MyButton("back",10,300);
        add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dr.setVisible(false);
                frame.menu.setVisible(true);
            }
        });
        text=new MyTextField(120,220);
        add(text);

    }

}

