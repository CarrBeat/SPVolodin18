import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int first = in.nextInt();
        System.out.println("Введите второе число: ");
        int second = in.nextInt();
        System.out.print(multiply(first, second));
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
    public static int multiply(int a, int b)
    {
        int m = mul(a, Math.abs(b));
        return (b < 0) ? -m : m;
    }
}