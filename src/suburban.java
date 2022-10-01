import java.util.Scanner;

public class suburban {
    public static int testCase(int manhattan){
        if(Math.sqrt(manhattan)%1==0){
            return (int) Math.sqrt(manhattan);
        }
        for (double i = Math.sqrt(manhattan)-Math.sqrt(manhattan)%1; i >= (Math.sqrt(manhattan)%1)/2; i-=1) {
            double test = Math.sqrt(manhattan-Math.pow(i,2));
            if(test%1==0){
                return (int) (test+i);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = scan.nextInt();
        for (int i = 0; i < iterations; i++) {
            int manhattan = scan.nextInt();
            System.out.println(testCase(manhattan));
        }
    }
}
