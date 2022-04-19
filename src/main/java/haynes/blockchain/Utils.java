
package haynes.blockchain;

import haynes.firebase.FirebaseManager;
import java.math.*;

public class Utils
{   
    private static final BigInteger max = new BigInteger("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",16);
    private static BigInteger difficulty = FirebaseManager.getDifficulty();
    
    //Returns the BigInteger target value of the blockchain
    public static BigInteger getTarget()
    {
        BigInteger target = max.divide(difficulty);
        return target;
    }
    
    //Sets the new difficulty of the blockchain every x blocks based on the previous index and latest timestamp
    public static void setDifficulty(int index, long timestampNew)
    {
        long timestampOld = FirebaseManager.getPastTimestamp(index);
        long timeBetween = timestampNew-timestampOld;
        double percentUpDown = ((double)timeBetween/225000.0)*100.0;
        long longDiff = difficulty.longValue();
        
        double ratio = 100.0/percentUpDown;
        longDiff = (long)(longDiff*ratio);
        
        difficulty = BigInteger.valueOf(longDiff);
        System.out.println("\n\nDifficulty: "+difficulty+"\n\n");
        FirebaseManager.setDifficulty(difficulty);
    }
}
