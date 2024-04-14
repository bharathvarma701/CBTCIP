import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Library_management extends JFrame implements ActionListener {
    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField f1, f2, f3, f4, f5, f6;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton,exitButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<String[]>();

    public Library_management() {
        setTitle("Digital Library Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("Book ID");
        l2 = new JLabel("Book Title");
        l3 = new JLabel("Author");
        l4 = new JLabel("Publisher");
        l5 = new JLabel("Year of Publication");
        l6 = new JLabel("Number of Copies");

        f1 = new JTextField(10);
        f2 = new JTextField(20);
        f3 = new JTextField(20);
        f4 = new JTextField(20);
        f5 = new JTextField(10);
        f6 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton=new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10,2));
        panel.add(l1);
        panel.add(f1);
        panel.add(l2);
        panel.add(f2);
        panel.add(l3);
        panel.add(f3);
        panel.add(l4);
        panel.add(f4);
        panel.add(l5);
        panel.add(f5);
        panel.add(l6);
        panel.add(f6);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);


        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String[] book = new String[7];
            book[0] = f1.getText();
            book[1] = f2.getText();
            book[2] = f3.getText();
            book[3] = f4.getText();
            book[4] = f5.getText();
            book[5] = f6.getText();
            books.add(book);
            JOptionPane.showMessageDialog(this, "Book added successfully");
            clearFields();
        }
        else if (e.getSource() == viewButton) {
            String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "Number of Copies"};
            Object[][] data = new Object[books.size()][7];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i)[0];
                data[i][1] = books.get(i)[1];
                data[i][2] = books.get(i)[2];
                data[i][3] = books.get(i)[3];
                data[i][4] = books.get(i)[4];
                data[i][5] = books.get(i)[5];

}
JTable table = new JTable(data, columns);
JScrollPane scrollPane = new JScrollPane(table);
JFrame frame = new JFrame("View Books");
frame.add(scrollPane);
frame.setSize(800, 400);
frame.setVisible(true);
}
else if (e.getSource() == editButton) {
String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
for (int i = 0; i < books.size(); i++) {
if (books.get(i)[0].equals(bookID)) {
String[] book = new String[7];
book[0] = bookID;
book[1] = f2.getText();
book[2] = f3.getText();
book[3] = f4.getText();
book[4] = f5.getText();
book[5] = f6.getText();
books.set(i, book);
JOptionPane.showMessageDialog(this, "Book edited successfully");
clearFields();
return;
}
}
JOptionPane.showMessageDialog(this, "Book not found");
}
else if (e.getSource() == deleteButton) {
String bookID = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
for (int i = 0; i < books.size(); i++) {
if (books.get(i)[0].equals(bookID)) {
books.remove(i);
JOptionPane.showMessageDialog(this, "Book deleted successfully");
clearFields();
return;
}
}
JOptionPane.showMessageDialog(this, "Book not found");
}
else if (e.getSource() == clearButton) {
clearFields();
}
        else if (e.getSource() == exitButton) {
            System.exit(0);
        }
}
    private void clearFields() {
    f1.setText("");
    f2.setText("");
    f3.setText("");
    f4.setText("");
    f5.setText("");
    f6.setText("");
}

public static void main(String[] args) {
    new Library_management();
}
}
