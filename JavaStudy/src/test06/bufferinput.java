package test06;

import java.io.*;

public class bufferinput {
    public static void main(String[] args) throws IOException {

        InputStream in = new FileInputStream("dog.jpg");
        OutputStream out = new FileOutputStream("dog_copy.jpg");
//        1바이트씩넣기. 버퍼없이사용하면 속도가 엄청느리다.
//        FileReader와 RileWriter를 쓰면 2바이트씩 작동이라 쓸데없이 바이트가 늘어 파일이 깨질수가 있다.
//        파일리더는 텍스트를 다룰때 사용하고 Stream은 복사할때사용한다.
        byte[] buf = new byte[1024];

        while(true){
            int len = in.read(buf);
            if(len == -1) break;
            out.write(buf);

        }

        in.close();
        out.close();

//        파일리더
        Reader reader = new FileReader("byte-stream-data.txt");
        InputStream isr = new FileInputStream("byte-stream-data.txt");

//        보조스트림(내용을 읽을 때 인코딩 방식을 지정)
        InputStreamReader isr2 = new InputStreamReader(isr, "euc-kr");
        BufferedReader br = new BufferedReader(isr2);
        br.readLine(); // 마지막사용법이 살짝 변경됨


        int data = 0;
        while((data = reader.read()) != -1){
            System.out.print((char)data);
        }
    }
}
