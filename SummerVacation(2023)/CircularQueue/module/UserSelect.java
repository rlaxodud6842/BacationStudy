package module;
public enum UserSelect {
    QUEUECREATE(1),ADD(2),POLL(3),PEEK(4),DELETE(5),EXIT(6);
    private final int value;
    UserSelect(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}