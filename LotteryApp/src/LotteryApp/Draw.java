package LotteryApp;

/**
 * @author Christopher Kambayi, Emma English, Mahamed Basha, Leandro Silva
 * Date: 24/10/2016
 * Draw.java
 * Version: 2
 */

public class Draw 
{
    //declaring the variables
    private int [] lotto;
    private String drawType;
    private int correct;
    
    //the default constructors
    public Draw()
    {
        lotto = new int[5];
        drawType = "";
        correct = 0;
    }
    
    //the overloaded constructor
    public Draw(int [] nums, String type)
    {
        this.lotto = nums;
        this.drawType = type;    
        correct = 0;
    }

    //setting which type of lottery they chose to do
    public void setDrawType(String drawType) 
    {
        this.drawType = drawType;
    }
    
    //method to generate 5 unique numbers between 1 and 40
    public void generate()
    {
        //declaring the temporary variable to store the generated number
        int temp;
        
        //for the length of the lotto
        for(int i = 0; i < lotto.length; i++)
        {
            //the temporary number is a random number between 1 - 40
            temp = 1 + (int)(Math.random() * 40);
            
            //as long as lotto already contains the temp
            while(temp == lotto[0] || temp == lotto[1] || temp == lotto[2] || temp == lotto[3] || temp == lotto[4])
            {
                //create and store another random number between 1 - 40 in temp
                temp = 1 + (int)(Math.random() * 40);
            }
            
            //if they number isn't within the lotto already, it will be stored
            lotto[i] = temp;
        }
    }
    
    /*the compute method (not sure if this is redundant or not)
    public void compute(int [] num)
    {
        //the loop runs five times
        for(int i = 0; i < 5; i++)
        {
            //the nested loop runs five times
            for(int j = 0; j < 5; j++)
            {
                //if the user guess is the lottery number
                if(num[i] == lotto[j])
                {
                    //increase the number of correct guesses
                    correct = correct + 1;
                }
            }
        }
    }
    */

    //the getters for the lotto and the draw type
    public int[] getLotto() 
    {
        return lotto;
    }

    public String getDrawType() 
    {
        return drawType;
    }
}
