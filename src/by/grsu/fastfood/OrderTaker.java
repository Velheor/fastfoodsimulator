package by.grsu.fastfood;

public class OrderTaker extends Thread {
    FastFood fastFood;

    OrderTaker(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fastFood.orderTakerJob();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
