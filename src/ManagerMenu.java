import javax.swing.*;
import java.awt.*;

public class ManagerMenu {
    private JFrame frame;

    public ManagerMenu() {
        frame = new JFrame("Manager Menu");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(8, 129, 120));

        JButton viewProductsButton = new JButton("View Pet Supplies");
        JButton addProductsButton = new JButton("Add Pet Supply");
        JButton searchProductsButton = new JButton("Search Pet Supplies");
        JButton createCashierButton = new JButton("Create Cashier Account");
        JButton logoutButton = new JButton("Logout");

        customizeButton(viewProductsButton);
        customizeButton(addProductsButton);
        customizeButton(searchProductsButton);
        customizeButton(createCashierButton);
        customizeButton(logoutButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(new Color(8, 129, 120));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(viewProductsButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(addProductsButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(searchProductsButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(createCashierButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(logoutButton);

        JLabel titleLabel = new JLabel("Manager Menu", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(8, 129, 120));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(buttonPanel);

        frame.getContentPane().add(mainPanel);

        viewProductsButton.addActionListener(e -> new ViewProductsForm());
        addProductsButton.addActionListener(e -> new AddProductForm());
        searchProductsButton.addActionListener(e -> new SearchProductsForm());
        createCashierButton.addActionListener(e -> new CreateCashierAccountForm());
        logoutButton.addActionListener(e -> frame.setVisible(false));
    }

    private void customizeButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(8, 129, 120));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setPreferredSize(new Dimension(200, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManagerMenu().show());
    }
}
