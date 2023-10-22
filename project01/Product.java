package project01;

public class Product {
    // 이름, 가격, 설명
    private String name;
    private double price;
    private String description;
    
    // 생성자
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    // getter
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getDescription() {
        return description;
    }
}
