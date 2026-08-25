import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long maxSoFar = Long.MIN_VALUE;
        long currentMax = 0;
        for (int i = 0; i < n; i++) {
            int profit = sc.nextInt();
            currentMax += profit;
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        System.out.println(maxSoFar);
        sc.close();
    }
}
