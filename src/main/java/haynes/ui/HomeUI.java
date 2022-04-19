package haynes.ui;

import haynes.main.*;
import haynes.firebase.FirebaseManager;
import haynes.blockchain.Blockchain;

import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.awt.event.*;
import javax.annotation.*;
import javax.swing.*;

public class HomeUI extends javax.swing.JFrame
{
    private boolean isPausedPressed = false;
    private double blocksMined = 0;
    private int kReward = 0;
    private double avgBPM = 0;
    private int milliseconds = 0;
    private int seconds = 0;
    private double minutes = 0;
    private double hours = 0;

    //Default constuctor for the HomeUI class
    public HomeUI()
    {    
        initComponents();
        LocalDataManager.addWipeOnCloseMethod();
        FirebaseManager.updateHelp("home");
        lblAddress.setText("Address: "+LocalDataManager.getAddress().toUpperCase());
        
        btnStop.setVisible(false);
        miningPopup.setVisible(false);
        
        if (Internet.isConnected())
        {
            //Adds a new thread listener to the stop button
            btnStop.addActionListener(new ActionListener()
            {
                //Method run when the button is pressed
                public void actionPerformed(ActionEvent e)
                {
                    milliseconds = 0;
                    seconds=0;
                    minutes=0;
                    hours=0;
                    blocksMined=0;
                    kReward=0;
                    avgBPM=0;
                    isPausedPressed = true;
                    btnMine.setVisible(true);
                    btnStop.setVisible(false);
                    miningPopup.setVisible(false);
                }
            });

            //Adds a new thread listener to the mine button
            btnMine.addActionListener(new ActionListener()
            {
                //Method run when the button is pressed
                public void actionPerformed(ActionEvent e)
                {
                    if (Internet.isConnected())
                    {
                        isPausedPressed = false;
                        btnMine.setVisible(false);
                        btnStop.setVisible(true);
                        miningPopup.setVisible(true);
                        startStopwatch();
                        
                        Blockchain blockchain = new Blockchain();
                        Thread mineThread = new Thread()
                        {
                            public void run()
                            {
                                while(!isPausedPressed)
                                {
                                    if(!Internet.isConnected())
                                    {
                                        lblError.setText("Please connect to the internet");
                                        break;
                                    }
                                    
                                    blockchain.addBlock(blockchain.newBlock(FirebaseManager.getPendingTransactions()));
                                    updateMiningUI();
                                    
                                    if(isPausedPressed)
                                    {
                                        break;
                                    }
                                }
                            }
                        };
                        mineThread.start();
                    } else {
                        lblError.setText("Please connect to the internet");
                    }
                }
            });
            
            String address = LocalDataManager.getAddress();

            Firestore db = FirestoreClient.getFirestore();

            DocumentReference docRef = db.collection("wallets").document(address);
            DocumentReference docRefTwo = db.collection("exchange").document("currentPrice");

            //This method constantly updates the balance with the latest information from the online database
            docRef.addSnapshotListener(new com.google.cloud.firestore.EventListener<DocumentSnapshot>()
            {
                public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException e)
                {
                    if (e!=null)
                    {
                        System.out.println("Listen Failed");
                        lblError.setText("Failed to load data");
                        return;
                    }

                    if (snapshot != null && snapshot.exists())
                    {
                        lblBalance.setText("K "+snapshot.getDouble("balance"));
                        CustomPrintWriter.writeToFile(address+"#"+snapshot.getDouble("balance"), "localWalletData");
                    } else {
                        System.out.println("Current Data: null");
                    }
                }
            });

            //This method constantly updates the exchange price with the latest information from the online database
            docRefTwo.addSnapshotListener(new com.google.cloud.firestore.EventListener<DocumentSnapshot>()
            {
                public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException e)
                {
                    if (e!=null)
                    {
                        System.out.println("Listen Failed");
                        lblError.setText("Failed to load data");
                        return;
                    }

                    if (snapshot != null && snapshot.exists())
                    {
                        lblExchangePrice.setText("K1 = R"+snapshot.getDouble("value"));
                    } else {
                        System.out.println("Current Data: null");
                    }
                }
            });
        } else {
            lblError.setText("Please connect to the internet");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblBalance = new javax.swing.JLabel();
        lblExchangePrice = new javax.swing.JLabel();
        lblAvailable = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        btnTransfer = new javax.swing.JButton();
        btnExchange = new javax.swing.JButton();
        btnMine = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        miningPopup = new javax.swing.JPanel();
        lblBlocksLabel = new javax.swing.JLabel();
        lblKLabel = new javax.swing.JLabel();
        lblTimeLabel = new javax.swing.JLabel();
        lblBPMLabel = new javax.swing.JLabel();
        lblBlocksMined = new javax.swing.JLabel();
        lblKRewarded = new javax.swing.JLabel();
        lblTimeMining = new javax.swing.JLabel();
        lblBPM = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblBalance.setFont(new java.awt.Font("Avenir", 1, 60)); // NOI18N
        lblBalance.setText("Loading...");

        lblExchangePrice.setText("K1 = R1");

        lblAvailable.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        lblAvailable.setText("Available");

        lblAddress.setFont(new java.awt.Font("Avenir", 1, 18)); // NOI18N
        lblAddress.setText("Address: 1MY9NJicCFa89U6oqVHY7xAxuSJJxaV6mY");

        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTransferActionPerformed(evt);
            }
        });

        btnExchange.setText("Exchange");
        btnExchange.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExchangeActionPerformed(evt);
            }
        });

        btnMine.setText("Start Mining");
        btnMine.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMineActionPerformed(evt);
            }
        });

        btnStop.setText("Stop Mining");
        btnStop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStopActionPerformed(evt);
            }
        });

        lblBlocksLabel.setText("Blocks Mined:");

        lblKLabel.setText("K Rewarded:");

        lblTimeLabel.setText("Time Mining:");

        lblBPMLabel.setText("Avg BPM");

        lblBlocksMined.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblBlocksMined.setText("0");

        lblKRewarded.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblKRewarded.setText("0");

        lblTimeMining.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTimeMining.setText("00:00:00");

        lblBPM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblBPM.setText("0");

        javax.swing.GroupLayout miningPopupLayout = new javax.swing.GroupLayout(miningPopup);
        miningPopup.setLayout(miningPopupLayout);
        miningPopupLayout.setHorizontalGroup(
            miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miningPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBlocksLabel)
                    .addComponent(lblKLabel)
                    .addComponent(lblTimeLabel)
                    .addComponent(lblBPMLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimeMining, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(lblKRewarded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBlocksMined, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        miningPopupLayout.setVerticalGroup(
            miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miningPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBlocksLabel)
                    .addComponent(lblBlocksMined))
                .addGap(18, 18, 18)
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKLabel)
                    .addComponent(lblKRewarded))
                .addGap(18, 18, 18)
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimeLabel)
                    .addComponent(lblTimeMining))
                .addGap(18, 18, 18)
                .addGroup(miningPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBPMLabel)
                    .addComponent(lblBPM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bottomPanelLayout.createSequentialGroup()
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
            .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
        );

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAddress)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMine))
                            .addGap(37, 37, 37)
                            .addComponent(btnExchange)
                            .addGap(40, 40, 40)
                            .addComponent(btnTransfer))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblAvailable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblExchangePrice))
                        .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(miningPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(413, 413, 413)))
            .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHelp)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHelp)
                .addGap(77, 77, 77)
                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvailable)
                    .addComponent(lblExchangePrice))
                .addGap(26, 26, 26)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExchange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(miningPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMineActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMineActionPerformed
    {//GEN-HEADEREND:event_btnMineActionPerformed
        // TODO add your handling code here:                
    }//GEN-LAST:event_btnMineActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStopActionPerformed
    {//GEN-HEADEREND:event_btnStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStopActionPerformed

    //Method run when the Transfer button is pressed
    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTransferActionPerformed
    {//GEN-HEADEREND:event_btnTransferActionPerformed
        JFrame transferUI = new TransferUI();
        transferUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferActionPerformed

    //Method run when the Exchange button is pressed
    private void btnExchangeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExchangeActionPerformed
    {//GEN-HEADEREND:event_btnExchangeActionPerformed
        JFrame exchangeUI = new ExchangeUI();
        exchangeUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExchangeActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpUI helpUI = new HelpUI();
        helpUI.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed
    
    //Method run to update the miningUI
    private void updateMiningUI()
    {
        //Finish stopWatch
        blocksMined++;
        lblBlocksMined.setText(""+blocksMined);
        kReward++;
        lblKRewarded.setText(""+kReward);
    }
    
    /*Starts a stopwatch and updates the stopwatch on the miningUI every second.
    Explanation as to why this is in this class can be found in document*/
    private void startStopwatch()
    {
        Thread th = new Thread()
        {
            public void run()
            {
                while (isPausedPressed==false)
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
                        
                        String secString="",minString="",hourString="";
                        
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
                        
                        lblTimeMining.setText(hourString+":"+minString+":"+secString);
                        
                        if (minutes>0 || hours>0)
                        {
                           avgBPM = blocksMined/(minutes+(hours*60));
                        } else {
                            avgBPM = blocksMined;
                        }
                        lblBPM.setText(""+avgBPM);
                        
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }                
            }
        };th.start();
    }
    
    public static void main(String args[])
    {    
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new HomeUI().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel bottomPanel;
    javax.swing.JButton btnExchange;
    javax.swing.JButton btnHelp;
    javax.swing.JButton btnMine;
    javax.swing.JButton btnStop;
    javax.swing.JButton btnTransfer;
    javax.swing.JLabel lblAddress;
    javax.swing.JLabel lblAvailable;
    javax.swing.JLabel lblBPM;
    javax.swing.JLabel lblBPMLabel;
    javax.swing.JLabel lblBalance;
    javax.swing.JLabel lblBlocksLabel;
    javax.swing.JLabel lblBlocksMined;
    javax.swing.JLabel lblError;
    javax.swing.JLabel lblExchangePrice;
    javax.swing.JLabel lblKLabel;
    javax.swing.JLabel lblKRewarded;
    javax.swing.JLabel lblTimeLabel;
    javax.swing.JLabel lblTimeMining;
    javax.swing.JPanel miningPopup;
    // End of variables declaration//GEN-END:variables
}
