import java.util.ArrayList;
import java.util.Scanner;
import module.Calculator;
import module.OperatorUtil;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("수식을 입력하세요(q 입력시 종료) : ");
            String formula = sc.nextLine();
            OperatorUtil op = new OperatorUtil();
            Calculator calc = new Calculator(formula,op);

            ArrayList parsedFormula = calc.postfix(calc.parsing(calc.formula));

            try{
                double result = calc.calculating(parsedFormula);
                System.out.println("계산 결과 : "+result);
                    }
            catch(Exception e){
                System.out.println(e);
            }

            if (formula.equals("q")){
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}