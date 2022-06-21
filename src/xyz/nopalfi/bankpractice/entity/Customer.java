package xyz.nopalfi.bankpractice.entity;

import java.math.BigDecimal;

public class Customer {
    private Long id;
    private String name;
    private BigDecimal balance;
    private String timeDate;

    public Customer() {
    }

    public Customer(String name, BigDecimal balance, String timeDate) {
        this.name = name;
        this.balance = balance;
        this.timeDate = timeDate;
    }

    public Customer(Long id, String name, BigDecimal balance, String timeDate) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.timeDate = timeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (balance != null ? !balance.equals(customer.balance) : customer.balance != null) return false;
        return timeDate != null ? timeDate.equals(customer.timeDate) : customer.timeDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (timeDate != null ? timeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", timeDate='" + timeDate + '\'' +
                '}';
    }
}
