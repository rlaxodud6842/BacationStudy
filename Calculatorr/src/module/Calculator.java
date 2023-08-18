package module;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    private ArrayList splitOperator = new ArrayList();
    private ArrayList splitNumber = new ArrayList();

    public Calculator(String formula) {
        Parsing(formula);
    }

    public void Parsing(String formula) {
        String nullRemoveFormula = formula.replace(" ","");
        System.out.println(nullRemoveFormula);

        for (int i = 0; i < nullRemoveFormula.length();i++) {
            if (isOperator(String.valueOf(nullRemoveFormula.charAt(i)))){
                System.out.println(nullRemoveFormula.charAt(i));
            // 연산자
            calculate(nullRemoveFormula.charAt(i) );
            }
            else{
                System.out.println(nullRemoveFormula.charAt(i));
            //숫자
            }
        }
        //스택에 숫자는 그냥 패스, 연산자 * ,/ 는 스택에 아무것도 없다면, 스택에 저장
        //스택안에 + , - 가 있다면, 그냥 저장
        // 새로 들어오는 녀석이
    }
    public void calculate(char number){
        Stack operatorStack = new Stack();
        operatorStack.push((number));
        System.out.println(operatorStack);
    }
    public boolean isOperator(String operator){
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")){
            return true;
        }
        return false;
    }

}


