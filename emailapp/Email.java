package emailapp;
import java.util.Scanner;

public class Email {
    public final int defaultPasswordLength = 10;
    public final String companySuffix = "mycompany.com";
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternameEmail;

    // constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // call a method asking for the department - return dept
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //call a method that returns a mailbox capacity
        this.mailboxCapacity = 500;
//        System.out.println("Mailbox capacity set to: " + this.mailboxCapacity);

        alternameEmail="";

        //combine fields to make complete email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
//        System.out.println("Your email is :" + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New Worker: " + firstName + ", DEPARTMENT CODES \n 1 for sales\n 2 for development\n 3 for accounting\n 0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){
            return "sales";
        } else if (depChoice == 2){
            return "dev";
        } else if (depChoice == 3){
            return "acct";
        } else {
            return "";
        }
    }

    // geneate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set a mailbox capacity
    public void setMailboxCapacity(int theCapacity) {
        mailboxCapacity = theCapacity;
    }

    // set the altername email
    public void setAlternateEmail(String theAltEmail) {
        this.alternameEmail = theAltEmail;
    }

    // change the password
    public void changePassword(String thePassword) {
        this.password = thePassword;
    }

    //show mailboc capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    //show alternate email
    public String getAlternateEmail() {
        return alternameEmail;
    }

    //show password
    public String getPassword() {
        return this.password;
    }

    //show all information at once
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
