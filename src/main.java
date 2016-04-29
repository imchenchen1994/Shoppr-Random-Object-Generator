import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Controller.Controller;
import RandomObjects.RandomObjects;


public class main {
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();

        String fileName = "output";
        Controller controller = new Controller();
        
        //Create a new file with file name of fileName 
        File f = new File(fileName);
        //file size
        long length = 0;
        
        //The file size of 10MB
        int MAX_FILE_SIZE = 1024*1024*10;
        
//        //Prepare the writer for writing to the file
//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter("output.txt", "UTF-8");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        
        System.out.println("Generating random objects...");
        int realNumberCount = 0;
        int alphanumericsCount = 0;
        int alphabeticalCount = 0;
        int integerCount = 0;
        
        try {
//            FileOutputStream fos = new FileOutputStream("output");
//            BufferedOutputStream bw = new BufferedOutputStream(fos);
            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            while(length < MAX_FILE_SIZE){
                //random generating objects
                RandomObjects randomObject = Controller.randomGeneration();
                int type = randomObject.getType();
                if(type>4 || type<1){
                    System.out.println("Error");
                    break;
                }
                switch(type){
                    case 1  : integerCount++;
                                break;
                    case 2  : alphabeticalCount++;
                                break;
                    case 3  : alphanumericsCount++;
                                break;
                    case 4  : realNumberCount++;
                                break;
                }
                length += randomObject.getSize()+2;
                bw.write(randomObject.toString(false));
            }
            RandomObjects randomObject = Controller.randomGeneration();
            int type = randomObject.getType();
            switch(type){
                case 1  : integerCount++;
                            break;
                case 2  : alphabeticalCount++;
                            break;
                case 3  : alphanumericsCount++;
                            break;
                case 4  : realNumberCount++;
                            break;
            }
            //last object without comma 
            bw.write(randomObject.toString(true));
            bw.flush();
            System.out.println("Total " + integerCount + " integers generated");
            System.out.println("Total " + alphabeticalCount + " alphabetical generated");
            System.out.println("Total " + alphanumericsCount + " alphanumerics generated");
            System.out.println("Total " + realNumberCount + " real number generated");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time used: " + totalTime + " ms");
    }
}
