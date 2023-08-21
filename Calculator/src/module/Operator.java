package module;
public class Operator {
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
    public boolean isOperator (String operator){
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")) {
            return true;
        }
        return false;
    }
}
