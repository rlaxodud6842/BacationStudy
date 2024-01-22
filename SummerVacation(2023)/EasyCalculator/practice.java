import java.util.Scanner;
class Calculator {
    private int value1;
    private int value2;
    private String operator;

    void inputData(String userInput) {
        if (userInput.contains("+")) {
            String[] dataList = userInput.split("\\+");
            operator = "+";
            computingSum(userInput,calculateData(dataList[0],dataList[1],operator));
        }else if (userInput.contains("-")) {
            String[] dataList = userInput.split("\\-");
            operator = "-";
            computingSum(userInput,calculateData(dataList[0],dataList[1],operator));
        }else if (userInput.contains("*")){
            String[] dataList = userInput.split("\\*");
            operator = "*";
            computingSum(userInput,calculateData(dataList[0],dataList[1],operator));
        }else if (userInput.contains("/")){
            String[] dataList = userInput.split("\\/");
            operator = "/";
            computingDivide(userInput,calculateDivide(dataList[0],dataList[1]));
        }
    }
    int calculateData(String x, String y, String operator){
        value1 = Integer.parseInt(x);
        value2 = Integer.parseInt(y);
        if (operator == "+"){
            int sum = value1 + value2;
            return sum;
        }else if (operator == "-"){
            int sum = value1 - value2;
            return sum;
        }else if (operator == "*"){
            int sum = value1 * value2;
            return sum;
        }
        return 0;
    }
    double calculateDivide(String x, String y){
        value1 = Integer.parseInt(x);
        value2 = Integer.parseInt(y);
        double sum = (double)value1 / value2;
        return sum;
    }
    void computingSum(String originalInput,int sum){
        System.out.printf("%s은(는) %s 입니다.",originalInput,sum);
    }
    void computingDivide(String originalInput,double sum){
        System.out.printf("%s은(는) %f_ 입니다.",originalInput,sum);
    }
}

public class practice{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner csc = new Scanner(System.in);
        Calculator calc1 = new Calculator();
        while(true) {
            System.out.println("\n1: 실행\n2: 종료");
            int userSelection = sc.nextInt();
            if (userSelection == 1) {
                System.out.println("수식을 입력하세요:");
                String userInput = csc.next();
                calc1.inputData(userInput);
            } else if (userSelection == 2) {
                break;
            }
        }
    }
}

