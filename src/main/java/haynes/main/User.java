package haynes.main;

public class User
{
    private final String name;
    private final String surname;
    private final String IDNum;
    private final String email;
    private final String password;
    private final String phone;
    private final String username;
    private final String walletAddress;
    
    //Default constructor of a user object
    public User()
    {
        name = "";
        surname = "";
        IDNum = "";
        email = "";
        password = "";
        phone = "";
        username = "";
        walletAddress = "";
    }
    
    //Parameterised constructor of a user object
    public User(String n,String sn, String id, String em, String pw, String p, String u, String wa)
    {
        name = n;
        surname = sn;
        IDNum = id;
        email = em;
        password = pw;
        phone = p;
        username = u;
        walletAddress = wa;
    }
}
