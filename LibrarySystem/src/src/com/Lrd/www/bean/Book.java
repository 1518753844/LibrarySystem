package src.com.Lrd.www.bean;

/**
 * @date 2020/2/19-11:29
 */
public class Book {
    private int id;
    private String ISBN;
    private String bookName;
    private String bookCate;
    private int remainingQuantity;
    private int lendOutQty;
    private double price;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCate() {
        return bookCate;
    }

    public void setBookCate(String bookCate) {
        this.bookCate = bookCate;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public int getLendOutQty() {
        return lendOutQty;
    }

    public void setLendOutQty(int lendOutQty) {
        this.lendOutQty = lendOutQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "书籍信息为：\n" +
                "     id:" + id +
                " ISBN:" + ISBN +
                " 书名:" + bookName  +
                " 书类:" + bookCate +
                " 馆内存有量:" + remainingQuantity +
                " 借出量:" + lendOutQty +
                " 价格:" + price +
                " 作者:" + author;
    }
}
