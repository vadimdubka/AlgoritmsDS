package arcm.computerl_links57;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String result = "NO";

        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt(); // количество поросят
        int c = sr.nextInt(); // стоимость провода
        double p = sr.nextDouble(); // количество денег

        if (c == 0) {
            result = "YES";
            System.out.println(result);
            sr.close();
            return;
        }
//        if (p == 0) {
//            System.out.println("NO");
//            sr.close();
//            return;
//        }

        int[] osX = new int[n];
        int[] osY = new int[n];

        for (int i = 0; i < n; i++) {
            osX[i] = sr.nextInt();
            osY[i] = sr.nextInt();
        }

        int netX = sr.nextInt();
        int netY = sr.nextInt();

        sr.close();

        for (int i = 0; i < n; i++) {
            double totalLength = 0;

            double len0 = count(netX, netY, osX[i], osY[i]);
            totalLength += len0;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double len = count(osX[i], osY[i], osX[j], osY[j]);
                    totalLength += len;
                }
            }

            double totalCost = totalLength * c;
            if (totalCost <= p) {
                result = "YES";
                break;
            }
        }

        System.out.println(result);
    }

    static double count(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}