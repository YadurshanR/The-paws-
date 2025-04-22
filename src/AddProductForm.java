import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddProductForm extends JFrame {
    public AddProductForm() {
        setTitle("Add Pet Supply");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(8, 129, 120));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField brandField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField stockField = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 10, 10));
        formPanel.setBackground(new Color(8, 129, 120));

        formPanel.add(new JLabel("Product ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Brand:"));
        formPanel.add(brandField);
        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);
        formPanel.add(new JLabel("Price:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Stock:"));
        formPanel.add(stockField);

        JButton addButton = new JButton("Add Product");
        addButton.setBackground(Color.WHITE);
        addButton.setForeground(new Color(8, 129, 120));
        addButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addButton.setPreferredSize(new Dimension(150, 35));
        addButton.setFocusPainted(false);

        addButton.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("C:\\Users\\HP\\IdeaProjects\\Thepaws\\src\\pet_supplies.txt", true)) {
                writer.write(String.format("%-15s%-20s%-15s%-15s%-10s%-10s\n",
                        idField.getText(), nameField.getText(), brandField.getText(),
                        categoryField.getText(), priceField.getText(), stockField.getText()));
                JOptionPane.showMessageDialog(this, "Product added successfully!");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + ioException.getMessage());
            }
        });

        JLabel titleLabel = new JLabel("Add New Pet Supply", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(8, 129, 120));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(formPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(addButton);

        getContentPane().add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddProductForm());
    }
}
