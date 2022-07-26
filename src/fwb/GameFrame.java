package fwb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class GameFrame extends JPanel{
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 800;

    //定时器，定时重画界面
    private static Timer timer = new Timer();
    private static final Random rand = new Random();

    //表示游戏时钟
    private long time;

    Plank plank = new Plank(200, 300,100,10,this);
    public List<Snow> snows = new ArrayList<>();
    int score = 0;//得分

    public void launchFrame() {
        JFrame frame = new JFrame("接雪花");
        frame.setLocation(480, 60);
        frame.setSize(GAME_WIDTH, GAME_HEIGHT);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addMouseMotionListener(new MouseMonitor());	//设置鼠标监听器
        frame.setContentPane(this);
        frame.setResizable(false);
        frame.setVisible(true);
        timer.schedule(new PaintTask(), 0, 30);//延迟delay毫秒后，执行第一次task，然后每隔period毫秒执行一次task
    }

    private void createSnow() {	//产生新的雪花
        //当游戏时钟能除进10时，产生雪花
        if ((time + 1) % 10 == 0) {
            snows.add(new Snow(rand.nextInt(GAME_WIDTH - 32),-32,32,32,this));
        }

    }

    public void addMark(){
        score++;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Resourse.background, 0, 0,GAME_WIDTH,GAME_HEIGHT , null);

        for (int i = 0; i < snows.size(); i++) {
            Snow snow = snows.get(i);
            snow.draw(g);
        }

        plank.hitSnows(snows);
        plank.draw(g);

        Font font = new Font("微软雅黑", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("得分：" + score, 700, 50);
    }

    class MouseMonitor extends MouseAdapter {	//木板跟随鼠标移动
        @Override
        public void mouseMoved(MouseEvent e) {
            plank.move(e.getPoint());
        }
    }

    class PaintTask extends TimerTask {
        @Override
        public void run() {
            createSnow();
            repaint();
            time++;
        }
    }

    public static void main(String[] args){
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }
}
