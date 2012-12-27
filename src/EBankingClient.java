import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

/**
 * Created with IntelliJ IDEA.
 * User: leiyu
 * Date: 12-12-26
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
public class EBankingClient extends JFrame implements ActionListener{
    private static final String HOST = "localhost";
    private static final long serialVersionUID = 1L;
    private JLabel jLabel0;
    private JTabbedPane jTabbedPane0;
    private JPanel jPanel0;
    private JLabel jLabel1;
    private JTextField usernameText;
    private JTextField firstnameText;
    private JTextField lastnameText;
    private JTextField titleText;
    private JTextField addressText;
    private JTextField phoneText;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField emailText;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTable accountTable;
    private JScrollPane jScrollPane0;
    private JButton addAccountBtn;
    private JLabel jLabel8;
    private JTextField newAccountNoText;
    private JButton addBtn;
    private JButton cancelAddBtn;
    private JPanel jPanel4;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JComboBox currentCom;
    private JTextField accountNumText;
    private JButton addConfirmBtn;
    private JButton jButton4;

    public EBankingClient(String username) {
        initComponents();
        //getIntialInfo(username);
        //getAccountInfo(username);
    }

    private void initComponents() {
        setTitle("e-Banking");
        setLayout(new GroupLayout());
        add(getJLabel0(), new Constraints(new Leading(25, 10, 10), new Leading(19, 10, 10)));
        add(getJPanel0(), new Constraints(new Leading(12, 518, 10, 10), new Leading(46, 264, 10, 10)));
        setSize(546, 331);
        this.jPanel4.setVisible(false);
    }

    private JButton getJButton4() {
        if (jButton4 == null) {
            jButton4 = new JButton();
            jButton4.setText("Add");
            jButton4.addActionListener(this);
        }
        return jButton4;
    }

    private JButton getJButton3() {
        if (addConfirmBtn == null) {
            addConfirmBtn = new JButton();
            addConfirmBtn.setText("Add Account");
            addConfirmBtn.addActionListener(this);
        }
        return addConfirmBtn;
    }

    private JTextField getJTextField8() {
        if (accountNumText == null) {
            accountNumText = new JTextField();
        }
        return accountNumText;
    }

    private JComboBox getJComboBox0() {
        if (currentCom == null) {
            currentCom = new JComboBox();
            currentCom.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
            currentCom.setDoubleBuffered(false);
            currentCom.setBorder(null);
        }
        return currentCom;
    }

    private JLabel getJLabel10() {
        if (jLabel10 == null) {
            jLabel10 = new JLabel();
            jLabel10.setText("Payment Amount：");
        }
        return jLabel10;
    }

    private JLabel getJLabel9() {
        if (jLabel9 == null) {
            jLabel9 = new JLabel();
            jLabel9.setText("Current Account：");
        }
        return jLabel9;
    }

    private JPanel getJPanel4() {
        if (jPanel4 == null) {
            jPanel4 = new JPanel();
            jPanel4.setLayout(new GroupLayout());
            jPanel4.add(getJLabel8(), new Constraints(new Leading(18, 10, 10), new Leading(9, 10, 10)));
            jPanel4.add(getJButton2(), new Constraints(new Trailing(12, 396, 396), new Leading(33, 12, 12)));
            jPanel4.add(getJTextField8(), new Constraints(new Bilateral(134, 12, 4), new Leading(7, 12, 12)));
            jPanel4.add(getJButton4(), new Constraints(new Trailing(97, 12, 12), new Leading(33, 12, 12)));
        }
        return jPanel4;
    }

    private JButton getJButton2() {
        if (cancelAddBtn == null) {
            cancelAddBtn = new JButton();
            cancelAddBtn.setText("Cancel");
            cancelAddBtn.addActionListener(this);
        }
        return cancelAddBtn;
    }

    private JButton getJButton1() {
        if (addBtn == null) {
            addBtn = new JButton();
            addBtn.setText("Cancel");
        }
        return addBtn;
    }

    private JTextField getJTextField7() {
        if (newAccountNoText == null) {
            newAccountNoText = new JTextField();
        }
        return newAccountNoText;
    }

    private JLabel getJLabel8() {
        if (jLabel8 == null) {
            jLabel8 = new JLabel();
            jLabel8.setText("Account Number:");
        }
        return jLabel8;
    }

    private JButton getJButton0() {
        if (addAccountBtn == null) {
            addAccountBtn = new JButton();
            addAccountBtn.setText("Confirm");
            addAccountBtn.addActionListener(this);
        }
        return addAccountBtn;
    }

    private JScrollPane getJScrollPane0() {
        if (jScrollPane0 == null) {
            jScrollPane0 = new JScrollPane();
            jScrollPane0.setViewportView(getJTable0());
        }
        return jScrollPane0;
    }

    private JTable getJTable0() {
        if (accountTable == null) {
            accountTable = new JTable();
            accountTable.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Account Number", "Balance", }) {
                private static final long serialVersionUID = 1L;
                Class<?>[] types = new Class<?>[] { Object.class, Object.class, };

                public Class<?> getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            });
        }
        return accountTable;
    }

    private JPanel getJPanel3() {
        if (jPanel3 == null) {
            jPanel3 = new JPanel();
            jPanel3.setLayout(new GroupLayout());
            jPanel3.add(getJLabel9(), new Constraints(new Leading(26, 10, 10), new Leading(18, 10, 10)));
            jPanel3.add(getJLabel10(), new Constraints(new Leading(26, 12, 12), new Leading(60, 10, 10)));
            jPanel3.add(getJComboBox0(), new Constraints(new Leading(160, 287, 10, 10), new Leading(14, 12, 12)));
            jPanel3.add(getJTextField7(), new Constraints(new Leading(160, 286, 12, 12), new Leading(59, 12, 12)));
            jPanel3.add(getJButton1(), new Constraints(new Leading(373, 12, 12), new Leading(107, 10, 10)));
            jPanel3.add(getJButton0(), new Constraints(new Leading(276, 12, 12), new Leading(107, 12, 12)));
        }
        return jPanel3;
    }

    private JPanel getJPanel2() {
        if (jPanel2 == null) {
            jPanel2 = new JPanel();
            jPanel2.setLayout(new GroupLayout());
            jPanel2.add(getJScrollPane0(), new Constraints(new Leading(15, 474, 10, 10), new Leading(8, 77, 10, 10)));
            jPanel2.add(getJPanel4(), new Constraints(new Leading(6, 492, 12, 12), new Leading(144, 70, 10, 10)));
            jPanel2.add(getJButton3(), new Constraints(new Leading(383, 12, 12), new Leading(93, 10, 10)));
        }
        return jPanel2;
    }

    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setVisible(false);
            jPanel1.setLayout(new GroupLayout());
            jPanel1.add(getJLabel1(), new Constraints(new Leading(20, 71, 12, 12), new Leading(12, 19, 12, 12)));
            jPanel1.add(getJTextField0(), new Constraints(new Leading(167, 241, 10, 10), new Leading(10, 12, 12)));
            jPanel1.add(getJTextField1(), new Constraints(new Leading(167, 240, 12, 12), new Leading(38, 12, 12)));
            jPanel1.add(getJTextField2(), new Constraints(new Leading(167, 240, 12, 12), new Leading(66, 12, 12)));
            jPanel1.add(getJTextField3(), new Constraints(new Leading(167, 240, 12, 12), new Leading(94, 12, 12)));
            jPanel1.add(getJTextField4(), new Constraints(new Leading(167, 240, 12, 12), new Leading(122, 12, 12)));
            jPanel1.add(getJTextField5(), new Constraints(new Leading(167, 240, 12, 12), new Leading(150, 12, 12)));
            jPanel1.add(getJLabel2(), new Constraints(new Leading(20, 12, 12), new Leading(38, 12, 12)));
            jPanel1.add(getJLabel3(), new Constraints(new Leading(20, 12, 12), new Leading(66, 12, 12)));
            jPanel1.add(getJLabel4(), new Constraints(new Leading(20, 12, 12), new Leading(94, 12, 12)));
            jPanel1.add(getJLabel5(), new Constraints(new Leading(20, 12, 12), new Leading(122, 12, 12)));
            jPanel1.add(getJLabel6(), new Constraints(new Leading(20, 12, 12), new Leading(150, 12, 12)));
            jPanel1.add(getJTextField6(), new Constraints(new Leading(167, 240, 12, 12), new Leading(178, 12, 12)));
            jPanel1.add(getJLabel7(), new Constraints(new Leading(20, 12, 12), new Leading(178, 12, 12)));
        }
        return jPanel1;
    }

    private JLabel getJLabel7() {
        if (jLabel7 == null) {
            jLabel7 = new JLabel();
            jLabel7.setText("Email:");
        }
        return jLabel7;
    }

    private JTextField getJTextField6() {
        if (emailText == null) {
            emailText = new JTextField();
        }
        return emailText;
    }

    private JLabel getJLabel6() {
        if (jLabel6 == null) {
            jLabel6 = new JLabel();
            jLabel6.setText("Phone Number:");
        }
        return jLabel6;
    }

    private JLabel getJLabel5() {
        if (jLabel5 == null) {
            jLabel5 = new JLabel();
            jLabel5.setText("Address:");
        }
        return jLabel5;
    }

    private JLabel getJLabel4() {
        if (jLabel4 == null) {
            jLabel4 = new JLabel();
            jLabel4.setText("Title:");
        }
        return jLabel4;
    }

    private JLabel getJLabel3() {
        if (jLabel3 == null) {
            jLabel3 = new JLabel();
            jLabel3.setText("Lastname:");
        }
        return jLabel3;
    }

    private JLabel getJLabel2() {
        if (jLabel2 == null) {
            jLabel2 = new JLabel();
            jLabel2.setText("Firstname:");
        }
        return jLabel2;
    }

    private JTextField getJTextField5() {
        if (phoneText == null) {
            phoneText = new JTextField();
        }
        return phoneText;
    }

    private JTextField getJTextField4() {
        if (addressText == null) {
            addressText = new JTextField();
        }
        return addressText;
    }

    private JTextField getJTextField3() {
        if (titleText == null) {
            titleText = new JTextField();
        }
        return titleText;
    }

    private JTextField getJTextField2() {
        if (lastnameText == null) {
            lastnameText = new JTextField();
        }
        return lastnameText;
    }

    private JTextField getJTextField1() {
        if (firstnameText == null) {
            firstnameText = new JTextField();
        }
        return firstnameText;
    }

    private JTextField getJTextField0() {
        if (usernameText == null) {
            usernameText = new JTextField();
        }
        return usernameText;
    }

    private JLabel getJLabel1() {
        if (jLabel1 == null) {
            jLabel1 = new JLabel();
            jLabel1.setText("Username:");
        }
        return jLabel1;
    }

    private JPanel getJPanel0() {
        if (jPanel0 == null) {
            jPanel0 = new JPanel();
            jPanel0.setLayout(new GroupLayout());
            jPanel0.add(getJTabbedPane0(), new Constraints(new Leading(2, 515, 10, 10), new Bilateral(0, 0, 7)));
        }
        return jPanel0;
    }

    private JTabbedPane getJTabbedPane0() {
        if (jTabbedPane0 == null) {
            jTabbedPane0 = new JTabbedPane();
            jTabbedPane0.addTab("User Details", getJPanel1());
            jTabbedPane0.addTab("Account Details", getJPanel2());
            jTabbedPane0.addTab("Withdrawal Money", getJPanel3());
        }
        return jTabbedPane0;
    }

    private JLabel getJLabel0() {
        if (jLabel0 == null) {
            jLabel0 = new JLabel();
            jLabel0.setText("e-Banking System Client");
        }
        return jLabel0;
    }
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
