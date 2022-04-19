package haynes.ui;

import haynes.main.*;
import haynes.firebase.FirebaseManager;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ExchangeUI extends javax.swing.JFrame
{
    //Default UI constructor method
    public ExchangeUI()
    {
        initComponents();
        FirebaseManager.updateExchangePrice();
        FirebaseManager.updateHelp("exchange");
        lblCurrentPrice.setText("K1 = R"+FirebaseManager.getCurrentPrice());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblCurrentPrice = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txfAmount = new javax.swing.JTextField();
        btnBuy = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Avenir", 0, 18)); // NOI18N
        lblHeader.setText("Current Price");

        lblCurrentPrice.setFont(new java.awt.Font("Avenir", 1, 70)); // NOI18N
        lblCurrentPrice.setText("Loading...");

        lblAmount.setFont(new java.awt.Font("Avenir", 0, 18)); // NOI18N
        lblAmount.setText("Amount");

        txfAmount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfAmountActionPerformed(evt);
            }
        });

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuyActionPerformed(evt);
            }
        });

        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSellActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 205, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblHeader)
                                .addGap(335, 335, 335))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSell)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuy))
                                    .addComponent(lblCurrentPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txfAmount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(265, 265, 265))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAmount)
                .addGap(359, 359, 359))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHelp))
                .addGap(80, 80, 80)
                .addComponent(lblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentPrice)
                .addGap(60, 60, 60)
                .addComponent(lblAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Method run when the back button is pressed
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        // TODO add your handling code here:
        JFrame homeUI = new HomeUI();
        homeUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    //Method run when Buy button is pressed
    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuyActionPerformed
    {//GEN-HEADEREND:event_btnBuyActionPerformed
        // TODO add your handling code here:
        if (checkBuyAmount())
        {
            if(Internet.isConnected())
            {
                FirebaseManager.changeSupplyDemand("demand", Double.parseDouble(txfAmount.getText()));
                FirebaseManager.updateExchangePrice();
                purchaseCoins(Double.parseDouble(txfAmount.getText()));
            } else {
                lblError.setText("Please connect to the internet");
            }
        }
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSellActionPerformed
    {//GEN-HEADEREND:event_btnSellActionPerformed
        // TODO add your handling code here:
        if (checkSellAmount())
        {
            if (Internet.isConnected())
            {
                FirebaseManager.changeSupplyDemand("demand", -Double.parseDouble(txfAmount.getText()));
                FirebaseManager.updateExchangePrice();
                sellCoins(Double.parseDouble(txfAmount.getText()));
            } else {
                lblError.setText("Please connect to the internet");
            }
        }
    }//GEN-LAST:event_btnSellActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpUI helpUI = new HelpUI();
        helpUI.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void txfAmountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txfAmountActionPerformed
    {//GEN-HEADEREND:event_txfAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfAmountActionPerformed

    private double getBalance()
    {
        if (LocalDataManager.getBalance() != -10)
        {
            return LocalDataManager.getBalance();
        } else {
            lblError.setText("Error loading data. Data file not found");
            return 0;
        }
    }
    
    private boolean checkSellAmount()
    {
        if (!txfAmount.getText().equals(""))
        {
            if (Checker.formatCheckNums(txfAmount.getText()))
            {
                if (getBalance()>0 && getBalance()>=Double.parseDouble(txfAmount.getText()))
                {
                    lblError.setForeground(Color.GREEN);
                    lblError.setText("Success!");
                    return true;
                } else {
                    lblError.setForeground(Color.RED);
                    lblError.setText("You do not have sufficient funds");
                    return false;
                }
            } else {
                lblError.setForeground(Color.RED);
                lblError.setText("Please enter a valid amount");
                return false;
            }
        } else {
            lblError.setForeground(Color.RED);
            lblError.setText("Please enter an amount");
            return false;
        }
    }
    
    private boolean checkBuyAmount()
    {
        if (!txfAmount.getText().equals(""))
        {
            if (Checker.formatCheckNums(txfAmount.getText()))
            {
                lblError.setForeground(Color.GREEN);
                lblError.setText("Success!");
                return true;
            } else {
                lblError.setForeground(Color.RED);
                lblError.setText("Please enter a valid amount");
                return false;
            }
        } else {
            lblError.setForeground(Color.RED);
            lblError.setText("Please enter an amount");
            return false;
        }
    }
    
    private void sellCoins(double amount)
    {
        FirebaseManager.debitWallet(-amount);
    }
    
    private void purchaseCoins(double amount)
    {
        FirebaseManager.debitWallet(amount);
    }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ExchangeUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnBack;
    javax.swing.JButton btnBuy;
    javax.swing.JButton btnHelp;
    javax.swing.JButton btnSell;
    javax.swing.JLabel lblAmount;
    javax.swing.JLabel lblCurrentPrice;
    javax.swing.JLabel lblError;
    javax.swing.JLabel lblHeader;
    javax.swing.JTextField txfAmount;
    // End of variables declaration//GEN-END:variables

}
