package LotteryApp;

/**
 * @author Christopher Kambayi, Emma English, Mahamed Basha, Leandro Silva
 * Date: 25/10/2016
 * LotteryApp.java
 * Version 2
 */

import javax.swing.JOptionPane;
import LotteryApp.Lottery;

public class LotteryApp 
{
    public static void main(String [] args)
    { 
        //declaring and creating variables
        int [] myNums = new int [5];
        
        //declaring an instance of the Lottery class
        Lottery myLotto = new Lottery();
        
        //welcoming the user to the application
        JOptionPane.showMessageDialog(null, "Welcome to the Lottery!");
        
        //specifying the rules for this application to the user
        JOptionPane.showMessageDialog(null, "Enter five numbers between 1 and 40.");
        
        //this for loop goes five times, asking the user for a number
        for(int i = 0; i < myNums.length; i++)
        {
            //the variables myNums is set at position i to the users entry
            //it displays the number we wish the user to enter
            myNums[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number " + (i + 1) + ":"));
        }
        
        //generates the lottery numbers
        myLotto.runLotto();
        
        //asks the user which lottery they'd like to do
        String runType = JOptionPane.showInputDialog(null, "Lotto, Plus1 or Plus2: ");
        
        //sends the users guesses and the type of lottery they'd like to do to the Lottery class
        myLotto.verify(myNums, runType);
        
        //this print methods shows the results to the user
        myLotto.printResults();        
    }
}
