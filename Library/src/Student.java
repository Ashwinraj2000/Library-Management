//To store Student Data
import java.util.*;
class Student {
    private String name;
    private int uid;
    private String pass;
    private int bookIDd;
    Student(String name, int uid, String pass,int bookIDd) {
        this.name = name;
        this.uid = uid;
        this.pass = pass;
        this.bookIDd=bookIDd;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return uid;
    }

    public String getPass() {
        return pass;
    }

    public int getBookIDd() {
        return bookIDd;
    }

    public void setBookIDd(int bookIDd) {
        this.bookIDd = bookIDd;
    }
}
