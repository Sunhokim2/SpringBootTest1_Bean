package test02;

import java.util.Arrays;

public class 곱하기더하기 {
    public static void main(String[] args) {
        String a = "09876";
        String[] nums = a.split("");

//        이렇게 하면 주소값이 나옴
        System.out.println(nums);
//        이렇게 해야 내부값이 나옴
        System.out.println(Arrays.toString(nums));
    }
}
