package haynes.blockchain;

import haynes.firebase.FirebaseBlockchain;
import haynes.firebase.FirebaseManager;

public class Blockchain
{
    private Block[] blocks;
    private int size = 0;
    
    //Constructor method
    public Blockchain()
    {
        blocks = new Block[21000000];
        
        if(FirebaseBlockchain.checkBlockchain())
        {
            size = (int) FirebaseBlockchain.getBlockchainSize();
            for (int i = size-1 ; i < size ; i++)
            {
                String[] arr = FirebaseBlockchain.getBlockchain(size);
                blocks[i] = new Block(Integer.parseInt(arr[2]),Long.parseLong(arr[4]),arr[1],arr[3],arr[0]);
            }
        } else {
            Block genesis = new Block(0,System.currentTimeMillis(),null,"Genisis Block");
            genesis.mineBlock();
            blocks[0] = genesis;
            size++;
        } 
    }
    
    //Return the latest Block from the blockchain
    public Block latestBlock()
    {
        return FirebaseBlockchain.getLatestBlock();
    }
    
    //Return the String value of the latest block from the blockchain
    public String latestBlockStr()
    {
        return FirebaseBlockchain.getLatestBlock().toString();
    }
    
    //Create a new block on the blockchain with custom String transaction data in parameter
    public Block newBlock(String data) 
    {
        Block latestBlock = latestBlock();
        return new Block(latestBlock.getIndex() + 1, System.currentTimeMillis(),latestBlock.getHash(), data);
    }
    
    //Add a block from parameter to the blockchain
    public void addBlock(Block b)
    {
        if(b != null)
        {
            b.mineBlock();
            blocks[size] = b;
            try {
                Block currentBlock = b;
                Block previousBlock = FirebaseBlockchain.getBlock(b.getIndex()-1);
                
                if (isValidNewBlock(currentBlock,previousBlock))
                {
                    FirebaseBlockchain.updateBlockchain(b.getIndex(),b);
                    FirebaseBlockchain.increaseBlockchainSize(1);
                } else {
                    b = newBlock(FirebaseManager.getPendingTransactions());
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    //Checks and returns a boolean for if the first block in the blockchain is valid
    public boolean isFirstBlockValid()
    {
        Block firstBlock = FirebaseBlockchain.getFirstBlock();
        
        if (firstBlock.getIndex() != 0)
        {
            return false;
        }
        
        if (firstBlock.getPreviousHash() != null) {
            return false;
        }
        
        if (firstBlock.getHash() == null || !Block.calculateHash(firstBlock).equals(firstBlock.getHash()))
        {
            return false;
        }
        
        return true;
    }
    
    //Checks and returns a boolean for if the newest block on the blockchain is valid
    public boolean isValidNewBlock(Block newBlock, Block previousBlock) 
    {
        if (newBlock != null  &&  previousBlock != null) 
        {
            if (previousBlock.getIndex() + 1 != newBlock.getIndex()) 
            {
              return false;
            }

            if (newBlock.getPreviousHash() == null || !newBlock.getPreviousHash().equals(previousBlock.getHash())) 
            {
              return false;
            }

            if (newBlock.getHash() == null || !Block.calculateHash(newBlock).equals(newBlock.getHash())) 
            {
              return false;
            }
            return true;
        }
        return false;
      }

    //Checks and returns a boolean for if the entire blockchain is valid
    public boolean isBlockChainValid() 
    {
        if (!isFirstBlockValid()) 
        {
          return false;
        }

        for (int i = 1; i < size; i++) 
        {
            Block currentBlock = FirebaseBlockchain.getBlock(i);
            Block previousBlock = FirebaseBlockchain.getBlock(i-1);

            if (!isValidNewBlock(currentBlock, previousBlock)) 
            {
              return false;
            }
        }
        return true;
    }
}
