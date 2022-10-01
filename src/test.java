import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println(distance(1, 2,6));
    }
    public static int[] findIndex(double[] arr, double[] radio){
        int[] indexes = new int[arr.length];
        int checkIndex = 0;
        for(int i = 0; i<radio.length; i++) {
            if (radio[i] == arr[checkIndex]) {
                indexes[checkIndex] = i;
                checkIndex++;
            }
            if (checkIndex == arr.length) {
                return indexes;
            }
        }
        return indexes;
    }
    public static int distance(int first, int second, int length){
        if(second<first){
            int temp = second;
            second = first;
            first = temp;
        }
        int direct = second-first;
        int indirect = first+(length-second);
        if(direct>indirect){
            return indirect;
        }
        else{
            return direct;
        }
    }
}
