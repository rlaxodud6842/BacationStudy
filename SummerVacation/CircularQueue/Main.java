import module.CircularQueue;
import module.UserSelect;

import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `showStack whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue que = null;

        while (true) {
            System.out.println("\n1: QueueCreate\n2: Add \n3: Poll \n4: Peek \n5: Delete Queue \n6: Exit");
            int userSelection = sc.nextInt();

            //큐 생성 부분
            if (userSelection == UserSelect.QUEUECREATE.getValue()) {
                if (que == null){
                    System.out.println("선형큐의 Limit을 정해주세요:");
                    int QueueLimit = sc.nextInt();

                    que = new CircularQueue(QueueLimit);
                    que.show();

                }else{
                    System.out.println("이미 기존의 큐가 존재합니다.");
                }
            }

            //add 부분
            else if (userSelection == UserSelect.ADD.getValue()) {
                System.out.println("Add할 숫자를 입력하세요:");
                int enqueueNumber = sc.nextInt();

                que.add(enqueueNumber);
                que.show();
            }

            //poll 부분
            else if (userSelection == UserSelect.POLL.getValue()) {
                que.poll();
                que.show();
            }

            //peek 부분
            else if (userSelection == UserSelect.PEEK.getValue()) {
                que.peek();
                que.show();

            } else if (userSelection == UserSelect.DELETE.getValue()) {
                que = null;
                System.out.println("Queue가 정상적으로 삭제 되었습니다.");

            } else if (userSelection == UserSelect.EXIT.getValue()){
                break;
            }
        }
    }
}