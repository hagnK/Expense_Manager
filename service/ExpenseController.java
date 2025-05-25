package service;

import model.Expense;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class ExpenseController {
    private final HashMap<LocalDateTime,Expense> list;
    private boolean stop;
    Scanner scan;
    private final ExpenseRecord entry;
    private final DateTimeUtil time;

    public ExpenseController(){
        stop = false;
        list = new HashMap<>();
        scan = new Scanner(System.in);
        entry = new ExpenseRecord(null, null );
        time = new DateTimeUtil(null);
    }

    public void Start() {
        while (!stop) {
            int menu;
            while (true) {
                try {
                    System.out.println("-- 메뉴 선택 ---");
                    System.out.println("1. 거래 입력");
                    System.out.println("2. 거래 수정");
                    System.out.println("3. 거래 삭제");
                    System.out.println("4. 거래 조회");
                    System.out.println("0. 종료");
                    System.out.print("메뉴 선택 >> ");
                    menu = scan.nextInt();

                    if (menu < 0 || menu > 4) {
                        System.out.println("0~4의 숫자를 다시 입력하세요");
                        scan.nextLine();
                        continue;
                    }

                    break;
                } catch (Exception e) {
                    System.out.println("0~4의 숫자를 다시 입력하세요");
                    scan.nextLine();
                }
            }
            System.out.println();

            switch (menu) {
                case 1:
                    AddMenu();
                    System.out.println();
                    break;
                case 2:
                    UpdateMenu();
                    System.out.println();
                    break;
                case 3:
                    DeleteMenu();
                    System.out.println();
                    break;
                case 4:
                    SearchMenu();
                    System.out.println();
                    break;
                case 0:
                    Stop();
                    break;
            }
        }
    }


    public void AddMenu(){
        System.out.println("-- 거래 추가 --");
        entry.InputInfo(scan);
        list.put(entry.getTime(), entry.getProduct());
        System.out.println("거래를 추가했습니다");
    }

    public void UpdateMenu(){
        System.out.println("-- 거래 수정 --");
        time.InputTime(scan);

        if(list.containsKey(time.getTime())){
            entry.InputInfo(scan);
            list.replace(entry.getTime(), entry.getProduct());
            System.out.print("거래를 수정했습니다");
        }

        else
            System.out.println("해당 날짜가 없습니다.");
    }

    public void DeleteMenu(){
        System.out.println("-- 거래 삭제 --");
        time.InputTime(scan);

        if(list.containsKey(time.getTime())){
            list.remove(time.getTime());
            System.out.println("삭제가 완료되었습니다");
        }else{
            System.out.println("삭제할 날짜가 없습니다");
        }
    }

    public void SearchMenu(){
        System.out.println("-- 거래 조회 --");
        time.InputTime(scan);

        if(list.containsKey(time.getTime())){
            Expense temp = list.get(time.getTime());

            System.out.println("가계부 조회");
            System.out.println("날짜 : " + time.getTime());
            System.out.println("품명 : " + temp.getName());
            System.out.println("가격 : " + temp.getPrice());
            System.out.println("세부사항 : " + temp.getDetail());
        }else{
            System.out.println("해당 날짜가 없습니다");
        }
    }

    public void Stop(){
        System.out.println("시스템 종료 되었습니다.");
        stop = true;
    }
}
