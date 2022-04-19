package haynes.main;

import java.io.*;

public class CustomPrintWriter
{
    //Create a new file with a custom name and contents as Strings
    public static void writeToFile(String contents, String fileName)
    {
        try
        {
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName+".txt"));
            outFile.println(contents);
            outFile.close();
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    //Clear the contents of a file with the provided String name
    public static void wipeFile(String fileName)
    {
        try 
        {
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName+".txt"));
            outFile.println("");
            outFile.close();
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
