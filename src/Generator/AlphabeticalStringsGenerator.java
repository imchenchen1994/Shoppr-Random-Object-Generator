package Generator;

import java.util.ArrayList;

import RandomObjects.RandomObjects;

//This class implements Generator and generates an random size of random alphabets

public class AlphabeticalStringsGenerator implements Generator{

    @Override
    public RandomObjects generate() {
        ArrayList<Character> alphabeticalStrings = new ArrayList<Character>();
        int random = randomInt(true); 
        while(random < 26){
            alphabeticalStrings.add((char) ('a' + random));
            random = randomInt(false);
        }
        
        return new RandomObjects(alphabeticalStrings,2);
    }

    //Random generates number from 0 to 25 if parameter is true or 0 to 26 if parameter is false
    private int randomInt(boolean first){
        if(first){
            return (int) (Math.random() * 26); 
        }
        else{
            return (int) (Math.random() * 27);
        }
    }

}
