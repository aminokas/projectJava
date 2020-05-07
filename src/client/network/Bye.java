package client.network;

import client.BossFrame;
import client.components.MyButton;
import server.CountDownThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bye extends JPanel {

    private JTextArea tovar;
    private MyButton back = null, bye=null ;
    private BossFrame frame = null;


    private CountDownThread uvedom=null;

    public Bye(BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.PINK);
        tovar=new JTextArea();
        tovar.setBounds(10,10,300,300);
        add(tovar);
        back=new MyButton("Back",10,330);
        add(back);
        bye=new MyButton("Bye",300,330);
        add(bye);

        bye.addActionListener(new ActionListener() {

                                  public void actionPerformed(ActionEvent actionEvent) {
                                      JOptionPane.showMessageDialog(frame, "Thank you to bye, it wait your order");
                                      uvedom.start();
                                      frame.bye.setVisible(false);
                                      frame.menu.setVisible(true);

                                  }
                              }
        );

    }

}


