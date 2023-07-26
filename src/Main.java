import Task3.EncoderDecoderovich;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String choice = "";
        do{
            System.out.println("Оберіть завдання:\n 1) Отримати рядок з максимальною кількістю слів із заданого" +
                    " файлу\n 2) Зашифрувати вхідний символьний потік за наступним алгоритмом: замінити кожний " +
                    "символ на такий, код якого більший на значення коду ключового символу\n 3) Підрахувати частоту, " +
                    "з якою зустрічаються теги на сторінці по URL");
            choice = in.nextLine();
            switch (choice) {
                case "1" -> {
                    Task_1 task1 = new Task_1("D:/Мои документы/Java Labs (3 course)/Lab_5/random_text.txt");
                    task1.readFromFile();
                }
                case "2" -> {
                    EncoderDecoderovich ed = new EncoderDecoderovich();
                    System.out.println("Введіть ключовий символ кодування");
                    String keySymbol = in.nextLine();
                    String text = ed.EncodeFromFile("D:/Мои документы/Java Labs (3 course)/Lab_5/encodeSource.txt",keySymbol.charAt(0));
                    System.out.println(text);
                    SaveFile savior = new SaveFile();
                    System.out.println("Введіть назву файл для збереження");
                    String fileName = in.nextLine();
                    ed.DecodeFromInput(savior.fileChoose(fileName) ,text, keySymbol.charAt(0));
                }
                case "3" -> {
                    Task_4 task4 = new Task_4();
                    String tags = task4.URLreader();
                    SaveFile savior = new SaveFile();
                    System.out.println("Введіть назву файл для збереження");
                    String fileName = in.nextLine();
                    try(FileOutputStream t4 = new FileOutputStream(savior.fileChoose(fileName)))
                    {
                        t4.write(tags.getBytes());
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                        System.out.println("Error writing. Try another file.");
                    }
                }
                default -> {
                }
            }

        }while (!choice.isEmpty());
    }

}

