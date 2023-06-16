package org.informatics;

import org.informatics.employees.Employee;
import org.informatics.employees.Manager;
import org.informatics.employees.OperatorOfMachine;
import org.informatics.printingshop.PrintingShop;
import org.informatics.publication.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        PrintingShop printingShop = new PrintingShop();
        Employee employee = new Employee();
        Manager manager = new Manager(printingShop, employee);
        Manager manager1 = new Manager(printingShop, employee);
        OperatorOfMachine operator = new OperatorOfMachine(printingShop);
        Publication publication1 = new Publication("Romeo and Juliette", 50, PublicationType.BOOK, SizePage.A3, TypePaper.NORMAL, MachineType.COLORFUL, printingShop);
        Publication publication2 = new Publication("Game of Thrones", 80, PublicationType.POSTER, SizePage.A5, TypePaper.GLOSSY, MachineType.COLORLESS, printingShop);
        Publication publication3 = new Publication("24 Chasa", 120, PublicationType.NEWSPAPER, SizePage.A4, TypePaper.PAPER, MachineType.COLORFUL,printingShop);
        Publication publication4 = new Publication("Forbes", 60, PublicationType.MAGAZINE, SizePage.A2, TypePaper.GLOSSY, MachineType.COLORLESS, printingShop);

        employee.setSalary(1300);
        Publication.setMaxPaperSheets(100);
        manager.setPercentageIncrease(5);
        printingShop.setExpectedIncome(1500);
        publication1.setDiscount(2.3);
        publication1.setCountDiscount(55);

        System.out.println(printingShop.salaryExpenses());
        System.out.println(printingShop.paperExpenses());
        System.out.println(printingShop.getIncome());

        try {
            publication1.checkPaperLoad();
        } catch (PaperLoadedException e) {
            System.out.println(e.getMessage());
        }
        try {
            publication2.checkPaperLoad();
        } catch (PaperLoadedException e) {
            System.out.println(e.getMessage());
        }
        try {
            publication3.checkPaperLoad();
        } catch (PaperLoadedException e) {
            System.out.println(e.getMessage());
        }
        try {
            publication4.checkPaperLoad();
        } catch (PaperLoadedException e) {
            System.out.println(e.getMessage());
        }

        printingShop.writeToFile("printing_data.txt");


    }
}