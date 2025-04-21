package test02;

public class MethodExam1 {
    /** static은 메소드영역에 저장
     * new는 힙영역
     * 그냥 만들어지는 건 JVM Stack 영역에 저장  
     */

//    상수
    final int a = 15;

    static int score = 1; // Class, Static 변수
    int age = 10; // Member (전역변수)
    public static void main(String[] args) {
        int age = 0; //지역변수
    }

    void method1(){} //Member
}
