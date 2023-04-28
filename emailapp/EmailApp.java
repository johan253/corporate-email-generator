package emailapp;

public class EmailApp {
    public static void main(String [] theArgs){
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());
    }
}