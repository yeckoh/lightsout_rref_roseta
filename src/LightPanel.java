import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LightPanel extends JPanel {
    private boolean on = true;
    public boolean selected = false;
    //int insideX = 0;
    //int insideY = 0;
    public LightPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
    
    
    public void toggle() {
        on = !on;
        //selected = false;
    }
    
    public void setOnOff(boolean status) {
        on = status;
    }

    public double getState() {
        if(on)
            return 1;
        return 0;
    }
    
    //public void setInsidePos(int x, int y) {
        
    //}
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        if(on)
            setBackground(Color.DARK_GRAY);
        else
            setBackground(MainFrame.dkgry);
        if(selected) {
            g2.setColor(Color.WHITE);
            g2.drawRect(getWidth()/2, getHeight()/2, 5, 5);
        }
        repaint();
        
        // Rectangle2D rct = new Rectangle2D.Float();
        // rct.setRect(0,0,25,25);

        // g2.draw(new Rectangle2D(this.getWidth()/componentXY,
        // this.getHeight()/componentXY));
        // g2.draw(rct);
    }

}
