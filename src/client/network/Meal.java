package client.network;

import client.BossFrame;
import client.components.MyButton;
import client.components.MyLabel;
import client.components.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Meal extends JPanel {
    private MyLabel label,label2,label3,label4;
    private JComboBox mealbox;
    private JComboBox backeryckbox;
    private MyButton button1,button2,button3,button4;
    private MyTextField text;
    private String sweet[] = {"angelica","apple pie","banana split","blancmange", "brown sugar", "buttercream", "cake" , "caramel" };
    private String bakery[] = {"Biscuit", "Bread ", "Brownie ", "Cake","Cookie ","Cracker ","Pastry "};
    private BossFrame frame = null;

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

    public Meal(BossFrame frame) {
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        label = new MyLabel("Meal", 200, 10);
        add(label);
        label2 = new MyLabel("Backery", 10, 50);
        add(label2);
        label3 = new MyLabel("Sweets", 10, 110);
        add(label3);
        label4 = new MyLabel("count", 10, 220);
        add(label4);
        mealbox = new JComboBox(bakery);
        mealbox.setBounds(120, 50, 100, 30);
        add(mealbox);
        backeryckbox = new JComboBox(sweet);
        backeryckbox.setBounds(120, 110, 100, 30);
        add(backeryckbox);
        button1 = new MyButton("add", 230, 50);
        add(button1);
        button2 = new MyButton("add", 230, 110);
        add(button2);
        button3 = new MyButton("next", 400, 300);
        add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.meal.setVisible(false);
                frame.bye.setVisible(true);
            }
        });
        button4 = new MyButton("back", 10, 300);
        add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.meal.setVisible(false);
                frame.menu.setVisible(true);
            }
        });
        text = new MyTextField(120, 220);
        add(text);

    }
}

