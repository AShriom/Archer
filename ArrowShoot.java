/*
Author: Shriom Tiwari
GitHub: AShriom
Date:23/7/15
*/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ArrowShoot extends Thread
{
	
	Target obst;
	JLabel arrow;
	ImageIcon img;
	int xarrow,yarrow,fate=0;
	ArrowShoot(int y,Target obst)
	{
		this.obst=obst;
		xarrow=45;
		yarrow=y+40;
		img=new ImageIcon(this.getClass().getResource("afig.png"));
		arrow=new JLabel(img);
		arrow.setBounds(xarrow,yarrow,45,25);
		Archer.base.add(arrow);
	}
	public void run()
	{
		while(fate==0)
		{
			if(Archer.level==2)
			{
				if((xarrow+45)>=605 && xarrow<=635)
				{	
					for(int i=0;i<3;i++)
					{
					
						if((obst.obsttwo[i].getY()+100)>=yarrow && obst.obsttwo[i].getY()<=(yarrow+25))
						{
							fate=1;
							Archer.base.remove(arrow);
							Archer.base.revalidate();
							Archer.base.repaint();
							arrow=new JLabel();
						}
					
					}
				}	
			}
			else if(Archer.level==3)
			{
				if((xarrow+45)>=605 && xarrow<=635)
				{	
					for(int i=0;i<3;i++)
					{
					
						if((obst.obsttwo[i].getY()+100)>=yarrow && obst.obsttwo[i].getY()<=(yarrow+25))
						{
							fate=1;
							Archer.base.remove(arrow);
							Archer.base.revalidate();
							Archer.base.repaint();
							arrow=new JLabel();
						}
					}
				}
			}	
			
			if((xarrow+45)>=660 && xarrow<=675)
			{	
				for(int i=0;i<4;i++)
				{
				
					if((obst.obstone[i].getY()+80)>=yarrow && obst.obstone[i].getY()<=(yarrow+25))
					{
						fate=1;
						Archer.base.remove(arrow);
						Archer.base.revalidate();
						Archer.base.repaint();
						arrow=new JLabel();
					}
					
				}
			}
			if(xarrow<=700)
				{
					
					xarrow=xarrow+10;
					arrow.setBounds(xarrow,yarrow,45,25);
					if(xarrow>675)
					{	Archer.score=Archer.score+1;
						Archer.sc.setText("Score: "+Archer.score);
						if(Archer.score==30)
						{
							Archer.wnls.setText("YOU WIN!!!");
							Archer.base.removeAll();
						}
						Archer.base.remove(arrow);
						Archer.base.revalidate();
						Archer.base.repaint();
						arrow=new JLabel();
						fate=1;
					}	
				}
				else
				{
					fate=1;
					Archer.base.remove(arrow);
						Archer.base.revalidate();
						Archer.base.repaint();
						arrow=new JLabel();
				}
			try
			{
				sleep(15);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
