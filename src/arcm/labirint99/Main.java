package arcm.labirint99;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    static char[][][] arr;
    static int[][]    queue;
    static int        queueAdd;
    static int        stepCount;
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int r = scanner.nextInt();
        int s = scanner.nextInt();
        
        scanner.nextLine();
        
        arr = new char[h][r][s];
        
        boolean startPositionIsFound = false;
        int[] startPos = {0, 0, 0};
        
        String line;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                line = scanner.nextLine();
                for (int k = 0; k < s; k++) {
                    arr[i][j][k] = line.charAt(k);
                    if (!startPositionIsFound && i == 0) {
                        if (line.charAt(k) == '1') {
                            startPos[1] = j;
                            startPos[2] = k;
                            startPositionIsFound = true;
                        }
                    }
                }
            }
            if (i != h - 1) {
                scanner.nextLine();
            }
        }
        
        scanner.close();
        
        int noteNumber = h * r * s;
        queue = new int[noteNumber + 2][];
        queueAdd = 0;
        int queueGet = 0;
        
        queue[queueAdd++] = startPos;
        
        for (stepCount = 0; stepCount <= noteNumber; stepCount++) {
            int iterationInStep = queueAdd - queueGet;
            for (int i = 0; i < iterationInStep; i++) {
                int[] point = queue[queueGet++];
                
                int hPos = point[0];
                int rPos = point[1];
                int sPos = point[2];
                
                int hh;
                int rr;
                int ss;
                
                char var;
                
                //смотрим вправо
                hh = hPos;
                rr = rPos;
                ss = sPos + 1;
                if (ss < s) {
                    if (analyze(hh, rr, ss)) {
                        return;
                    }
                }
                
                
                //смотрим влево
                hh = hPos;
                rr = rPos;
                ss = sPos - 1;
                if (ss >= 0) {
                    if (analyze(hh, rr, ss)) {
                        return;
                    }
                }
                
                //смотрим вверх
                hh = hPos;
                rr = rPos - 1;
                ss = sPos;
                if (rr >= 0) {
                    if (analyze(hh, rr, ss)) {
                        return;
                    }
                }
                
                // смотрим вниз
                hh = hPos;
                rr = rPos + 1;
                ss = sPos;
                if (rr < r) {
                    if (analyze(hh, rr, ss)) {
                        return;
                    }
                }
                
                // смотрим уровень вниз
                hh = hPos + 1;
                rr = rPos;
                ss = sPos;
                if (hh < h) {
                    if (analyze(hh, rr, ss)) {
                        return;
                    }
                }
            }
        }
    }
    
    private static boolean analyze(int hh, int rr, int ss) {
        char var = arr[hh][rr][ss];
        if (var == '.') {
            queue[queueAdd++] = new int[]{hh, rr, ss};
            arr[hh][rr][ss] = 'o';
        } else if (var == '2') {
            System.out.println((stepCount + 1) * 5);
            return true;
        }
        return false;
    }
}