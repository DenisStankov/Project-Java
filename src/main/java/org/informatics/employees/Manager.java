package org.informatics.employees;

import org.informatics.printingshop.PrintingShop;

public class Manager extends Employee{
    private double percentageIncrease;
    private PrintingShop printingShop;
    private Employee employee;

    public Manager(PrintingShop printingShop, Employee employee) {
        printingShop.addManager(this);
        this.printingShop = printingShop;
        this.employee = employee;
    }

    public double getPercentageIncrease() {
        return percentageIncrease;
    }

    public void setPercentageIncrease(double percentageIncrease) {
        this.percentageIncrease = percentageIncrease;
    }

    public double getSalary() {
        return (printingShop.getIncome() > printingShop.getExpectedIncome())
                ? employee.getSalary() + (employee.getSalary() * getPercentageIncrease() / 100)
                : employee.getSalary();
    }

}
