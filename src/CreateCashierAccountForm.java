import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCashierAccountForm extends JFrame {
    public CreateCashierAccountForm() {
        setTitle("Create Cashier Account");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(8, 129, 120));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton createButton = new JButton("Create");
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(new Color(8, 129, 120));
        createButton.setFont(new Font("Arial", Font.PLAIN, 14));
        createButton.setPreferredSize(new Dimension(150, 35));
        createButton.setFocusPainted(false);

        createButton.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("C:\\Users\\HP\\IdeaProjects\\Thepaws\\src\\cashier_accounts.txt", true)) {
                writer.write("Username: " + usernameField.getText() + " | Password: " + new String(passwordField.getPassword()) + "\n");
                JOptionPane.showMessageDialog(this, "Cashier account created successfully!");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + ioException.getMessage());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(8, 129, 120));
        panel.add(Box.createVerticalStrut(30));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(createButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateCashierAccountForm());
    }
}
