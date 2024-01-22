import java.util.Scanner;
import module.UserSelect;
import module.newRotto;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        newRotto rotto = new newRotto();
        while (true) {
            System.out.println("\n1: 추첨 돌리기\n2: 기록 보기\n3: 종료");
            int userSelection = sc.nextInt();
            if (userSelection == UserSelect.ROLL.getValue()) {
                System.out.println("몇 회 반복하시겠습니까?:");
                int userRpeat = sc.nextInt();
                rotto.setWinNumber();
                rotto.compareRotto(userRpeat,rotto.setGrade());
                rotto.buyRotto();
            } else if (userSelection == UserSelect.SHOWDATA.getValue()) {
            } else if (userSelection == UserSelect.EXIT.getValue()) {
                break;
            } else{
                System.out.println("올바르지 않은 번호를 입력하셨습니다. 다시입력해주세요");
            }
        }
    }
}