package readtextdatafromfile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ReadTextDataFromFile {
    public static void main(String[] args) {
        /*
        File file = new File("\\D:\\Java\\information file\\src\\Text");
        System.out.println(file.exists());
        try{
            BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true){
                line =br.readLine();
                if(line == null){
                    break;
                }else{
                    System.out.println(line);
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

         */
        File file = new File("\\D:\\Java\\information file\\src\\Text");
        System.out.println(file.exists());
        try{
            List<String> allText =Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
            for (String line:allText) {
                System.out.println(line);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
