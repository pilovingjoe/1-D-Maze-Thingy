import java.awt.Dimension;
import javax.swing.JFrame;
import java.util.*;
public class OneDMaze
{
	static Node begin = new Node(0);
	static Node current = begin;
	static int size = 5;
	static boolean isFinished;
	public static void main(String[] args)
	{

		JFrame frame=new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    CustomPanel panel=new CustomPanel();
	    frame.setContentPane(panel);
	    panel.setPreferredSize( new Dimension( 960, 540 ) );
	    frame.pack();
		panel.buttonSetUp();
	    frame.setVisible(true);
		
		makeMaze(size);
		current=begin;
	
	}
	
	static void Left()
	{
		current=current.left;
		if(current.cell == size-1)
		{
			isFinished=true;
		}
		

	}
	static void Right()
	{
		current=current.right;
		if(current.cell == size-1)
		{
			isFinished=true;
		}
	}
	static void makeMaze(int size)
	{
		Random rand =  new Random(420);
		current.left=current;
		current.previous=current;
		Node previous = current;

		for(int i=1; i<size; i++)
		{
			current = new Node(i);
			previous.right=current;
			previous.next = current;
			current.previous=previous;
			current.left=previous;
			previous=current;
			if(i==size-1)
			{
				current.right=current;
				current.next = current;
			}
		}
		
		//Make the Shuffler here
		current = begin;
		Node next = current;

		for(int i=1; i<size; i++)
		{
			int rnum = rand.nextInt(size*2)+1;
			for(int j = 0; j<rnum; j++)
			{
				int rnum1 =rand.nextInt(2);
				if(rnum1%2==0)
				next = next.previous;
				else
				next = next.next;
			}
			current.left = next;
			current = current.next;
			next = current;
		}
		current = begin;
		next = current;
		for(int i=1; i<size; i++)
		{
			int rnum = rand.nextInt(size*2)+1;
			for(int j = 0; j<rnum; j++)
			{
				int rnum1 =rand.nextInt(2);
				if(rnum1%2==0)
				{
					next = next.previous;
				}
				else
				{
					next = next.next;
				}
			}
			current.right = next;
			current = current.next;
			next = current;
		}
		

	}
}