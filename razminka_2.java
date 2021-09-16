import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class razminka_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример для вычисления: ");
        String Line = in.nextLine();
        String str_a = "";
        String str_b = "";
        int i = 0;
        Matcher matcher = Pattern.compile("(\\d+)").matcher(Line);
        while (matcher.find()) {
            if (i == 0) {
                str_a = matcher.group();
                i++;
            }
            str_b = matcher.group();
        }
        int a = Integer.parseInt(str_a);
        int b = Integer.parseInt(str_b);
        multiply(a, b);
    }

    public static void multiply(int a, int b) {
        int res = 0;
        if (a == 0 | b == 0) {
            System.out.println("На 0 умножать нельзя!");
        } else {
            while (true) {
                res += a;
                b -= 1;
                if (b == 0) {
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
