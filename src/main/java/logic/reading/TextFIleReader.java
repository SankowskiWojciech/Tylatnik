package logic.reading;

import java.io.*;

public class TextFIleReader implements Reader{

    @Override
    public String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuilder.toString();
    }
}
