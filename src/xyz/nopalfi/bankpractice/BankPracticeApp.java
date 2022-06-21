package xyz.nopalfi.bankpractice;


import xyz.nopalfi.bankpractice.entity.Customer;
import xyz.nopalfi.bankpractice.repository.MoneyRepositoryImpl;
import xyz.nopalfi.bankpractice.view.BankPracticeView;

import java.math.BigDecimal;


public class BankPracticeApp {

    public static void main(String[] args) {
        MoneyRepositoryImpl repository = new MoneyRepositoryImpl();
        BankPracticeView view = new BankPracticeView(repository);
        Customer customer1 = new Customer(1L,"Andi", BigDecimal.valueOf(50_000), "19:00");
        Customer customer2 = new Customer(2L,"Budi", BigDecimal.valueOf(50_000), "20:00");
        repository.addCustomer(customer1);
        repository.addCustomer(customer2);
        view.showAll();
    }
}
