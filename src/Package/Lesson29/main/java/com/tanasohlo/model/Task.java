package Package.Lesson29.main.java.com.tanasohlo.model;

import java.math.BigDecimal;

public class Task {
    private String name;
    private BigDecimal price;
    private String id;
    private Employee assignee;

    public Task(String name, BigDecimal price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }
}
