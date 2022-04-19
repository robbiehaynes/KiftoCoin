package haynes.ui;

import haynes.main.*;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.*;
import haynes.firebase.FirebaseManager;
import haynes.main.LocalDataManager;
import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.annotation.*;
import javax.swing.*;

public class TransferUI extends javax.swing.JFrame
{
    private String balance;
    private String address;
    
    public TransferUI()
    {
        initComponents();
        
        address = LocalDataManager.getAddress();

        if (Internet.isConnected())
        {
            Firestore db = FirestoreClient.getFirestore();
            FirebaseManager.updateHelp("transfer");

            DocumentReference docRef = db.collection("wallets").document(address);
            
            //This method constantly updates the exchange price with the latest information from the online database
            docRef.addSnapshotListener(new com.google.cloud.firestore.EventListener<DocumentSnapshot>()
            {
                public void onEvent(@Nullable DocumentSnapshot snapshot, @Nullable FirestoreException e)
                {
                    if (e!=null)
                    {
                        System.out.println("Listen Failed");
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
        } else {
            lblError.setText("Please check your connection");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblBalance = new javax.swing.JLabel();
        lblAvailable = new javax.swing.JLabel();
        txfAmount = new javax.swing.JTextField();
        lblWalletAddress = new javax.swing.JLabel();
        txfWalletAddress = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        btnTransfer = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblBalance.setFont(new java.awt.Font("Avenir", 1, 54)); // NOI18N
        lblBalance.setText("Loading...");

        lblAvailable.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        lblAvailable.setText("Available");

        txfAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfAmount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfAmountActionPerformed(evt);
            }
        });

        lblWalletAddress.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        lblWalletAddress.setText("Receiving wallet address");

        txfWalletAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAmount.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        lblAmount.setText("Amount to transfer");

        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTransferActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(lblBalance))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(txfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(lblAmount))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(lblWalletAddress))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(328, 328, 328)
                                .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(359, 359, 359)
                                .addComponent(lblAvailable))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfWalletAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHelp))
                .addGap(76, 76, 76)
                .addComponent(lblBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvailable)
                .addGap(50, 50, 50)
                .addComponent(lblAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWalletAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfWalletAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        // TODO add your handling code here:
        JFrame homeUI = new HomeUI();
        homeUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTransferActionPerformed
    {//GEN-HEADEREND:event_btnTransferActionPerformed
        // TODO add your handling code here:
        String amount = txfAmount.getText();
        if (!txfAmount.getText().equals(""))
        {
            if (Checker.formatCheckNums(txfAmount.getText()))
            {
                if (LocalDataManager.getBalance()>0 && LocalDataManager.getBalance()>Double.parseDouble(txfAmount.getText()))
                {
                    if (!FirebaseManager.firebasePresenceCheck(txfWalletAddress.getText(), "wallets"))
                    {
                        FirebaseManager.addPendingTransaction(address,txfWalletAddress.getText(), Double.parseDouble(txfAmount.getText()));
                        lblError.setForeground(Color.GREEN);
                        lblError.setText("Success!");
                    } else {
                        lblError.setForeground(Color.RED);
                        lblError.setText("Wallet Address does not exist");
                    }
                } else {
                    lblError.setForeground(Color.RED);
                    lblError.setText("You do not have sufficient funds");
                }
            } else {
                lblError.setForeground(Color.RED);
                lblError.setText("Please enter a valid amount");
            }
        } else {
            lblError.setForeground(Color.RED);
            lblError.setText("Please enter an amount to transfer");
        }
    }//GEN-LAST:event_btnTransferActionPerformed

    private void txfAmountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txfAmountActionPerformed
    {//GEN-HEADEREND:event_txfAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfAmountActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpUI helpUI = new HelpUI();
        helpUI.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TransferUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnBack;
    javax.swing.JButton btnHelp;
    javax.swing.JButton btnTransfer;
    javax.swing.JLabel lblAmount;
    javax.swing.JLabel lblAvailable;
    javax.swing.JLabel lblBalance;
    javax.swing.JLabel lblError;
    javax.swing.JLabel lblWalletAddress;
    javax.swing.JTextField txfAmount;
    javax.swing.JTextField txfWalletAddress;
    // End of variables declaration//GEN-END:variables
}
