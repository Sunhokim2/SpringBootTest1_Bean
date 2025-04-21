package test01;

public class Performance {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); //현재시각
//                                                밀리초 기준. 그래서 2000이면 2초
        long end = 0L;
//        String s : 2388

//        Thread에 안전하지 않습니다❗
//        StringBuilder s = new StringBuilder(); : 7

//        Thread에 안전한 처리가 됩니다.✨ 그래서 시간이 좀 더 걸립니다.
//        동기화 문제를 방지하나? 다른쓰레드에서 같은 거 접근할때 처리가 안되곤 하는 것들?
//        Synchornized 가 있다
        StringBuffer s = new StringBuffer(); // : 8

        for(int i = 0; i < 100000; i++) {
            s.append(i);
        }

        end = System.currentTimeMillis();
        System.out.println("String : "+ (end-start));
    }
}
