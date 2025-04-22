import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierLoginForm {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public CashierLoginForm() {
        frame = new JFrame("Cashier Login");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(8, 129, 120));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(8, 129, 120));

        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        loginButton.setFont(buttonFont);
        loginButton.setPreferredSize(new Dimension(150, 40));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("cashier") && password.equals("5678")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    new CashierMenu().show();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 20));
        panel.setBackground(new Color(8, 129, 120));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        JLabel titleLabel = new JLabel("Cashier Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        usernameField.setMargin(new Insets(5, 5, 5, 5));
        passwordField.setMargin(new Insets(5, 5, 5, 5));
    }

    public void show() {
        frame.setVisible(true);
    }
}
