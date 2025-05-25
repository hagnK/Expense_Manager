package service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeUtil {
    protected LocalDateTime time;


    public DateTimeUtil(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void InputTime(Scanner scan) {
        while(true){
            try{
                System.out.print("날짜 입력 (형식 yyyyMMddHH) : ");
                String time_str = scan.next();
                scan.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
                this.time = LocalDateTime.parse(time_str, formatter);
                break;
            } catch (Exception e) {
                System.out.println("형식(yyyyMMddHH)에 맞춰 입력해주세요");
            }
        }
    }
}
