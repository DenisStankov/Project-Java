package org.informatics.employees;

import org.informatics.printingshop.PrintingShop;

public class OperatorOfMachine extends Employee{

    public OperatorOfMachine(PrintingShop printingShop) {
        printingShop.addOperator(this);
    }

}
