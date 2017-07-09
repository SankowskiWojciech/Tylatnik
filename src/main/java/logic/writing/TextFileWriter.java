package logic.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter implements Writer {

    public boolean writeFile(File file, String data) {
        if(file == null)
            return false;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(data);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
