package bankAccount;
import java.util.Scanner;
public class Account extends Thread {
    int balance;
    public Account(int balance) {
        this.balance = balance;
    }
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        int money;
        hello();
        while (true) {
            String request = in.nextLine();
            if (request.equals("+")) {
                System.out.println("Введите сумму для пополнения: ");
                money = in.nextInt();
                if (money % 10 > 0){
                    System.out.println("Сумма пополнения должна быть круглой (с 0 на конце)! ");
                    hello();
                    continue;
                }
                if (money < 0 | money == 0){
                    System.out.println("Неверная сумма!");
                    hello();
                    continue;
                }
                addMoney(money);
            }
            if (request.equals("-")) {
                System.out.println("Введите сумму для снятия");
                money = in.nextInt();
                if (money > balance) {
                    System.out.println("У Вас недостаточно средств");
                    hello();
                    continue;
                }
                if (money < 50 | (money % 10 > 0) | money == 0) {
                    System.out.println("Вы снимаете менее 50 рублей, либо некруглое число (оканчивается не 0)! ");
                    hello();
                    continue;
                }
                takeMoney(money);
            }
            if (request.equals(" ")) {
                System.out.println("Спасибо, что пользуетесь нашими услугами! ");
                break;
            }
        }
    }
    public void hello(){
        System.out.println("Чтобы пополнить счет введите +, чтобы снять со счета введите -, выйти - пробел");
    }
    public void takeMoney(int money){
        balance -= money;
        System.out.println("Со счета снято " + money + " рублей" + "\nВаш баланс: " + balance + " рублей");
        hello();
    }
    public void addMoney(int money){
        balance += money;
        System.out.println("На счет зачислено " + money + " рублей" + "\nВаш баланс: " + balance + " рублей");
        hello();
    }
}
