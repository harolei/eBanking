import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
/**
 * Created with IntelliJ IDEA.
 * User: leiyu
 * Date: 12-12-26
 * Time: 下午4:29
 * To change this template use File | Settings | File Templates.
 */
public class Register extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel jLabel0;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JComboBox titleCom;
    private JTextField jTextField0;
    private JTextField lastnameText;
    private JTextField firstnameText;
    private JTextField addressText;
    private JTextField usernameText;
    private JPasswordField paaswordText;
    private JPasswordField reenterText;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField phoneNoText;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JTextField emailText;
    private JTextField accountNoText;
    private JButton cancelBtn;
    private JButton submitBtn;
    //private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String HOST = "localhost";

    public Register() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Register");
        setLayout(new GroupLayout());
        add(getJLabel0(), new Constraints(new Leading(18, 10, 10), new Leading(19, 10, 10)));
        add(getJTextField0(), new Constraints(new Leading(346, -147, 10, 10), new Leading(109, 12, 12)));
        add(getJLabel10(), new Constraints(new Leading(18, 12, 12), new Leading(49, 12, 12)));
        add(getJLabel11(), new Constraints(new Leading(36, 12, 12), new Leading(71, 10, 10)));
        add(getJLabel1(), new Constraints(new Leading(23, 10, 10), new Leading(181, 10, 10)));
        add(getJLabel2(), new Constraints(new Leading(38, 10, 10), new Leading(211, 12, 12)));
        add(getTitleCom(), new Constraints(new Leading(201, 163, 10, 10), new Leading(195, 10, 10)));
        add(getLastnameText(), new Constraints(new Leading(198, 166, 12, 12), new Leading(263, 10, 10)));
        add(getFirstnameText(), new Constraints(new Leading(197, 166, 12, 12), new Leading(235, 12, 12)));
        add(getAddressText(), new Constraints(new Leading(197, 166, 12, 12), new Leading(291, 10, 10)));
        add(getJLabel3(), new Constraints(new Leading(38, 12, 12), new Leading(237, 10, 10)));
        add(getJLabel4(), new Constraints(new Leading(38, 12, 12), new Leading(265, 10, 10)));
        add(getJLabel5(), new Constraints(new Leading(38, 12, 12), new Leading(293, 10, 10)));
        add(getPhoneNoText(), new Constraints(new Leading(197, 166, 12, 12), new Leading(320, 10, 10)));
        add(getJLabel8(), new Constraints(new Leading(20, 12, 12), new Leading(381, 10, 10)));
        add(getJLabel9(), new Constraints(new Leading(36, 12, 12), new Leading(411, 12, 12)));
        add(getSubmitBtn(), new Constraints(new Leading(186, 92, 10, 10), new Leading(456, 10, 10)));
        add(getUsernameText(), new Constraints(new Leading(198, 166, 12, 12), new Leading(73, 12, 12)));
        add(getPasswordText(), new Constraints(new Leading(198, 166, 12, 12), new Leading(103, 10, 10)));
        add(getReenterText(), new Constraints(new Leading(198, 166, 12, 12), new Leading(137, 12, 12)));
        add(getEmailText(), new Constraints(new Leading(197, 166, 12, 12), new Leading(349, 12, 12)));
        add(getAccountNoText(), new Constraints(new Leading(197, 166, 12, 12), new Leading(409, 12, 12)));
        add(getCancelBtn(), new Constraints(new Leading(288, 10, 10), new Leading(456, 12, 12)));
        add(getJLabel6(), new Constraints(new Leading(36, 12, 12), new Leading(322, 12, 12)));
        add(getJLabel7(), new Constraints(new Leading(38, 12, 12), new Leading(348, 12, 12)));
        add(getJLabel12(), new Constraints(new Leading(36, 12, 12), new Leading(103, 12, 12)));
        add(getJLabel13(), new Constraints(new Leading(33, 12, 12), new Leading(137, 12, 12)));
        setSize(395, 512);
    }

    private JButton getSubmitBtn() {
        if (submitBtn == null) {
            submitBtn = new JButton();
            submitBtn.setText("Submit");
            submitBtn.addActionListener(this);
        }
        return submitBtn;
    }

    private JButton getCancelBtn() {
        if (cancelBtn == null) {
            cancelBtn = new JButton();
            cancelBtn.setText("Cancel");
            cancelBtn.addActionListener(this);
        }
        return cancelBtn;
    }

    private JTextField getAccountNoText() {
        if (accountNoText == null) {
            accountNoText = new JTextField();
        }
        return accountNoText;
    }

    private JPasswordField getReenterText(){
        if (reenterText == null) {
            reenterText = new JPasswordField();
        }
        return reenterText;
    }

    private JPasswordField getPasswordText(){
        if (paaswordText == null) {
            paaswordText = new JPasswordField();
        }
        return paaswordText;
    }

    private JTextField getUsernameText() {
        if (usernameText == null) {
            usernameText = new JTextField();
        }
        return usernameText;
    }

    private JTextField getEmailText() {
        if (emailText == null) {
            emailText = new JTextField();
        }
        return emailText;
    }

    private JLabel getJLabel13() {
        if (jLabel13 == null) {
            jLabel13 = new JLabel();
            jLabel13.setText("Reenter Your Password:");
        }
        return jLabel13;
    }

    private JLabel getJLabel12() {
        if (jLabel12 == null) {
            jLabel12 = new JLabel();
            jLabel12.setText("Password:");
        }
        return jLabel12;
    }

    private JLabel getJLabel11() {
        if (jLabel11 == null) {
            jLabel11 = new JLabel();
            jLabel11.setText("Username:");
        }
        return jLabel11;
    }

    private JLabel getJLabel10() {
        if (jLabel10 == null) {
            jLabel10 = new JLabel();
            jLabel10.setText("Secure Access");
        }
        return jLabel10;
    }

    private JLabel getJLabel9() {
        if (jLabel9 == null) {
            jLabel9 = new JLabel();
            jLabel9.setText("Bank Account Number:");
        }
        return jLabel9;
    }

    private JLabel getJLabel8() {
        if (jLabel8 == null) {
            jLabel8 = new JLabel();
            jLabel8.setText("Financial Details");
        }
        return jLabel8;
    }

    private JLabel getJLabel7() {
        if (jLabel7 == null) {
            jLabel7 = new JLabel();
            jLabel7.setText("Email:");
        }
        return jLabel7;
    }

    private JLabel getJLabel6() {
        if (jLabel6 == null) {
            jLabel6 = new JLabel();
            jLabel6.setText("Phone Number:");
        }
        return jLabel6;
    }

    private JTextField getPhoneNoText() {
        if (phoneNoText == null) {
            phoneNoText = new JTextField();
        }
        return phoneNoText;
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
            jLabel4.setText("Last Name:");
        }
        return jLabel4;
    }

    private JLabel getJLabel3() {
        if (jLabel3 == null) {
            jLabel3 = new JLabel();
            jLabel3.setText("First Name(s):");
        }
        return jLabel3;
    }

    private JTextField getAddressText() {
        if (addressText == null) {
            addressText = new JTextField();
        }
        return addressText;
    }

    private JTextField getFirstnameText() {
        if (firstnameText == null) {
            firstnameText = new JTextField();
        }
        return firstnameText;
    }

    private JTextField getLastnameText() {
        if (lastnameText == null) {
            lastnameText = new JTextField();
        }
        return lastnameText;
    }

    private JTextField getJTextField0() {
        if (jTextField0 == null) {
            jTextField0 = new JTextField();
        }
        return jTextField0;
    }

    private JComboBox getTitleCom() {
        if (titleCom == null) {
            titleCom = new JComboBox();
            titleCom.setModel(new DefaultComboBoxModel(new Object[] { "Mr", "Mrs", "Miss", "Ms", "Other" }));
            titleCom.setDoubleBuffered(false);
            titleCom.setBorder(null);
        }
        return titleCom;
    }

    private JLabel getJLabel2() {
        if (jLabel2 == null) {
            jLabel2 = new JLabel();
            jLabel2.setText("Title:");
        }
        return jLabel2;
    }

    private JLabel getJLabel1() {
        if (jLabel1 == null) {
            jLabel1 = new JLabel();
            jLabel1.setText("Personal Details");
        }
        return jLabel1;
    }

    private JLabel getJLabel0() {
        if (jLabel0 == null) {
            jLabel0 = new JLabel();
            jLabel0.setText("Welcome To e-Banking System! ");
        }
        return jLabel0;
    }
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
