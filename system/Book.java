package system;

public class Book {
    public String title;
    public String author;
    public int quantity;
    public String tag;

    public Book(String title, String author, int quantity, String tag) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.tag = tag;
    }

    public void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Stock: " + quantity);
        System.out.println("Preview QR Link: https://preview.example.com/book/" + title.replace(" ", "%20"));
        System.out.println("Tag: " + tag + "\n");
    }
}
