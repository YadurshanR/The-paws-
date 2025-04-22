import javax.swing.*;
import java.awt.*;

public class HomepageForm {
    private JFrame frame;
    private JButton managerButton;
    private JButton cashierButton;

    public HomepageForm() {
        frame = new JFrame("The Paws Shop");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(8, 129, 120));

        JLabel titleLabel = new JLabel("Welcome to The Paws Shop", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("Your One-Stop Shop for Pet Supplies", JLabel.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitleLabel.setForeground(Color.LIGHT_GRAY);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(new Color(8, 129, 120));
        titlePanel.add(Box.createVerticalStrut(20));
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(10));
        titlePanel.add(subtitleLabel);
        titlePanel.add(Box.createVerticalStrut(30));

        managerButton = new JButton("Manager");
        cashierButton = new JButton("Cashier");

        customizeButton(managerButton);
        customizeButton(cashierButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(new Color(8, 129, 120));
        buttonPanel.add(managerButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(cashierButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(8, 129, 120));
        mainPanel.add(titlePanel);
        mainPanel.add(buttonPanel);

        frame.getContentPane().add(mainPanel);

        managerButton.addActionListener(e -> {
            new ManagerLoginForm().show();
            frame.setVisible(false);
        });

        cashierButton.addActionListener(e -> {
            new CashierLoginForm().show();
            frame.setVisible(false);
        });
    }

    private void customizeButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(8, 129, 120));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(120, 35));
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomepageForm().show());
    }
}
