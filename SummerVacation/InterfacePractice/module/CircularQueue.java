package module;

public class CircularQueue implements iStorage {
    private int[] newCircularQueue;
    private int queueLimit;
    private int rear;
    private int front;

    public CircularQueue(int limit){
        this.queueLimit = limit;
        this.newCircularQueue = new int[limit];
        this.rear = 0;
        this.front = 0;
    }

    public void push(int targetNumber) throws Exception{
        if (isfull()){
            throw new Exception("Queue is full");
        }

        else{
            rear = (rear + 1) % queueLimit;
            newCircularQueue[rear] = targetNumber;
        }
    }

    public int pop() throws Exception{
        if (isempty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            front = (front + 1) % queueLimit;
            int popedNumber = newCircularQueue[front];
            newCircularQueue[front] = 0;
            return popedNumber;
        }
    }
    public int peek()throws Exception{
        if (isempty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return newCircularQueue[(front + 1) % queueLimit];
    }
    public boolean isfull() {
        return ((rear + 1) % queueLimit  == front);}
    private boolean isempty(){return rear == front;}
}
