package module;

public class CircularQueue {
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

    public void add(int targetNumber){
        if (isfull() == true){
            System.out.println("Queue is full");
        }

        else{
            rear = (rear + 1) % queueLimit;
            newCircularQueue[rear] = targetNumber;
            System.out.printf("rear %d, front %d\n",rear, front);

        }
    }

    public int poll(){
        if (isempty() == true){
            System.out.println("Queue is empty!");
        }
        else{
            front = (front + 1) % queueLimit;
            int pollNumber = newCircularQueue[front];
            newCircularQueue[front] = 0;
            System.out.printf("rear %d, front %d\n",rear, front);
            return pollNumber;
        }
        return 0;
    }

    public void peek(){
        if (isempty() == true){
            System.out.println("Queue is empty!");
        }
        System.out.println(newCircularQueue[(front + 1) % queueLimit]);
    }

    public boolean isfull() {
        return ((rear + 1) % queueLimit  == front);}
    private boolean isempty(){return rear == front;}

    public void show(){
        String str = "";
        for (int i: newCircularQueue){
            str += i;
        }
        System.out.println(str);
    }


}
