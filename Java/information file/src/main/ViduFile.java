package main;

import java.io.File;
import java.util.Scanner;
public class ViduFile {
    File file;

    public ViduFile(String tenFile) {
        this.file = new File(tenFile);
    }

    // kiem tra file co the thuc thi
    public boolean textExecutableFile(){
        return this.file.canExecute();
    }
    //kiem tra co the doc
    public  boolean checkReadableFile(){
        return this.file.canRead();
    }
    // kiem tra co the ghi
    public boolean testWriteableFile(){
        return this.file.canWrite();
    }
    // in duong dan
    public void printPath(){
        System.out.println(this.file.getAbsolutePath());
    }
    // in ten
    public void printFileName(){
        System.out.println(this.file.getName());
    }
    // kiem tra file la thu muc hay tap tin
    public void checkFileOfDricetoryOrFile(){
        if(this.file.isDirectory())
            System.out.println("This is the dricetory");
        else if(this.file.isFile())
            System.out.println("This is the file");
    }
    // in ra list cac file con
    public void printListOfSubfile(){
        if(this.file.isDirectory()){
            System.out.println("subfiles and subfoldes");
            File[] arrarys = this.file.listFiles();
            for (File file:arrarys) {
                System.out.println(file.getAbsolutePath());
            }

        }
        else if(this.file.isFile())
            System.out.println("this is the file, no data in side");
    }
    public void printTreeOfDirectory(){
        this.printTreeOfDirectory1(this.file,1);
    }
    public void printTreeOfDirectory1(File f,int levels){
        System.out.println("|");
        for(int i=0;i<levels;i++){
            System.out.print("\t");
        }
        System.out.println(f.getName());
        if(f.canRead()&&f.isDirectory()) {
            File[] arrarys = f.listFiles();
            for (File file : arrarys) {
                printTreeOfDirectory1(file, levels + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("import filename: ");
        String filename=sc.nextLine();
        ViduFile vdf = new ViduFile(filename);
        int luachon = 0;
        while(true){
            System.out.println("------------ MENU -------------");
            System.out.println("1. text executable file ");
            System.out.println("2. check readable file");
            System.out.println("3. test writable file");
            System.out.println("4. print path");
            System.out.println("5. print filename ");
            System.out.println("6. check file of driectory or file ");
            System.out.println("7. print list of subfile ");
            System.out.println("8. print tree of directory");
            System.out.println("0. exit program");
            luachon = Integer.parseInt(sc.nextLine());
            if(luachon==1||luachon==2||luachon==3){
                if(luachon==1)
                    System.out.println(vdf.textExecutableFile());
                else if(luachon==2)
                    System.out.println(vdf.checkReadableFile());
                else if(luachon==3)
                    System.out.println(vdf.testWriteableFile());
            }else if(luachon==4){
                    vdf.printPath();
            }else if(luachon==5){
                    vdf.printFileName();
            }else if(luachon==6){
                    vdf.checkFileOfDricetoryOrFile();
            }else if(luachon==7){
                    vdf.printListOfSubfile();
            }else if(luachon==8){
                    vdf.printTreeOfDirectory();
            }else if(luachon==0)
                break;
            sc.nextLine();
        }
    }
}