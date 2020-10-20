package by.grsu.fastfood;

public class Customer {
    private Integer number;
    private Integer ticket;

    public Customer(Integer number) {
        this.number = number;
    }

    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
}
