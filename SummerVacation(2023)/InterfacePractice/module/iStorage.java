package module;

public interface iStorage{
    public void push(int targetNumber) throws Exception;
    public int pop() throws Exception;
    public int peek() throws Exception;
}
