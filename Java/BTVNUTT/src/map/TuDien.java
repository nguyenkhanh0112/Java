package map;

import java.util.*;

public class TuDien {
    private Map<String,String> data = new TreeMap<String,String>();
    public String moreWords(String key,String word){
       return this.data.put(key,word);
    }
    public String deleteWord(String key){
        return this.data.remove(key);
    }
    public String checkWord(String word){
        String ketQua = this.data.get(word);
        return ketQua;
    }
    public void exportKeyWord(){
        Set<String>tapHopKeyWord = this.data.keySet();
        System.out.println(Arrays.toString(tapHopKeyWord.toArray()));
    }
    public int zise(){
        return this.data.size();
    }
    public void clearAll(){
        this.data.clear();
    }

    public static void main(String[] args) {
        TuDien tuDien = new TuDien();
        Scanner sc = new Scanner(System.in);
        int luachon=0;
        while(true){
            System.out.println("---------MENU Tu Dien Anh-Viet -------");
            System.out.println("1. more Words ");
            System.out.println("2. delete Words");
            System.out.println("3. check Words(tim y nghia cua tu)");
            System.out.println("4. export key Words");
            System.out.println("5. export size words");
            System.out.println("6. delete all words");
            luachon = Integer.parseInt(sc.nextLine());
            if(luachon==1){
                System.out.println("improt key: ");
                String key = sc.nextLine();
                System.out.println("improt Words: ");
                String Words = sc.nextLine();
                tuDien.moreWords(key,Words);
            }else if(luachon == 2||luachon==3){
                System.out.println("import words: ");
                String key = sc.nextLine();
                if(luachon==2)
                    tuDien.deleteWord(key);
                else
                    System.out.println("Meaning Words : "+tuDien.checkWord(key));
            }else if(luachon==4){
                tuDien.exportKeyWord();
            }else if(luachon==5){
                System.out.println("Quantity Words: "+tuDien.zise());
            }else if(luachon==6){
                System.out.println("Data has been deleted");
                tuDien.clearAll();
            }else if(luachon==0){
                break;
            }
        }
    }
}
