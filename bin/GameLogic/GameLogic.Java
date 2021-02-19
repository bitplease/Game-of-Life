import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class GameOfLifeClass implements ActionListener{

	private JFrame frame;
	private int[][] cells=new int[116][78];
	private Thread gamePlay;
	private JButton startButton,stopButton,resetButton;
	private Board board;
	public static void main(String[] args) {
		
					GameOfLifeClass window = new GameOfLifeClass();
					window.frame.setVisible(true);

			}
		
	

	/**
	 * Create the application.
	 */
	public GameOfLifeClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//System.out.println(cells[50][50]);
		frame = new JFrame();
		frame.setTitle("Game Of Life");
		frame.setSize(1286,829);
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board=new Board();
		frame.setContentPane(board);
		//frame.getContentPane().setBackground(Color.gray);
		//Move move=new Move();
		//frame.addMouseMotionListener(this);
		//Click click=new Click();
		//frame.addMouseListener(this);
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		stopButton = new JButton("Stop");
		stopButton.addActionListener(this);
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		frame.add(startButton);
		frame.add(stopButton);
		frame.add(resetButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(resetButton)) {
			gameReset();
		}
		else if(e.getSource().equals(startButton))
		{
	   gamePlay=new Thread(board);
	   gamePlay.start();
	   
	    }
		else
		{
			gamePlay.interrupt();
		}
	}

	public int space=1;
	public int mx=-100;
	public int my=-100;
	public class Board extends JPanel implements MouseMotionListener,MouseListener,Runnable
	{

		public Board() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }
		
		public void paintComponent(Graphics g) {

			for(int i=5;i<=115;i++)
			{
				for(int j=5;j<=77;j++)
				{if(cells[i][j]==1)
					{g.setColor(Color.red);
                      g.fillRect((10*i+10),(10*j+10), 10, 10);
					}
				}
			}

            g.setColor(Color.BLACK);
            for (int i=5; i<=115; i++) {
                g.drawLine(((i*10)+10), 60, (i*10)+10, 10 + (10*75));
            }
            for (int i=5; i<=75; i++) {
                g.drawLine(60, ((i*10)+10), 10*(115+1), ((i*10)+10));
            }
            
        }
		public void run() {
			// TODO Auto-generated method stub
			 int count,x,y;
				 int [][]b=new int[116][78];
				 for( x=5; x<115 ; x++)
				  {
				   count =  0;
				   for( y=5; y<75 ; y++)
				   {
					
				    if(cells[x+1][y] == 1 && (x+1)<115) // next element in the row
				     count++;
				    if(cells[x-1][y] == 1 && (x-1)>5) // previous element in row
				     count++;
				    if(cells[x][y+1] == 1 && (y+1)<75) // element above it
				     count++;
				    if(cells[x][y-1] == 1 && (y-1)>5) // element below it
				     count++;
				    if(cells[x+1][y+1] == 1 && (x+1)<115 && (y+1)<75) // element to bottom right
				     count++;
				    if(cells[x+1][y-1] == 1 && (x+1)<115 && (y+1)>5) // element to bottom left
				     count++;
				    if(cells[x-1][y+1] == 1 && (x-1)>5 && (y+1)<115) // element top right 
				     count++;
				    if(cells[x-1][y-1] == 1 && (x-1)>5 && (y-1)>5) // element top left
				     count++; 
				    if(cells[x][y] == 1)
				     {
				    	if(count>=4) // over population death			
				    		b[x][y]=0;
				    	else if( count>=2) // remains alive
				    		b[x][y]=1;
				    	else // death due to solitude
				    		b[x][y]=0;
				     }
				    else if(cells[x][y]==0)
				    	if(count == 3) // population condition
				    		b[x][y]=1;
				    else
				     b[x][y]=0;
				    }
				   }
				 for( x=5; x<115 ; x++)
				  {
				   for( y=5; y<75 ; y++)
				   {
					   System.out.print(b[x][y]+" ");
				   }
				   System.out.println("");
				  }
				 gameReset();
			     cells=b;
				frame.repaint();
				 try {
		                Thread.sleep(1000);
		                run();
		            } catch (InterruptedException ex) {}
		}
		public void mouseClicked(MouseEvent e) {
	    	mx=e.getX()/10-1;
			my=e.getY()/10-1;
			System.out.println(mx+" "+my);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			mx=e.getX()/10-1;
			my=e.getY()/10-1;
			
			/*if(pointArr.contains(new Point(mx,my)))
				pointArr.remove(new Point(mx,my));
			else*/
			cells[mx][my]=1;
			frame.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			mx=e.getX()/10-1;
			my=e.getY()/10-1;
			//System.out.println(mx+" "+my);
			/*if(pointArr.contains(new Point(mx,my)))
				pointArr.remove(new Point(mx,my));
			else*/
			cells[mx][my]=1;
			frame.repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
		
	}
	public void gameReset()
	{
		cells=new int[116][78];
		frame.repaint();
	}

	
}

