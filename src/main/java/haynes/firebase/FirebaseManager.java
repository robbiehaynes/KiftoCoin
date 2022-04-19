package haynes.firebase;

import haynes.main.CustomPrintWriter;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.*;
import com.google.firebase.auth.*;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class FirebaseManager
{          
    private static String helpText = "";
    //Initialize the connection to the online database    
    public static void initFirebase()
    {
        try {
            FileInputStream serviceAccount = new FileInputStream("credentials.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setProjectId("kiftocoin")
            .build();
            if (FirebaseApp.getApps().isEmpty())
            {
                FirebaseApp.initializeApp(options);
            } else {
                System.out.println("Firebase Already Initialized");
            }
        } catch (Exception e)
        {
            System.out.println("File Not Found: "+ e);
        }
    } 

    //Connects to the online database to add specified data
    public static void setData(Map map, String docName) throws InterruptedException, ExecutionException
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection("users").document(docName);
        
        ApiFuture<WriteResult> result = docRef.set(map);
        
        try
        {
            System.out.println("Update time : " + result.get().getUpdateTime());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    //Loads the user information from the database and stores it locally
    public static void loadDataLocal(String username)
    {
        String name = "";
        String surname = "";
        String IDNum = "";
        String email = "";
        String password = "";
        String phone = "";
        String localUsername = "";
        String walletAddress = "";
        double balance = 0.00;
        
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            CollectionReference users = db.collection("users");
            Query queryUsers = users.whereEqualTo("username", username);
            
            ApiFuture<QuerySnapshot> querySnapshot = queryUsers.get();
            
            List<QueryDocumentSnapshot> userDocuments = querySnapshot.get().getDocuments();
            for (DocumentSnapshot document : userDocuments) {
                name = document.getString("name");
                surname = document.getString("surname");
                IDNum = document.getString("IDNum");
                email = document.getString("email");
                password = document.getString("password");
                phone = document.getString("phone");
                localUsername = document.getString("username");
                walletAddress = document.getString("walletAddress");
            }
            
            CollectionReference wallets = db.collection("wallets");
            Query queryWallets = wallets.whereEqualTo("address", walletAddress);
            
            ApiFuture<QuerySnapshot> queryWalletsSnapshot = queryWallets.get();
            
            List<QueryDocumentSnapshot> walletDocuments = queryWalletsSnapshot.get().getDocuments();
            for (DocumentSnapshot document : walletDocuments) {
                balance = document.getDouble("balance"); 
            }
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
        } catch (ExecutionException ex)
        {
            System.out.println(ex);
        }
        
        String localUserToWrite = name+"#"+surname+"#"+IDNum+"#"+email+"#"+password+"#"+phone+"#"+localUsername+"#"+walletAddress;
        String localWalletToWrite = walletAddress+"#"+balance;
        
        CustomPrintWriter.writeToFile(localUserToWrite, "localUserData");
        CustomPrintWriter.writeToFile(localWalletToWrite, "localWalletData");
        
        System.out.println("All Data Written");
    }
    
    //Connects to the online database to create a new user
    public static void createUser(String email,String password,String name, String uid)
    {
        CreateRequest request = new CreateRequest().setDisplayName(name).setEmail(email + "@kiftouser.com").setPassword(password).setUid(uid);
        try
        {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        } catch (Exception ex) {
            System.out.println("Signup Error: "+ex);
        }
    }
    
    //Connects to the online database to check the user's details and allow login
    public static boolean login(String username, String password)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        if (firebasePresenceCheck(username,"users")==false)
        {
            CollectionReference users = db.collection("users");
            Query query = users.whereEqualTo("username", username);
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            String onlinePassword = "";
            
            try
            {
                for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                    onlinePassword = document.getString("password");
                }
            } catch (InterruptedException ex)
            {
                System.out.println(ex);;
            } catch (ExecutionException ex)
            {
                System.out.println(ex);;
            }
            
            if (password.equals(onlinePassword))
            {
                System.out.println("Login Successful");
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("The username does not exist");
            return false;
        }
    }
    
    //Connects to the online database to check whether something already exists in the database
    public static boolean firebasePresenceCheck(String document,String collection)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection(collection).document(document);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        try
        {
            DocumentSnapshot doc = future.get();
            if (doc.exists())
            {
                System.out.println("Document Already Exists");
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    //Connects to the online database to add a new wallet to the database
    public static void createWallet(String address)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection("wallets").document(address);
        
        Map<String,Object> map = new HashMap<>();
        map.put("address", address);
        map.put("balance", 0);
        
        ApiFuture<WriteResult> future = docRef.set(map);
    }
    
    //Connects to the online database to add a specified amount of currency to a wallet
    public static void debitWallet(double amount)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        try
        {
            String walletAddress = "";
            Scanner scFile = new Scanner(new File("localWalletData.txt"));
            while (scFile.hasNext())
            {
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("#");
                walletAddress = scLine.next();
                scLine.close();
            }
            DocumentReference docRef = db.collection("wallets").document(walletAddress);
            ApiFuture<WriteResult> future = docRef.update("balance",FieldValue.increment(amount));

            scFile.close();
        } catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
    
    //Connects to the online database to add complete the pending transactions
    public static void completeTransfers()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = db.collection("pendingTransactions").get();
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            if (!documents.isEmpty())
            {
                for (DocumentSnapshot document : documents)
                {
                    String walletFrom = document.getString("walletFrom");
                    String walletTo = document.getString("walletTo");
                    String amount = ""+document.getDouble("amount");
                    transfer(walletFrom,walletTo,Double.parseDouble(amount));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    //Connects to the online database to transfer currency from one account to another
    public static void transfer(String walletFrom, String walletTo, double amount)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docFromRef = db.collection("wallets").document(walletFrom);
        ApiFuture<WriteResult> futureFrom = docFromRef.update("balance",FieldValue.increment(-amount));

        DocumentReference docToRef = db.collection("wallets").document(walletTo);
        ApiFuture<WriteResult> futureTo = docToRef.update("balance",FieldValue.increment(amount));
    }
    
    //Connects to the online database to check if a transaction is pending
    private static boolean checkIfPending(String walletFrom, String walletTo, double amount)
    {
        boolean flag = false;
        boolean result = true;
        
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = db.collection("pendingTransactions").get();
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            if (documents.isEmpty())
            {
                return false;
            } else {
                for (DocumentSnapshot document : documents)
                {
                    String from = document.getString("walletFrom");
                    String to = document.getString("walletTo");
                    double a = document.getDouble("amount");
                    
                    if(walletFrom.equals(from)&& walletTo.equals(to) && amount==a && flag == false)
                    {
                        flag = true;
                        result = true;
                    } else {
                        result = false;
                    }
                }
                return result;
            } 
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    //Connects to the online database to change the supply and demand of the exchange
    public static void changeSupplyDemand(String type, double amount)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection("exchange").document(type);
        ApiFuture<WriteResult> future = docRef.update("value",FieldValue.increment(amount));
    }
    
    //Connects to the online database to update the exchange price based on supply and demand
    public static void updateExchangePrice()
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference supplyDoc = db.collection("exchange").document("supply");
        DocumentReference demandDoc = db.collection("exchange").document("demand");
        ApiFuture<DocumentSnapshot> supFuture = supplyDoc.get();
        ApiFuture<DocumentSnapshot> demFuture = demandDoc.get();
        
        try
        {
            DocumentSnapshot supplyDocument = supFuture.get();
            DocumentSnapshot demandDocument = demFuture.get();
            
            double supply = supplyDocument.getDouble("value");
            double demand = demandDocument.getDouble("value");
            double price = (double) Math.round((supply/demand)*100)/100;
            ApiFuture<WriteResult> future = db.collection("exchange").document("currentPrice").update("value",price);
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
        } catch (ExecutionException ex)
        {
            System.out.println(ex);
        }
    }
    
    //Connects to the online database to return the current exchange price
    public static double getCurrentPrice()
    {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> future = db.collection("exchange").document("currentPrice").get();
        
        try
        {
            DocumentSnapshot doc = future.get();
            return doc.getDouble("value");
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
            return 0;
        } catch (ExecutionException ex)
        {
            System.out.println(ex);
            return 0;
        }
    }
    
    //Connects to the online database to return pending transactions in the database
    public static String getPendingTransactions()
    {
        String output = "";
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = db.collection("pendingTransactions").get();
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            if (documents.isEmpty())
            {
                return output;
            } else {
                for (DocumentSnapshot document : documents)
                {
                    String walletFrom = document.getString("walletFrom");
                    String walletTo = document.getString("walletTo");
                    String amount = ""+document.getDouble("amount");
                    output=walletFrom+"#"+walletTo+"#"+amount+"#";
                }
                return output;
            } 
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    //Connects to the online database to add a new pending transaction
    public static void addPendingTransaction(String walletFrom, String walletTo, double amount)
    {
        Firestore db = FirestoreClient.getFirestore();
        
        DocumentReference docRef = db.collection("pendingTransactions").document();
        
        Map<String,Object> map = new HashMap<>();
        map.put("walletFrom", walletFrom);
        map.put("walletTo", walletTo);
        map.put("amount", amount);
        
        ApiFuture<WriteResult> future = docRef.set(map);
    }
    
    //Connects to the online database to delete pending transactions
    public static void deletePendingTransactions()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            ApiFuture<QuerySnapshot> future = db.collection("pendingTransactions").limit(10).get();
            int deleted = 0;
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
              document.getReference().delete();
              deleted++;
            }
            if (deleted >= 10) {
              deletePendingTransactions();
            }
        } catch (Exception ex) {
            System.out.println("Error deleting documents: "+ex);
        }
    }
    
    //Connects to the online database to return the timestamp value of specified block
    public static long getPastTimestamp(int id)
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            DocumentSnapshot document = db.collection("blockchain").document(""+(id-15)).get().get();
            return document.getLong("timestamp");
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }
    
    //Connects to the online database to update the difficulty of the blockchain in the database
    public static void setDifficulty(BigInteger difficulty)
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            Map<String,Object> map = new HashMap<>();
            map.put("value", difficulty.longValue());
            ApiFuture<WriteResult> future = db.collection("blockchain").document("difficulty").set(map);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    //Connects to the online database to return the current difficulty of the blockchain
    public static BigInteger getDifficulty()
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            DocumentSnapshot document = db.collection("blockchain").document("difficulty").get().get();
            return BigInteger.valueOf(document.getLong("value"));
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    //Fetches the help text from the database and updates the text to be accessed
    public static void updateHelp(String doc)
    {
        try
        {
            Firestore db = FirestoreClient.getFirestore();
            
            DocumentSnapshot document = db.collection("help").document(doc).get().get();
            helpText = document.getString("text");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    //Returns the value of the help text to another class
    public static String getHelp()
    {
        return helpText;
    }
}
