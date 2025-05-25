package appcli;

import service.ExpenseController;

public class Logic {
    public static void main(String[] args){
        ExpenseController logic = new ExpenseController();
        logic.Start();
    }
}