package by.grsu.fastfood;

public class Order {
    private Integer number;

    boolean prepare;

    public Order(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isPrepare() {
        return prepare;
    }

    public void setPrepare(boolean prepere) {
        this.prepare = prepere;
    }
}
