package module;
public enum UserSelect {
    ROLL(1),SHOWDATA(2),EXIT(3);
    private final int value;
    UserSelect(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
