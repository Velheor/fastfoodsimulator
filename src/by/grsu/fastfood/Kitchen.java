package by.grsu.fastfood;

public class Kitchen extends Thread {
    FastFood fastFood;

    Kitchen(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    @Override
    public void run(){
        while (true) {
            try {
                fastFood.kitchenJob();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
