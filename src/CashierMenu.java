import javax.swing.*;
import java.awt.*;

public class CashierMenu {
    private JFrame frame;

    public CashierMenu() {
        frame = new JFrame("Cashier Menu");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(8, 129, 120));

        JButton viewProductsButton = new JButton("View Products");
        JButton addProductsButton = new JButton("Add Pet Supply");
        JButton searchProductsButton = new JButton("Search Pet Supplies");
        JButton logoutButton = new JButton("Logout");

        viewProductsButton.setBackground(Color.WHITE);
        addProductsButton.setBackground(Color.WHITE);
        searchProductsButton.setBackground(Color.WHITE);
        logoutButton.setBackground(Color.WHITE);

        viewProductsButton.setForeground(new Color(8, 129, 120));
        addProductsButton.setForeground(new Color(8, 129, 120));
        searchProductsButton.setForeground(new Color(8, 129, 120));
        logoutButton.setForeground(new Color(8, 129, 120));

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        viewProductsButton.setFont(buttonFont);
        addProductsButton.setFont(buttonFont);
        searchProductsButton.setFont(buttonFont);
        logoutButton.setFont(buttonFont);

        viewProductsButton.setPreferredSize(new Dimension(150, 40));
        addProductsButton.setPreferredSize(new Dimension(150, 40));
        searchProductsButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.setPreferredSize(new Dimension(150, 40));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 20));
        panel.setBackground(new Color(8, 129, 120));

        panel.add(viewProductsButton);
        panel.add(addProductsButton);
        panel.add(searchProductsButton);
        panel.add(logoutButton);

        JLabel titleLabel = new JLabel("Cashier Menu", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        viewProductsButton.addActionListener(e -> new ViewProductsForm());
        addProductsButton.addActionListener(e -> new AddProductForm());
        searchProductsButton.addActionListener(e -> new SearchProductsForm());
        logoutButton.addActionListener(e -> frame.setVisible(false));
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CashierMenu().show());
    }
}
