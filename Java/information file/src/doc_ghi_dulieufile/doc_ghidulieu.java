package doc_ghi_dulieufile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class doc_ghidulieu {
    public void writeToFile(ArrayList<studen> arrayList){

        try{
            FileWriter fw = new FileWriter("Data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (studen o:arrayList) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fw.close();
        }catch (Exception e){

        }
    }
    public ArrayList<studen> readerToFile(){
        ArrayList<studen> arrayList = new ArrayList<>();
        try{
            FileReader fr = new FileReader("Data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while((line = br.readLine())!=null){
                String[] txt = line.split(";");
                String name = txt[0];
                int old =Integer.parseInt(txt[1]);
                double marks  = Double.parseDouble(txt[2]);
                arrayList.add(new studen(name,old,marks));
            }
        }catch (Exception e){

        }
        return arrayList;
    }
    public static void main(String[] args) {
        doc_ghidulieu a = new doc_ghidulieu();
        ArrayList<studen> arrayList = a.readerToFile();
        for (studen o :arrayList) {
            System.out.println(o);
        }


    }
}
