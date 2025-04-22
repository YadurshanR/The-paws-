import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchProductsForm extends JFrame {
    public SearchProductsForm() {
        setTitle("Search Pet Supplies");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(8, 129, 120));

        JTextField searchField = new JTextField();
        add(new JLabel("Enter category to search:"));
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.WHITE);
        searchButton.setForeground(new Color(8, 129, 120));
        searchButton.setFont(new Font("Arial", Font.PLAIN, 14));
        searchButton.setPreferredSize(new Dimension(150, 35));
        searchButton.setFocusPainted(false);

        searchButton.addActionListener(e -> {
            try {
                String category = searchField.getText();
                File file = new File("C:\\Users\\HP\\IdeaProjects\\Thepaws\\src\\pet_supplies.txt");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "No product file found. Please add products first.");
                    return;
                }

                Scanner reader = new Scanner(file);
                StringBuilder found = new StringBuilder();
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    if (line.contains(category)) {
                        found.append(line).append("\n");
                    }
                }

                reader.close();
                if (found.length() > 0) {
                    JTextArea textArea = new JTextArea(found.toString());
                    textArea.setEditable(false);
                    JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Search Results", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No supplies found in category: " + category);
                }
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + ioException.getMessage());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(8, 129, 120));
        panel.add(Box.createVerticalStrut(50));
        panel.add(new JLabel("Enter category to search:"));
        panel.add(searchField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(searchButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchProductsForm());
    }
}
