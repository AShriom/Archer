/*
Author:Shriom Tiwari
GitHub:AShriom
Date:23/7/15
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Archer implements MouseListener, MouseMotionListener,ActionListener
{
	JFrame f;
	static JPanel base;
	JLabel man,banner;
	static JLabel sc,lv,wnls;
	JButton newgm,quit;
	Target obst;
	ImageIcon img;
	int yman,state=0;
	static int score=0;
	static int level=1;
	static int levelchange=0;
	Archer()
	{
		
		
		f=new JFrame("Archer");
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(715,740);
		//f.setResizable(false);
		f.setVisible(true);
		
		base=new JPanel();
		base.setLayout(null);
		base.setBounds(0,66,700,600);
		base.setBackground(Color.orange);
		
		base.addMouseListener(this);
		base.addMouseMotionListener(this);
		obst=new Target();
		img=new ImageIcon(this.getClass().getResource("mfig.png"));
		man=new JLabel(img);
		man.setBounds(15,450,60,100);
		img=new ImageIcon(this.getClass().getResource("banner.png"));
		banner=new JLabel(img);	
		banner.setBounds(0,0,500,66);
		
		newgm=new JButton("New Game");
		quit=new JButton("Quit");
		newgm.addActionListener(this);
		quit.addActionListener(this);
		newgm.setBounds(500,0,100,33);
		quit.setBounds(500,33,100,33);
		sc=new JLabel("Score: "+score);
		sc.setBorder(BorderFactory.createLineBorder(Color.black));
		lv=new JLabel("Level: "+level);
		lv.setBorder(BorderFactory.createLineBorder(Color.black));
		wnls=new JLabel("Good Luck!!!");
		wnls.setBorder(BorderFactory.createLineBorder(Color.black));
		sc.setBounds(100,666,100,30);
		wnls.setBounds(300,666,100,30);
		lv.setBounds(500,666,100,30);	
		base.add(man);
		
		f.add(base);
		f.add(banner);
		f.add(newgm);
		f.add(quit);
		f.add(sc);
		f.add(lv);
		f.add(wnls);
		f.repaint();
	}
	
	public static void main(String ar[])
	{
		Archer play=new Archer();
		
		play.obst.start();
	}
	

		
	public void mouseClicked(MouseEvent e)
	{
		if(state==0)
		{
			state=1;
			new ArrowShoot(man.getY(),obst).start();
			state=0;
		}	
	}
	
	public void mouseMoved(MouseEvent e)
	{
		if(state==0)
		{
			yman=e.getY();
			
			if(yman>=20&&yman<=450)
			{
				man.setBounds(15,yman,60,100);
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((JButton)e.getSource()==newgm)
		{
			levelchange=1;
			score=0;
			sc.setText("Score: "+score);
			level=1;
			lv.setText("Level: "+level);
			wnls.setText("Good Luck!!");
		}
		if((JButton)e.getSource()==quit)
		{
			System.exit(0);
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{}
	public void mouseEntered(MouseEvent e)
	{}
	public void mousePressed(MouseEvent e)
	{}
	public void mouseReleased(MouseEvent e)
	{}
	public void mouseExited(MouseEvent e)
	{}

	
	
}
