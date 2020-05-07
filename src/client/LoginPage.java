package client;

import client.components.MyButton;
import client.components.MyLabel;
import client.components.MyPasswordField;
import client.components.MyTextField;
import data.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private MyLabel ll, pl;
    private MyTextField ltf;
    private MyPasswordField ptf;
    private MyButton logb = null,regb=null;
    private BossFrame frame = null;

    public LoginPage(BossFrame frame){
        this.frame = frame;

        setSize(800, 600);
        setLayout(null);
        setBackground(Color.PINK);

        ll = new MyLabel("login: ", 50, 50);
        add(ll);

        pl = new MyLabel("password: ", 50, 100);
        add(pl);

        ltf = new MyTextField(150, 50);
        add(ltf);

        ptf = new MyPasswordField(150, 100);
        add(ptf);

        logb = new MyButton("Login", 150, 150);
        add(logb);

        logb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ltf.getText().isEmpty() || ptf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                }
                else{
                    User u = new User();
                    u.setLogin(ltf.getText());
                    u.setPassword(ptf.getText());

                    User authUser = frame.clientSocket.toLogin(u);
                    if(authUser != null){
                        frame.currentUser = authUser;
                        JOptionPane.showMessageDialog(frame, "You are Logged in");
                        ltf.setText("");
                        ptf.setText("");

                        if(authUser.getRole().equals("ADMIN")){
                            frame.logPage.setVisible(false);
                            frame.menu.setVisible(true);
                        }
                        else{
                            frame.logPage.setVisible(false);
                            frame.menu.setVisible(true);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(frame, "Incorrect login or password");
                }
            }
        });
        regb=new MyButton("Regist",300,300);
        add(regb);
        regb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.logPage.setVisible(false);
                frame.regPage.setVisible(true);
            }
        });
    }
}
