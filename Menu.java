
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

import javax.sound.sampled.*;
import java.net.*;
public class Menu extends JFrame
{

    private JButton buttonStart;
    private JButton buttonEnd;
    private JLabel gameTitle;
    private JPanel panel;
    
    private URL url;
    private AudioInputStream ais;
    private Clip clip;

    public Menu(){//creates the JFrame of the game menu
        createButton1(); //methods to create buttons
        createButton2();
        createPanel();

        setSize(500,800);
        setResizable(false);

        try{//play title screen music
            url = Bomb.class.getResource("f.wav");
            ais = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch(Exception e2){e2.printStackTrace();}
    }

    private void createButton1(){ //start game button
        buttonStart = new JButton(""); //making button
        buttonStart.setOpaque(false); //make buttons invisible
        buttonStart.setContentAreaFilled(false);
        buttonStart.setBorderPainted(false);

        class MenuListener implements ActionListener{ //button to start a new game
            public void actionPerformed(ActionEvent a){
                try{//play start sound
                    URL url = Bomb.class.getResource("c.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                    Clip clip2 = AudioSystem.getClip();
                    clip2.open(ais);
                    clip2.start();
                }
                catch(Exception e){e.printStackTrace();}

                new GameGrid().setVisible(true); 
                setVisible(false);
                dispose();
                clip.stop();
            }
        }

        ActionListener action = new MenuListener(); //assigning action to the button
        buttonStart.addActionListener(action);
        buttonStart.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createButton2(){ //end game button
        buttonEnd = new JButton(""); //making button
        buttonEnd.setOpaque(false);//make buttons invisible
        buttonEnd.setContentAreaFilled(false);
        buttonEnd.setBorderPainted(false);

        class MenuListener implements ActionListener{ //button to quit game
            public void actionPerformed(ActionEvent a){
                dispose();
                clip.stop();
            }
        }

        ActionListener action = new MenuListener(); //assigning action to the button
        buttonEnd.addActionListener(action);
        buttonEnd.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    } 

    private void createPanel(){//create the main panel of the menu
        class BGPanel extends JPanel{//imports image
            Image bg = new ImageIcon("Title.png").getImage();
            @Override
            public void paintComponent(Graphics g){
                g.drawImage(bg, 0,0, getWidth(), getHeight(), this);
            }
        }
        JPanel bgPanel = new BGPanel();
        bgPanel.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(6,3));
        panel.setOpaque(false);
        bgPanel.add(panel, BorderLayout.CENTER);
        for(int i = 0; i < 18; i++){
            if(i == 10){
                panel.add(buttonStart);
            }
            else if(i==13){
                panel.add(buttonEnd);
            }
            else{
                JButton temp = new JButton("");
                temp.setOpaque(false);
                temp.setContentAreaFilled(false);
                temp.setBorderPainted(false);
                panel.add(temp);
            }
        }
        add(bgPanel);
    }

}
