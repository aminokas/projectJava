package client;
import server.CountDownThread;

public class App {
    public static void main(String[] args) {
        BossFrame boss = new BossFrame();
        boss.setVisible(true);
        CountDownThread ct = new CountDownThread(180);
        ct.start();
    }
}
