package by.grsu.fastfood;

import java.util.LinkedList;

public class FastFood {
    LinkedList<Customer> customers = new LinkedList<>();
    LinkedList<Customer> waiters = new LinkedList<>();
    LinkedList<Order> orders = new LinkedList<>();
    LinkedList<Order> prepare = new LinkedList<>();

    int numberCustomer = 0;

    public static void main(String[] argv) {
        FastFood fastFood = new FastFood();
        Line line = new Line(fastFood);
        OrderTaker orderTaker = new OrderTaker(fastFood);
        Kitchen kitchen = new Kitchen(fastFood);
        Server server = new Server(fastFood);
        line.start();
        orderTaker.start();
        kitchen.start();
        server.start();
    }

    public synchronized void lineJob() throws InterruptedException {
        while (customers.size() > 10)
            wait();

        numberCustomer += 1;

        customers.add(new Customer(numberCustomer));
        System.out.println("Add customer in line " + numberCustomer);
        notify();
    }

    public synchronized void orderTakerJob() throws InterruptedException {
        while (customers.size() == 0)
            wait();

        Customer customer = customers.removeFirst();
        customer.setTicket(numberCustomer);
        System.out.println("OrderTaker give ticket number to customer - "
                + customer.getNumber() + " and put him to server");

        waiters.add(customer);
        orders.add(new Order(customer.getNumber()));
        notify();
    }

    public synchronized void kitchenJob() throws InterruptedException {
        while (orders.size() == 0)
            wait();

        Order order = orders.removeFirst();
        order.setPrepare(true);
        System.out.println("Kitchen take order -" + order.getNumber() + " prepare");

        prepare.add(order);

        notify();
    }

    public synchronized void serverJob() throws InterruptedException {
        while (waiters.size() == 0 || prepare.size() == 0)
            wait();

        Customer customer = waiters.removeFirst();
        customer.setOrder(prepare.removeFirst());

        System.out.println("Server take waiter - "
                + customer.getNumber() + " and left him");

        notify();
    }
}