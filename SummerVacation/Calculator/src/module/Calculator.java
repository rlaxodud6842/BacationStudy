package module;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Calculator extends Exception{
    public OperatorUtil op;
    public String formula;

    public Calculator(String formula, OperatorUtil operatorUtil){
        this.op = operatorUtil;
        this.formula = formula;
    }

        /*
        ((31-22/34)+(15*5))
        (31+4-(31-22/34)+(15*5))
         */
    public Stack<String> parsing(String formula) throws Exception {
        Stack<String> buket = new Stack<>();
        String nullRemovedList = formula.replace(" ","");

        //한놈 받아보고 다음놈이 괄호 또는 연산자가 아니면 합쳐서 넣기.
        for (int i = 0;i < nullRemovedList.length();i ++) {
            String temp = "";
            int j = i;
            //숫자일 경우
            if (isInt(nullRemovedList.charAt(i))){
                while(isInt(nullRemovedList.charAt(j))){
                    temp += nullRemovedList.charAt(j);
                    j++;
                }
                buket.push(temp);
                i = j-1;
            }else{
                buket.push(String.valueOf(nullRemovedList.charAt(i)));
            }
        }
        System.out.println(buket);
        return buket;
    }

    public ArrayList<String> postfix(Stack<String> formula){

        //후위 연산으로 만들어진 각각을 저장하는 리스트 생성
        ArrayList<String> postfixFormula = new ArrayList<String>();
        // 연산자를 저장하는 스택 생성
        Stack<String> operatorStack = new Stack<String>();

        for (String i : formula) {
            String element = i;
            //연산자일 경우
            if (op.isOperator(element)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(element);
                    //들어오는놈이 연산자 스택 안에있는놈보다 우선순위가 낮으면 스택 방출 후 추가.
                } else if (op.operatorJudge(element) <= op.operatorJudge(operatorStack.peek())) {
                    postfixFormula.add(operatorStack.pop());
                    operatorStack.push(element);
                } else {
                    operatorStack.push(element);
                }
                // 숫자일 경우
            } else {
                postfixFormula.add(element);
            }
        }
        //파싱이 끝나면 스택에 있는놈들 대방출
        while(!operatorStack.isEmpty()) {
            postfixFormula.add(operatorStack.pop());
        }
        return postfixFormula;
    }
    public double calculating(ArrayList<String> posixArray)throws Exception{
        Stack<String> calculatedFormula = new Stack();
        double n1;
        double n2;

        for (int i = 0;i < posixArray.size();i++) {
            String element = posixArray.get(i);
            //연산자일 경우
            if (op.isOperator(element)){
                //어떤 연산자인지 확인하고 스택에서 꺼내서 다시 넣기.
                //더하기인 경우
                n1 = Double.parseDouble(calculatedFormula.pop());
                if(element.equals("+")){
                    n2 = Double.parseDouble(calculatedFormula.pop()) + n1;
                }else if(element.equals("-")){
                    n2 = Double.parseDouble(calculatedFormula.pop()) - n1;
                }else if(element.equals("*")) {
                    n2 = Double.parseDouble(calculatedFormula.pop()) * n1;
                }else if(element.equals("/")){
                    n2 = Double.parseDouble(calculatedFormula.pop()) / n1;
                }else {
                    throw new Exception("n2 is Error");
                }
                calculatedFormula.push(String.valueOf(n2));
            }
            //피연산자일 경우
            else{
                calculatedFormula.push(element);
            }
            System.out.println(calculatedFormula);
        }
        return Double.parseDouble(calculatedFormula.pop());
    }
    public boolean isInt (char string){
        try{
            int trash = Integer.parseInt(String.valueOf(string));
        }catch(Exception e){
            return false;
        }
        return true;
    }

    //파싱 구현 완료, 계산 구현하면 된다.
}