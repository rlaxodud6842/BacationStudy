import java.util.Scanner;
import module.Calculator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("수식을 입력하세요(q 입력시 종료) : ");
            String formula = sc.nextLine();

            Calculator calc = new Calculator(formula);



            if (formula.equals("q")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

    }
}