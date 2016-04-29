package Generator;

import java.util.ArrayList;

import RandomObjects.RandomObjects;

//This class implements Generator and generates an random size random number Integer
public class IntegersGenerator implements Generator{

    @Override
    public RandomObjects generate() {
        ArrayList<Character> alphabeticalStrings = new ArrayList<Character>();
        //First generates a staring integer which exclude 0 and 10; 
        int random = randomInt(true); 
        
        //whenever the random number isn't 10, the Integer continue to be generated.
        while(random < 10){
            alphabeticalStrings.add((char) ('0' + random));
            //random generates from 0 to 10;
            random = randomInt(false);
        }
        return new RandomObjects(alphabeticalStrings,1);
    }

    //This method generates an Integer from 1 to 9 or 0 to 10 be the maximum integer to be generated
    //a boolean parameter indicates the maximum where true is 1 to 9, false is 0 to 10
    private int randomInt(boolean first){
        if(first){
            return (int) (Math.random() * 9 + 1); 
        }
        else{
            return (int) (Math.random() * 11);
        }
    }
}
