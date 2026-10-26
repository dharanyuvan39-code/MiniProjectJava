import java.util.*;
import javax.swing.*;

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    public String toString() {
        return id + " - " + title + (issued ? " (Issued)" : " (Available)");
    }
}

public class LibrarySystem {
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            String menu = JOptionPane.showInputDialog(
                "📚 Library System\n\n" +
                "1. Add Member\n" +
                "2. View Members\n" +
                "3. Add Book\n" +
                "4. View Books\n" +
                "5. Issue Book\n" +
                "6. Return Book\n" +
                "7. Exit\n\n" +
                "Enter choice:"
            );

            if (menu == null) break;

            int choice = Integer.parseInt(menu);

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    addBook();
                    
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    static void addMember() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Member ID:"));
        String name = JOptionPane.showInputDialog("Enter Member Name:");
        members.add(new Member(id, name));
        JOptionPane.showMessageDialog(null, "✅ Member Added!");
    }

    static void viewMembers() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No members found.");
            return;
        }
        String data = "";
        for (Member m : members) {
            data += m + "\n";
        }
        JOptionPane.showMessageDialog(null, data);
    }

    static void addBook() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID:"));
        String title = JOptionPane.showInputDialog("Enter Book Title:");
        books.add(new Book(id, title));
        JOptionPane.showMessageDialog(null, "📘 Book Added!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books available.");
            return;
        }
        String data = "";
        for (Book b : books) {
            data += b + "\n";
        }
        JOptionPane.showMessageDialog(null, data);
    }

    static void issueBook() {
        int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to Issue:"));

        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.issued) {
                    b.issued = true;
                    JOptionPane.showMessageDialog(null, "📕 Book Issued!");
                } else {
                    JOptionPane.showMessageDialog(null, "Already Issued!");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found!");
    }

    static void returnBook() {
        int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to Return:"));

        for (Book b : books) {
            if (b.id == bookId) {
                if (b.issued) {
                    b.issued = false;
                    JOptionPane.showMessageDialog(null, "📗 Book Returned!");
                } else {
                    JOptionPane.showMessageDialog(null, "Book was not issued!");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found!");
    }
}