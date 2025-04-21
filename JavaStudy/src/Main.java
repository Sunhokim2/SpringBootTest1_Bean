import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int age = 0;
//        ✨이건 시간복잡도와 공간복잡도가 문제가 될 수 있다.

//        int t = 3;
//
//        for(int i = 0; i < t; ++i){
//            for(int j = 0; j < t-i; ++j){
//                System.out.print(" ");
//            }
//            for(int k = 0; k < 2*i +1; ++k){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        for(int i = t; i >= 0; --i){
//            for(int j = 0; j < t-i; ++j){
//                System.out.print(" ");
//            }
//            for(int k = 0; k < 2*i+1; ++k){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        ❗이거는 좀더 괜찮다. for문이 이중으로 1번만사용되었다.
        int t = 3;
        int width = 2 * t + 1;
        int rows = 2 * t + 1;

        for (int i = 0; i < rows; ++i) {
            int left = 0;
            int right = -1;

            if (i <= t) {
                left = t - i;
                right = t + i;
            } else {
                int j = i - t;
                left = j;
                right = width - 1 - j;
            }

            for (int k = 0; k < width; ++k) {
                if (k >= left && k <= right) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getComponent();
        String name = button.getText();
        String link = "https://www.google.com/";

        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}