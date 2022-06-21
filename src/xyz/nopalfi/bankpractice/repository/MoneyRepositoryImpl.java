package xyz.nopalfi.bankpractice.repository;

import xyz.nopalfi.bankpractice.entity.Customer;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MoneyRepositoryImpl implements MoneyRepository{

    List<Customer> customersList = new ArrayList<>();

    Locale indonesia = new Locale("id","ID");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesia);

    @Override
    public List<Customer> findAll() {
        return customersList;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        for (var customers : customersList) {
            if (customers.getId() == customer.getId()) {
                System.out.println("This ID has been used");
                return null;
            } else if (customers.getName().equals(customer.getName())) {
                System.out.println("This name has been used");
            }
            customersList.add(customer);
        }
        return customer;
    }

    @Override
    public void addBalance(Long id, BigDecimal balance) {
        for (var customer : customersList) {
            if (customer.getId() == id) {
                customer.setBalance(customer.getBalance().add(balance));
                System.out.println("Money successfully transfered.");
                System.out.println("Balance: "+numberFormat.format(customer.getBalance()));
            }
        }
    }

    @Override
    public void withdrawBalance(Long id, BigDecimal balance) {

        for (var customer : customersList) {
            if (customer.getId() == id) {
                customer.setBalance(customer.getBalance().subtract(balance));
                if (customer.getBalance().compareTo(BigDecimal.valueOf(0)) == -1) {
                    System.out.println("Insufficient balance");
                } else {
                    customer.setBalance(customer.getBalance().add(balance));
                    System.out.println("Money successfully withdrawn.");
                    System.out.println("Balance: "+numberFormat.format(customer.getBalance()));
                }
            }
        }
    }

    @Override
    public Customer findCustomer(Long id) {
        Customer customer = null;
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getId() == id) {
                customer = customersList.get(i);
            }
        }
        return customer;
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getId() == id) {
                customersList.remove(i);
                return true;
            }
        }
        return false;
    }
}
