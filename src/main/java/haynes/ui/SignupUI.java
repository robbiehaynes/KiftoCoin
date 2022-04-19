
package haynes.ui;

import haynes.main.*;
import haynes.firebase.FirebaseManager;
import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class SignupUI extends javax.swing.JFrame
{
    Color transparent = new Color(1f,0f,0f,0f);
    private String[] keyArr;

    public SignupUI() {
        initComponents();
        FirebaseManager.updateHelp("signup");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlTopBar = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        pnlLabels = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblIDNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        pnlInputs = new javax.swing.JPanel();
        txfSurnameInput = new javax.swing.JTextField();
        txfNameInput = new javax.swing.JTextField();
        txfIDNumberInput = new javax.swing.JTextField();
        txfEmailInput = new javax.swing.JTextField();
        txfPhoneInput = new javax.swing.JTextField();
        pwfPasswordInput = new javax.swing.JPasswordField();
        pwfConfirmPasswordInput = new javax.swing.JPasswordField();
        txfAgeInput = new javax.swing.JTextField();
        txfUsernameInput = new javax.swing.JTextField();
        pnlConfirms = new javax.swing.JPanel();
        lblCitizenAgreeError = new javax.swing.JLabel();
        lblCitizenConfirm = new javax.swing.JLabel();
        btnConfirmCitizen = new javax.swing.JToggleButton();
        btnSignup = new javax.swing.JButton();
        pnlBottomBar = new javax.swing.JPanel();
        lblOutput = new javax.swing.JLabel();
        pnlErrors = new javax.swing.JPanel();
        lblNameError = new javax.swing.JLabel();
        lblSurnameError = new javax.swing.JLabel();
        lblIDNumberError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPhoneError = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblConfirmPasswordError = new javax.swing.JLabel();
        lblAgeError = new javax.swing.JLabel();
        lblUsernameError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlTopBar.setBackground(new java.awt.Color(0, 255, 153));
        pnlTopBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("KiftoCoin Signup");

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
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTopBarLayout.setVerticalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnHelp))
        );

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblName.setText("Name");

        lblSurname.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSurname.setText("Surname");

        lblIDNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblIDNumber.setText("ID Number");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmail.setText("Email");

        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPhoneNumber.setText("Phone");

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword.setText("Password");

        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblConfirmPassword.setText("Confirm Password");

        lblAge.setText("Age");

        lblUsername.setText("Username");

        javax.swing.GroupLayout pnlLabelsLayout = new javax.swing.GroupLayout(pnlLabels);
        pnlLabels.setLayout(pnlLabelsLayout);
        pnlLabelsLayout.setHorizontalGroup(
            pnlLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLabelsLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pnlLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsername)
                    .addComponent(lblAge)
                    .addComponent(lblConfirmPassword)
                    .addComponent(lblPassword)
                    .addComponent(lblIDNumber)
                    .addComponent(lblSurname)
                    .addComponent(lblName)
                    .addComponent(lblPhoneNumber)
                    .addComponent(lblEmail))
                .addGap(46, 46, 46))
        );
        pnlLabelsLayout.setVerticalGroup(
            pnlLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabelsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(lblSurname)
                .addGap(18, 18, 18)
                .addComponent(lblIDNumber)
                .addGap(18, 18, 18)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(lblPhoneNumber)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addGap(12, 12, 12)
                .addComponent(lblConfirmPassword)
                .addGap(18, 18, 18)
                .addComponent(lblAge)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txfIDNumberInput.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfIDNumberInputActionPerformed(evt);
            }
        });

        txfAgeInput.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfAgeInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputsLayout = new javax.swing.GroupLayout(pnlInputs);
        pnlInputs.setLayout(pnlInputsLayout);
        pnlInputsLayout.setHorizontalGroup(
            pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txfSurnameInput)
                    .addComponent(txfIDNumberInput)
                    .addComponent(txfEmailInput)
                    .addComponent(txfPhoneInput)
                    .addComponent(pwfPasswordInput)
                    .addComponent(pwfConfirmPasswordInput)
                    .addComponent(txfAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfUsernameInput))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlInputsLayout.setVerticalGroup(
            pnlInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txfNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfSurnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfIDNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPhoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwfPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwfConfirmPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        lblCitizenAgreeError.setForeground(new java.awt.Color(255, 0, 0));

        lblCitizenConfirm.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCitizenConfirm.setText("I am a South African Citizen");

        btnConfirmCitizen.setText("Confirm");

        javax.swing.GroupLayout pnlConfirmsLayout = new javax.swing.GroupLayout(pnlConfirms);
        pnlConfirms.setLayout(pnlConfirmsLayout);
        pnlConfirmsLayout.setHorizontalGroup(
            pnlConfirmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlConfirmsLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pnlConfirmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCitizenAgreeError, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConfirmsLayout.createSequentialGroup()
                        .addComponent(lblCitizenConfirm)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        pnlConfirmsLayout.setVerticalGroup(
            pnlConfirmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfirmsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfirmsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCitizenConfirm)
                    .addComponent(btnConfirmCitizen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCitizenAgreeError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnSignup.setText("Signup");
        btnSignup.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSignupActionPerformed(evt);
            }
        });

        pnlBottomBar.setBackground(new java.awt.Color(204, 204, 204));
        pnlBottomBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOutput.setForeground(new java.awt.Color(255, 255, 255));
        lblOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlBottomBarLayout = new javax.swing.GroupLayout(pnlBottomBar);
        pnlBottomBar.setLayout(pnlBottomBarLayout);
        pnlBottomBarLayout.setHorizontalGroup(
            pnlBottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomBarLayout.createSequentialGroup()
                .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnlBottomBarLayout.setVerticalGroup(
            pnlBottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomBarLayout.createSequentialGroup()
                .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblNameError.setForeground(new java.awt.Color(255, 0, 0));

        lblSurnameError.setForeground(new java.awt.Color(255, 51, 0));

        lblIDNumberError.setForeground(new java.awt.Color(255, 51, 0));

        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));

        lblPhoneError.setForeground(new java.awt.Color(255, 0, 0));

        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));

        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));

        lblAgeError.setForeground(new java.awt.Color(255, 0, 0));

        lblUsernameError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlErrorsLayout = new javax.swing.GroupLayout(pnlErrors);
        pnlErrors.setLayout(pnlErrorsLayout);
        pnlErrorsLayout.setHorizontalGroup(
            pnlErrorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPhoneError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIDNumberError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSurnameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlErrorsLayout.createSequentialGroup()
                .addComponent(lblAgeError, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlErrorsLayout.createSequentialGroup()
                .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlErrorsLayout.setVerticalGroup(
            pnlErrorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlErrorsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSurnameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIDNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhoneError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgeError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setText("Already have an account?");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlConfirms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnlErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlConfirms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)))
                .addGap(20, 20, 20)
                .addComponent(pnlBottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfIDNumberInputActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txfIDNumberInputActionPerformed
    {//GEN-HEADEREND:event_txfIDNumberInputActionPerformed

    }//GEN-LAST:event_txfIDNumberInputActionPerformed

    //Method run when Signup Button is pressed
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSignupActionPerformed
    {//GEN-HEADEREND:event_btnSignupActionPerformed
        validateData();
    }//GEN-LAST:event_btnSignupActionPerformed

    private void txfAgeInputActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txfAgeInputActionPerformed
    {//GEN-HEADEREND:event_txfAgeInputActionPerformed

    }//GEN-LAST:event_txfAgeInputActionPerformed

    //Method run when Login Button is pressed
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        this.dispose();
        JFrame loginUI = new LoginUI();
        loginUI.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpUI helpUI = new HelpUI();
        helpUI.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed
    
    //Checks and returns a boolean for if the given name+surname from parameters are valid
    private boolean checkNames(String name, String surname) {
        boolean nameBool,surnameBool;
        
        if (Checker.presenceCheck(name) == true) {
            if (Checker.checkCharacterFormat(name)==true) {
                nameBool=true;
            } else {
                lblNameError.setText("Your name cannot contain special characters");
                nameBool=false;
            }
        } else {
            lblNameError.setText("Please enter a name");
            nameBool=false;
        }
        
        if (Checker.presenceCheck(surname) == true) {
            if (Checker.checkCharacterFormat(surname)==true) {
                surnameBool=true;
            } else {
                lblSurnameError.setText("Your surname cannot contain special characters");
                surnameBool=false;
            }
        } else {
            lblSurnameError.setText("Please enter a surname");
            surnameBool=false;
        }
        
        if (nameBool==true && surnameBool==true) {
            return true;
        } else {
            return false;
        }
    }
    
    //Checks and returns a boolean for if the given ID number from parameters are valid
    private boolean idFormatCheck(String id) {        
        if (Checker.presenceCheck(id) == true && Checker.formatCheckNums(id) == true) {
            if (Checker.lengthCheck(id,13) == true) {
                String dob = id.substring(0, 6);
                int month =  Integer.parseInt(dob.substring(2,4));
                int day = Integer.parseInt(dob.substring(4,6));
                if (month <= 12 && day <= 31) 
                {
                    if (Checker.checkdigits(id))
                    {
                        return true;
                    } else {
                        lblIDNumberError.setText("Please enter a valid ID number");
                        return false;
                    }
                } else {
                    lblIDNumberError.setText("Your ID Number does not contain a valid date");
                    return false;
                }
            } else {
                lblIDNumberError.setText("Your ID Number is not 13 digits long");
                return false;
            }
        } else {
            lblIDNumberError.setText("Please enter a valid ID Number");
            return false;
        }
    }
    
    //Checks and returns a boolean for if the given email from parameters are valid
    private boolean emailFormatCheck(String email) {
        if (Checker.presenceCheck(email)==true) {
            if (email.contains("@") && email.contains(".")) {
                if (email.indexOf("@") < email.indexOf(".")) {
                    return true;
                } else {
                    lblEmailError.setText("Please enter a valid email");
                    return false;
                }
            } else {
                lblEmailError.setText("Please enter a valid email");
                return false;
            }
        } else {
            lblEmailError.setText("Please enter an email");
            return false;
        }       
    }
    
    //Checks and returns a boolean for if the given username from parameters are valid
    private boolean usernameFormatCheck(String username)
    {
        if (Checker.presenceCheck(username) == true)
        {
            if (username.length() > 5)
            {
                if (FirebaseManager.firebasePresenceCheck(username,"users") == true)
                {
                    return true;
                } else {
                    lblUsernameError.setText("That username is taken");
                    return false;
                }
            } else {
                lblUsernameError.setText("Your username must be longer than 5 characters");
                return false;
            }
        } else {
            lblUsernameError.setText("Please enter a username");
            return false;
        }
    }
    
    //Checks and returns a boolean for if the given phone number from parameters are valid
    private boolean phoneFormatCheck(String phone) {
        if (Checker.presenceCheck(phone) == true && Checker.formatCheckNums(phone) == true) {
            if (Checker.lengthCheck(phone,10) == true) {
                if (phone.substring(0, 1).equals("0")) {
                    return true;
                } else {
                    lblPhoneError.setText("Your number should start with a 0");
                    return false;
                }
            } else {
                lblPhoneError.setText("Your number should be 10 digits long");
                return false;
            }            
        } else {
            lblPhoneError.setText("Please enter a valid phone number");
            return false;
        }
    }
    
    //Checks and returns a boolean for if the given password from parameters are valid
    private boolean passwordFormatCheck(String password) {
        if (Checker.presenceCheck(password)) {
            if (Checker.passwordLengthCheck(password)) {
                
                int[] counts = Checker.countPasswordCharacters(password);
                int capitalCount = counts[2];
                int numCount = counts[1];
                int specialCount = counts[0];

                boolean flag = false;
                while(flag == false) {
                    if (capitalCount > 0) {
                        flag = true;
                    } else {                    
                        lblPasswordError.setText("Your password should contain a capital letter");
                        return false;
                    }

                    if (numCount > 0) {
                        flag = true;
                    } else {
                        lblPasswordError.setText("Your password should contain a number");
                        return false;
                    }

                    if (specialCount > 0) {
                        flag = true;
                    } else {
                        lblPasswordError.setText("Your password should contain a special character");
                        return false;
                    }
                }
                confirmPasswordFormatCheck(new String(pwfConfirmPasswordInput.getPassword()));
                return flag;
            } else {
                confirmPasswordFormatCheck(new String(pwfConfirmPasswordInput.getPassword()));
                lblPasswordError.setText("Your password should be at least 8 characters long");
                return false;        
            }
        } else {
            confirmPasswordFormatCheck(new String(pwfConfirmPasswordInput.getPassword()));
            lblPasswordError.setText("Please enter a password");
            return false;
        }
        
    }
    
    //Checks and returns a boolean for if the given password from parameters matches the other password
    private boolean confirmPasswordFormatCheck(String password) {
        if (Checker.presenceCheck(password)==true) {
            if (password.equals(new String(pwfPasswordInput.getPassword()))) {
                return true;
            } else {
                lblConfirmPasswordError.setText("Passwords do not match");
                return false;
            }
        } else {
            lblConfirmPasswordError.setText("Please confirm your password");
            return false;
        }
    }
    
    //Checks and returns a boolean for if the given age from parameters are valid
    private boolean ageCheck(int age) {
        if (Checker.presenceCheck(Integer.toString(age))==true) {
            if (age > 0 && Checker.formatCheckNums(Integer.toString(age))==true) {
                if (age >= 18) {
                    return true;
                } else {
                    lblAgeError.setText("You must be at least 18 years old");
                    return false;
                }
            } else {
                lblAgeError.setText("Please enter a valid age");
                return false;
            }
        } else {
            lblAgeError.setText("Please enter your age");
            return false;
        }
    }
    
    //Checks and returns a boolean for if the user is a SA citizen
    private boolean selectedCitizenCheck() {
        if (btnConfirmCitizen.isSelected() == true) 
        {
            if (txfIDNumberInput.getText().charAt(10)=='0') {
                return true;
            } else {
                lblCitizenAgreeError.setText("Your ID Number says you are not a resident");
            }
            return true;
        } else {
            lblCitizenAgreeError.setText("Please accept this agreement");
            return false;
        }
    }
    
    //Method to wipe the error messages from the labels
    private void updateUI() {
        lblNameError.setText("");
        lblSurnameError.setText("");
        lblIDNumberError.setText("");
        lblEmailError.setText("");
        lblPhoneError.setText("");
        lblPasswordError.setText("");
        lblConfirmPasswordError.setText("");
        lblCitizenAgreeError.setText("");
        lblAgeError.setText("");
    }
    
    //Method to perform all the format checks and update the UI accordingly
    private void validateData() {
        updateUI();
        boolean flag=true;
        
        if (checkNames(txfNameInput.getText(),txfSurnameInput.getText())==false) {
            flag=false;
        }
        if (usernameFormatCheck(txfUsernameInput.getText()) == false)
        {
            flag=false;
        }
        if (idFormatCheck(txfIDNumberInput.getText())==false) {
            flag=false;
        }
        if (emailFormatCheck(txfEmailInput.getText())==false) {
            flag=false;
        }
        if (phoneFormatCheck(txfPhoneInput.getText())==false) {
            flag=false;
        }
        if (passwordFormatCheck(new String(pwfPasswordInput.getPassword()))==false) {
            flag=false;
        }
        if (ageCheck(Integer.parseInt(txfAgeInput.getText()))==false) {
            flag=false;
        }
        if (selectedCitizenCheck()==false) {
            flag=false;
        }
        if (flag==true) {
            pnlBottomBar.setBackground(Color.green);           
            lblOutput.setText("ALL DATA IS VALID");
            
            keyArr = KeyGenerator.generateKeys();
            CustomPrintWriter.writeToFile(keyArr[0], "privateWalletAddress");
            
            if (Internet.isConnected())
            {
                FirebaseManager.createWallet(keyArr[1]);
                uploadToFirebase();
            } else {
                lblOutput.setText("Please check your internet connection");
            }

            this.dispose();
            JFrame loginUI = new LoginUI();
            loginUI.setVisible(true);
        } else {
            pnlBottomBar.setBackground(Color.red);
            lblOutput.setText("DATA IS INVALID. PLEASE SEE ISSUES ABOVE");
        }
    }
    
    //Uploads the user data to the database
    private void uploadToFirebase()
    {       
        
        Map<String, Object> data = new HashMap<>();
        data.put("name", txfNameInput.getText());
        data.put("surname", txfSurnameInput.getText());
        data.put("IDNum", txfIDNumberInput.getText());
        data.put("username", txfUsernameInput.getText());
        data.put("walletAddress", keyArr[1]);
        data.put("email", txfEmailInput.getText());
        data.put("phone", txfPhoneInput.getText());
        data.put("password", new String(pwfPasswordInput.getPassword()));
        
        try
        {
            FirebaseManager.setData(data, txfUsernameInput.getText());
            FirebaseManager.createUser(txfUsernameInput.getText(), new String(pwfPasswordInput.getPassword()), txfNameInput.getText()+" "+txfSurnameInput.getText(), txfUsernameInput.getText());
        } catch (Exception ex)
        {
            System.out.println(ex);
            lblOutput.setText("Error uploading data");
        }
    }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new SignupUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConfirmCitizen;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgeError;
    private javax.swing.JLabel lblCitizenAgreeError;
    private javax.swing.JLabel lblCitizenConfirm;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblIDNumber;
    private javax.swing.JLabel lblIDNumberError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblPhoneError;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblSurnameError;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameError;
    private javax.swing.JPanel pnlBottomBar;
    private javax.swing.JPanel pnlConfirms;
    private javax.swing.JPanel pnlErrors;
    private javax.swing.JPanel pnlInputs;
    private javax.swing.JPanel pnlLabels;
    private javax.swing.JPanel pnlTopBar;
    private javax.swing.JPasswordField pwfConfirmPasswordInput;
    private javax.swing.JPasswordField pwfPasswordInput;
    private javax.swing.JTextField txfAgeInput;
    private javax.swing.JTextField txfEmailInput;
    private javax.swing.JTextField txfIDNumberInput;
    private javax.swing.JTextField txfNameInput;
    private javax.swing.JTextField txfPhoneInput;
    private javax.swing.JTextField txfSurnameInput;
    private javax.swing.JTextField txfUsernameInput;
    // End of variables declaration//GEN-END:variables
}
