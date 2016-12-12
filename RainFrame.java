import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RainFrame extends JFrame {
    JFrame frame;
    Drops drop;
    
    public class RainPanel extends JPanel implements ActionListener
    {
        JPanel panel;
        Drops[] drop;
        Timer timer; 
        
        public RainPanel()
        {
            timer = new Timer(5, this);
            panel = new JPanel();
            panel.setBackground(Color.BLACK);
            
            drop = new Drops[300];
            
            for (int i = 0; i < 300; i++)
            {
                Random ran = new Random();
                if (i % 3 == 0)
                {
                    drop[i]= new Drops(ran.nextInt(800), ran.nextInt(600),1, 10, 3);
                }
                else if (i % 2 == 0)
                {
                    drop[i]= new Drops(ran.nextInt(800), ran.nextInt(600),3, 15, 2);
                }
                else
                {
                    drop[i]= new Drops(ran.nextInt(800), ran.nextInt(600), 5, 20, 3);
                }
            } 
            
            setBackground(Color.BLACK);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            timer.start();
            for (int i = 0; i < drop.length; i++)
            {
                g.setColor(Color.cyan);
                g.fillRect(drop[i].x, drop[i].y, drop[i].rect.width, drop[i].rect.height);
            }
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 300; i++)
            {
                drop[i].fall();
            }
            repaint();
        }

    }
    
    
    ///////////////////
    /*
     * -Rain Drops-
     * Main Frame for rain drops
     */
    public RainFrame()
    {
        frame = new JFrame("Rain Drops");
        frame.setLayout(new BorderLayout());
        frame.add(new RainPanel(), BorderLayout.CENTER);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        RainFrame rainFrame = new RainFrame();
        
    }
}
