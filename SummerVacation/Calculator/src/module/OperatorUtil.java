package module;
public class OperatorUtil {
    //예외처리
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

    public boolean isOperator(String operator) {
        return (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*"));
    }

    public int isbraket(String braket){
        if (braket.equals("(")){
           return 1;
        }else if(braket.equals(")")){
            return 2;
        }
        return -452564;
    }
}