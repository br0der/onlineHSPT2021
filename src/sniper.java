import java.util.Arrays;
import java.util.Scanner;

public class sniper {
    public static void main(String[] args) {
        String output = "";
        Scanner scan = new Scanner(System.in);
        int iterations = scan.nextInt();
        for (int i = 0; i < iterations; i++) {
            long numOfSoldiers = scan.nextInt();
            int numOfBullets = scan.nextInt();
            int[] soldiers = new int[(int)numOfSoldiers];
            int[] bullets = new int[numOfBullets];
            long totalHealth = 0;

            int[] effectiveness = new int[(int)numOfSoldiers];
            Arrays.fill(effectiveness, 0);
            for (int j = 0; j < numOfSoldiers; j++) {
                soldiers[j]=scan.nextInt();
            }
            for (int j = 0; j < numOfBullets; j++) {
                bullets[j]=scan.nextInt();
            }
            for (int j = 0; j < soldiers.length; j++) {
                totalHealth+=soldiers[j];
            }
            for (int j = 0; j < effectiveness.length; j++) {
                if(j!=0){
                    effectiveness[j]=effectiveness[j-1];
                }
                if(soldiers[j]>0){  //teammate
                    effectiveness[j]++;
                }
                else{
                    effectiveness[j]--;
                }
            }
/*
2
6 5
3 -2 -4 1 5 -1
3 5 4 1 3
1 2
-1
1 1

 */

            for (int j = 0; j < bullets.length; j++) {
                if(effectiveness[bullets[j]-1]>0){
                    totalHealth+=effectiveness[bullets[j]-1];
                }
            }
            output+=totalHealth+"\n";
        }
        scan.close();
        System.out.println(output);
    }
}
