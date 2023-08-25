import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game{

    JFrame window;
    Container con;
    JPanel titlePanel;
    JPanel startButtoPanel;
    JLabel titleNameLabel;
    Font titleFont=new Font("Times New Roman", Font.PLAIN , 90);
    Font buttonFont=new Font("Consolas", Font.PLAIN, 45);
    Font normalFont=new Font("Consolas", Font.PLAIN, 30);
    JButton starButton;

    JPanel mainTextPanel;
    JTextArea mainTextArea;
    JPanel ButtonChoicePanel;
    JButton choice1,choice2,choice3,choice4;
    Font buttonFont2=new Font("null",Font.PLAIN, 25);
    JPanel PlayerPanel;
    JLabel hpLabel, hpLabelNumber, weaponLabel, weaponlabelName;

    int playerHp;
    int monsterHp;
    String weapon;

    String DragonHead="no";

    String position;

    TitleScreenHandler tsHandler= new TitleScreenHandler();
    ChoiceHandler chHandler= new ChoiceHandler();

    public static void main(String[] args) {
        
        new Game();
        
        
    }

    public Game(){

        window= new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setResizable(false);

        con=window.getContentPane();

        titlePanel=new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.BLACK);

        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);


        titlePanel.add(titleNameLabel);

        starButton=new JButton("Start");
        starButton.setBackground(Color.BLACK);
        starButton.setForeground(Color.WHITE);
        starButton.setFont(buttonFont);
        starButton.setFocusable(false);

        startButtoPanel=new JPanel();
        startButtoPanel.setBounds(300, 350, 200, 100);
        startButtoPanel.setBackground(Color.BLACK);
        starButton.addActionListener(tsHandler);
        startButtoPanel.add(starButton);
        


        con.add(titlePanel);
        con.add(startButtoPanel);


        window.setVisible(true);

    }

    public void createGameScreen(){

        titleNameLabel.setVisible(false);
        startButtoPanel.setVisible(false);

        mainTextPanel=new JPanel();
        
        mainTextArea=new JTextArea("This is the main text Area");
        mainTextArea.setBounds(100,100, 600, 250);
        mainTextArea.setBackground(Color.WHITE);
        mainTextArea.setForeground(Color.BLACK);
        mainTextArea.setFont(buttonFont2);
        mainTextArea.setLineWrap(true);
        
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);

        mainTextPanel.add(mainTextArea);


        ButtonChoicePanel=new JPanel();
        ButtonChoicePanel.setBounds(250, 350, 300, 150);
        ButtonChoicePanel.setBackground(Color.BLACK);
        ButtonChoicePanel.setLayout(new GridLayout(4,1));

        choice1=new JButton("Choice1");
        choice2=new JButton("Choice2");
        choice3=new JButton("Choice3");
        choice4=new JButton("Choice4");

        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.white);
        choice1.setFont(buttonFont2);
        choice1.setFocusPainted(false);
        
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.white);
        choice2.setFont(buttonFont2);
        choice2.setFocusPainted(false);
        
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.white);
        choice3.setFont(buttonFont2);
        choice3.setFocusPainted(false);
        
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.white);
        choice4.setFont(buttonFont2);
        choice4.setFocusPainted(false);

        choice1.addActionListener(chHandler);
        choice2.addActionListener(chHandler);
        choice3.addActionListener(chHandler);
        choice4.addActionListener(chHandler);

        choice1.setActionCommand("c1");
        choice2.setActionCommand("c2");
        choice3.setActionCommand("c3");
        choice4.setActionCommand("c4");

        ButtonChoicePanel.add(choice1);
        ButtonChoicePanel.add(choice2);
        ButtonChoicePanel.add(choice3);
        ButtonChoicePanel.add(choice4);
        


        con.add(ButtonChoicePanel);

        con.add(mainTextPanel);

        PlayerPanel=new JPanel();
        PlayerPanel.setBounds(100,15, 600, 50);
        PlayerPanel.setBackground(Color.BLACK);
        PlayerPanel.setLayout(new GridLayout(1,4));

        
        hpLabel=new JLabel("HP :");
        hpLabel.setForeground(Color.WHITE);
        hpLabel.setFont(buttonFont2);

        hpLabelNumber=new JLabel();
        hpLabelNumber.setFont(buttonFont2);
        hpLabelNumber.setForeground(Color.WHITE);

        weaponLabel=new JLabel("Weapon :");
        weaponLabel.setForeground(Color.WHITE);
        weaponLabel.setFont(buttonFont2);

        weaponlabelName=new JLabel();
        weaponlabelName.setForeground(Color.WHITE);
        weaponlabelName.setFont(buttonFont2);

        PlayerPanel.add(hpLabel);
        PlayerPanel.add(hpLabelNumber);
        PlayerPanel.add(weaponLabel);
        PlayerPanel.add(weaponlabelName);
        con.add(PlayerPanel);


        PlayerSetup();
    }

    public void PlayerSetup(){
        playerHp=15;
        weapon="Knife";

        monsterHp=20;

        weaponlabelName.setText(weapon);
        hpLabelNumber.setText(playerHp+"");

        townGate();

    }

    public void townGate(){
        position="townGate";
        mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\n\nWhat do you do?");

        choice1.setText("Talk to the Gurad");
        choice2.setText("Attack the Guard");
        choice3.setText("Leave");
        choice4.setText("");
        
    }
    
    public void talkGuard(){
        position="TalkGuard";
  

        mainTextArea.setText("Gurad: Hello Stranger. I have never seen your face. I'm sorry but we cannot let a stranger enter our town");
  
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }

    public void attackGuard(){
        position="attackGuard";
        mainTextArea.setText("Gurad: Hey dont't be stupid! \n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
        if(playerHp<=0){
            mainTextArea.setText("Player DIED");
            choice1.setEnabled(false);
        }
        playerHp=playerHp-3;
        hpLabelNumber.setText(playerHp+"");
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void crossRoad(){
        position="crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will be go back to the town.");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go West");
        choice4.setText("Go South");
    }
    
    public void North(){
        position="north";
        mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside. \n\n (Your HP is recovered by 2)");
        playerHp=playerHp+2;
        hpLabelNumber.setText(playerHp+"");
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }
    
    public void East(){
        position="east";
        
        mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(Ypu obtained a Long Sword)");
        weapon="Long Sword";
        weaponlabelName.setText(weapon);
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }
    
    public void west(){
        position="west";
        mainTextArea.setText("You encounter a Goblin");
        
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");



    }

    public void fight(){
        position="fight";
        mainTextArea.setText("Monster HP: "+monsterHp+ " \n\nWhat do you want to do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");

    }

    public void playerAttack(){
        position="playerAttack";
        
        int playerDamage=0;

        if(weapon.equals("Knife")){
            playerDamage=new java.util.Random().nextInt(3); 
        }
        else if(weapon.equals("Long Sword")){
            playerDamage=new java.util.Random().nextInt(7);
        }

        mainTextArea.setText("You Attack the monster and gave "+ playerDamage+ " damage!");

        monsterHp=monsterHp-playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");


    }

    public void monsterAttack(){
        position="monsterAttack";

        int monsterDamage=0;

        monsterDamage=new java.util.Random().nextInt(6);

        mainTextArea.setText("The Monster attacked you and gave "+ monsterDamage+ " damage");
        playerHp=playerHp-monsterDamage;

        hpLabelNumber.setText(playerHp+"");

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void win(){
        position="win";

        mainTextArea.setText("You Killed the Dragon\n\n(You have obtained Dragon Head)\n\nTalk to Guard Now");
        DragonHead="yes";
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void lose(){
        position="lose";

        mainTextArea.setText("You DIE\n\n<GAME OVER>");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

    }

    public void ending(){
        position="ending";

        mainTextArea.setText("Guard: Oh you killed that Dragon?\n\nThank you so much. You are true hero!\nWelcome to our town!\n\n<THE END>");
         choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

    }




    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }

    }

    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice= e.getActionCommand();
            if(yourChoice.equals("c1") && position.equals("townGate")){
                talkGuard();
            }

            else if(yourChoice.equals("c1") && position.equals("TalkGuard")){
                townGate();
            }
            else if(yourChoice.equals("c1") && position.equals("crossRoad")){
                North();
            }

            else if(yourChoice.equals("c1") && position.equals("attackGuard")){
                townGate();
            }
            
            else if(yourChoice.equals("c1") && position.equals("east")){
                crossRoad();
            }

            else if(yourChoice.equals("c2") && position.equals("townGate")){
                attackGuard();
            }
            else if(yourChoice.equals("c2") && position.equals("crossRoad")){
                East();
            }

            else if(yourChoice.equals("c3") && position.equals("townGate")){
                crossRoad();
            }

            else if(yourChoice.equals("c3") && position.equals("crossRoad")){
                west();
            }

            else if(yourChoice.equals("c4") && position.equals("crossRoad")){
                townGate();
            }

            else if(yourChoice.equals("c1") && position.equals("west")){
                fight();
            }
            else if(yourChoice.equals("c2")&& position.equals("west")){
                crossRoad();
            }

            else if(yourChoice.equals("c2") && position.equals("fight")){
                crossRoad();
            }

            else if(yourChoice.equals("c1") && position.equals("fight")){
                playerAttack();
            }    

            else if(yourChoice.equals("c1") && position.equals("playerAttack")){
                monsterAttack();
            }
            else if(yourChoice.equals("c1") && position.equals("monsterAttack")){
                fight();
                if(playerHp<1){
                    lose();
                }
                else if(monsterHp<1){
                    win();
                }
                
            }

            else if(yourChoice.equals("c1") && position.equals("win")){
                ending();
            }

            else if(yourChoice.equals("c1") && position.equals("north")){
                crossRoad();
            }


        }
        
    }

}