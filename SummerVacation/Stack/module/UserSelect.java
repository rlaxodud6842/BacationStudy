package module;
public enum UserSelect {
    STACKCREATE(1),PUSH(2),POP(3),PEEK(4),DELETESTACK(5),EXIT(6);
    private final int value;
    UserSelect(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}