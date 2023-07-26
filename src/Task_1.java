import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task_1 {
    private String text = "";
    private String file_path;

    public Task_1(String file_path) {
        this.file_path = file_path;
    }

    public void readFromFile(){
        try(FileReader out = new FileReader(file_path))
        {
            int a = 0;
            while ((a=out.read())!=-1)
            {
                text += (char) a;
            }
        }
        catch(IOException ex) {System.out.println("Помилка!");}
        String [] strings = text.split("\n");
        System.out.println("\tУсі рядки:");
        for (String string : strings) {
            System.out.println(string);
        }
        Arrays.sort(strings, (a, b)->Integer.compare(b.length(), a.length()));
        System.out.println("\n\tНайдовший:\n" + strings[0] + '\n');
    }
}