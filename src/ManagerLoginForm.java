import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerLoginForm {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public ManagerLoginForm() {
        frame = new JFrame("Manager Login");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(8, 129, 120));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        customizeButton(loginButton);

        JLabel titleLabel = new JLabel("Manager Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(8, 129, 120));
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(createFieldPanel(usernameLabel, usernameField));
        inputPanel.add(Box.createVerticalStrut(20));
        inputPanel.add(createFieldPanel(passwordLabel, passwordField));
        inputPanel.add(Box.createVerticalStrut(20));
        inputPanel.add(loginButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(8, 129, 120));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(inputPanel);

        frame.getContentPane().add(mainPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    new ManagerMenu().show();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
                }
            }
        });
    }

    private JPanel createFieldPanel(JLabel label, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(8, 129, 120));
        panel.setPreferredSize(new Dimension(300, 50));
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        field.setFont(new Font("Arial", Font.PLAIN, 16));
        field.setPreferredSize(new Dimension(200, 35));
        field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel.add(label);
        panel.add(field);
        return panel;
    }

    private void customizeButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(8, 129, 120));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(150, 40));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManagerLoginForm().show());
    }
}
