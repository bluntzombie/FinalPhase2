package LotteryApp;

import javax.swing.JOptionPane;

/**
 * @author Christopher Kambayi, Emma English, Mahamed Basha, Leandro Silva
 * Date: 11/10/2016
 * Lottery.java
 * Version: 2
 */

public class Lottery extends Draw
{
    //declaring and creating the variables
    private final Draw [] lotto = new Draw[3];
    private int lineOne, lineTwo, lineThree, printNum;

    //the constructor
    public Lottery()
    {        
        this.lotto[0] = new Draw();
        this.lotto[0].setDrawType("lotto");
        
        this.lotto[1] = new Draw();
        this.lotto[1].setDrawType("plus1");
                
        this.lotto[2] = new Draw(); 
        this.lotto[2].setDrawType("plus2");
        
        this.lineOne = 0;
        this.lineTwo = 0;
        this.lineThree = 0;
    }
    
    //this method gets the Draw class to generate the lottery numbers
    public void runLotto()
    {
        //this loop goes five times, generate the lottery numbers
        for(int i = 0; i < lotto.length; i++)
        {
            lotto[i].generate();
        }
    }
    
    //this method verifies what the user entered
    public void verify(int [] num, String typ)
    {
        //creating the variable for the type of lottery to run
        int numRun = 0;
        
        //if they chose just the lottery
        if(typ.equalsIgnoreCase("lotto"))
        {
            numRun = 1;
            this.printNum = 0;
        }
        
        //if they chose the lottery and plus1
        if(typ.equalsIgnoreCase("plus1"))
        {
            numRun = 2;
            this.printNum = 1;
        }
        
        //if they chose the lottery, plus1 and plus2
        if(typ.equalsIgnoreCase("plus2"))
        {
            numRun = 3;
            this.printNum = 2;
        }
        
        //going on what they chose, the lottery compare runs
        for(int i = 0; i < numRun; i++)
        {
            //variables for comparing the lotto  
            int []  temp = lotto[i].getLotto();
            String type = lotto[i].getDrawType();
            
            //the first loop, goes from 1-5
            for(int j = 0; j < 5; j++)
            {
                //the nested loop, goes from 1-5
                for(int k = 0; k < 5; k++)
                {
                    //if position j in num equals the lottery at position k
                    if((num[j] == temp[k]) && (type.equalsIgnoreCase("lotto")))
                    {
                        //add to the right guesses for the lottery
                        lineOne = lineOne + 1;
                        //the k counter increases
                    }
                    if((num[j] == temp[k]) && (type.equalsIgnoreCase("plus1")))
                    {
                        //add to the right guesses for plus one
                        lineTwo = lineTwo + 1;
                        //the k counter increases
                    }
                    if((num[j] == temp[k]) && (type.equalsIgnoreCase("plus2")))
                    {
                        //add to the right guesses for plus two
                        lineThree = lineThree + 1;
                        //the k counter increases
                    }
                    
                    //the j counter increases
                }
            }
        }
    }
    
    //the print method
    public void printResults()
    {
        //if they entered lottery, plusOne or plusTwo
        if(printNum <= 2)
        {
            JOptionPane.showMessageDialog(null, "You guessed " + lineOne + " right on the Lottery.");
        }
        
        //if they entered plusOne or plusTwo
        if(printNum >= 1)
        {
            JOptionPane.showMessageDialog(null, "You guessed " + lineTwo + " right on Plus1.");
        }
        
        //if they entered plusTwo
        if(printNum == 2)
        {
            JOptionPane.showMessageDialog(null, "You guessed " + lineThree+ " right on Plus2.");
        }
    }
}