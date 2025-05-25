package service;

import model.Expense;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ExpenseRecord extends DateTimeUtil {
    private Expense product;

    public ExpenseRecord(LocalDateTime time, Expense product){
        super(time);
        this.product = product;
    }
    public Expense getProduct(){
        return product;
    }

    public void InputInfo(Scanner scan){
        InputTime(scan);

        System.out.print("제품 명 : ");
        String name = scan.nextLine();

        int price;
        while(true){
            try{
                System.out.print("총 가격 : ");
                price = scan.nextInt();
                break;

            } catch (Exception e) {
                System.out.println("알맞은 가격을 입력하세요");
                scan.nextLine();
            }
        }

        scan.nextLine();

        System.out.print("세부 사항 : ");
        String detail = scan.nextLine();

        this.product = new Expense(name, price, detail);
    }
}
