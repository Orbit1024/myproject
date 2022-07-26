package fwb;

import java.awt.*;

public class Snow {
    protected int x,y;           //雪花的位置
    protected int width,height;  //雪花的宽和高
    private int speed;           //定义雪花的速度
    private Image image;
    private boolean live = true;

    GameFrame game;

    public Snow(int x, int y,int w,int h,GameFrame game) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.game = game;
        this.image = Resourse.snow;
        speed = 25 + (int)(Math.random()*2);//雪花飞行速度设置随机值
    }

    public void draw(Graphics g){ //在界面中添加新的雪花
        if(!live) {
            game.snows.remove(this);
            return;
        }
        g.drawImage(image, x, y,width,height, null);
        move();
    }

    public void move(){ //雪花超过游戏界面时live设定为false
        y += speed;
        if(x < 0 || x > GameFrame.GAME_WIDTH || y > GameFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public void hit(){
        setLive(false);
    }

    public Rectangle getRect() {	//判断木板和雪花是否发生碰撞
        return new Rectangle(x,y,width,height);
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
    public boolean isLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}

