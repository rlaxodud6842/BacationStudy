import module.Stack;
import module.UserSelect;

import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `showStack whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st = null;
        while (true) {
            System.out.println("\n1: StackCreate\n2: Push \n3: Pop \n4: Peek \n5: Delete Stack \n6: Exit");
            int userSelection = sc.nextInt();

            if (userSelection == UserSelect.STACKCREATE.getValue()) {

                if (st == null){
                    System.out.println("스택의 Limit을 정해주세요:");
                    int setStackLimit = sc.nextInt();

                    st = new Stack(setStackLimit);
                    st.createStack();

                }else{
                    System.out.println("이미 기존의 스택이 존재합니다.");
                }

            } else if (userSelection == UserSelect.PUSH.getValue()) {
                System.out.println("Push할 숫자를 입력하세요:");
                int userPushNumber = sc.nextInt();

                try {
                    st.push(userPushNumber);
                }
                catch (NullPointerException e) {
                    System.out.println("Stack이 존재하지 않아서, Push할 수 없습니다, 스택을 만들어 주세요.");
                    continue;
                }
                st.showStack();

            } else if (userSelection == UserSelect.POP.getValue()) {

                try {
                    st.pop();
                } catch (NullPointerException e) {
                    System.out.println("Stack이 존재하지 않아서, Pop할 수 없습니다, 스택을 만들어 주세요.");
                    continue;
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Stack안에 비어서 Pop 할 수 없었습니다.");
                    continue;
                }
                st.showStack();

            } else if (userSelection == UserSelect.PEEK.getValue()) {

                try {
                    st.peek();
                } catch (NullPointerException e) {
                    System.out.println("Stack이 존재하지 않아서, Peek할 수 없습니다, 스택을 만들어 주세요.");
                    continue;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Stack안에 비어서 Peek 할 수 없었습니다.");
                    continue;
                }
                st.showStack();

            } else if (userSelection == UserSelect.DELETESTACK.getValue()) {
                st = null;
                System.out.println("Stack이 정상적으로 삭제 되었습니다.");

            } else if (userSelection == UserSelect.EXIT.getValue()){
                break;
            }
        }
    }
}