package fwb;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageUtil {//读取Images中的图片
    public static Image read(String path){
        return Toolkit.getDefaultToolkit().getImage(ImageUtil.class.getClassLoader()
                .getResource(path));
    }
}
