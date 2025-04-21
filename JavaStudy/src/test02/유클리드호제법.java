package test02;

public class 유클리드호제법 {
    /** B에는 나머지 값이 계속 들어간다.a **/
    static int 최대공약수(int A, int B) {
        System.out.println("A : " + A + ", B : " + B);
        if(B==0) return A;
        return 최대공약수(B, A%B);
    }



    public static void main(String[] args) {
        int a=14, b=7;
        System.out.println(최대공약수(a,b));
    }
}
