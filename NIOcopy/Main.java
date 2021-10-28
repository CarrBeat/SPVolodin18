// код взят у Соусова Ильи
package NIOcopy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// импорт библиотек
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        long startTime =  System.currentTimeMillis(); /* задание переменной и присваивание
        ей текущего значения миллисекунд компьютера */
        Path file1 = Paths.get("file1.txt"); // инициализация файла 1 (указание пути)
        Path file2 = Paths.get("file2.txt"); // инициализация файла 2 (указание пути)
        Files.copy(file1, Paths.get("consistent1.txt"), StandardCopyOption.REPLACE_EXISTING); /* метод, который
        копирует файл. Аргументы: (файл 1, путь к получаемому файлу, опция для замены существующего файла */
        Files.copy(file2, Paths.get("consistent2.txt"), StandardCopyOption.REPLACE_EXISTING);
        // также как с предыдущим
        long endTime = System.currentTimeMillis(); /* задание переменной окончания копирования со значением текущего
        времени системы (компьютера) */
        long constTime = endTime - startTime; /* задание переменной со временем выполнения копирования и ее вычисление
        путем вычитания из времени окончания копирования время начала копирования */
        System.out.println(constTime + " мс при последовательном считывании"); /* вывод сообщения с количеством
        миллисекунд, которое было затрачено для копирования файла последовательным считыванием */
        FileThread fwriter1 = new FileThread("parallel1.txt", file1); // открытие потока fwriter1
        FileThread fwriter2 = new FileThread("parallel2.txt", file2); // открытие потока fwriter2
        fwriter1.join(); /* метод, который заставляет вызвавший поток ожидать завершения вызываемого потока
        для которого применяется метод */
        fwriter2.join();
    }
}