
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import io.github.cdimascio.dotenv.Dotenv;







public class Login extends javax.swing.JFrame {

  
    private SecretKey secretKey; // Store the secret key for encryption/decryption

    public Login() {
        try {
            secretKey = SecureEncryption.generateSecretKey(); // Generate a new secret key
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating key: " + e.getMessage());
        }
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFrame1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setPreferredSize(new java.awt.Dimension(800, 500));

        JFrame1.setBackground(new java.awt.Color(255, 255, 255));
        JFrame1.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("I don't have an account");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JFrame1Layout = new javax.swing.GroupLayout(JFrame1);
        JFrame1.setLayout(JFrame1Layout);
        JFrame1Layout.setHorizontalGroup(
            JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFrame1Layout.createSequentialGroup()
                .addGroup(JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JFrame1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(JFrame1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1)
                                .addComponent(jLabel3)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        JFrame1Layout.setVerticalGroup(
            JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFrame1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(JFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
  
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                        
        String email = jTextField1.getText().trim();
        String password = new String(jPasswordField1.getPassword()).trim();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        // Call the method to validate credentials
        if (validateUser(email, password)) {
            JOptionPane.showMessageDialog(this, "Sign in successful!");

            // Open the TransactionDetails window
            TransactionDetails transactionDetails = new TransactionDetails();
            transactionDetails.setVisible(true);
            transactionDetails.pack();
            transactionDetails.setLocationRelativeTo(null);

            // Close the Login window
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.");
        }


    
   
    }//GEN-LAST:event_jButton1ActionPerformed

private boolean validateUser(String email, String password) {
    Dotenv dotenv = Dotenv.load();
    String url = dotenv.get("DB_URL");  // Database URL
    String user = dotenv.get("DB_USER");  
    String dbPassword =  dotenv.get("DB_PASSWORD");  // Database password

    // SQL query to fetch the user with the provided email
    String selectSQL = "SELECT password, iv, secret_key FROM public.users WHERE email = ?";

    try (Connection conn = DriverManager.getConnection(url, user, dbPassword);
         PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Retrieve the encrypted password and IV
            String encryptedPassword = rs.getString("password"); // Assuming it's stored as a Base64 string
            byte[] iv = rs.getBytes("iv"); // Retrieve the IV
            byte[] securityKeyBytes = rs.getBytes("secret_key"); // Retrieve the security key

            // Convert the security key from byte array to SecretKey
            SecretKeySpec secretKeySpec = new SecretKeySpec(securityKeyBytes, 0, securityKeyBytes.length, "AES");

            // Decrypt the stored password
            String decryptedPassword = SecureEncryption.decrypt(encryptedPassword, secretKeySpec, iv);

            // Compare the decrypted password with the input password
            return password.equals(decryptedPassword);
        }
    } catch (Exception e) {
        // Show the error message to the user
        JOptionPane.showMessageDialog(this, "Failed to connect to the database: " + e.getMessage());
        // Log the exception for debugging
        e.printStackTrace(); // Better for debugging
    }
    return false; // Invalid credentials
}


 

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JFrame1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

