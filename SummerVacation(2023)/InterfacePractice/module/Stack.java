package module;

public class Stack implements iStorage{
    private int[] newStack;
    private int stackLimit;
    private int stackIndex = 0;

    public Stack(int userStackLimit){
        this.stackLimit =  userStackLimit;
        newStack = new int[userStackLimit];
    }

    
    public void push(int targetNumber)throws Exception{
        if(isFull())
            throw new Exception("Stack is full");

        newStack[stackIndex++] = targetNumber;
    }

    public int pop() throws Exception{
        if(isEmpty())
            throw new ArrayIndexOutOfBoundsException();
            
        int popedNumber = newStack[stackIndex-1];
        newStack[stackIndex-1] = 0;
        stackIndex -= 1;

        return popedNumber;
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }

        int peekededNumber = newStack[stackIndex-1];
        return peekededNumber;
    }

    public void show(){
        String str = "";
        for (int i: newStack){
            str += i;
        }
        System.out.println(str);
    }

    private boolean isEmpty(){return stackIndex == 0;}
    private boolean isFull(){return stackIndex == stackLimit;}
}