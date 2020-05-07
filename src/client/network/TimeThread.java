package client.network;

import client.BossFrame;

import javax.swing.*;

public class TimeThread extends Thread{
    private BossFrame frame;
    private String bookName;
    private int seconds;

    public TimeThread(BossFrame frame, String bookName, int seconds) {
        this.frame = frame;
        this.bookName = bookName;
        this.seconds = seconds;
    }

    public void run(){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(frame,"your order is ready");
    }
}

