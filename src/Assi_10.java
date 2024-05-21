abstract class Document {
    private String title;
    private String author;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void generateDocument();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

interface Printable {
    void print();
}

interface Editable {
    void edit();
}

interface Shareable {
    void share();
}

class DocumentImplementation extends Document implements Printable, Editable, Shareable
 {
    public DocumentImplementation(String title, String author) {
        super(title, author);
    }

    @Override
    public void generateDocument() {
        System.out.println("Generating the document: " + getTitle() + " by " + getAuthor());
    }

    @Override
    public void print() {
        System.out.println("Printing the document: " + getTitle());
    }

    @Override
    public void edit() {
        System.out.println("Editing the document: " + getTitle());
    }

    @Override
    public void share() {
        System.out.println("Sharing the document: " + getTitle());
    }
}

public class Assi_10 {
    public static void main(String[] args) {
        DocumentImplementation myDocument = new DocumentImplementation("The Hierarchy of Life", "Omi");

        myDocument.generateDocument();
        myDocument.print();       
        myDocument.edit();     
        myDocument.share();
    }
}