package fwb;

import java.awt.Image;

public class Resourse {//调用ImageUtil方法导入图片
    public static Image background;
    public static Image plank;
    public static Image snow;
    static {
        background = ImageUtil.read("imgs/Background.jpg");
        plank = ImageUtil.read("imgs/plank.png");
        snow = ImageUtil.read("imgs/snow.png");
    }
}
