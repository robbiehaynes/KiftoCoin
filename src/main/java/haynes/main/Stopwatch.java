package haynes.main;

public class Stopwatch
{
    public static boolean stop = true;
    private static int milliseconds = 0;
    private static int seconds = 0;
    private static double minutes = 0;
    private static double hours = 0;
    private static String secString="",minString="",hourString="";
    
    public static void start()
    {
        Thread th = new Thread()
        {
            public void run()
            {
                while (stop==false)
                {
                    try
                    {
                        sleep(1);
                        milliseconds++;
                        if(milliseconds==1000)
                        {
                            seconds++;
                            milliseconds=0;
                        }
                        if(seconds==60)
                        {
                            minutes++;
                            seconds=0;
                        }
                        if(minutes==60)
                        {
                            hours++;
                            minutes=0;
                        }
                        
                        int secCount = String.valueOf((int)seconds).length();
                        int minCount = String.valueOf((int)minutes).length();
                        int hourCount = String.valueOf((int)hours).length();

                        if(secCount>1)
                        {
                            secString=""+seconds;
                        } else {
                            secString="0"+seconds;
                        }
                        if(minCount>1)
                        {
                            minString=""+(int)minutes;
                        } else {
                            minString="0"+(int)minutes;
                        }
                        if(hourCount>1)
                        {
                            hourString=""+(int)hours;
                        } else {
                            hourString="0"+(int)hours;
                        }
                        
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }                
            }
        };th.start();
    }
    
    public static void stop()
    {
        stop = true;
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secString = "";
        minString = "";
        hourString = "";
    }
    
    public static String getHour()
    {
        return hourString;
    }
    
    public static String getMin()
    {
        return minString;
    }
    
    public static String getSec()
    {
        return secString;
    }
}
