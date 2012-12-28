import java.sql.*;
import java.util.Vector;
/**
 * Created with IntelliJ IDEA.
 * User: leiyu
 * Date: 12-12-27
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public class DBConnection {
    private String dbUrl = "jdbc:mysql://localhost:3306/eBanking?useUnicode=true&characterEncoding=GB2312";
    private String dbUser = "root";
    private String dbPwd = "root";

    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public boolean finduser(String username,String password){
        try {

            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select username,password from user_details where username = '"+username+"'and password = '"+password +"';");
            String dbusername = null;
            String dbpassword = null;
            while(rs.next()){
                dbusername = rs.getString("username");
                dbpassword = rs.getString("password");
            }
            rs.close();
            st.close();
            con.close();
            if(username.equals(dbusername) && password.equals(dbpassword)){
                return true;
            }
            else
                return false;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    public String addUser(Vector<String> userinfo){
        String username = userinfo.elementAt(0);
        String password = userinfo.elementAt(1);
        String title = userinfo.elementAt(2);
        String firstname = userinfo.elementAt(3);
        String lastname = userinfo.elementAt(4);
        String address = userinfo.elementAt(5);
        String phoneNo = userinfo.elementAt(6);
        String email = userinfo.elementAt(7);
        String accountNo = userinfo.elementAt(8);
        String result = null;

        Connection con;
        try {
            con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
            Statement st = con.createStatement();

            ResultSet rt = st.executeQuery("select * from user_details where username='" + username +"';");
            if(rt.next()){
                result = "The username has already been used, please change username!";
            }
            else{

                System.out.print("select * from account_details where account_number='"+accountNo+"';");
                ResultSet rt1 = st.executeQuery("select * from account_details where account_number='"+accountNo+"';");
                if(rt1.next()){

                    int re = st.executeUpdate("insert into user_details(fisrtname,lastname,title,address,phoneNo,email,username,password) "
                            +"values('"+firstname+"','"+lastname+"','"+title+"','"+address+"','"+phoneNo+"','"+email+"','"
                            +username+"','"+password+"');");
                    if(re == 1){
                        System.out.print(re);
                        ResultSet rt2 = st.executeQuery("select user_id from user_details where username='"+username+"';");
                        if(rt2.next()){
                            String userid = rt2.getString("user_id");
                            int res = st.executeUpdate("update account_details set user_id= '" + userid + "' where account_number = '" + accountNo+"';");

                            if(res == 1)
                                result = "OK";
                            else
                                result = "Erorr! Please try again later!";
                        }

                    }
                    else{
                        result = "Erorr! Please try again later!";
                    }
                }
                else{
                    result = "Please enter the right account number!";
                }
            }
            //st.close();
            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean addAccount(String accountNo, int balance) throws SQLException{
        boolean result = false;
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        Statement st = con.createStatement();
        int re = st.executeUpdate("insert into account_details(account_number,balance) values('"+accountNo+"','"+balance+"');");
        if(re ==1)
            result = true;
        else
            result = false;
        st.close();
        con.close();
        return result;
    }

    public Vector<String> getInitialInfo(String username) throws SQLException{
        Vector<String> initialInfo = new Vector<String>();
        String firstname = null;
        String lastname = null;
        String title = null;
        String address = null;
        String phoneNo = null;
        String email = null;
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from user_details where username = '"+username+"';");
        if(rs.next()){
            firstname = rs.getString("fisrtname");
            lastname = rs.getString("lastname");
            title = rs.getString("title");
            address = rs.getString("address");
            phoneNo = rs.getString("phoneNo");
            email = rs.getString("email");
        }
        initialInfo.addElement(firstname);
        initialInfo.addElement(lastname);
        initialInfo.addElement(title);
        initialInfo.addElement(address);
        initialInfo.addElement(phoneNo);
        initialInfo.addElement(email);
        return initialInfo;

    }

    public Vector<String> getAccountInfo(String username) throws SQLException{
        Vector<String> result = new Vector<String>();
        //String userid = null;
        int id = 0;
        String accountNo = null;
        int balance = 0;
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from user_details where username = '"+username+"';");
        if(rs.next()){
            id = rs.getInt("user_id");
        }
        rs.close();
        ResultSet rs1 = st.executeQuery("select * from account_details where user_id= " + id +";");
        while(rs1.next()){
            accountNo = rs1.getString("account_number");
            balance = rs1.getInt("balance");
            result.addElement(accountNo);
            result.addElement(String.valueOf(balance));
        }
        rs1.close();
        st.close();
        con.close();
        return result;
    }

    public String userAddAccount(String username,String newAccount) throws SQLException{
        String result = null;
        int userid = 0;
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        Statement st = con.createStatement();
        ResultSet re = st.executeQuery("select user_id from user_details where username = '"+username+"';");
        if(re.next()){
            userid = re.getInt("user_id");
        }
        re.close();
        ResultSet rt1 = st.executeQuery("select * from account_details where account_number='"+newAccount+"';");
        if(rt1.next())
        {
            int rs = st.executeUpdate("update account_details set user_id = '"+userid+"' where account_number = '"+newAccount+"';");
            if(rs==1){
                result = "OK!Account has been added successfully!";
            }
        }
        else{
            result = "Error! Please enter the right account number!";
        }
        rt1.close();
        st.close();
        con.close();
        return result;
    }

    public String withdrawalMoney(String accountNo,int amount) throws SQLException{
        String result = null;
        int balance = 0;
        int newBalance = 0;
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select balance from account_details where account_number='"+accountNo+"';");
        if(rs.next()){
            balance = rs.getInt("balance");
            newBalance = balance - amount;
            int re = st.executeUpdate("update account_details set balance="+newBalance+" where account_number='"+accountNo+"';");
            if(re==1){
                result = "Success!";
            }
            else{
                result = "Error! Please try later!";
            }
        }
        else{
            result = "Error! Please try later!";
        }
        rs.close();
        st.close();
        con.close();
        return result;
    }
}
