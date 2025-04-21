package test06;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Balloon1 {
    public static void makeBalloon(JPanel panel, int x, final int y) { /* 이미지 생성 */
        new Thread(() -> {
            int y2 = y;

            ImageIcon icon = new ImageIcon("images/balloon.png"); /* 이미지를 보여주기 위해서 JLabel 사용 */
            JLabel label = new JLabel(icon); /* 이미지 크기와 같게 JLabel 크기 지정 */
            label.setSize(icon.getIconWidth(), icon.getIconHeight()); /* 이미지를 가지고 있는 JLabel을 JPanel로 추가 */
            panel.add(label);
            for (int i = 0; i < 10; i++) { /* 이미지가 보여질 위치 지정 */
                label.setLocation(x, y2);
                /* 그래픽 표현 상태 변경 후 새로 고침을 해야 화면에 반영 */
                panel.repaint();
                try{
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                y2 -= 25;
            }
        }).start();
    }

    public static void main(String[] args) {
        JFrame j = new JFrame();
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Balloon1.makeBalloon(panel, e.getX(), e.getY());
            }
        });
        j.add(panel);
        j.setSize(700, 500);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }

}
