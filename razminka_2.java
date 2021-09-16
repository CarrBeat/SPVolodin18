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
        while(matcher.find()){
            if(i == 0){
                str_a = matcher.group();
                i++;
            }
            str_b = matcher.group();
        }
        int a = Integer.parseInt(str_a);
        int b = Integer.parseInt(str_b);
        System.out.println(multiply(a, b));
    }
    public static int multiply(int a, int b)
    {
        int m = mul(a, Math.abs(b));
        return (b < 0) ? -m : m;
    }
    public static int mul(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return b;
        }
        return a + mul(a, b - 1);
    }
}

