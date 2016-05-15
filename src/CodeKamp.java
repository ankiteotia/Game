import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Vaio on 2/19/2016.
 */
public class CodeKamp extends JPanel implements KeyListener {

    protected int pappuXchord = 45;
    protected int pappuYchord = 400;
    protected int pappuYvel = 0;
    protected int pappuYAcc = 0;
    protected int logXcord = 50;
    protected int branchXcord = 500;
    protected int branch1Xcord = 950;
    protected int branchYcord = 300;
    protected int branch1Ycord = 300;
    protected int frontTreeXcord = 0;
    protected int backTreeXcord = 0;
    protected int skyClouds1Xcord = 70;
    protected int skyClouds2Xcord = 550;

    protected BufferedImage groundImage = null;
    protected BufferedImage logImage = null;
    protected BufferedImage backTreeImage = null;
    protected BufferedImage frontTreeImage = null;
    protected BufferedImage cloudsImage = null;
    protected BufferedImage skyCloudsImage1 = null;
    protected BufferedImage skyCloudsImage2 = null;
    protected BufferedImage happyPakiaImage = null;
    protected BufferedImage branchImage = null;

    protected boolean gameOver = false;
    protected boolean gamePause = true;
    private int i = 1;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (this.gameOver) {
            g.setColor(Color.BLUE);
            g.drawString("Game Over", 445, 300);
        } else {

            g.setColor(Color.blue);
            g.fillRect(0, 0, 1000, 600);

            if (skyCloudsImage1 != null) {
                g.drawImage(skyCloudsImage1, skyClouds1Xcord, 20, null);
            }

            if (skyCloudsImage2 != null) {
                g.drawImage(skyCloudsImage2, skyClouds2Xcord, 60, null);
            }

            if (cloudsImage != null) {
                g.drawImage(cloudsImage, 0, 53, null);
            }

            if (backTreeImage != null) {
                g.drawImage(backTreeImage, backTreeXcord, 60, null);
            }

            if (frontTreeImage != null) {
                g.drawImage(frontTreeImage, frontTreeXcord, 100, null);
            }

            if (logImage != null) {
                g.drawImage(logImage, logXcord, 443, null);
            }

            if (groundImage != null) {
                g.drawImage(groundImage, 0, 110, null);
            }

            if (happyPakiaImage != null) {
                g.drawImage(happyPakiaImage, pappuXchord, pappuYchord, null);
            }

            if (branchImage != null) {
                g.drawImage(branchImage, branchXcord, branchYcord, null);
            }

            if (branchImage != null) {
                g.drawImage(branchImage, branch1Xcord, branch1Ycord, null);
            }
        }

        if(this.gameOver == false) {
            g.setColor(Color.red);
            g.drawString(String.valueOf(i++), 10, 20);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        } else {
            g.setColor(Color.BLUE);
            g.drawString(String.valueOf("Score  = " + i), 440, 330);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP || this.pappuYchord == 400) {

            this.logXcord -= 50;
            this.pappuYvel = -15;
            this.pappuYAcc = 1;
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
