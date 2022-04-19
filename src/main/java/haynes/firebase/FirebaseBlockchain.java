package haynes.firebase;

import haynes.blockchain.Block;

import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.*;

import java.util.*;
import java.util.concurrent.*;

public class FirebaseBlockchain
{
    //Connects to the online database to add the latest Block to the blockchain
    public static void updateBlockchain(int index,Block block)
    {
        try {
            Firestore db = FirestoreClient.getFirestore();
        
            CollectionReference colRef = db.collection("blockchain");
            ApiFuture<WriteResult> future = colRef.document(""+index).set(block);
            FirebaseManager.debitWallet(1);
            System.out.println("Update time : " + future.get().getUpdateTime());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    //Connects to the online database to increase the size of the blockchain by a specified amount
    public static void increaseBlockchainSize(int amount)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection("blockchain").document("size");
        ApiFuture<WriteResult> updateFuture = docRef.update("value",FieldValue.increment(amount));
        System.out.println("Size incremented");
    }
    
    //Connects to the online database to check and return a boolean for if the blockchain already exists
    public static boolean checkBlockchain()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            ApiFuture<DocumentSnapshot> future = db.collection("blockchain").document("0").get();
            DocumentSnapshot document = future.get();
            if (document.exists())
            {
                System.out.println("Blockchain Exists");
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
            return false;
        } catch (ExecutionException ex)
        {
            System.out.println(ex);
            return false;
        }
    }
    
    //Connects to the online database to return the last 2 blocks in the blockchain
    public static String[] getBlockchain(int size)
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            int size2 = size-1;
            
            CollectionReference colRef = db.collection("blockchain");
            ApiFuture<QuerySnapshot> future = colRef.whereEqualTo(FieldPath.documentId(), ""+size2).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for(QueryDocumentSnapshot document : documents)
            {
                String[] dataReceived = new String[5];
                dataReceived[0] = document.getString("hash");
                dataReceived[1] = document.getString("previousHash");
                dataReceived[2] = ""+document.getLong("index");
                dataReceived[3] = document.getString("data");
                dataReceived[4] = ""+document.getLong("timestamp");
                return dataReceived;
            }
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
            return null;
        } catch (ExecutionException ex)
        {
            System.out.println(ex);
            return null;
        }
        return null;
    }
        
    //Connects to the online database to return the current size of the database
    public static long getBlockchainSize()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            ApiFuture<DocumentSnapshot> future = db.collection("blockchain").document("size").get();
            DocumentSnapshot document = future.get();
            
            if (document.exists())
            {
                return document.getLong("value");
            } else {
                Map<String, Object> update = new HashMap<>();
                update.put("value", 0);
                db.collection("blockchain").document("size").set(update);
                return 0;
            }
        } catch (Exception ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    //Connects to the online database to return the latest block in the blockchain
    public static Block getLatestBlock()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            String size = ""+(getBlockchainSize()-1);
            DocumentSnapshot document = db.collection("blockchain").document(size).get().get();
            if (document.exists())
            {
                Block block = document.toObject(Block.class);
                return block;
            } else {
                System.out.println("No Block Found");
                return null;
            }
        } catch (Exception ex)
        {
            System.out.println(ex);
            return null;
        }
    }
    
    //Connects to the online database to return the first block in the blockchain
    public static Block getFirstBlock()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            DocumentSnapshot document = db.collection("blockchain").document("0").get().get();
            return document.toObject(Block.class);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    //Connects to the online database to return a block at a specified index
    public static Block getBlock(int index)
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            DocumentSnapshot document = db.collection("blockchain").document(""+index).get().get();
            if (document.exists())
            {
                return document.toObject(Block.class);
            } else {
                System.out.println("No Block exists at this index");
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
