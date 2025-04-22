import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewProductsForm extends JFrame {
    public ViewProductsForm() {
        setTitle("View Pet Supplies");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(8, 129, 120));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE);

        try {
            File file = new File("C:\\Users\\HP\\IdeaProjects\\Thepaws\\src\\pet_supplies.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "No product file found. Please add products first.");
                return;
            }

            Scanner reader = new Scanner(file);
            StringBuilder data = new StringBuilder();

            String header = String.format("%-15s %-20s %-20s %-10s %-10s %-15s\n",
                    "PRODUCT ID", "NAME", "BRAND", "PRICE", "STOCK", "REMAINING STOCK");
            data.append(header);

            boolean isFirstLine = true; // Track first line to avoid adding header again

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();

                // Skip the first line of the file if it's the header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] productDetails = line.split("\\s{2,}");

                if (productDetails.length == 6) {
                    data.append(String.format("%-15s %-20s %-20s %-10s %-10s %-15s\n",
                            productDetails[0], productDetails[1], productDetails[2],
                            productDetails[3], productDetails[4], productDetails[5]));
                }
            }
            reader.close();

            textArea.setText(data.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700, 400));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(8, 129, 120));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(50));

        JLabel titleLabel = new JLabel("Pet Supplies", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel);

        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(scrollPane);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewProductsForm());
    }
}
