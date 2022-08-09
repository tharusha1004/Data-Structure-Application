package Controller;


import java.util.HashSet;
import java.util.Random;

public class GenerateKey {
    
    private HashSet<Integer> keys = new HashSet<Integer>();
    private Random dice = new Random();

    public int getKey()
    {
        int key = 1+dice.nextInt(100);
            
        while(checkAvailability(key)==true)
        {
            key = 1+dice.nextInt(10);
        }
        if(checkAvailability(key)==false)
        {
            keys.add(key);
            return key;
        }
        return 0;

    }

    public boolean checkAvailability(int key)
    {
        boolean status=false;

        for(int newKey: keys){
            if(key == newKey)
            {
                status = true;
                break;
            }
            else
            {   status = false;
            }
        }
        return status;
    }
}

