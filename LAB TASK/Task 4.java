import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DNAPatternSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String T = reader.readLine();
        String P = reader.readLine();
        
        if (T == null || P == null) return;
        
        int[] lps = computeLPSArray(P);
        int i = 0; // index for T
        int j = 0; // index for P
        
        StringBuilder sb = new StringBuilder();
        while (i < T.length()) {
            if (P.charAt(j) == T.charAt(i)) {
                i++;
                j++;
            }
            if (j == P.length()) {
                sb.append((i - j)).append("\n");
                j = lps[j - 1];
            } else if (i < T.length() && P.charAt(j) != T.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        System.out.print(sb.toString());
    }
    
    private static int[] computeLPSArray(String pat) {
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length()];
        lps[0] = 0;
        
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
