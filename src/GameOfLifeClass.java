import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class GameOfLifeClass implements ActionListener,Runnable{

	private JFrame frame;
	private ArrayList<Point> pointArr;
	private Thread gamePlay;
	private JButton startButton,stopButton,resetButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOfLifeClass window = new GameOfLifeClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		pointArr=new ArrayList<>();
		frame = new JFrame();
		frame.setTitle("Game Of Life");
		frame.setSize(1286,829);
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Board board=new Board();
		frame.setContentPane(board);
		Move move=new Move();
		frame.addMouseMotionListener(move);
		Click click=new Click();
		frame.addMouseListener(click);
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
	public int space=1;
	public int mx=-100;
	public int my=-100;
	public class Board extends JPanel{
		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0,1280,800);
			g.setColor(Color.gray);
			for(int i=0;i<128;i++)
			{
				for(int j=0;j<80;j++)
				{
					
					for(Point p:pointArr)
						
					{ 
						if(p==null)
						continue;
						mx=p.x;
					  my=p.y;
						if(mx >= space+i*10 && mx < space+i*10+10-1*space && my >= space+j*10+40 && my < space+j*10+40+10-1*space )
						{
							System.out.println(mx+" "+my);
						g.setColor(Color.red);
						System.out.println("hello");
						}
					}
					g.fillRect(space+i*10, 2*space+j*10+40, 10-1*space, 10-1*space);
					g.setColor(Color.gray);
				}
			}
		}
		
		
		
	}
	public void gameReset()
	{
		pointArr.clear();
	}
	public class Move implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
//			mx=e.getX();
//			my=e.getY();
//			/*if(pointArr.contains(new Point(mx,my)))
//				pointArr.remove(new Point(mx,my));
//			else*/
//			pointArr.add(new Point(mx,my));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		
		}
	}
	public class Click implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			mx=e.getX();
			my=e.getY();
			/*if(pointArr.contains(new Point(mx,my)))
				pointArr.remove(new Point(mx,my));
			else*/
			pointArr.add(new Point(mx,my));
			//System.out.println("hi");
			//System.out.println(mx+" "+my);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
//			mx=e.getX();
//			my=e.getY();
//			/*if(pointArr.contains(new Point(mx,my)))
//				pointArr.remove(new Point(mx,my));
//			else*/
//			pointArr.add(new Point(mx,my));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(resetButton)) {
			gameReset();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
