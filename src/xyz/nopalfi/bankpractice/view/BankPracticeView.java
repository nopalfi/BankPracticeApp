package xyz.nopalfi.bankpractice.view;

import xyz.nopalfi.bankpractice.entity.Customer;
import xyz.nopalfi.bankpractice.repository.MoneyRepositoryImpl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.exit;

public class BankPracticeView {
    private MoneyRepositoryImpl repository;
    Scanner scanner = new Scanner(System.in);
    Locale indonesia = new Locale("id","ID");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesia);

    public BankPracticeView(MoneyRepositoryImpl repository) {
        this.repository = repository;
    }
    public void showAll() {
        System.out.println("All Customers: ");
        for (var customer : repository.findAll()) {
            System.out.println("ID : "+customer.getId());
            System.out.println("Name : "+customer.getName());
            System.out.println("Balance : "+numberFormat.format(customer.getBalance()));
        }
        System.out.println("Choices: ");
        System.out.println("1. Transfer Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Find a customer by id");
        System.out.println("4. Delete a customer");
        System.out.print("Choice (x to exit): ");
        String choice = scanner.next();

        if (choice.equals("1")) {
            transferMoney();
        } else if(choice.equals("2")) {
            withdrawMoney();
        } else if (choice.equals("3")) {
            findCustomer();
        } else if (choice.equals("4")) {
            deleteACustomer();
        } else if (choice.equals("x")) {
            exit(0);
        } else {
            System.out.println("Try again");
            showAll();
        }
    }

    private void deleteACustomer() {
        System.out.println("ID customer (-1 to back): ");
        Long input = scanner.nextLong();
        if (input == -1) {
            showAll();
        } else {
            Customer customer = repository.findCustomer(input);
            if (customer.equals(null)) {
                System.out.println("Customer is not found");
                findCustomer();
            } else {
                repository.deleteCustomer(input);
                System.out.println("Customer deleted!");
                showAll();
            }
        }
    }

    private void withdrawMoney() {
        System.out.println("ID customer (-1 to back): ");
        Long input = scanner.nextLong();
        if (input == -1) {
            showAll();
        } else {
            Customer customer = repository.findCustomer(input);
            if (customer.equals(null)) {
                System.out.println("Customer is not found");
                transferMoney();
            } else {
                System.out.println("Customer found!");
                System.out.println("Withdraw :");
                BigDecimal balance = scanner.nextBigDecimal();
                repository.withdrawBalance(customer.getId(), balance);
                System.out.println();
                showAll();
            }
        }
    }

    private void transferMoney() {
        System.out.println("ID customer (-1 to back): ");
        Long input = scanner.nextLong();
        if (input == -1) {
            showAll();
        } else {
            Customer customer = repository.findCustomer(input);
            if (customer.equals(null)) {
                System.out.println("Customer is not found");
                transferMoney();
            } else {
                System.out.println("Customer found!");
                System.out.println("Balance :");
                BigDecimal balance = scanner.nextBigDecimal();
                repository.addBalance(customer.getId(), balance);
                System.out.println();
                showAll();
            }
        }
    }

    private void findCustomer() {
        System.out.println("ID customer (-1 to back): ");
        Long input = scanner.nextLong();
        if (input == -1) {
            showAll();
        } else {
            Customer customer = repository.findCustomer(input);
            if (customer.equals(null)) {
                System.out.println("Customer is not found");
                findCustomer();
            } else {
                System.out.println("Customer found!");
                System.out.println(customer.toString());
                showAll();
            }
        }
    }
}
