import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
class task_3 {
    public static void main(String[] args){
        reader();
    }
    public static void reader(){
        try(BufferedReader read = new BufferedReader(new FileReader("task3.txt"))){
            String tmp1 = "";
            String tmp2 = "";
            int i = 0;
            String Line = read.readLine();
            Matcher matcher = Pattern.compile("(\\d+)").matcher(Line);
            while(matcher.find()){
                if(i == 0){
                    tmp1 = matcher.group();
                    i++;
                }
                tmp2 = matcher.group();
            }
            multiplys multiplication = new  multiplys();
            System.out.println(multiplication.multiply(Integer.parseInt(tmp1), Integer.parseInt(tmp2)));

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
class multiplys {
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
    public static int multiply(int a, int b)
    {
        int m = mul(a, Math.abs(b));
        return (b < 0) ? -m : m;
    }
} 
