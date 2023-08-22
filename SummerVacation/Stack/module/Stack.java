package module;

public class Stack {
    boolean isStackCreated;
    private int[] newStack;
    private int stackLimit;
    private int userStackLimit;


    public Stack(int userStackLimit){
        this.userStackLimit = userStackLimit;
        this.isStackCreated =true;

    }

    public void createStack(){
        newStack = new int[userStackLimit];
        this.stackLimit =  userStackLimit;

        System.out.println("스택이 정상적으로 만들어졌습니다.");
    }

    private int stackIndex = 0;
    public void push(int targetNumber){
        newStack[stackIndex] = targetNumber;
        stackIndex += 1;
        System.out.println(targetNumber+"(이)가 Push되었습니다.");
    }

    public void pop(){
        int popedNumber = newStack[stackIndex-1];
        newStack[stackIndex-1] = 0;
        stackIndex -= 1;

        System.out.println(popedNumber+"(이)가 Pop되었습니다.");
    }

    public int peek(){
        int peekededNumber = newStack[stackIndex-1];
        newStack[stackIndex-1] = 0;
        stackIndex -= 1;

        System.out.println(peekededNumber+"(이)가 Peek되었습니다.");

        return peekededNumber;
    }

    public void showStack(){
        String currentStack ="";
        for (int i = 0; i < stackLimit; i++) {
            currentStack += newStack[i] + ",";
        }

        System.out.println(currentStack);
    }

    private boolean isEmpty(){
        int emptyCounter = 0;
        for (int i = 0; i <stackLimit;i++){
            if (newStack[i] ==  0){
                emptyCounter += 1;
            }
        }
        if (emptyCounter == stackLimit){
         return true;
        }
        else{
            return false;
        }
    }
    private boolean isFull(){
        int FullCounter = 0;
        for (int i = 0; i <stackLimit;i++){
            if (newStack[i] !=  0){
                FullCounter += 1;
            }
        }
        if (FullCounter == stackLimit){
            return true;
        }
        else{
            return false;
        }
    }




}