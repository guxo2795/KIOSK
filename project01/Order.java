package project01;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orders;
    private int orderNumber;

    public Order() {
        orders = new ArrayList<>();
        orderNumber = 1; // 대기번호 1번으로 초기화
    }

    public ArrayList<Product> getOrders() {
        return orders;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addOrder(Product menu) {
        orders.add(menu);
    }

    public void clearOrder() {
        orders.clear();
    }

    public double total() {
        double total = 0.0;
        for (Product menu : orders) {
            total += menu.getPrice();
        }
        return total;
    }
}
