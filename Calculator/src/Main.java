import java.util.Scanner;
import module.Calculator;
import module.Operator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("수식을 입력하세요(q 입력시 종료) : ");
            String formula = sc.nextLine();

            Operator op = new Operator();
            Calculator calc = new Calculator(formula,op);
            System.out.println("계산 결과 : "+calc.showResult());

            if (formula.equals("q")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

    }
}