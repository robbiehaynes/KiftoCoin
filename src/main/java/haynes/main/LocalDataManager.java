package haynes.main;

import java.io.*;
import java.util.*;

public class LocalDataManager
{
    //This method returns the current balance stored locally
    public static double getBalance()
    {
        try
        {
            Scanner scFile = new Scanner(new File("localWalletData.txt"));
            String adrs,bal="";
            while (scFile.hasNext())
            {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("#");
                adrs = scLine.next();
                bal = scLine.next();
            }
            
            return Double.parseDouble(bal);
        } catch (FileNotFoundException e) {
            return -10;
        }
    }
    
    //This method returns the wallet address of the user stored locally
    public static String getAddress()
    {
        try
        {
            Scanner scFile = new Scanner(new File("localWalletData.txt"));
            String adrs="";
            while (scFile.hasNext())
            {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("#");
                adrs = scLine.next();
            }
            
            return adrs;
        } catch (FileNotFoundException e) {
            return "";
        }
    }
    
    //This method adds a method to be run when the app is closed. In this case, wipes all local data for security/privacy
    public static void addWipeOnCloseMethod()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run()
            {
                System.out.println("In Shutdown Hook");
                CustomPrintWriter.wipeFile("localWalletData");
                CustomPrintWriter.wipeFile("localUserData");
            }
        }, "Shutdown-thread"));
    }
}
