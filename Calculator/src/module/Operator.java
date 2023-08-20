package module;
import java.util.Stack;

public class Operator {
    Stack operatorStack = new Stack();

    public int operatorJudge(String operator) {
        if (operator.equals("+")) {
            return 0;
        } else if (operator.equals("-")) {
            return 0;
        } else if (operator.equals("*")) {
            return 1;
        } else if (operator.equals("/")) {
            return 1;
        }
        return -18461324;
    }

    public String operatorCalculating(char operator, boolean isFinish) {
        String calcOperator = "";

        if (isFinish) {
            while (operatorStack.isEmpty()) {
                calcOperator += operatorStack.pop();
                return calcOperator;
            }
        }

        if (operatorStack.isEmpty()) {
            operatorStack.push(operator);
            //들어오려는 녀석이 스택 최상위 녀석보다 순위가 낮으면.
        } else if (operatorJudge(String.valueOf(operator)) <= operatorJudge(String.valueOf(operatorStack.peek()))) {
            //스택이 빌때까지 스택을 비우고, 위에 push
            while (operatorStack.isEmpty()) {
                calcOperator += operatorStack.pop();
                operatorStack.push(String.valueOf(operator));
            }
            //들어 오려는 녀석이 스택 최상위 녀석보다 순위가 크다.
        } else if (operatorJudge(String.valueOf(operator)) > operatorJudge(String.valueOf(operatorStack.peek()))) {
            //바로 Push
            operatorStack.push(operator);
        }
        return calcOperator;

    }
    public boolean isOperator (String operator){
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")) {
            return true;
        }
        return false;
    }
}
