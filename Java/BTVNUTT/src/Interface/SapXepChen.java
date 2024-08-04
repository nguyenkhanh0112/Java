package Interface;

public class SapXepChen implements SapXepInterface{
    public void sapXepTang(double[] arr){
        int j;
        double key;
        for (int i = 1; i < arr.length; i++) {
            key=arr[i];
            j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public void sapXepGiam(double[] arr){
        int j;
        double key;
        for (int i = 1; i < arr.length; i++) {
            key=arr[i];
            j=i-1;
            while(j>=0&&arr[j]<key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
