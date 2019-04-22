
/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.sound.sampled.*;
import java.net.*;

public class Bomb extends JFrame
{
    private int count = 0;
    private boolean red = true;
    private boolean green = true;
    private boolean blue = true;
    private boolean yellow = true;
    private boolean black = true;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton yellowButton;
    private JButton blackButton;
    private JButton backButton;
    private JPanel panel;
    private JPanel keyPanel;   
    private GameGrid game;

    public Bomb()//create the bomb object
    {
        createRedButton();
        createGreenButton();
        createBlueButton();
        createYellowButton();
        createBlackButton();
        createPanel();
    }

    public void setGame(GameGrid game)//imports the GameGrid object (used in tandem with the returnGame() method in GameGrid)
    {
        this.game = game;
    }

    private void createRedButton()//create a red button
    {
        redButton = new JButton(" ");//image   
        redButton.setOpaque(false);
        redButton.setContentAreaFilled(false);
        redButton.setBorderPainted(false);
        class CutRedListener implements ActionListener
        {
            boolean b = true;            
            public void actionPerformed(ActionEvent event)//record button press and check if order is correct
            {
                if(event.getSource() == redButton && b)
                {
                    try{//play win sound
                        URL url = Bomb.class.getResource("e.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e1){e1.printStackTrace();}

                    count++;
                    red = false;
                    if(count != 1)
                    {
                        loseGame();
                    }
                    else if(check())
                    {
                        winGame();
                    }
                    b = false;               
                }
            }
        }        

        CutRedListener cr = new CutRedListener();
        redButton.addActionListener(cr);

        redButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createGreenButton()//create a green button
    {
        greenButton = new JButton(" ");//image      
        greenButton.setOpaque(false);
        greenButton.setContentAreaFilled(false);
        greenButton.setBorderPainted(false);
        class CutGreenListener implements ActionListener
        {
            boolean b = true;
            public void actionPerformed(ActionEvent event)//record button press and check if order is correct
            {
                if(event.getSource() == greenButton && b)
                {
                    try{//play win sound
                        URL url = Bomb.class.getResource("e.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e2){e2.printStackTrace();}
                    count++;
                    green = false;
                    if(count != 2)
                    {
                        loseGame();
                    }
                    else if(check())
                    {
                        winGame();
                    }
                    b = false;
                }
            }
        }  

        CutGreenListener cg = new CutGreenListener();
        greenButton.addActionListener(cg);

        greenButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createBlueButton()//create a blue button
    {        
        blueButton = new JButton(" ");//image
        blueButton.setOpaque(false);
        blueButton.setContentAreaFilled(false);
        blueButton.setBorderPainted(false);
        class CutBlueListener implements ActionListener
        {
            boolean b = true;
            public void actionPerformed(ActionEvent event)//record button press and check if order is correct
            {
                if(event.getSource() == blueButton && b)
                {
                    try{//play win sound
                        URL url = Bomb.class.getResource("e.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e3){e3.printStackTrace();}
                    count++;
                    blue = false;
                    if(count != 3)
                    {
                        loseGame();
                    }
                    else if(check())
                    {
                        winGame();
                    }
                    b = false;
                }
            }
        }  

        CutBlueListener cbl = new CutBlueListener();
        blueButton.addActionListener(cbl);

        blueButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }   

    private void createYellowButton()//create a yellow button
    {
        yellowButton = new JButton(" ");//image
        yellowButton.setOpaque(false);
        yellowButton.setContentAreaFilled(false);
        yellowButton.setBorderPainted(false);
        class CutYellowListener implements ActionListener
        {
            boolean b = true;
            public void actionPerformed(ActionEvent event)//record button press and check if order is correct
            {
                if(event.getSource() == yellowButton && b)
                {
                    try{//play win sound
                        URL url = Bomb.class.getResource("e.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e5){e5.printStackTrace();}
                    count++;
                    yellow = false;
                    if(count != 4)
                    {
                        loseGame();
                    }
                    else if(check())
                    {
                        winGame();
                    }
                    b = false;
                }
            }
        }  

        CutYellowListener cy = new CutYellowListener();
        yellowButton.addActionListener(cy);

        yellowButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createBlackButton()//create a black button
    {
        blackButton = new JButton(" ");//image
        blackButton.setOpaque(false);
        blackButton.setContentAreaFilled(false);
        blackButton.setBorderPainted(false);
        class CutBlackListener implements ActionListener
        {
            boolean b = true;
            public void actionPerformed(ActionEvent event)//record button press and check if order is correct
            {
                if(event.getSource() == blackButton && b)
                {
                    try{//play win sound
                        URL url = Bomb.class.getResource("e.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e6){e6.printStackTrace();}
                    count++;
                    black = false;
                    if(count != 5)
                    {
                        loseGame();
                    }
                    else if(check())
                    {
                        winGame();
                    }
                    b = false;
                }
            }
        }  

        CutBlackListener cb = new CutBlackListener();
        blackButton.addActionListener(cb);

        blackButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    public JPanel createPanel()//creates bomb panel
    {
        class BGPanel extends JPanel//imports image of the bomb
        {
            Image bg = new ImageIcon("bomb.jpg").getImage();
            public void paintComponent(Graphics g)
            {
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        }
        JPanel bgPanel = new BGPanel();
        bgPanel.setLayout(new BorderLayout());
        keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(7,9));

        for(int i = 1; i <= 9; i++)
        {
            JButton button = new JButton("");
            button.setVisible(false);
            panel.add(button);
        }
        panel.add(redButton);
        for(int i = 1; i <= 16; i++)
        {
            JButton button = new JButton("");
            button.setVisible(false);
            panel.add(button);
        }
        panel.add(greenButton);
        panel.add(blueButton);
        for(int i = 1; i <= 16; i++)
        {
            JButton button = new JButton("");
            button.setVisible(false);
            panel.add(button);
        }
        panel.add(yellowButton);
        panel.add(blackButton);
        for(int i = 1; i <= 15; i++)
        {
            JButton button = new JButton("");
            button.setVisible(false);
            panel.add(button);
        }
        panel.setOpaque(false);//Make the button grid transparent
        bgPanel.add(panel, BorderLayout.CENTER);//add the button panel on top of the background
        keyPanel.add(bgPanel, BorderLayout.CENTER);
        return keyPanel;       
    }

    public boolean check()//check if all buttons have been clicked
    {
        return !red && !green && !blue && !yellow && !black;
    }

    public void winGame()//method that runs when the player wins (all bomb cords cut correctly)
    {
        try{//play win sound
            URL url = Bomb.class.getResource("b.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}

        game.stopTimer();
        new WinGame().setVisible(true);
        game.setVisible(false);
        game.dispose();
    }

    public void loseGame()//method that runs when the player loses (bomb cords cut incorrectly)
    {

        try{//play lose sound
            URL url = Bomb.class.getResource("a.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}

        game.stopTimer();
        new LoseGame().setVisible(true);
        game.setVisible(false);
        game.dispose();        
    }
}