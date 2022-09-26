//class name-Main.java
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Globally{
    static String student="";
    static int Bookidd=0;
    static int stdidd=1001;
}
public class Main {
    static List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }
    static void checkStudent(String name,String pass,int id) {
        int flag = 0;
        for (Student student : studentList) {
            if ((student.getName().equals(name))&& student.getPass().equals(pass)&&student.getRoll()==id) {
                System.out.println("! ! Login successful ! !");
                Globally.student=student.getName();
                flag = 1;
                studentLogin();
            }
        }
        if (flag == 0) {
            System.out.println("----Login Unsuccessful----");
            MENU();
        }
    }
    static void enterDetails(){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        System.out.println("Enter the Details of the students");
        System.out.print("Name:");
        String name = sc.next();
        System.out.print("password:");
        String pass = sc.next();
        int bookidd=-1;
        System.out.println("Your unique Id is:"+Globally.stdidd);
        int uid =Globally.stdidd;
        Globally.stdidd++;
        m.addStudent(new Student(name,uid,pass,bookidd));
    }
    public static void MENU(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Student signup.\n2.Student Login.\n3.exit");
        System.out.println(" ");
        System.out.print("Enter your choice:");
        int ch=sc.nextInt();
        if(ch==1) {
            enterDetails();
            System.out.println("Account created successfully.");
            System.out.println(" ");
            MENU();
        }
        else if(ch==2)
        {
            System.out.println("**** LOGIN ****");
            System.out.print("Enter your Id:");
            int cId=sc.nextInt();
            System.out.print("Enter your name:");
            String cname=sc.next();
            System.out.print("Enter your password:");
            String pass=sc.next();
            checkStudent(cname,pass,cId);
            studentLogin();
        }
        else {
            Bookfunc.Menu();
        }
    }
    static void change(){
        for (Student student : studentList){
            if(student.getName().equals(Globally.student))
                student.setBookIDd(Globally.Bookidd);
        }
        studentLogin();
    }
    static void reset(){
        for (Student student : studentList){
            if(student.getName().equals(Globally.student))
                student.setBookIDd(0);
        }
        studentLogin();
    }
    static void studentLogin() {
        Bookfunc bf=new Bookfunc();
        Scanner sc=new Scanner(System.in);
        System.out.println("************************************************************************************************");
        System.out.println("\n1.View Book\n2.Issue Book\n3.Return book\n4.LogOut\n");
        System.out.println("************************************************************************************************");
        System.out.println("\n");
        System.out.print("Enter your choice:");
        int ch1=sc.nextInt();
        if(ch1==1)
        {
            Bookfunc.showBook1();
            studentLogin();
        }
        else if(ch1==2) {
            int flag = 1;
            for (Student student : studentList) {
                if (Globally.student.equals(student.getName())) {
                    if (student.getBookIDd() > 0) {
                        System.out.println("\n!!! You have exceeded your Limit !!!\n\n");
                        flag = 0;
                        studentLogin();
                    }
                }
            }
            if (flag == 1) {
                System.out.println("**** Issue Book ****");
                Globally.Bookidd = Bookfunc.takeBook();
                change();
            }
        }
        else if(ch1==3)
        {
            int tempidd=0;
            for(Student student : studentList) {
                if(student.getName().equals(Globally.student)){
                   tempidd=student.getBookIDd();
                }
            }
           Bookfunc.returnBook(tempidd);
        }
        else {
            System.out.println("$$ Logged out Successfully $$");
            System.out.println(" ");
            MENU();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bookfunc m = new Bookfunc();
        m.addBook(new Book("C++","E.Balagurusamy",100,1,1));
        m.addBook(new Book("Java","KathySeierra",260,2,1));
        m.addBook(new Book("Python","K.Brian",980,3,1));
        Bookfunc.Menu();
    }
}
