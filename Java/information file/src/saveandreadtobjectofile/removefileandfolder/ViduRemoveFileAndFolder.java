package saveandreadtobjectofile.removefileandfolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ViduRemoveFileAndFolder {

    public static void removeFile(File fx){
        if(fx.isFile()){
            System.out.print("file remove: "+fx.getName());
            System.out.println("print path remove: "+fx.getAbsolutePath());
            fx.delete();
        }
        else if(fx.isDirectory()){
            File[] arrary =  fx.listFiles();
            for (File arr:arrary) {
                removeFile(arr);
            }
            System.out.print("remove directory "+fx.getAbsolutePath());
            fx.delete();
        }
    }
    public static void main(String[] args) {
        File f0 = new File("\\D:\\Java\\information file\\f0");
        File f0_1 = new File(("\\D:\\Java\\information file\\f0_1"));
        File f_Vidu= new File("\\D:\\Java\\information file\\Vidu");

        /*System.out.println("file co ton tai hay ko "+f0_1.exists());
        // f0.deleteOnExit();
        f0_1.deleteOnExit();//xoa duoc vi la thu muc rong
        f_Vidu.deleteOnExit();//xoa duoc vi la tap tin
        removeFile(f0);
         */

            //use file class to delete files and folders
        Path p = f0.toPath();
        Path p0_1 = f0_1.toPath();
        Path p_vidu = f_Vidu.toPath();

        try {
          //  Files.deleteIfExists(p);
            Files.deleteIfExists(p0_1);
            Files.deleteIfExists(p_vidu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
