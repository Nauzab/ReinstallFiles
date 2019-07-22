/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

/**
 *
 * @author nz
 */
public class Game extends Canvas implements Runnable{
        ///Create a choice of difficulty level of computer ... 
    
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //sets frame parametrs 
    
    private Thread thread; //Create thread for start() function
    private boolean running = false; //check for if thread is on or it is not on
    
    public Game(){
        new Window(WIDTH, HEIGHT, "Thousand Game", this);
        
    }
    
    public synchronized void start(){
        thread = new Thread(this);//'this' represents game class
        thread.start();
        running = true;
    }
    
     public synchronized void stop(){
       try{
           thread.join();//killing thread
           running = false;
       }catch(Exception e){
           e.printStackTrace();
        }
    }  
    public void run(){
        //Game loop Algorith
        long lastTime = System.nanoTime(); //Getns time in nano seconds
        double amountOfTicks = 60.0; //set tick frame ( frame per second - the game will run with 60 FPS)
        double ns = 1000000000 / amountOfTicks; // nano seconds divides by amountOFTicks to see how many Seconds there have been
        double delta = 0 ; //time since the game last updated
        long timer = System.currentTimeMillis(); //curretct time in miliseconds
        int frames = 0 ; //frames per secconds actually getting
        while(running){ //while game is running
            long now = System.nanoTime(); //number of miliseconds 
            delta += (now - lastTime) / ns; //evens out space between time ( time before by time now)
            lastTime = now; // set lasttime to now
            while(delta >=1 ){ //while the time between each frame is less than one tick 
                tick();
                delta--; //minus one from delta
            }
            if(running) //if game is running
                render(); //render images 
            frames++; //add one to frame
            
            if(System.currentTimeMillis() - timer > 1000){ //if the gap between when times was set and now is lees than 1000 miliseconds
                timer += 1000; //add 1000 to timer
                System.out.println("FPS: " + frames); //print frames per second
                frames = 0 ; //set frames to 0
            }
        }
        stop(); 
    }
    
    private void tick(){
        
    }
    
    private void render(){
    
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){//if buffer is null
            this.createBufferStrategy(3);//how many buffers it creates, in this case 3
            return;
        }
        
        Graphics g = bs.getDrawGraphics();//
        
        g.setColor(Color.black); //change window screen color
        g.fillRect(0, 0, WIDTH, HEIGHT); //fill hole window screen
        
        g.dispose();//causes the JFrame window to be destroyed and cleaned up by the OP system
        bs.show(); //show window
    }
