package module;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class newRotto {
    private int won = -5000;
    private HashSet<Integer> winNumber;
    private int winBonusNumber;
    private HashSet<Integer> buyNumber;
    private int buyBonusNumber;

    public void setWinNumber() {
        winNumber = new HashSet<>();
        winBonusNumber = getRandomNumber();
        addNumber(winNumber);
        removeFirstPair(winNumber, winBonusNumber);
    }// 1등 번호 저장하는 Set 구성

    public void buyRotto() {
        buyNumber = new HashSet<Integer>();
        buyBonusNumber = getRandomNumber();
        addNumber(buyNumber);
        removeBuyPair(buyNumber, buyBonusNumber);
    }//새로운 로또 배열 설정

    public void removeFirstPair(HashSet addedset, int bonusNumber) {
        if (addedset.contains(bonusNumber) || addedset.size() != 6) {
            setWinNumber();
        }
    }//1등 중복검사

    public void removeBuyPair(HashSet addedset, int bonusNumber) {
        if (addedset.contains(bonusNumber) || addedset.size() != 6) {
            buyRotto();
        }
    }//새로운 로또 중복검사 -> 이게 두개나 필요한가?

    public void addNumber(HashSet set) {
        for (int i = 0; i < 6; i++) {
            set.add(getRandomNumber());
        }
    }//6번 반복 삽입

    public int getRandomNumber() {
        Random random = new Random();
        int RandomNumber = random.nextInt(45) + 1;
        return RandomNumber;
    }// 랜덤 번호 추첨

    public HashMap<String, Integer> setGrade(){
        HashMap<String,Integer> grade = new HashMap<>();
        for (int i = 1; i<6;i++){
            grade.put(i+"등",0);
        }
        return grade;
    }// 초기 등수 설정

    public void compareRotto(int repeat,HashMap<String,Integer>grade){

        for (int i = 1; i < repeat+1; i++) {
            buyRotto(); //로또 구입.
            HashSet<Integer> compareSet = new HashSet<>(winNumber);
            compareSet.retainAll(buyNumber); // 비교하기위한 HashSet 설정.


            if (compareSet.size() == 6) {
                grade.put(1+"등",grade.get(1+"등")+1);
                won += 570901018;
            } else if (compareSet.size() == 5 && winBonusNumber == buyBonusNumber) {
                grade.put(2+"등",grade.get(2+"등")+1);
                won += 42510727;
            } else if (compareSet.size() == 5) {
                grade.put(3+"등",grade.get(3+"등")+1);
                won += 1287806;
            } else if (compareSet.size() == 4) {
                grade.put(4+"등",grade.get(4+"등")+1);
                won += 50000;
            } else if (compareSet.size() == 3) {
                grade.put(5+"등",grade.get(5+"등")+1);
                won += 5000;
            }
            if (i % 10 == 0 && i !=0){
                nowShow(i,grade);
            }
        }//새로 산 로또랑 1등이랑 비교
    }
//    public void showResult(){
//        System.out.printf("시도횟수 : %d, 사용 금액 : %d원\n 1등:%d(%d)\n 2등:%d(%d)\n 3등:%d(%d)\n 4등:%d(%d)\n 5등:%d(%d)\n",count,won*count,first,first/count,second,second/count,third,third/count,fourth,fourth/count,fifth,fifth/count);
//    }// 결과 출력
    public void nowShow(int repeat, HashMap<String,Integer> nowGrade){
        System.out.printf("시도횟수:%d",repeat);
        String result = "[";
        for (int i = 1; i<6;i++){
            result += nowGrade.get(i+"등");
            if (i < 5){
            result += ",";}
        }
        result += "]";
        System.out.print(result+"\n");
    }
}

//돈 이득 손해 구현, 코드 간결화 , 출력 UI 구현, 확률 모르겠음. 질문해야함, 순위 누적이 안됨.