import java.io.File;
import java.io.IOException;

public class SaveFile {
    public String pathToDirectory = "D:/Мои документы/Java Labs (3 course)/Lab_5/";

    public String fileChoose(String filename) throws IOException {
        String path = pathToDirectory + filename;
        File f = new File(path);
        if(!f.exists()){
            f.createNewFile();
        }
        return path;
    }
}
