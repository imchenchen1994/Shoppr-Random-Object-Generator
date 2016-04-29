package Controller;

import Generator.AlphabeticalStringsGenerator;
import Generator.AlphanumericsGenerator;
import Generator.Generator;
import Generator.IntegersGenerator;
import Generator.RealNumberGenerator;
import RandomObjects.RandomObjects;

//This class handles the distribution of each objects
public class Controller {
    private double size;
    private static Generator alphabetical =  new AlphabeticalStringsGenerator();
    private static Generator integers = new IntegersGenerator();
    private static Generator alphanumerics = new AlphanumericsGenerator();
    private static Generator realNumber = new RealNumberGenerator();
    
    //Constuctor
    public Controller(){
        
    }
    
    //This method decides which object to be generated using a random number.
    public static RandomObjects randomGeneration(){
        int object = objectTypeRandomGeneration();
        RandomObjects randomObject = null;

        switch(object){
            case 1  : randomObject = integers.generate();
                        break;
            case 2  : randomObject = alphabetical.generate();
                        break;
            case 3  : randomObject = alphanumerics.generate();
                        break;
            case 4  : randomObject = realNumber.generate();
                        break;
        }
        return randomObject;
    }
    
    //This method generates a random number from 1 to 4
    private static int objectTypeRandomGeneration(){
        int random = (int)(Math.random() * 4 + 1);
        return random;
    }
    
    
}
