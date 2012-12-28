/**
 * Created with IntelliJ IDEA.
 * User: leiyu
 * Date: 12-12-26
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

public class ClientLogin extends JFrame implements ActionListener{
    private JLabel jLabel0;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JButton registerBtn;
    private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

    private DBConnection connection;

    public ClientLogin() {
        initComponents();
        connection = new DBConnection();
    }

    private void initComponents() {
        setTitle("Login");
        setLayout(new GroupLayout());
        add(getJLabel0(), new Constraints(new Leading(23, 10, 10), new Leading(24, 10, 10)));
        add(getJLabel1(), new Constraints(new Leading(23, 12, 12), new Leading(64, 10, 10)));
        add(getJLabel2(), new Constraints(new Leading(23, 12, 12), new Leading(103, 10, 10)));
        add(getJTextField0(), new Constraints(new Leading(111, 171, 10, 10), new Leading(62, 12, 12)));
        add(getJPasswordField0(), new Constraints(new Leading(111, 170, 12, 12), new Leading(102, 12, 12)));
        add(getJButton0(), new Constraints(new Leading(23, 12, 12), new Leading(147, 10, 10)));
        add(getJButton1(), new Constraints(new Leading(111, 12, 12), new Leading(147, 12, 12)));
        add(getJButton2(), new Constraints(new Leading(202, 12, 12), new Leading(147, 12, 12)));
        setSize(313, 211);
    }

    private JButton getJButton0() {
        if (loginBtn == null) {
            loginBtn = new JButton();
            loginBtn.setText("Login");
            loginBtn.addActionListener(this);
        }
        return loginBtn;
    }

    private JButton getJButton1() {
        if (cancelBtn == null) {
            cancelBtn = new JButton();
            cancelBtn.setText("Cancel");
            cancelBtn.addActionListener(this);
        }
        return cancelBtn;
    }

    private JButton getJButton2() {
        if (registerBtn == null) {
            registerBtn = new JButton();
            registerBtn.setText("Register");
            registerBtn.addActionListener(this);
        }
        return registerBtn;
    }

    private JTextField getJTextField0() {
        if (usernameText == null) {
            usernameText = new JTextField();
        }
        return usernameText;
    }

    private JPasswordField getJPasswordField0() {
        if (passwordText == null) {
            passwordText = new JPasswordField();
        }
        return passwordText;
    }

    private JLabel getJLabel0() {
        if (jLabel0 == null) {
            jLabel0 = new JLabel();
            jLabel0.setText("Welcome To e-Banking System! Please Log In!");
        }
        return jLabel0;
    }

    private JLabel getJLabel1() {
        if (jLabel1 == null) {
            jLabel1 = new JLabel();
            jLabel1.setText("Username:");
        }
        return jLabel1;
    }

    private JLabel getJLabel2() {
        if (jLabel2 == null) {
            jLabel2 = new JLabel();
            jLabel2.setText("Password:");
        }
        return jLabel2;
    }

    private static void installLnF() {
        try {
            String lnfClassname = PREFERRED_LOOK_AND_FEEL;
            if (lnfClassname == null)
                lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(lnfClassname);
        } catch (Exception e) {
            System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
                    + " on this platform:" + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Register")){
            Register reg = new Register();
            reg.setDefaultCloseOperation(Register.EXIT_ON_CLOSE);
            reg.setTitle("Register");
            reg.getContentPane().setPreferredSize(reg.getSize());
            reg.pack();
            reg.setLocationRelativeTo(null);
            reg.setVisible(true);

            this.dispose();
        }
        if(e.getActionCommand().equals("Login")){
            String username = this.usernameText.getText();
            String password = new String(this.passwordText.getPassword());
            if(username.equals("admin")&&password.equals("admin")){
                Administrator admin = new Administrator();
                admin.setDefaultCloseOperation(EBankingClient.EXIT_ON_CLOSE);
                admin.setTitle("eBanking");
                admin.getContentPane().setPreferredSize(admin.getSize());
                admin.pack();
                admin.setLocationRelativeTo(null);
                admin.setVisible(true);

                this.dispose();
            }
            else{
                boolean log = connection.finduser(username,password);
                JFrame parent = new JFrame();
                if(log){
                    JOptionPane.showMessageDialog(parent, "Welcome!");
                    EBankingClient client = new EBankingClient(username);
                    client.setDefaultCloseOperation(EBankingClient.EXIT_ON_CLOSE);
                    client.setTitle("eBanking");
                    client.getContentPane().setPreferredSize(client.getSize());
                    client.pack();
                    client.setLocationRelativeTo(null);
                    client.setVisible(true);

                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(parent, "Log in failed!");
                    this.usernameText.setText("");
                    this.passwordText.setText("");
                }
            }
        }
    }
    public static void main(String[] args) {
        installLnF();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClientLogin frame = new ClientLogin();
                frame.setDefaultCloseOperation(ClientLogin.EXIT_ON_CLOSE);
                frame.setTitle("ClientLogin");
                frame.getContentPane().setPreferredSize(frame.getSize());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}
