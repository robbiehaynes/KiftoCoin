package haynes.blockchain;

import haynes.firebase.FirebaseBlockchain;
import haynes.firebase.FirebaseManager;

import java.math.BigInteger;
import java.security.*;

//Custom Block object that link together to form the blockchain
public class Block
{
    private int index;
    private long timestamp;
    private String hash;
    private String previousHash;
    private String data;
    private int nonce;
    
    //Constructor without a custom hash
    public Block(int index, long timestamp, String previousHash, String data)
    {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = FirebaseBlockchain.getLatestBlock().getHash();
        this.data = data;
        nonce = 0;
        hash = Block.calculateHash(this);
    }
    
    //Constructor with a custom hash
    public Block(int index, long timestamp, String previousHash, String data, String hash)
    {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = FirebaseBlockchain.getLatestBlock().getHash();
        this.data = data;
        nonce = 0;
        this.hash = hash;
    }
    
    //Default Constructor
    public Block()
    {
        index = getIndex();
        timestamp = getTimestamp();
        previousHash = getPreviousHash();
        data = getData();
        hash = getHash();
    }
    
    //Return the index of the current block
    public int getIndex() 
    {
        return index;
    }

    //Return the long timestamp of when the current block was mined
    public long getTimestamp() 
    {
        return timestamp;
    }

    //Return the String hash of the current block
    public String getHash() 
    {
      return hash;
    }

    //Return the String hash of the previous block in the chain
    public String getPreviousHash() 
    {
      return previousHash;
    }

    //Return the String transaction data stored in the current block
    public String getData() 
    {
      return data;
    }
    
    //Return a String value for attributes of the block
    public String str() 
    {
        return index + timestamp + previousHash + data + nonce;
    }
    
    //toString method for a Block object
    public String toString()
    {
        String string = "Block #"+index+
                "[previousHash: "+previousHash+
                ", timestamp: "+timestamp+
                ", data: "+data+
                ", hash: "+hash+
                ", nonce: "+nonce+"]";
        return string;
    }
    
    //Calculate and return the hash of the block provided in parameters 
    public static String calculateHash(Block block)
    {
        if(block != null)
        {
            MessageDigest digest = null;
            
            try {
                digest = MessageDigest.getInstance("SHA3-256");
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
                return null;
            }
            
            String txt = block.str();
            final byte bytes[] = digest.digest(txt.getBytes());
            final StringBuilder builder = new StringBuilder();
			
            for (final byte b : bytes) {
              String hex = Integer.toHexString(0xff & b);

              if (hex.length() == 1) {
                builder.append('0');
              }

              builder.append(hex);
            }

            return builder.toString();
        }
        
        return null;
    }
    
    //Attempt to mine the current block
    public void mineBlock() {
        nonce = 0;

        while (toBigInt(getHash()).compareTo(Utils.getTarget())==1) 
        {
           nonce++;
           hash = Block.calculateHash(this);
        }
        
        if(index%15==0)
        {
            Utils.setDifficulty(index, timestamp);
        }
        
        try
        {
            FirebaseManager.completeTransfers();
            FirebaseManager.deletePendingTransactions();
            FirebaseManager.changeSupplyDemand("supply", 1);
            FirebaseManager.updateExchangePrice();
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Successful Hash: "+hash);
    }
    
    //Return the BigInteger equivalent of a string hash in the parameter
    private BigInteger toBigInt(String s)
    {
        return new BigInteger(s,16);
    }
}
