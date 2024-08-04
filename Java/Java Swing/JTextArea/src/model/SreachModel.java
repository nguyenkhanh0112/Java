package model;

public class SreachModel {
    private String text;
    private String wordsKey;
    private String result;
    public SreachModel(){
        this.result="";
        this.text="";
        this.wordsKey="";
    }

    public String getWordsKey() {
        return wordsKey;
    }

    public void setWordsKey(String wordsKey) {
        this.wordsKey = wordsKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void sreach(){
        int count=0;
        int index=0;
        while(true){
            int i = this.text.indexOf(this.wordsKey,index);
            if(i == -1){
                // tinh huong ko tim thay
                break;
            }else{
                count++;
                index=i+1;
            }
        }
        this.result=" Result: co "+ count +" "+ this.wordsKey;
        System.out.println(result);
    }
}
