package test03;

import javax.swing.*;
import java.awt.*;

public class 메모리영역 {
    static final String name = "0001";
    float bottom;
    float height;


    public static void main(String[] args) {
//        method1();
        JFrame frame = new JFrame("윈도우");

        JButton button = new JButton("대명갓");
        button.setBackground(Color.yellow);

        frame.add(button);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
