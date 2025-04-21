package demo.demo;


import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;




@Component
public class ImageUtil {

    public void downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);

        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String fileExt = imageUrl.substring(imageUrl.lastIndexOf(".") + 1);


        BufferedImage image = ImageIO.read(url);
        
        ImageIO.write(image, fileExt, new File(fileName));
    }
}