package Interface;

public class PhanMenMayTinh implements MayTinhBoTuiInterface,SapXepInterface {
    @Override
    public double cong(double a,double b){
        return a+b;
    }
    @Override
    public double tru(double a,double b){
        return a-b;
    }
    @Override
    public double nhan(double a,double b){
        return a*b;
    }
    @Override
    public double chia(double a,double b){
        return a/b;
    }
    @Override
    public void sapXepTang(double[] arr){
        int max_indx;
        for(int i =0;i<arr.length-1;i++){
            max_indx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    max_indx=j;
                    double temp = arr[max_indx];
                    arr[max_indx]=arr[i];
                    arr[i]= temp;
                }
            }
        }
    }
    @Override
    public void sapXepGiam(double[] arr) {
        int min_indx;
        for (int i = 0; i < arr.length - 1; i++) {
            min_indx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    min_indx = j;
                    double temp = arr[min_indx];
                    arr[min_indx] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

}
