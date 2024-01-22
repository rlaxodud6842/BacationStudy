import module.*;

import java.util.InputMismatchException;
import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `showStack whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        iStorage something = null;
            while (true) {
                try {
                System.out.println("\n1: 저장소 생성\n2: Push \n3: Pop \n4: Peek \n5: 저장소 삭제 \n6: Exit");
                int userSelection = sc.nextInt();

                //저장소 생성 시
                if (userSelection == UserSelect.CREATESOMTHING.getValue()) {

                    if (something == null) {
                        System.out.println("어떤 저장소를 사용하시겠습니까?\n 1.Stack 2.Queue");
                        int stackOrQueue = sc.nextInt();
                        //스택을 골랐을 경우
                        if (stackOrQueue == StackOrQueue.STACK.getValue()) {
                            System.out.println("Stack을 선택하셨습니다, 크기는 몇으로 하시겠습니까?");
                            int selectStack = sc.nextInt();
                            something = new Stack(selectStack);
                        }
                        // 큐를 골랐을 경우
                        else if ((stackOrQueue == StackOrQueue.QUEUE.getValue())) {
                            System.out.println("Queue 을 선택하셨습니다, 크기는 몇으로 하시겠습니까?");
                            int selectQueue = sc.nextInt();
                            something = new CircularQueue(selectQueue);
                        }
                        //나머지 숫자를 골랐을 경우
                        else {
                            System.out.println("올바른 숫자를 입력해주세요.");
                        }
                        //기존 저장소 존재할 경우
                    } else {
                        System.out.println("이미 기존의 저장소가 존재합니다.");
                    }

                    //Push
                } else if (userSelection == UserSelect.PUSH.getValue()) {

                    System.out.println("Push할 숫자를 입력하세요:");
                    int userPushNumber = sc.nextInt();

                    try {
                        something.push(userPushNumber);

                    } catch (NullPointerException e) {
                        System.out.println("저장소가 존재하지 않아서, Push할 수 없습니다, 저장소을 만들어 주세요.");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    //POP
                } else if (userSelection == UserSelect.POP.getValue()) {
                    try {
                        System.out.println(something.pop());
                    } catch (NullPointerException e) {
                        System.out.println("저장소가 존재하지 않아서, Pop할 수 없습니다,저장소를 만들어 주세요.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("저장소가 비어있어서, Pop을 할 수 없었습니다. 저장소를 채워주세요.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    //peek
                } else if (userSelection == UserSelect.PEEK.getValue()) {
                    try {
                        System.out.println(something.peek());
                    } catch (NullPointerException e) {
                        System.out.println("저장소가 존재하지 않아서, Peek할 수 없습니다, 저장소을 만들어 주세요.");

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("저장소가 비어있어서, Peek을 할 수 없었습니다. 저장소를 채워주세요.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else if (userSelection == UserSelect.DELETESTACK.getValue()) {
                    if (something == null) {
                        System.out.println("존재하는 저장소가 없습니다, 저장소를 생성해 주세요.");
                    } else {
                        something = null;
                        System.out.println("저장소가 정상적으로 삭제 되었습니다.");
                    }

                } else if (userSelection == UserSelect.EXIT.getValue()) {
                    break;
                }else{
                System.out.println("올바른 숫자를 입력해주세요.");
                }
            }catch (InputMismatchException e){
                System.out.println("올바른 입력을 해주세요");}
                sc = new Scanner(System.in);
        }
    }
}
