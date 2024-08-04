package JavaSwing.BTVN;

public class test {
    public static void main(String[] args) {
        double d;
        for(int i=0;i<=100;i++){
                d =(1.0*((1260*i)+1))/19;
            if(d%1==0){
                System.out.println(i);
                System.out.println(d);
                break;
            }
        }


    }
}
