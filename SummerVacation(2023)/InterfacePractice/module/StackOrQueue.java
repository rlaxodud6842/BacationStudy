package module;
public enum StackOrQueue {
    STACK(1),QUEUE(2);
    private final int value;
    StackOrQueue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}