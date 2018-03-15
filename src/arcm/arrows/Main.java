package arcm.arrows;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) {
            System.out.println(00);
            return;
        }
        reader.close();
        char[] chars = line.toCharArray();

        String str1 = ">>-->";
        String str2 = "<--<<";

        int result = 0;

        for (int i = 0; i < line.length() - 4; i++) {
            if (new String(chars, i, 5).equals(str1) || new String(chars, i, 5).equals(str2)) result += 1;
        }
        System.out.println(result);
    }
}