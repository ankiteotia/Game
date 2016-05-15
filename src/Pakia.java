import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Vaio on 3/8/2016.
 */
public class Pakia {
    public static void pappu(){

        JFrame frame1 = new JFrame("Pappu Pakia");
        CodeKamp panel1 = new CodeKamp();

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setPreferredSize(new Dimension(990, 600));
        frame1.setContentPane(panel1);
        frame1.setFocusable(true);
        frame1.requestFocus();
        frame1.setResizable(false);
        frame1.addKeyListener(panel1);
        frame1.pack();
        frame1.setVisible(true);

        try {
            panel1.skyCloudsImage1 = ImageIO.read(Game.class.getResourceAsStream("/CL29.png"));
            panel1.skyCloudsImage2 = ImageIO.read(Game.class.getResourceAsStream("/cloud_PNG13.png"));
            panel1.cloudsImage = ImageIO.read(Game.class.getResourceAsStream("/clouds.png"));
            panel1.backTreeImage = ImageIO.read(Game.class.getResourceAsStream("/back_trees.png"));
            panel1.frontTreeImage = ImageIO.read(Game.class.getResourceAsStream("/front_trees.png"));
            panel1.logImage = ImageIO.read(Game.class.getResourceAsStream("/log.png"));
            panel1.groundImage = ImageIO.read(Game.class.getResourceAsStream("/ground.png"));
            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu1.png"));
            panel1.branchImage = ImageIO.read(Game.class.getResourceAsStream("/branch.png"));

            panel1.repaint();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Random random = new Random();
        Rectangle pappuRect;
        Rectangle branchRect;

        int count = 0;
        while (!panel1.gameOver) {
            if (panel1.gamePause) {
                count++;
                count = count % 8;
                try {
                    switch (count) {
                        case 0:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu1.png"));
                            break;
                        case 1:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu2.png"));
                            break;
                        case 2:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu3.png"));
                            break;
                        case 3:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu4.png"));
                            break;
                        case 4:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu5.png"));
                            break;
                        case 5:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu4.png"));
                            break;
                        case 6:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu3.png"));
                            break;
                        case 7:
                            panel1.happyPakiaImage = ImageIO.read(Game.class.getResourceAsStream("/pappu2.png"));
                            break;
                    }

                    panel1.pappuYchord += panel1.pappuYvel;
                    panel1.pappuYvel += panel1.pappuYAcc;

                    panel1.branchXcord -= 6;
                    panel1.branch1Xcord -= 6;
                    panel1.backTreeXcord -= 1;
                    panel1.frontTreeXcord -= 4;
                    panel1.skyClouds1Xcord -= 3;
                    panel1.skyClouds2Xcord -= 3;

                    if(panel1.backTreeXcord < -1000){
                        panel1.backTreeXcord = 990;
                        panel1.repaint();
                    }

                    if(panel1.frontTreeXcord < -1000){
                        panel1.frontTreeXcord = 990;
                        panel1.repaint();
                    }

                    if(panel1.skyClouds1Xcord < -160){
                        panel1.skyClouds1Xcord = 1000;
                        panel1.repaint();
                    }

                    if(panel1.skyClouds2Xcord < -280){
                        panel1.skyClouds2Xcord = 1000;
                        panel1.repaint();
                    }

                    if (panel1.branchXcord <= -10) {
                        panel1.branchXcord = 1000;
                        if (random.nextInt(0) == 0) {
                            panel1.branchYcord = 300;
                        } else {
                            panel1.branchYcord = 0;
                        }
                    }
                    if (panel1.branch1Xcord <= -10) {
                        panel1.branch1Xcord = 1000;
                        if (random.nextInt(2) == 0) {
                            panel1.branch1Ycord = 300;
                        } else {
                            panel1.branch1Ycord = 0;
                        }
                    }

                    pappuRect = new Rectangle(panel1.pappuXchord, panel1.pappuYchord, 60, 60);
                    branchRect = new Rectangle(panel1.branchXcord, panel1.branchYcord, 30, 300);

                    if (pappuRect.intersects(branchRect)) {

                        panel1.pappuYvel = -2;
                        panel1.pappuYAcc = -2;
                    }

                    if(panel1.pappuYchord < -20 || panel1.pappuYchord > 620){
                        panel1.gameOver = true;
                    }

                    panel1.repaint();

                } catch (Exception e) {

                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
