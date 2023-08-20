package module;
import java.util.ArrayList;

public class Calculator {

    private ArrayList parsedFormula = new ArrayList();
    public boolean isFinished = false;
    public Operator op;

    public Calculator(String formula,Operator operator) {
        this.op = operator;
        //객체 생성시 바로 파싱
        parsing(formula);
    }

    public void parsing(String Formula){
        //공백 제거
        String nullRemovedFormula = Formula.replace(" ","");
        // 연산자 기준으로 먼저 분리
        String[] tempNumberList = nullRemovedFormula.split("\\+|\\-|\\*|\\/");
        // 연산자는 따로 어레이 리스트 만들어놓고
        ArrayList tempOperatorList = new ArrayList();
        // For문 돌면서 연산자인지 비교해서 맞다면 넣는다.
        for (int i = 0; i < nullRemovedFormula.length();i++) {
            if (op.isOperator(String.valueOf(nullRemovedFormula.charAt(i)))){
                tempOperatorList.add(nullRemovedFormula.charAt(i));
            }
        }
        //분리한 숫자와, 연산자를 "파싱된 배열"에 하나로 합치는 과정
        while (isFinished == false){
            //숫자 배열 돌면서 "파싱된 배열"에 숫자 넣기
            for (int i = 0; i<tempNumberList.length;i++){
                parsedFormula.add(tempNumberList[i]);
                //연산자 배열 돌면서 "파싱된 배열"에 연산자 넣기
                if (!tempOperatorList.isEmpty()){
                    parsedFormula.add(tempOperatorList.get(0));
                    tempOperatorList.remove(0);
                }
            }
            isFinished =true;
        }
    }

    public ArrayList getParsedFormula(){
        return parsedFormula;
    }

    public void postfixCalculating(String formula,Operator operator){
        ArrayList calculatedFormula = new ArrayList();

        for (int i = 0; i < formula.length();i++) {
            //연산자는 내부 스택에서 비교
            if (operator.isOperator(String.valueOf(formula.charAt(i)))){
                // 연산자
                calculatedFormula.add(operator.operatorCalculating(formula.charAt(i),isFinished));
            }
            //숫자는 바로 들어감
            else{
                calculatedFormula.add(formula.charAt(i));
            }
        }
        while(operator.operatorStack.isEmpty()== true) {
            calculatedFormula.add(operator.operatorStack.pop());
        }
        System.out.println(calculatedFormula);
    }
}


