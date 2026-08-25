import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        if (line1 == null) return;
        String line2 = br.readLine();
        if (line2 == null) return;
        String result = Arrays.stream(line2.trim().split("\\s+"))
                             .mapToInt(Integer::parseInt)
                             .map(salary -> (int)(salary * 1.1))
                             .mapToObj(String::valueOf)
                             .collect(Collectors.joining(" "));
                             
        System.out.println(result);
    }
}
