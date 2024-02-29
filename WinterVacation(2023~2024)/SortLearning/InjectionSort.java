import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        int[] arr = {5,4,6,8,2};
        int length = arr.length;
        for (int i = 1; i < length; i++){
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > target){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }
    }
}