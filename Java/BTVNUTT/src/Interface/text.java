package Interface;

public class text {
    public static void main(String[] args) {
        System.out.println("test cau a: ");
        MayTinhCasioFx500 mfx500 = new MayTinhCasioFx500();
        MayTinhVinaCal500 mv500 = new MayTinhVinaCal500();

        System.out.println("10 + 3 = "+mfx500.cong(10,3));
        System.out.println("10 * 3 = "+mv500.nhan(10,3));
        System.out.println("4 / 0 = "+mv500.chia(4,0));

        System.out.println("Text cau b: ");
        double[] arr = new double[]{5,1,3,4,5,8,0};
        double[] arr2 = new double[]{6,2,7,9,2,4,5};
        SapXepChen sxc = new SapXepChen();
        SapXepchon sxch = new SapXepchon();

        sxc.sapXepTang(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        sxch.sapXepTang(arr2);
        System.out.println();
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }

        System.out.println();
        System.out.println("Text cau c: ");
        PhanMenMayTinh pmmt = new PhanMenMayTinh();
        System.out.println(" 3 + 5 = "+pmmt.cong(3,5));
        double[] arr3 = new double[]{6,2,7,9,2,4,5};
        pmmt.sapXepTang(arr3);
        System.out.println();
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
    }
}
