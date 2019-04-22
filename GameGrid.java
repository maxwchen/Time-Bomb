
/**
 * This class is the base of the entire game. The constructor opens up a JFrame, in which we layer JPanels, and their components (Buttons,
 * Text fields, etc) to form the game.
 * 
 * @author Nicholas Hoang, Maxwell Chen, Jun Gao
 * @version 04 June 2016
 */
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;
import java.net.*;
public class GameGrid extends JFrame
{
    private Timer gameTimer;  
    private JFrame frame;
    private JButton east;
    private JButton west;
    private JPanel panel;
    private JPanel keyPanel;
    private JTextField display;
    private String mainText;
    private JButton bomb;    

    public GameGrid(){ //opens up the base JFrame
        createPanel();
        createTimer();
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private JButton createButtonGeneral(String label, String action, String img){ //General method used to create invisible buttons used as links
        JButton button = new JButton(label); //making button
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        class ButtonHandler implements ActionListener{ //button press action
            public void actionPerformed(ActionEvent a){
                //open up the actual game
                if(a.getSource() == button){

                    try{//play click sound
                        URL url = GameGrid.class.getResource("d.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e1){e1.printStackTrace();}

                    getContentPane().removeAll();

                    JPanel keyPanel1 = new JPanel(); //Main Panel
                    keyPanel1.setLayout(new BorderLayout()); //Layout of Main

                    ImageIcon icon = new ImageIcon(img);
                    JLabel thumb = new JLabel();
                    thumb.setIcon(icon);

                    keyPanel1.add(thumb, BorderLayout.CENTER);
                    Button ret = new Button(action);   

                    class ButtonHan implements ActionListener{ //return to the main screen
                        public void actionPerformed(ActionEvent e){
                            if(e.getSource() == ret){

                                try{//play click sound
                                    URL url = GameGrid.class.getResource("d.wav");
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.start();
                                }
                                catch(Exception e2){e2.printStackTrace();}

                                getContentPane().removeAll();
                                createPanel();
                                revalidate();
                                repaint();
                            }
                        }
                    }
                    ButtonHan handle2 = new ButtonHan();
                    ret.addActionListener(handle2);

                    keyPanel1.add(ret, BorderLayout.SOUTH); //Adding return button
                    add(keyPanel1);//adding main panel to the frame without making new frame
                    revalidate();
                    repaint();

                }
            }
        }

        ButtonHandler handle = new ButtonHandler();
        button.addActionListener(handle);

        button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        return button;
    }

    private void createButtonEast(){ //creates the button used for east navigation, also draws the east panel onto the frame
        east = new JButton(">"); //making button
        east.setOpaque(false);
        east.setContentAreaFilled(false);
        east.setBorderPainted(false);

        class ButtonHandler implements ActionListener{ //action when button is pressed
            public void actionPerformed(ActionEvent a){//specific action of press
                //open up the actual game
                if(a.getSource() == east){
                    getContentPane().removeAll();

                    try{//play click sound
                        URL url = GameGrid.class.getResource("d.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e3){e3.printStackTrace();}

                    class BGPanel extends JPanel{//setting background
                        Image bg = new ImageIcon("right.jpg").getImage();
                        @Override//Overrides paint component to draw background
                        public void paintComponent(Graphics g){
                            g.drawImage(bg, 0,0, getWidth(), getHeight(), this);
                        }
                    }
                    JPanel bgPanel = new BGPanel();
                    bgPanel.setLayout(new BorderLayout());

                    JPanel keyPanel1 = new JPanel(); //Main Panel
                    keyPanel1.setLayout(new BorderLayout()); //Layout of Main
                    JPanel panel1 = new JPanel(); //Button Panel
                    panel1.setLayout(new GridLayout(8,9)); //Dimensions of Button Grid
                    for(int i =0; i< 23; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    for(int i =0; i< 6; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    for(int i =0; i< 6; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a poster of the solar system. Flipped, you notice the number 4 and a message. \"At night they come without being fetched, And by day they are lost without being stolen.\" Click to return.", "clue6.jpg"));
                    for(int i =0; i< 3; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "As you look towards the potted grape vine, you notice a note dangling from one of its branches. It reads \"Who was the angel that planted the grapevine?\". Under lies the number 5. Click to return.", "clue2.jpg"));
                    for(int i =0; i< 8; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "As you look towards the potted grape vine, you notice a note dangling from one of its branches. It reads \"Who was the angel that planted the grapevine?\". Under lies the number 5. Click to return.", "clue2.jpg"));
                    for(int i =0; i< 8; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "As you look towards the potted grape vine, you notice a note dangling from one of its branches. It reads \"Who was the angel that planted the grapevine?\". Under lies the number 5. Click to return.", "clue2.jpg"));
                    for(int i =0; i< 6; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }

                    keyPanel1.add(panel1, BorderLayout.CENTER); //Adding the buttons to main panel
                    Button ret = new Button("Return to bomb site");  

                    class ButtonHan implements ActionListener{ //return to the main screen
                        public void actionPerformed(ActionEvent e){
                            if(e.getSource() == ret){

                                try{//play click sound
                                    URL url = GameGrid.class.getResource("d.wav");
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.start();
                                }
                                catch(Exception e4){e4.printStackTrace();}
                                getContentPane().removeAll();
                                createPanel();
                                revalidate();
                                repaint();
                            }
                        }
                    }
                    ButtonHan handle2 = new ButtonHan();
                    ret.addActionListener(handle2);

                    keyPanel1.add(ret, BorderLayout.SOUTH); //Adding return button

                    panel1.setOpaque(false);//Make the button grid transparent
                    bgPanel.add(panel1, BorderLayout.CENTER);//add the button panel on top of the background
                    keyPanel1.add(bgPanel, BorderLayout.CENTER);

                    add(keyPanel1);//adding main panel to the frame without making new frame
                    revalidate();
                    repaint();

                }
            }
        }

        ButtonHandler handle = new ButtonHandler();
        east.addActionListener(handle);

        east.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createButtonWest(){ //creates the button for west naviation, also draws the west panel onto the frame
        west = new JButton("<"); //making button
        west.setOpaque(false);
        west.setContentAreaFilled(false);
        west.setBorderPainted(false);

        class ButtonHandler implements ActionListener{ //button press action
            public void actionPerformed(ActionEvent a){//spcific action
                //open up the actual game
                if(a.getSource() == west){
                    getContentPane().removeAll();

                    try{//play click sound
                        URL url = GameGrid.class.getResource("d.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e5){e5.printStackTrace();}

                    class BGPanel extends JPanel{//background of panel
                        Image bg = new ImageIcon("left.jpg").getImage();
                        @Override//Overrides paint component to draw background
                        public void paintComponent(Graphics g){
                            g.drawImage(bg, 0,0, getWidth(), getHeight(), this);
                        }
                    }
                    JPanel bgPanel = new BGPanel();
                    bgPanel.setLayout(new BorderLayout());

                    JPanel keyPanel1 = new JPanel(); //Main Panel
                    keyPanel1.setLayout(new BorderLayout()); //Layout of Main
                    JPanel panel1 = new JPanel(); //Button Panel
                    panel1.setLayout(new GridLayout(8,9)); //Dimensions of Button Grid
                    for(int i =0; i< 50; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    for(int i =0; i< 3; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }                   
                    panel1.add(createButtonGeneral("", "You notice the number 2 and a message. \"There was a green house. Inside the green house there was a white house. Inside the white, a red, and inside the red house there were a lot of babies. What is the house?\". Click to return.", "clue4.jpg"));
                    for(int i =0; i< 3; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    for(int i =0; i< 2; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice the number 2 and a message. \"There was a green house. Inside the green house there was a white house. Inside the white, a red, and inside the red house there were a lot of babies. What is the house?\". Click to return.", "clue4.jpg"));
                    panel1.add(createButtonGeneral("", "You notice the number 2 and a message. \"There was a green house. Inside the green house there was a white house. Inside the white, a red, and inside the red house there were a lot of babies. What is the house?\". Click to return.", "clue4.jpg"));
                    for(int i =0; i< 3; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    panel1.add(createButtonGeneral("", "You notice a toy bus on the shelf. Under the bus lies the number 4 and the message: \"There is a house. One enters it blind and comes out seeing. What is it?\" Click to return.", "clue5.jpg"));
                    for(int i =0; i< 2; i++){ //adding the buttons
                        Button temp = new Button("");
                        temp.setVisible(false);
                        panel1.add(temp);
                    }
                    keyPanel1.add(panel1, BorderLayout.CENTER); //Adding the buttons to main panel
                    Button ret = new Button("Return to bomb site");  

                    class ButtonHan implements ActionListener{ //return to the main screen
                        public void actionPerformed(ActionEvent e){
                            if(e.getSource() == ret){

                                try{//play click sound
                                    URL url = GameGrid.class.getResource("d.wav");
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.start();
                                }
                                catch(Exception e6){e6.printStackTrace();}
                                getContentPane().removeAll();
                                createPanel();
                                revalidate();
                                repaint();
                            }
                        }
                    }
                    ButtonHan handle2 = new ButtonHan();
                    ret.addActionListener(handle2);

                    keyPanel1.add(ret, BorderLayout.SOUTH); //Adding return button

                    panel1.setOpaque(false);//Make the button grid transparent
                    bgPanel.add(panel1, BorderLayout.CENTER);//add the button panel on top of the background
                    keyPanel1.add(bgPanel, BorderLayout.CENTER);

                    add(keyPanel1);//adding main panel to the frame without making new frame
                    revalidate();
                    repaint();

                }
            }
        }

        ButtonHandler handle = new ButtonHandler();
        west.addActionListener(handle);

        west.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    private void createBomb(){ //button that leads to the bomb
        bomb = new JButton(""); //making button
        bomb.setOpaque(false);
        bomb.setContentAreaFilled(false);
        bomb.setBorderPainted(false);

        class ButtonHandler implements ActionListener{ //click action
            public void actionPerformed(ActionEvent a){//specifc action
                if(a.getSource() == bomb){

                    try{//play click sound
                        URL url = GameGrid.class.getResource("d.wav");
                        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                        Clip clip = AudioSystem.getClip();
                        clip.open(ais);
                        clip.start();
                    }
                    catch(Exception e7){e7.printStackTrace();}
                    getContentPane().removeAll();

                    JPanel keyPanel1 = new JPanel(); //Main Panel
                    keyPanel1.setLayout(new BorderLayout()); //Layout of Main

                    Bomb n = new Bomb();
                    n.setGame(returnGame());
                    keyPanel1.add(n.createPanel(), BorderLayout.CENTER); //Adding the buttons to main panel
                    Button ret = new Button("Click on the colored wires in the correct order to defuse the bomb. Return to bomb site");  

                    class ButtonHan implements ActionListener{ //return to the main screen
                        public void actionPerformed(ActionEvent e){
                            if(e.getSource() == ret){

                                try{//play click sound
                                    URL url = GameGrid.class.getResource("d.wav");
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.start();
                                }
                                catch(Exception e8){e8.printStackTrace();}
                                getContentPane().removeAll();
                                createPanel();
                                revalidate();
                                repaint();
                            }
                        }
                    }
                    ButtonHan handle2 = new ButtonHan();
                    ret.addActionListener(handle2);

                    keyPanel1.add(ret, BorderLayout.SOUTH); //Adding return button
                    add(keyPanel1);//adding main panel to the frame without making new frame
                    revalidate();
                    repaint();

                }
            }
        }

        ButtonHandler handle = new ButtonHandler();
        bomb.addActionListener(handle);

        bomb.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
    }

    public void createTimer()//sets and creates the bomb timer
    {
        gameTimer = new Timer();
        TimerTask display = new TimerTask()
            {

                int seconds = 600;
                public void run()//starts the timer
                {
                    seconds--;
                    if (seconds == 0)
                    {
                        loseGame();
                    }
                    if (seconds%60<10)
                    {
                        changeText(seconds/60 + ":0"+seconds%60);
                    }
                    else
                    {
                        changeText(seconds/60 + ":"+seconds%60);
                    }
                }
            };
        gameTimer.schedule(display, 1000,1000);
    }

    public GameGrid returnGame()//returns the running object (actual GameGrid object) being used when game is running
    {
        return(this);
    }

    private void createPanel(){//draws main room panel onto the frame, for loops are used to arrange buttons in correct order

        class BGPanel extends JPanel{//setting the background
            Image bg = new ImageIcon("test.jpg").getImage();
            @Override //Overrides paint component to draw background
            public void paintComponent(Graphics g){
                g.drawImage(bg, 0,0, getWidth(), getHeight(), this);
            }
        }
        JPanel bgPanel = new BGPanel();
        bgPanel.setLayout(new BorderLayout());

        keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(8,9));

        createButtonEast();
        createButtonWest();
        createBomb();
        for(int i = 0; i < 20; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.add(createButtonGeneral("", "You move towards the painting and notice a note wedged in between the frame. It reads \"What walks on four legs in the morning, two legs in the afternoon, and three legs at night?\". Under lies the number 1. Click to return", "clue1.jpg"));
        panel.add(createButtonGeneral("", "You move towards the painting and notice a note wedged in between the frame. It reads \"What walks on four legs in the morning, two legs in the afternoon, and three legs at night?\". Under lies the number 1. Click to return", "clue1.jpg"));
        for(int i = 0; i < 1; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.add(createButtonGeneral("", "You notice a stuffed fish hung on the wall. On its stomach you find the message enscribed: \"What we caught, we threw away; what we didn't catch, we kept. What did we keep?\". The number 3 is under the message. Click to return.", "clue3.jpg"));
        panel.add(createButtonGeneral("", "You notice a stuffed fish hung on the wall. On its stomach you find the message enscribed: \"What we caught, we threw away; what we didn't catch, we kept. What did we keep?\". The number 3 is under the message. Click to return.", "clue3.jpg"));
        for(int i = 0; i < 4; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.add(createButtonGeneral("", "You move towards the painting and notice a note wedged in between the frame. It reads \"What walks on four legs in the morning, two legs in the afternoon, and three legs at night?\". Under lies the number 1. Click to return", "clue1.jpg"));
        panel.add(createButtonGeneral("", "You move towards the painting and notice a note wedged in between the frame. It reads \"What walks on four legs in the morning, two legs in the afternoon, and three legs at night?\". Under lies the number 1. Click to return", "clue1.jpg"));
        for(int i = 0; i < 1; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.add(createButtonGeneral("", "You notice a stuffed fish hung on the wall. On its stomach you find the message enscribed: \"What we caught, we threw away; what we didn't catch, we kept. What did we keep?\". The number 3 is under the message. Click to return.", "clue3.jpg"));
        panel.add(createButtonGeneral("", "You notice a stuffed fish hung on the wall. On its stomach you find the message enscribed: \"What we caught, we threw away; what we didn't catch, we kept. What did we keep?\". The number 3 is under the message. Click to return.", "clue3.jpg"));
        for(int i = 0; i < 6; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.add(bomb);
        for(int i = 0; i < 31; i++)
        {
            Button temp = new Button("");
            temp.setVisible(false);
            panel.add(temp);
        }
        panel.setOpaque(false);//Make the button grid transparent
        bgPanel.add(panel, BorderLayout.CENTER);//add the button panel on top of the background
        keyPanel.add(bgPanel, BorderLayout.CENTER);
        display = new JTextField();
        mainText="      You wake up in a room. You have lost your memories and do not remember who you are. The only thing that awaits you is a bomb. You find a note wedged into the bomb. \"Look for clues and defuse the bomb.\". Escape.";
        display.setText(mainText);
        keyPanel.add(display, BorderLayout.SOUTH);
        keyPanel.add(east, BorderLayout.EAST);
        keyPanel.add(west, BorderLayout.WEST);
        add(keyPanel);
    }

    private void changeText(String str)//displays timer onto the main text field
    {
        display.setText(mainText+" "+str);
    }

    public void stopTimer()//stops the timer (when game ends -win or lose)
    {
        gameTimer.cancel();
    }

    private void loseGame()//what happens when game is lost (this one only runs when time runs out)
    {

        try{//play lose sound
            URL url = GameGrid.class.getResource("a.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
        gameTimer.cancel();
        new LoseGame().setVisible(true);
        setVisible(false);
        dispose();
    }
}
