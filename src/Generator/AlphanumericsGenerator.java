package Generator;

import java.util.ArrayList;

import RandomObjects.RandomObjects;

//This class will generate a alphanumerics character array with random size of numbers and alphabets
//Ex: 3 numbers and 2 alphabets will give you total 5 characters : 1a22b
//It is generated using only 1 random number for each character to improve efficientcy.
//
public class AlphanumericsGenerator implements Generator{

    @Override
    public RandomObjects generate() {

        ArrayList<Character> alphanumerics = new ArrayList<Character>();
        
        addSpacesBefore(alphanumerics);
        
        //First random alphanumerics
        int random = randomInt(true); 
        
        //Indicators to make sure there is numbers and alphabet in an alphanumeric object
        boolean numeric = false;
        boolean alphabet = false;
        
        //generates alphabet when the random number is < 26
        //generates numeric number when the random number is < 36
        //keep generating alphabet or numeric number
        //while there is either no numeric or no alphabet or random number < 36
        while(random < 36 || !numeric || !alphabet ){
            if(random < 26){
                alphanumerics.add((char) ('a' + random));
                alphabet = true;
            }
            else if(random < 36){
                alphanumerics.add((char)('0'+ (random - 26)));
                numeric = true;
            }
            random = randomInt(false);
        }
        
        addSpacesAfter(alphanumerics);
        
        return new RandomObjects(alphanumerics,3);
    }
    
    //This method add random 0 to 10 spaces after the actual object
    private void addSpacesAfter(ArrayList<Character> alphanumerics) {
        int randomSpace = (int) (Math.random() * 11);
        for(int i = 0;i < randomSpace;i++){
            alphanumerics.add(' ');
        }
    }

    //This method add random 0 to 10 spaces before the actual object
    private void addSpacesBefore(ArrayList<Character> alphanumerics){
        int randomSpace = (int) (Math.random() * 11);
        
        for(int i = 0;i < randomSpace;i++){
            alphanumerics.add(' ');
        }
    }
        
    //This method generates a random integer from 0 to 35 if it is first
    // and generates 0 to 36 if it is not first
    private int randomInt(boolean first){
        if(first){
            return (int) (Math.random() * 36); 
        }
        else{
            return (int) (Math.random() * 37);
        }
    }

}
