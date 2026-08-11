import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // Create the LPS (Longest Prefix Suffix) array
    static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    // KMP search
    static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        StringBuilder answer = new StringBuilder();

        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                int index = i - j;

                if (answer.length() > 0) {
                    answer.append(" ");
                }

                answer.append(index);

                // Allows overlapping matches
                j = lps[j - 1];

            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String pattern = br.readLine();

        if (text == null || pattern == null) {
            return;
        }

        text = text.trim();
        pattern = pattern.trim();

        kmpSearch(text, pattern);
    }
}