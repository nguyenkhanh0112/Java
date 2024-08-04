package renameandmoveandcopyfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class RenameAndMoveAndCopyFile {

    public static void copyAll(File f1,File f2){
        try{
            Files.copy(f1.toPath(),f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(f1.isDirectory()){
            File[] arrary = f1.listFiles();
            for (File arr:arrary) {
                File file_new = new File(f2.getAbsoluteFile()+"\\"+arr.getName());
                copyAll(arr,file_new);
            }
        }
    }
    public static void removeFile(File file){
        if(file.isFile()){
            System.out.println("file remove ");
            file.delete();
        }else if(file.isDirectory()){
            File[] arrary = file.listFiles();
            for (File file1:arrary) {
                removeFile(file1);
            }
            System.out.println("remove Directory "+file.getAbsolutePath());
            file.delete();
        }
    }
    public static void main(String[] args) {
       /* File file11 = new File("\\D:\\Java\\information file\\clcc");
        File file22 = new File("\\D:\\Java\\information file\\file2");
        File file33 = new File("\\D:\\Java\\information file\\abcxyz11");

        */
        /*System.out.println(file11.exists());
        System.out.println(file22.exists());
        file11.renameTo(file22);

         */
        /*
        Path f1 = file22.toPath();
        Path f2 = file33.toPath();
        try{
            Files.move(f1,f2, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
         */
        /*Path f1 = file33.toPath();
        File f2 = new File("\\D:\\Java\\information file\\cc\\abcxyz11");
        try{
            Files.move(f1,f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            throw new RuntimeException(e);
       }
         */

        File f1 = new File("\\D:\\Java\\information file\\cc");
        File f2 = new File("\\D:\\Java\\information file\\cc_copy");
        /*try{
            Files.copy(f1.toPath(),f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        //copyAll(f1,f2);
        removeFile(f1);
        removeFile(f2);
    }
}
