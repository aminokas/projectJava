package client;

import client.network.*;
import data.User;

import javax.swing.*;

public class BossFrame extends JFrame {
    public RegisterPage regPage;
    public LoginPage logPage;
    public ClientSocket clientSocket;
    public Menu menu ;
    public MaPage m;
    public Payments pay;
    public Drinks dr;
    public Meal meal;
    public Bye bye;
    public User currentUser = null;

    public BossFrame(){

        clientSocket = new ClientSocket();

        setSize(600, 500);
        setTitle("Starbucks");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        bye=new Bye(this);
        add(bye);
        bye.setVisible(false);
        meal= new Meal(this);
        add(meal);
        meal.setVisible(false);
        dr=new Drinks(this);
        add(dr);
        dr.setVisible(false);
        pay=new Payments(this);
        add(pay);
        pay.setVisible(false);
        m=new MaPage(this);
        add(m);
        m.setVisible(false);
        menu =new Menu(this);
        add(menu);
        menu.setVisible(false);
        regPage = new RegisterPage(this);
        add(regPage);
        regPage.setVisible(false);
        logPage = new LoginPage(this);
        add(logPage);
        logPage.setVisible(true);
    }
}
