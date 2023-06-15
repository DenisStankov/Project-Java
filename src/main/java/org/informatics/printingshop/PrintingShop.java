package org.informatics.printingshop;

import org.informatics.employees.Manager;
import org.informatics.employees.OperatorOfMachine;
import org.informatics.publication.Publication;

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
        return income;
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
            if(publication.getCount() > publication.getCountDiscount()) {
                paperCosts += paperCosts * publication.getDiscount() / 100;
            }
        }
        return paperCosts;
    }
}
