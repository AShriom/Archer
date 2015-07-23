/*
Author: Shriom Tiwari
GitHub: AShriom
Date: 23/7/15
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Target extends Thread
{
	
	JButton obstone[]=new JButton[4],obsttwo[]=new JButton[3];
	int speed=45,score=0,flag=0;
	
	Target()
	{
		
		
		for(int i=0;i<4;i++)
		{
			obstone[i]=new JButton();
			
		}
		obstone[0].setBounds(660,35,25,80);
		obstone[1].setBounds(660,185,25,80);
		obstone[2].setBounds(660,335,25,80);
		obstone[3].setBounds(660,485,25,80);
		
		for(int i=0;i<3;i++)
		{
			obsttwo[i]=new JButton();
			
		}
		Archer.base.add(obstone[0]);
		Archer.base.add(obstone[1]);
		Archer.base.add(obstone[2]);
		Archer.base.add(obstone[3]);
		
	}
	
	public void run()
	{
		while(true)
		{
		if(score<Archer.score)
		{
			speed-=2;
			score=Archer.score;
			if(score==10&&flag==0)
			{
				Archer.levelchange=2;
				Archer.level=2;
				Archer.lv.setText("Level: "+Archer.level);
				speed=45;
				flag=1;
			}
			else if(score==20&&flag==1)
			{
				
				Archer.level=3;
				Archer.lv.setText("Level: "+Archer.level);
				speed=45;
				flag=0;
			}
		}
		if(Archer.levelchange==1)
		{
			obstone[0].setBounds(660,35,25,80);
			obstone[1].setBounds(660,185,25,80);
			obstone[2].setBounds(660,335,25,80);
			obstone[3].setBounds(660,485,25,80);
			Archer.levelchange=0;
			Archer.base.remove(obsttwo[0]);
			Archer.base.remove(obsttwo[1]);
			Archer.base.remove(obsttwo[2]);
			Archer.base.revalidate();
			Archer.base.repaint();
			score=0;
			speed=45;
		}
		if(Archer.levelchange==2)
		{
			Archer.base.add(obsttwo[0]);
			Archer.base.add(obsttwo[1]);
			Archer.base.add(obsttwo[2]);
			
			obstone[0].setBounds(660,35,25,80);
			obstone[1].setBounds(660,185,25,80);
			obstone[2].setBounds(660,335,25,80);
			obstone[3].setBounds(660,485,25,80);
			obsttwo[0].setBounds(605,50,30,100);
			obsttwo[1].setBounds(605,250,30,100);
			obsttwo[2].setBounds(605,450,30,100);
			Archer.levelchange=0;
		}
		
		if(Archer.level==3)
		{
			for(int i=0;i<3;i++)
			{
				int y=obsttwo[i].getY();
				if(y>=600)
				{
					obsttwo[i].setBounds(605,0,30,100);
				}
				else
				{
					obsttwo[i].setBounds(605,y+10,30,100);
				}
			}
		}
		for(int i=0;i<4;i++)
		{
			int y=obstone[i].getY();
			if(y>=600)
			{
				obstone[i].setBounds(660,0,25,80);
			}
			else
			{
				obstone[i].setBounds(660,y+10,25,80);
			}
		}
		
		try
		{
			sleep(speed);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
	}
}
