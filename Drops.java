import java.awt.Rectangle;

public class Drops {

    Rectangle rect;
    int x;
    int y;
    int ySpeed;
    
    public Drops(int x, int y, int width, int height, int ySpeed)
    {
        rect = new Rectangle(width, height);
        
        this.x = x;
        this.y = y;
        this.ySpeed = ySpeed;
    }
    
    public void fall()
    {
        if (y >= 720)
        {
            y = -20;
        }
        
        y += ySpeed;
    }
    
    public void show()
    {
       
    }
}
