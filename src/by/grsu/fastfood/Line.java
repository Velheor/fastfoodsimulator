package by.grsu.fastfood;

public class Line extends Thread {
    FastFood fastFood;

    Line(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fastFood.lineJob();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
