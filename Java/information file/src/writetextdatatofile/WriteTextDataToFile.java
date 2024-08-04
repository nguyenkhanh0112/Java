package writetextdatatofile;

import java.io.PrintWriter;

public class WriteTextDataToFile {
    public static void main(String[] args) {

        try{
            PrintWriter pw = new PrintWriter("\\D:\\Java\\information file\\Diary");
            pw.println("Hello everthing, my name is khanhsky 22222 ");
            pw.println("Diary");
            Student st = new Student("72DCHT20021","Nguyen Van Khanh 2003");
            pw.println(st);
            pw.flush();
            pw.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }


        /*
        File f1 = new File("\\D:\\Java\\information file\\Diary");
        File f2 = new File("\\D:\\Java\\information file\\11\\Diary");
        Path f11=f1.toPath();
        Path f22=f2.toPath();
        try {
            Files.move(f11,f22,StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

         */

    }
}
