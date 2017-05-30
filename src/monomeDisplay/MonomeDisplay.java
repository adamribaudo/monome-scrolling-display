package monomeDisplay;

import oscP5.*;
import processing.core.*;
import org.monome.*;
import netP5.*;
import oscP5.*;


public class MonomeDisplay extends PApplet {
	
	Monome m;
	int model[][];
	int rows=8,cols=16;
	OscP5 abletonOSC;
	int[] frame;
	NetAddress localhost;
	boolean invert = false;

	public static void main(String[] args) {
		PApplet.main("monomeDisplay.MonomeDisplay");
	}
	
	public void settings() {
		  size(160, 80); //Displays the monome's output on the screen
	}
	
	public void setup()
	{
		m = new Monome(this);
		stroke(255);
		fill(255);
			  
		  size(160,80);
		  abletonOSC = new OscP5(this,7777);
		  //monomeOSC = new OscP5(this,7778);
		  
		  localhost = new NetAddress("127.0.0.1",12002);
		  
		  frame = new int[rows];
		  model = new int[rows][cols];		  
	}
	
	public void draw() {
		background(0);
		  for(int x=0;x<rows;x++)
		  {
		    for(int y=0;y<cols;y++)
		    {
		      if(getModel()[x][y] == 1)rect(y*10, x*10, 10, 10);
		    }
		  }
		}

public void addFrameToModel(int[] frame)
{
  for(int x=0;x<rows;x++)
  {
    model[x][cols-1] = frame[x];
  }
}

public void addNoteToFrame(int note, int index)
{
  frame[index] = note;
}

public int[][] getModel()
{
	
	int[][] tempModel = new int[rows][cols];
	
	
	for(int x=0;x<rows;x++)
		for(int y=0;y<cols;y++)
		{
			if(invert)
			{
			if(model[x][y] == 1)tempModel[x][y] = 0;
			if(model[x][y] == 0)tempModel[x][y] = 1;
			}else
				tempModel[x][y] = model[x][y];
		}
	
	return tempModel;
}


public void shiftModel()
{
  
  for(int x=0;x<rows;x++)
  {
    for(int y=0;y<cols-1;y++)
    {
      model[x][y] = model[x][y+1];
    }
  }
}

public void keyPressed()
{
	/*if(this.key == 'd')
	{
		//destroy
		System.out.println("destroy");
		m = null;
	}
	
	if(this.key == 'c')
	{
		System.out.println("create");
		m = new Monome(this);
	}*/
}

public void restartMonome()
{
	m = new Monome(this);
}

public void clearModel()
{
	frame = new int[rows];
	model = new int[rows][cols];
}



public void oscEvent(OscMessage msg) {
  int note;
  if(msg.checkAddrPattern("/mtn/note") && msg.get(1).intValue() > 0)
    {
      note = msg.get(0).intValue();
     if(note == 8)
      {
    	  shiftModel();
    	  addFrameToModel(frame);
        
    	if(m != null)
    		m.refresh(getModel());
        frame = new int[8];
      }
      else if(note == 9)
      {
    	  clearModel();
      }
      else if(note == 10)
    	  invert = true;
      else if(note == 11)
    	  invert = false;
      else if(note < 8)
      {
        addNoteToFrame(1, 7-note);
      }
      
  }
}
}
