package helper;

public class Customer {

    private String loginName;
    private String pw;
    private String forename;

    public Customer(
            String loginName,
            String pw,
            String forename
    ) {
        this.loginName = loginName;
        this.pw = pw;
        this.forename = forename;
    }

    public static Customer getBuyerGmbh() {
        return new Customer("TestBuyer", "removed", "Peter");
    }

    public static Customer getSellerGmbh() {
        return new Customer("TestSeller", "removed", "Uwe");
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPw() {
        return pw;
    }

    public String getForename() { return forename; }

}
