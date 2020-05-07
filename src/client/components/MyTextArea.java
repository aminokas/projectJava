package client.components;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MyTextArea extends JTextArea {
    public MyTextArea(int x, int y){
        setForeground(Color.darkGray);
        setBackground(Color.white);
        setSize(200, 100);
        setLocation(x, y);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBorder(new EtchedBorder(Color.GRAY, Color.GRAY));
    }
}
