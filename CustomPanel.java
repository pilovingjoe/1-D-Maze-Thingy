import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class CustomPanel extends JPanel implements ActionListener
{
	//Make class wide variables
    TextField text = new TextField(50);
    JButton leftBut = new JButton("Left");
    JButton rightBut = new JButton("Right");

    private static BufferedImage background;
    private static BufferedImage win;

    static 
    {
    	try 
        {
			background = ImageIO.read(new File ("background.jpg"));
            win = ImageIO.read(new File ("win.jpg"));
		}
        catch (IOException e) 
        {
			System.out.println("Error loading images");
        }
    }
    
    public void buttonSetUp()
    {
        
    leftBut.setVerticalTextPosition(AbstractButton.BOTTOM);
    leftBut.setHorizontalTextPosition(AbstractButton.CENTER);
    leftBut.setMnemonic(KeyEvent.VK_D);
    leftBut.addActionListener(this);
    rightBut.setVerticalTextPosition(AbstractButton.BOTTOM);
    rightBut.setHorizontalTextPosition(AbstractButton.CENTER);
    rightBut.setMnemonic(KeyEvent.VK_M);
    rightBut.addActionListener(this);
    add(leftBut);
    add(rightBut);
    add(text);
    }
    //Applies all visuals to the GUI
    public void paint(Graphics g)
    {
    	Graphics2D g2=(Graphics2D)g;
        text.setText("Cell " + OneDMaze.current.cell);   
        //Draws the images and applies transformations
        g2.drawImage(background, 0,0,getWidth(),getHeight(), null);
        //super.paint(g);
        if(OneDMaze.isFinished)
        {
           remove(leftBut);
           remove(rightBut);
           remove(text);
           g2.drawImage(win, 0,0,getWidth(),getHeight(), null);
        }
        
    }

    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==leftBut)
        {
            OneDMaze.Left();
        }
        if(e.getSource()==rightBut)
        {
            OneDMaze.Right();
        }
        repaint();
    }
   
    
}