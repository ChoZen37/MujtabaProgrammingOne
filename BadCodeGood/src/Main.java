/* Mujtaba Ghulam
2026/01/16
Fixing bad code
 */
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;

public class Main {
    private static String readFile(String fileName) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    void main(String[] args) {
        String output = readFile("src/yurr");
        System.out.println(output);
    }

}