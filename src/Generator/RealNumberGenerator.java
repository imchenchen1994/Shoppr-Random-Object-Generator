package Generator;

import java.util.ArrayList;

import RandomObjects.RandomObjects;


//This class will generate a random size of real number 
public class RealNumberGenerator implements Generator{

    @Override
    public RandomObjects generate() {
        ArrayList<Character> realNumber = new ArrayList<Character>();
        
        //Generates the first number of the real number
        int random = randomIntFirst();
        
        //Random Generates the numbers before decimal seperator if the random number isn't 10
        while(random < 10){
            realNumber.add((char) ('0' +random));
            //Generates number from 0 to 10
            random = randomInt(false);
        }
        //Decimal Seperator
        realNumber.add('.');
        //Generates the number just after decimal seperator which is from 0 to 9
        random = randomInt(true);
        
        //Random Generates the numbers after decimal seperator if the random number isn't 10
        while(random < 10){
            realNumber.add((char) ('0' +random));
            
            //Generates number from 0 to 10
            random = randomInt(false);
        }
     
        return new RandomObjects(realNumber,4);
        
    }
    
    //Random generates number from 1 to 9
    private int randomIntFirst(){
        return (int) (Math.random() * 9 + 1);

    }
    
    //Random generates number from 0 to 9 if parameter is true or 0 to 10 if parameter is false
    private int randomInt(boolean first){
        if(first){
            return (int) (Math.random() * 10); 
        }
        else{
            return (int) (Math.random() * 11);
        }
    }
    
}
