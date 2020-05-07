package client.network;

import client.BossFrame;
import client.components.MyButton;
import client.components.MyLabel;
import client.components.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu  extends JPanel {
    private MyLabel menu;
    private MyButton menud,mypage,payments,drinks,meal;
    private MyTextField search;
    private BossFrame frame = null;
    public Menu (BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        menu= new MyLabel("Menu",250,10);
        add(menu);
        menud=new MyButton("Menu",10,400);
        add(menud);
        mypage=new MyButton("My Page",120,400);
        add(mypage);
        mypage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.menu.setVisible(false);
                frame.m.setVisible(true);
            }
        });
        payments=new MyButton("Payments",340,400);
        add(payments);
        payments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.menu.setVisible(false);
                frame.pay.setVisible(true);
            }
        });
        drinks=new MyButton("Drinks",150,200);
        add(drinks);
        drinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.menu.setVisible(false);
                frame.dr.setVisible(true);
            }
        });
        meal=new MyButton("Meal",260,200);
        add(meal);
        meal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.menu.setVisible(false);
                frame.meal.setVisible(true);
            }
        });
        search=new MyTextField(150,100);
        add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(search.equals(frame.meal.getBackeryckbox())||search.equals(frame.meal.getMealbox())){
                    frame.menu.setVisible(false);
                    frame.meal.setVisible(true);
                }
                else  if(search.equals(frame.dr.getBav())||search.equals(frame.dr.getCofee())){
                    frame.menu.setVisible(false);
                    frame.dr.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(frame, "I dont know this order");
                }
            }
        });
    }

}