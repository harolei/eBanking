import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
/**
 * Created with IntelliJ IDEA.
 * User: leiyu
 * Date: 12-12-28
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */

//VS4E -- DO NOT REMOVE THIS LINE!
public class Administrator extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JLabel jLabel0;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JTextField accountNoText;
    private JButton jButton1;
    private JButton jButton0;
    private JTextField balanceText;
    private DBConnection connection;

    public Administrator() {
        initComponents();
        connection = new DBConnection();
    }

    private void initComponents() {
        setTitle("Administrator");
        setLayout(new GroupLayout());
        add(getJLabel0(), new Constraints(new Leading(27, 10, 10), new Leading(24, 10, 10)));
        add(getJLabel2(), new Constraints(new Leading(27, 12, 12), new Leading(99, 10, 10)));
        add(getJLabel1(), new Constraints(new Leading(27, 12, 12), new Leading(69, 12, 12)));
        add(getJButton1(), new Constraints(new Leading(262, 12, 12), new Leading(157, 10, 10)));
        add(getJButton0(), new Constraints(new Leading(188, 12, 12), new Leading(157, 12, 12)));
        add(getJTextField0(), new Constraints(new Leading(139, 198, 10, 10), new Leading(65, 12, 12)));
        add(getJTextField1(), new Constraints(new Leading(139, 198, 12, 12), new Leading(99, 12, 12)));
        setSize(361, 216);
    }

    private JTextField getJTextField1() {
        if (balanceText == null) {
            balanceText = new JTextField();
            balanceText.setText("");
        }
        return balanceText;
    }

    private JButton getJButton0() {
        if (jButton0 == null) {
            jButton0 = new JButton();
            jButton0.setText("Add");
            jButton0.addActionListener(this);
        }
        return jButton0;
    }

    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("Cancel");
            jButton1.addActionListener(this);
        }
        return jButton1;
    }

    private JTextField getJTextField0() {
        if (accountNoText == null) {
            accountNoText = new JTextField();
            accountNoText.setText("");
        }
        return accountNoText;
    }

    private JLabel getJLabel1() {
        if (jLabel1 == null) {
            jLabel1 = new JLabel();
            jLabel1.setText("Account Number:");
        }
        return jLabel1;
    }

    private JLabel getJLabel2() {
        if (jLabel2 == null) {
            jLabel2 = new JLabel();
            jLabel2.setText("Balance:");
        }
        return jLabel2;
    }

    private JLabel getJLabel0() {
        if (jLabel0 == null) {
            jLabel0 = new JLabel();
            jLabel0.setText("Add an account to e-Banking System:");
        }
        return jLabel0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add")){
            String accountNo = this.accountNoText.getText();
            int balance = Integer.parseInt(this.balanceText.getText());
            boolean result = false;
            try {
                result = connection.addAccount(accountNo, balance);
            } catch (SQLException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            JFrame parent = new JFrame();
            if(result){
                JOptionPane.showMessageDialog(parent, "New account has been added successfully!");
            }
            else{
                JOptionPane.showMessageDialog(parent, "Add new account failed!");
                this.accountNoText.setText("");
                this.balanceText.setText("");
            }
        }
        if(e.getActionCommand().equals("Cancel")){
            this.dispose();
        }

    }

}

