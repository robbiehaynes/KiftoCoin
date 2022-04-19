
package haynes.ui;

import haynes.main.Internet;
import haynes.firebase.FirebaseManager;
import javax.swing.*;

public class LoginUI extends javax.swing.JFrame
{
    //Default constuctor for LoginUI
    public LoginUI()
    {
        initComponents();
        FirebaseManager.initFirebase();
        FirebaseManager.updateHelp("login");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlTopBar = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txfUsernameInput = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        pwfPasswordField = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTopBar.setBackground(new java.awt.Color(0, 255, 153));
        pnlTopBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("KiftoCoin Login");

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopBarLayout = new javax.swing.GroupLayout(pnlTopBar);
        pnlTopBar.setLayout(pnlTopBarLayout);
        pnlTopBarLayout.setHorizontalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
        );
        pnlTopBarLayout.setVerticalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHelp)))
        );

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        txfUsernameInput.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfUsernameInputActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Don't have an account yet?");

        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSignUpActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPassword)
                        .addComponent(lblUsername))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSignUp)
                        .addComponent(jLabel1)
                        .addComponent(btnLogin)
                        .addComponent(txfUsernameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(pwfPasswordField))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txfUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pwfPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSignUp)
                .addGap(27, 27, 27)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfUsernameInputActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txfUsernameInputActionPerformed
    {//GEN-HEADEREND:event_txfUsernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfUsernameInputActionPerformed

    //Method run when Login button is pressed
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        if (Internet.isConnected())
        {
            if (FirebaseManager.login(txfUsernameInput.getText(), new String(pwfPasswordField.getPassword())))
            {
                lblError.setText("Login Complete");
                prepareForSegue();
            } else {
                lblError.setText("Username or Password is incorrect");
            }
        } else {
            lblError.setText("Please check your connection and try again");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    //Method run when SignUp button is pressed
    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSignUpActionPerformed
    {//GEN-HEADEREND:event_btnSignUpActionPerformed
        this.setVisible(false);
        JFrame signupUI = new SignupUI();
        signupUI.setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        // TODO add your handling code here:
        JFrame helpUI = new HelpUI();
        helpUI.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    //Method loads the data from the online database into a local textfile
    private void prepareForSegue()
    {
        FirebaseManager.loadDataLocal(txfUsernameInput.getText());
        
        JFrame homeUI = new HomeUI();
        homeUI.setVisible(true);
        this.dispose();
    }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnHelp;
    javax.swing.JButton btnLogin;
    javax.swing.JButton btnSignUp;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel lblError;
    javax.swing.JLabel lblPassword;
    javax.swing.JLabel lblTitle;
    javax.swing.JLabel lblUsername;
    javax.swing.JPanel pnlTopBar;
    javax.swing.JPasswordField pwfPasswordField;
    javax.swing.JTextField txfUsernameInput;
    // End of variables declaration//GEN-END:variables
}
