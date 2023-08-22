package module;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator extends Exception{
    public boolean isFinished = false;
    public Operator op;
    public String formula;

    public Calculator(String formula,Operator operator){
        this.op = operator;
        this.formula = formula;
        if (isFormula(formula)){
            throw new NumberFormatException();
        }
        //객체 생성시 바로 파싱
    }

    public boolean isFormula (String formula){
        if (formula == null){
            return false;
        }
        try{
            double f = Double.parseDouble(formula);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public double showResult(ArrayList parsedFormula){
        double result = calculating(parsedFormula);
        return result;
    }
    public ArrayList parsing(String Formula){
        ArrayList parsedFormula = new ArrayList();
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
        isFinished =false;
        return parsedFormula;
    }

    public ArrayList postfix(ArrayList formula){

        //후위 연산으로 만들어진 각각을 저장하는 리스트 생성
        ArrayList postfixFormula = new ArrayList();
        // 연산자를 저장하는 스택 생성
        Stack operatorStack = new Stack();

        for (int i =0;i<formula.size();i++){
            String element = formula.get(i).toString();
            //연산자일 경우
                if(op.isOperator(element)){
                    if (operatorStack.isEmpty()){
                    operatorStack.push(element);
                    //들어오는놈이 연산자 스택 안에있는놈보다 우선순위가 낮으면 스택 대방출// 후 추가.
                    }else if (op.operatorJudge(element) <= op.operatorJudge(operatorStack.peek().toString())){
                            postfixFormula.add(operatorStack.pop());
                            operatorStack.push(element);
                    }
                    else{
                        operatorStack.push(element);
                    }
                // 숫자일 경우
                }else{
                    postfixFormula.add(element);
                }
        }
        //파싱이 끝나면 스택에 있는놈들 대방출
        while(!operatorStack.isEmpty()) {
            postfixFormula.add(operatorStack.pop());
        }
        return postfixFormula;
    }
    public double calculating(ArrayList posixArray){
        Stack calculatedFormula = new Stack();
        double n1;
        double n2;

        for (int i = 0;i < posixArray.size();i++) {
            String element = posixArray.get(i).toString();
            //연산자일 경우
            if (op.isOperator(element)){
                //어떤 연산자인지 확인하고 스택에서 꺼내서 다시 넣기.
                //더하기인 경우
                if(element.equals("+")){
                    n1 = Double.parseDouble(calculatedFormula.pop().toString());
                    n2 = Double.parseDouble(calculatedFormula.pop().toString()) + n1;
                    calculatedFormula.push(n2);
                }else if(element.equals("-")){
                    n1 = Double.parseDouble(calculatedFormula.pop().toString());
                    n2 = Double.parseDouble(calculatedFormula.pop().toString()) - n1;
                    calculatedFormula.push(n2);
                }else if(element.equals("*")) {
                    n1 = Double.parseDouble(calculatedFormula.pop().toString());
                    n2 = Double.parseDouble(calculatedFormula.pop().toString()) * n1;
                    calculatedFormula.push(n2);
                }else if(element.equals("/")){
                    n1 = Double.parseDouble(calculatedFormula.pop().toString());
                    n2 = Double.parseDouble(calculatedFormula.pop().toString()) / n1;
                    calculatedFormula.push(n2);
                }
            }
            //피연산자일 경우
            else{
                calculatedFormula.push(Integer.parseInt(element));
            }
            //System.out.println(calculatedFormula); 디버깅시 켜기
        }
        return Double.parseDouble(calculatedFormula.pop().toString());
    }
}