import java.util.Scanner;

public class miracle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = scan.nextInt();
        for (int i = 0; i < iterations; i++) {
            int length = scan.nextInt();
            double total = 100;
            for (int j = 0; j < length; j++) {
                double percent = scan.nextDouble()/100;
                total+=total*percent;
            }
            System.out.println(total-100);
        }
    }
}
