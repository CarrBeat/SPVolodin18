package obfuscator;
import java.io.*;
public class Main_Obfuscator {
    public static void main(String[] args) throws FileNotFoundException {
        String rstr;
        String temp;
        boolean check = false;
        int ind;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\input.txt"));
             FileWriter fw = new FileWriter("src\\output.java")) {
            while ((rstr = br.readLine()) != null) {
                System.out.println(rstr + "Вошло");
                if (rstr.contains(" ")) { // удаление пробелов в начале строки
                    rstr = rstr.trim();
                }
                if (rstr.chars().allMatch(Character::isWhitespace)){ // пропуск строк с пробелами
                    continue;
                }
                if (rstr.startsWith("/*")) { // начало  многострочного комментария с начала строки
                    check = true;
                    continue;
                }
                if (check & !rstr.contains("*/")) { // пропуск строки, если идет многострочный коммент
                    continue;
                }
                if (check & rstr.endsWith("*/")) { // конец многострочного коммента
                    check = false;
                    continue;
                }
                if (!rstr.contains("//") & !rstr.contains("*/") & !rstr.contains("*/")) { // не комментарии
                    rstr = rstr.trim();
                    fw.write(rstr + " ");
                } else {
                    ind = rstr.lastIndexOf("//"); // однострочные комментарии
                    if (ind == 0){
                        continue;
                    }
                    if (ind > 0 & ind + 3 != rstr.indexOf(")")) { // запись строки, которая была с комментарием
                        temp = rstr.substring(0, ind);
                        temp = temp.trim();
                        fw.write(temp + " ");
                    } else { // запись других строк
                        rstr = rstr.trim();
                        fw.write(rstr + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Преобразование выполнено!");
    }
}