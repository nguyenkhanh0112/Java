package btvn;

public class Bai2_1 {
    public static void main(String[] args) {
        int cnt=0;
        int i=0;
        int sum=0;
        while(true){
            i++;
            if(cnt==10)
                break;
            if(i%2==0){
                sum+=i;
                cnt++;
            }
        }
        System.out.println("Tong 10 so chan dau tien: "+sum);
    }
}
