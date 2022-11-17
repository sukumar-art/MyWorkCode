import java.util.*;

class GuessersArea{ 

    int gussedNumber, a=50, b, c;

    int gusserNumber(){
        System.out.println("Players are ready!"+"\n"+"Hey Gusser guess a 'Number'");
        Scanner scan = new Scanner(System.in);
            gussedNumber=scan.nextInt(); 
            if(gussedNumber<a){
                b=gussedNumber+a; c=gussedNumber+gussedNumber;
                
            }
            else if(gussedNumber>a){
                b=gussedNumber-a; c=gussedNumber+b;
            }
            System.out.println("Hey Players Guess the Number from below the three Numbers"+"\n"+b+" "+gussedNumber+" "+c);
            return gussedNumber;
    }
}
class PlayersArea{
    
    int guessNum; String name;
    
    int gussedNumber(){
        System.out.println("Hey Player Enter your answer");
        Scanner scanner = new Scanner(System.in);
        guessNum=scanner.nextInt(); 
        return guessNum;
        
    }
}
class UmpireDecesion{

    int valueFromGusser;
    int valueFromPlayerOne;
    int valueFromPlayerTwo;
    int valueFromPlayerThree;
    String name;                                          //Taking PlayerOne Name as Input

    void pName(){
        System.out.println("PlayerOne Enter your Name");
        Scanner scan=new Scanner(System.in);
        name=scan.nextLine();
    }
    void gusserToUmpire(){
       GuessersArea guss=new GuessersArea();
       valueFromGusser = guss.gusserNumber();
    }
    void playersToUmpire(){
        PlayersArea p1=new   PlayersArea();
        valueFromPlayerOne   = p1.gussedNumber();
        PlayersArea p2=new   PlayersArea();
        valueFromPlayerTwo   = p2.gussedNumber();
        PlayersArea p3=new   PlayersArea();
        valueFromPlayerThree = p3.gussedNumber();
    }
    void umpirCompare(){
        if(valueFromGusser==valueFromPlayerOne){
            if(valueFromGusser==valueFromPlayerTwo && valueFromGusser==valueFromPlayerThree){
                System.out.println("Wounderful All Plyayers won the Game");
             }
                else if(valueFromGusser==valueFromPlayerTwo){
                    System.out.println(name+" "+"and PlayerTwo won the Game");
                }
                else if(valueFromGusser==valueFromPlayerThree){
                    System.out.println(name+" "+"and PlayerThree won the Game");
                }
                else{
                    System.out.println("Hey "+name+" "+"you won the game");
                }
        }
        else if(valueFromGusser==valueFromPlayerTwo)        {
            if(valueFromGusser==valueFromPlayerThree){
                System.out.println("PlayerTwo and PlayerThree Won the Game");
            }
            else{
                System.out.println("PlayerTwo Won the Game");
            }
        }    
            else if(valueFromGusser==valueFromPlayerThree){
                System.out.println("PlayerThree Won the Game");
            }
            else{
                System.out.println("All Players Lost, TRY AGAIN");
            }
    }
}
class AGussersArea{
    String gussedString;
    String gussedString(){
        System.out.println("Players are ready!"+"Gusser guess a Character");
        Scanner scan = new Scanner(System.in);
        gussedString=scan.nextLine();
        return gussedString;
    }
}
class APlayersArea{
    String gussedString;
    String gussedString(){
        System.out.println("Players Enter your Character");
        Scanner scan =new Scanner(System.in);
        gussedString=scan.nextLine();
        return gussedString;
    }
}
class AUmpireDecesion{
    String valueFromGusser;
    String valueFromPlayerOne;
    String valueFromPlayerTwo;
    String valueFromPlayerThree;
    String name;
    
    void pName(){
        System.out.println("PlayerOne Enter your Name");
        Scanner scan=new Scanner(System.in);
        name=scan.nextLine();
    }
    public void gusserToUmpire(){
        AGussersArea g=new AGussersArea();
        valueFromGusser=g.gussedString();
    }
    public void playersToUmpire(){
        APlayersArea p1=new APlayersArea();
        valueFromPlayerOne=p1.gussedString();
        APlayersArea p2=new APlayersArea();
        valueFromPlayerTwo=p2.gussedString();
        APlayersArea p3=new APlayersArea();
        valueFromPlayerThree=p3.gussedString();
    }
    public void umpirCompare(){
        if(valueFromGusser.equals(valueFromPlayerOne)){
            if(valueFromGusser.equals(valueFromPlayerTwo) && valueFromGusser.equals(valueFromPlayerThree)){
                System.out.println("Awsome All Players Won the Game");
            }
            else if(valueFromGusser.equals(valueFromPlayerTwo)){
                System.out.println(name+"&  "+"PlayerTwo Won the Game");
            }
            else if(valueFromGusser.equals(valueFromPlayerThree)){
                System.out.println(name+"& "+"PlayerThree Won the Game");
            }
            else{
                System.out.println("Hey "+name+" "+"You Won the Game");
            }
        }
        else if(valueFromGusser.equals(valueFromPlayerTwo)){
            if(valueFromGusser.equals(valueFromPlayerThree)){
                System.out.println("PlayerOne and PlayerThree Won the Game");
                }
                else{
                    System.out.println("PlayerTwo Won the Game");
                }
        }
        else if(valueFromGusser.equals(valueFromPlayerThree)){
            System.out.println("PlayerThree Won the Game");
        }
        else{
            System.out.println("All Players, BetterLuck Try Again");
        }
    } 
}
class GameZone{
    String a; String num="n"; String num2="N"; String charr="c"; String charr2="C";
    void gameZone(){
        System.out.println("Welcome to GameZone"+"\n"+"Please enter 'N' to Play with Numbers"+"\n"+"or Enter 'C' to Play with Characters");
        Scanner scan=new Scanner(System.in);
        a=scan.nextLine();
    }
    void execution(){
        if(a.equals(num)||a.equals(num2)){
            UmpireDecesion umpir=new UmpireDecesion();
            umpir.pName();
            umpir.gusserToUmpire();
            umpir.playersToUmpire();
            umpir.umpirCompare();
        }
        else if(a.equals(charr)||a.equals(charr2)){
            AUmpireDecesion umpir=new AUmpireDecesion();
            umpir.pName();
            umpir.gusserToUmpire();
            umpir.playersToUmpire();
            umpir.umpirCompare();
        }
    }
}
class  ReExecution{
    String yes="y"; String no="n";
    
    void reEx(){
        System.out.println("Press 'Y' to play again or Press 'N' to exit");
        Scanner scan=new Scanner(System.in);
        yes=scan.nextLine();
        while(yes.equals(yes)){
                     
            if(yes.equals(no)){
                break;
            }
            else{
                GameZone beginGame=new GameZone();
                beginGame.gameZone();
                beginGame.execution();
                ReExecution reExx=new ReExecution();
                reExx.reEx();
                break;                                                   //Breaking the Loop
            }
        }
    }
}
public class GusserGame{
    public static void main(String[] args) {
        GameZone beginGame=new GameZone();
        beginGame.gameZone();
        beginGame.execution();
        ReExecution exe=new ReExecution();
        exe.reEx();
    } 
}