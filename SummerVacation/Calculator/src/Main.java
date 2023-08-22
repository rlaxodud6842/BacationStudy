import java.util.ArrayList;
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

            try{
                Calculator calc = new Calculator(formula,op);
                ArrayList parsedFormula = calc.postfix(calc.parsing(calc.formula));
                double result = calc.showResult(parsedFormula);
                System.out.println("계산 결과 : "+result);

            }catch (NumberFormatException e){

                if (formula.equals("q")){
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
                System.out.println("올바른 식을 입력해주세요\n 입력된 값 : " + formula);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}