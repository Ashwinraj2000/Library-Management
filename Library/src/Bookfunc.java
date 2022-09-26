//class name-Bookfunc.java
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
class Globall{
    static int bkid=4;
}
public class Bookfunc {
    static List<Book> BookList = new ArrayList<>();

    public void addBook(Book book) {
        BookList.add(book);
    }

    //To add book details to a list
    public static void addBookDetails(){
        Scanner sc = new Scanner(System.in);
        Bookfunc m = new Bookfunc();
        System.out.println("Enter the Details of the book");
        System.out.print("Name of the book:");
        String name = sc.next();
        System.out.print("Name of the author:");
        String authname = sc.next();
        int Bookid =Globall.bkid;
        Globall.bkid++;
        System.out.print("Enter book price:");
        int price = sc.nextInt();
        int flag=1;
        m.addBook(new Book(name,authname,price,Bookid,flag));
        System.out.println("Book added Successfully");
        adminmenu();
    }
    public static void fileReport() {//To save the status of books in a file
        String stat1 = "Available";
        String stat2 = "Not Available";
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\acer\\OneDrive\\Desktop\\Filereport\\Report.txt");
            myWriter.write("Book name" + "                  " + "Author name" + "                   " + "Price" + "                 " + "Status\n");
            for (Book book: BookList) {
                if (book.getFlag() == 1) {
                    myWriter.append((book.getBookname() + "\t\t\t\t\t" + book.getAuthorname() + "\t\t\t\t" + book.getPrice() +"\t\t\t\t"+stat1));
                    myWriter.append("\n");
                }
                else{
                    myWriter.append((book.getBookname() + "\t\t\t\t\t" + book.getAuthorname() + "\t\t\t\t\t" + book.getPrice()+"\t\t\t\t"+stat2));
                    myWriter.append("\n");
                }
            }
            myWriter.close();
            }
        catch (IOException e){
            System.out.println("An error occured");
        }
    }
    //Book list to be shown for Admin
    public static void showBook(){
        String status1="Available";
        String status2="Not Available";
        System.out.println("***************************************************************************************************************************");
        System.out.println("Book ID"+"        "+"Book name"+"           "+"Author name"+"             "+"Price"+"           "+"Status");
        System.out.println("***************************************************************************************************************************");
        for (Book book: BookList) {
            if(book.getFlag()==1) {
                System.out.printf("%5d%20s%20s%20s%20s\n",book.getBookid(),book.getBookname(),book.getAuthorname(),book.getPrice(),status1);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }
            else if(book.getFlag()!=1) {
                System.out.printf("%5d%20s%20s%20s%20s\n",book.getBookid(),book.getBookname(),book.getAuthorname(),book.getPrice(),status2);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }
                else
                System.out.println("Book not Available");
        }
        adminmenu();
    }
    //Book List to be shown for Students.
    public static void showBook1(){
        String status1="Available";
        String status2="Not Available";
        System.out.println("***************************************************************************************************************************");
        System.out.println("Book ID"+"        "+"Book name"+"          "+"Author name"+"             "+"Price"+"          "+"Status");
        System.out.println("***************************************************************************************************************************");
        for(Book book: BookList) {
            if(book.getFlag()==1) {
                System.out.printf("%5d%20s%20s%20s%20s\n",book.getBookid(),book.getBookname(),book.getAuthorname(),book.getPrice(),status1);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }
            else if(book.getFlag()!=1) {
                System.out.printf("%5d%20s%20s%20s%20s\n",book.getBookid(),book.getBookname(),book.getAuthorname(),book.getPrice(),status2);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }
            else
                System.out.println("Book not Available");
        }
        Main.studentLogin();
    }
    public static int takeBook(){
        Scanner sc1=new Scanner(System.in);
        int flag = 0;
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("NOTE:Each Student is allowed to take only one book.");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Enter the Book ID:");
        int id=sc1.nextInt();
        for(Book book: BookList) {
            if (book.getBookid() == id && book.getFlag() == 1) {
                book.setFlag(0);
                System.out.println("Book lent sucessfully");
                return id;
            }
        }
        if(flag==0)
            System.out.println("Book not available");
        Main.studentLogin();
        return 0;
    }
    public static void returnBook(int temp) {
        System.out.println("Enter the Book ID to return:");
        int flag=0;
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (Book book : BookList) {
            if (book.getBookid() == id && book.getFlag() == 0 && book.getBookid()==temp) {
                book.setFlag(1);
                flag=1;
            }
        }
        if(flag==1) {
            System.out.println("Book returned Successfully");
            Main.reset();
        }
        else
            System.out.println("Invalid Book Id.");
        Main.studentLogin();
    }
    public static void Menu()
    {
            Scanner sc = new Scanner(System.in);
            System.out.println("**********************************************************************************************************************************");
            System.out.println("\t\t\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM");
            System.out.println("\n1.Admin\n2.Student\n3.Exit\n");
            System.out.println("**********************************************************************************************************************************");
            System.out.println(" ");
            System.out.print("Enter your choice:");
            int mch = sc.nextInt();
            if (mch == 1) {
                admin();
            }
            else if(mch == 2) {
                Main.MENU();
            }
            else if(mch == 3) {
                System.out.println("\n\n");
                System.out.println("\t\tThank you User!");
                System.out.println("\t**********************");
                fileReport();
                System.exit(0);
            }
            else {
                System.out.println("Invalid input");
                Menu();
            }
    }
    //admin login credentials
    static void admin() {
        Scanner sc = new Scanner(System.in);
        String passcode = "1234";
        String Id = "ASHWIN";
        System.out.print("Enter your ID:");
        String adid = sc.next();
        System.out.print("Enter your password:");
        String apass = sc.next();
        if(adid.equals(Id) && apass.equals(passcode)) {
            adminmenu();

        }
        else {
            System.out.println("Invalid password or Id");
            Menu();
        }
    }
    static void adminmenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("***************************************************************");
        System.out.println("\n1.AddBook\n2.REPORT\n3.Exit\n");
        System.out.println("***************************************************************");
        System.out.println(" ");
        System.out.print("Enter your choice:");
        int ch = sc.nextInt();
        if (ch == 1)
            addBookDetails();
        else if (ch == 2) {
            showBook();
        } else {
            Menu();
        }
    }
}

