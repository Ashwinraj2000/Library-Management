//file name-Book.java
class Book {
    private String Bookname;
    private String Authorname;
    private int price;
    private int Bookid;
    private int Flag;

    Book(String Bookname, String Authorname, int price, int Bookid,int flag) {
        this.Bookname = Bookname;
        this.Authorname=Authorname;
        this.price=price;
        this.Bookid=Bookid;
        this.Flag=flag;
    }

    public String getBookname() {
        return Bookname;
    }

    public String getAuthorname() {
        return Authorname;
    }

    public int getPrice() {
        return price;
    }

    public int getBookid() {
        return Bookid;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }
}
