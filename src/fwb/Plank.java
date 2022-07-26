package fwb;

import java.awt.*;
import java.util.List;

public class Plank {
    protected int x,y;          //木板的位置
    protected int width,height; //木板的宽和高
    protected Image image;

    GameFrame game;

    public Plank(int x,int y,int w,int h,GameFrame game) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.game = game;
        this.image = Resourse.plank;//设定图片
    }

    public void draw(Graphics g){
        g.drawImage(image, x, y,width,height, null);//在（x,y）处显示图像image,不设置观察器
    }

    public void move(Point p){		//木板的移动
        this.x = p.x - this.width/2;
        this.y = p.y - this.height/2;
    }

    public Rectangle getRect() {	//判断木板和雪花是否发生碰撞
        return new Rectangle(x,y,width,height);
    }

    public boolean hitSnow(Snow snow) {	//判断是否与雪花发生碰撞
        if(this.getRect().intersects(snow.getRect())) {
            game.addMark();
            snow.hit();
            return true;
        }
        return false;
    }

    public boolean hitSnows(List<Snow> snows) {		//判断是否与雪花发生碰撞
        for (int i = 0; i < snows.size(); i++) {
            if(hitSnow(snows.get(i))) {
                return true;
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
