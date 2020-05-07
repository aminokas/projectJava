package client.network;

import client.BossFrame;
import client.components.*;
import data.Cofee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class AdminCoffeePage extends JPanel {
    private BossFrame frame = null;
    private MyTable table;
    private JScrollPane pane;
    private Object columns[] = {"ID", "NAME", "VKUS", "COUNT"};

    private ArrayList<Cofee> cofees = null;

    private MyLabel idl, nl, gl, aul, cl, avl;
    private MyTextField idf, nf, gtf, ctf, avtf;
    private MyTextArea auta;
    private MyButton addb, delb;
    public AdminCoffeePage(BossFrame frame){
        this.frame = frame;
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.white);

        table = new MyTable(columns);
        pane = new JScrollPane(table);
        pane.setBounds(0, 0, 500, 200);
        add(pane);
        updateTable();

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowind = table.getSelectedRow();
                idf.setText(table.model.getValueAt(rowind, 0).toString());
                nf.setText(table.model.getValueAt(rowind, 1).toString());
                gtf.setText(table.model.getValueAt(rowind, 4).toString());
                avtf.setText(table.model.getValueAt(rowind, 5).toString());
                ctf.setText(table.model.getValueAt(rowind, 3).toString());
                auta.setText(table.model.getValueAt(rowind, 2).toString());
            }

            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {

            }
        });
        idl = new MyLabel("id: ", 20, 200);
        add(idl);
        nl = new MyLabel("name: ", 20, 240);
        add(nl);
        gl = new MyLabel("Vkus: ", 20, 280);
        add(gl);
        avl = new MyLabel("Count: ", 20, 320);
        add(avl);

        idf = new MyTextField(70, 200);
        add(idf);
        nf = new MyTextField(70, 240);
        add(nf);
        gtf = new MyTextField(70, 280);
        add(gtf);
        avtf = new MyTextField(70, 320);
        add(avtf);
        addb = new MyButton("ADD", 300, 400);
        add(addb);
        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cofee cofee = new Cofee(null, nf.getText(), auta.getText(), Integer.parseInt(ctf.getText()), gtf.getText());
                frame.clientSocket.addCoffee(cofee);
                JOptionPane.showMessageDialog(frame, "YOUR BOOK IS ADDED");
                updateTable();
            }
        });
        delb = new MyButton("DELETE", 300, 450);
        add(delb);
        delb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cofee cofee = new Cofee();
                cofee.setId(Long.valueOf(idf.getText()));
                boolean removed = frame.clientSocket.removeCoffee(cofee);
                if(removed){
                    JOptionPane.showMessageDialog(frame, "Cofees is removed");
                    updateTable();
                }
                else
                    JOptionPane.showMessageDialog(frame, "SOME PROBLEMS");
            }
        });
    }
    public void updateTable(){
        while (table.model.getRowCount() > 0){
            table.model.removeRow(0);
        }
        cofees = frame.clientSocket.getAllCoffee();
        for(Cofee b : cofees){
            table.model.addRow(new Object[]{b.getId(), b.getName(), b.getCount(), b.getVkus()});
        }
    }
}

