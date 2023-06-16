package org.informatics.printingshop;

import org.informatics.employees.Manager;
import org.informatics.employees.OperatorOfMachine;
import org.informatics.publication.MachineType;
import org.informatics.publication.Publication;
import org.informatics.publication.PublicationType;

import javax.crypto.Mac;
import java.awt.print.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrintingShop {
    private double expectedIncome;
    private double income;
    private List<Publication> publications;
    private List<Manager> managers;
    private List<OperatorOfMachine> operators;

    public PrintingShop() {
        publications = new ArrayList<>();
        managers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }
    public void addManager(Manager manager){
        managers.add(manager);
    }
    public void addOperator(OperatorOfMachine operator){
        operators.add(operator);
    }

    public double getExpectedIncome() {
        return expectedIncome;
    }

    public void setExpectedIncome(double expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public double getIncome() {
        double income = 0.0;


        for(Publication publication : publications){
            MachineType machineType = publication.getMachineType();
            income += (publication.priceOfPaper() * publication.getCount());
            if(publication.getCount() > publication.getCountDiscount()) {
                income += income * publication.getDiscount() / 100;
            }
            if(machineType == MachineType.COLORFUL){
                income *= 1.5;
            }
            else if(machineType == MachineType.COLORLESS){
                income *= 1.2;
            }
        }
        return income - paperExpenses();
    }


    public double salaryExpenses() {
        double totalCosts = 0.0;

        for(Manager manager : managers){
            totalCosts += manager.getSalary();
        }
        for(OperatorOfMachine operator : operators){
            totalCosts += operator.getSalary();
        }

        return totalCosts;
    }

    public double paperExpenses() {
        double paperCosts = 0.0;

        for(Publication publication : publications){
            paperCosts += (publication.priceOfPaper() * publication.getCount());

        }
        return paperCosts;
    }

    public void writeToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            writer.println("Income: " + getIncome());
            writer.println("Paper expenses: " + paperExpenses());
            writer.println("Salary expenses: " + salaryExpenses());

            writer.println("Publications:");
            for (Publication publication : publications) {
                writer.println(publication.getTitle() + ", " + publication.getCount());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
