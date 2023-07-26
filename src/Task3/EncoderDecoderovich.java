package Task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncoderDecoderovich {

    public String EncodeFromFile(String path, char keyChar) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        do {
            try (FilterReaderEncode fr = new FilterReaderEncode(new FileReader(path))) {
                int i;
                while ((i = fr.read(keyChar)) != -1) {
                    sb.append((char) i);
                }
                flag = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Try another file. Enter path:");
                path = "D:/Мои документы/Java Labs (3 course)/Lab_5/decodedText.txt";
                flag = false;
            }
        } while (!flag);
        System.out.println("Закодовано текст з файлу");
        return sb.toString();
    }

    public void DecodeFromInput(String path, String str, char keyChar){
        try(FilterWriterDecode fw=new FilterWriterDecode(new FileWriter(path))){
            fw.write(str,keyChar);
        }catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Try another file.");
        }
        System.out.println("Декодовано у файл\n\n");
    }


}
