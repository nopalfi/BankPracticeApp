package xyz.nopalfi.bankpractice.repository;

import xyz.nopalfi.bankpractice.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface MoneyRepository {

    List<Customer> findAll();

    Customer addCustomer(Customer customer);

    void addBalance(Long id, BigDecimal balance);

    void withdrawBalance(Long id, BigDecimal balance);

    Customer findCustomer(Long id);

    Boolean deleteCustomer(Long id);

}
