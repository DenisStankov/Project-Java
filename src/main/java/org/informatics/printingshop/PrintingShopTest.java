package org.informatics.printingshop;

import org.informatics.employees.Employee;
import org.informatics.employees.Manager;
import org.informatics.publication.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintingShopTest {

    @org.junit.jupiter.api.Test
    void salaryExpenses() {
        PrintingShop printingShop = new PrintingShop();
        Employee employee = new Employee();
        Manager manager = new Manager(printingShop, employee);
        Manager manager1 = new Manager(printingShop, employee);
        employee.setSalary(1300);
        manager.setPercentageIncrease(2);
        System.out.println(printingShop.salaryExpenses());


    }

    @org.junit.jupiter.api.Test
    void paperExpenses() {
        PrintingShop printingShop = new PrintingShop();
        Publication publication1 = new Publication("Romeo and Juliette", 50, PublicationType.BOOK, SizePage.A3, TypePaper.NORMAL, MachineType.COLORFUL, printingShop);
        Publication publication2 = new Publication("Game of Thrones", 80, PublicationType.POSTER, SizePage.A5, TypePaper.GLOSSY, MachineType.COLORLESS, printingShop);
        publication1.setDiscount(2.3);
        publication1.setCountDiscount(55);
        System.out.println(printingShop.paperExpenses());
    }
}