package by.grsu.fastfood;

public class Server extends Thread {
    FastFood fastFood;

    Server(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fastFood.serverJob();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
