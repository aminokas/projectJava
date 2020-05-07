package server;

public class CountDownThread extends Thread {
    private int sec=0;

    public CountDownThread(int sec){
        this.sec=sec*1000;
    }

    public void run() {
        try {
            while (true){
                Thread.sleep(sec);
               // Server.showOrder();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

