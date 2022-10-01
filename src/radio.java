import java.util.Arrays;
import java.util.Scanner;

public class radio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = scan.nextInt();
        String output = "";
        for (int i = 0; i < days; i++) {
            
            int length = scan.nextInt();
            int numOfWarp = scan.nextInt();
            int numOfTest = scan.nextInt();

            double[] radio = new double[length];
            for (int j = 0; j < length; j++) {
                radio[j]=scan.nextDouble();
            }

            double[] warps = new double[numOfWarp];
            for (int j = 0; j < numOfWarp; j++) {
                warps[j] = scan.nextDouble();
            }
            int[] warpIndexes = new int[numOfWarp];

            int[] indexes = findIndex(warps,radio);
            output+="Day #"+(i+1)+":\n";
            for (int j = 0; j < numOfTest; j++) {
                double start = scan.nextDouble();
                double end = scan.nextDouble();
                int[] startEnd = findIndex(new double[] {start, end},radio);
                int shortestDistance = length;
                for (int k = 0; k < indexes.length; k++) {
                    int testDistance = distance(indexes[k],startEnd[1],length);
                    if(testDistance<shortestDistance){
                        shortestDistance=testDistance;
                    }
                }
                int startToEndDistance = distance(startEnd[0],startEnd[1], length);
                if(shortestDistance<startToEndDistance){
                    output+=shortestDistance+"\n";
                }
                else{
                    output+=startToEndDistance+"\n";
                }
            }
            output+="\n";
            /*
            2
            2 1 1
            88.5 107.9
            88.5
            88.5 107.9
            11 3 3
            89.9 90.1 90.5 92.3 93.7 94.9 95.3 96.7 97.5 98.3 101.1
            92.3 94.9 97.5
            89.9 101.1
            101.1 92.3
            94.9 90.1
             */
        }
        System.out.println(output);
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
}
