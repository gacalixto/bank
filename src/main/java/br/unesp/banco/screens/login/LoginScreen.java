package br.unesp.banco.screens.login;

import br.unesp.banco.app.account.Account;
import br.unesp.banco.app.account.AccountFacade;
import br.unesp.banco.app.primitives.usercredentials.UserCredentials;
import br.unesp.banco.core.ui.JFrameLoader;
import br.unesp.banco.core.ui.JFrameManager;
import br.unesp.banco.core.ui.Screen;
import br.unesp.banco.screens.main.MainAccountScreen;
import br.unesp.banco.screens.openaccount.OpenAccountScreen;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoginScreen extends Screen {
    private JTextField accountInput;
    private JPanel mainPanel;
    private JLabel accountLabel;
    private JButton loginButton;
    private JPasswordField passwordInput;
    private JButton openAccountButton;
    private JLabel errorMessage;


    public LoginScreen(JFrameManager frameManager) {
        super(frameManager);
        loginButton.addActionListener(e -> {
            String number = accountInput.getText();
            String password = new String(passwordInput.getPassword());

            AccountFacade accountFacade = (AccountFacade) getFrameManager().getFacades().get("account");

            try {
                Account account = accountFacade.login(number, password);
                System.out.println(account);
                getFrameManager().setUserCredentials(new UserCredentials(number, account.getId()));
                JFrameLoader.load(getFrameManager(), MainAccountScreen.class, MainAccountScreen.WIDTH, MainAccountScreen.HEIGHT, "ATM");
            } catch (Exception exception) {
                errorMessage.setText(exception.getMessage());
            }
        });

        openAccountButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), OpenAccountScreen.class, "Abrir uma nova conta"));
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void addStyle() {
        // Padding
        accountInput.setSize(accountInput.getWidth(), 100);
        accountInput.setBorder(BorderFactory.createCompoundBorder(
                accountInput.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        passwordInput.setSize(passwordInput.getWidth(), 100);
        passwordInput.setBorder(BorderFactory.createCompoundBorder(
                passwordInput.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-1));
        mainPanel.setEnabled(false);
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        accountLabel = new JLabel();
        accountLabel.setBackground(new Color(-1));
        accountLabel.setEnabled(true);
        accountLabel.setFocusable(true);
        Font accountLabelFont = this.$$$getFont$$$("IBM Plex Sans", -1, 18, accountLabel.getFont());
        if (accountLabelFont != null) accountLabel.setFont(accountLabelFont);
        accountLabel.setForeground(new Color(-16777216));
        accountLabel.setHorizontalTextPosition(0);
        accountLabel.setText("nº da conta");
        accountLabel.putClientProperty("html.disable", Boolean.FALSE);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(accountLabel, gbc);
        loginButton = new JButton();
        loginButton.setActionCommand("");
        loginButton.setBackground(new Color(-14452481));
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(true);
        loginButton.setFocusPainted(false);
        loginButton.setFocusTraversalPolicyProvider(false);
        loginButton.setFocusable(false);
        Font loginButtonFont = this.$$$getFont$$$("IBM Plex Sans", Font.BOLD, 20, loginButton.getFont());
        if (loginButtonFont != null) loginButton.setFont(loginButtonFont);
        loginButton.setForeground(new Color(-1));
        loginButton.setHideActionText(true);
        loginButton.setLabel("Acessar conta");
        loginButton.setMargin(new Insets(20, 20, 20, 20));
        loginButton.setText("Acessar conta");
        loginButton.putClientProperty("hideActionText", Boolean.TRUE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(loginButton, gbc);
        passwordInput = new JPasswordField();
        passwordInput.setBackground(new Color(-1));
        passwordInput.setCaretColor(new Color(-16777216));
        passwordInput.setDisabledTextColor(new Color(-1));
        Font passwordInputFont = this.$$$getFont$$$("IBM Plex Sans", -1, 18, passwordInput.getFont());
        if (passwordInputFont != null) passwordInput.setFont(passwordInputFont);
        passwordInput.setForeground(new Color(-16777216));
        passwordInput.setMargin(new Insets(2, 6, 2, 6));
        passwordInput.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(passwordInput, gbc);
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-1));
        label1.setEnabled(true);
        label1.setFocusable(true);
        Font label1Font = this.$$$getFont$$$("IBM Plex Sans", -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16777216));
        label1.setHorizontalTextPosition(0);
        label1.setText("Senha");
        label1.putClientProperty("html.disable", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(label1, gbc);
        accountInput = new JTextField();
        accountInput.setBackground(new Color(-1));
        accountInput.setCaretColor(new Color(-16777216));
        accountInput.setEditable(true);
        Font accountInputFont = this.$$$getFont$$$("IBM Plex Sans", -1, 18, accountInput.getFont());
        if (accountInputFont != null) accountInput.setFont(accountInputFont);
        accountInput.setForeground(new Color(-16777216));
        accountInput.setMargin(new Insets(2, 6, 2, 6));
        accountInput.setOpaque(true);
        accountInput.setSelectedTextColor(new Color(-15592942));
        accountInput.setSelectionStart(0);
        accountInput.setText("");
        accountInput.putClientProperty("caretWidth", new Integer(2));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(accountInput, gbc);
        openAccountButton = new JButton();
        openAccountButton.setActionCommand("");
        openAccountButton.setBackground(new Color(-1));
        openAccountButton.setBorderPainted(false);
        openAccountButton.setContentAreaFilled(false);
        openAccountButton.setDefaultCapable(false);
        openAccountButton.setFocusPainted(false);
        openAccountButton.setFocusTraversalPolicyProvider(false);
        openAccountButton.setFocusable(true);
        Font openAccountButtonFont = this.$$$getFont$$$("IBM Plex Sans", Font.BOLD, 20, openAccountButton.getFont());
        if (openAccountButtonFont != null) openAccountButton.setFont(openAccountButtonFont);
        openAccountButton.setForeground(new Color(-16777216));
        openAccountButton.setHideActionText(true);
        openAccountButton.setLabel("Abrir uma nova conta");
        openAccountButton.setMargin(new Insets(20, 20, 20, 20));
        openAccountButton.setText("Abrir uma nova conta");
        openAccountButton.putClientProperty("hideActionText", Boolean.TRUE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(openAccountButton, gbc);
        errorMessage = new JLabel();
        Font errorMessageFont = this.$$$getFont$$$("IBM Plex Sans", -1, 18, errorMessage.getFont());
        if (errorMessageFont != null) errorMessage.setFont(errorMessageFont);
        errorMessage.setForeground(new Color(-2555883));
        errorMessage.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(errorMessage, gbc);
        accountLabel.setLabelFor(accountInput);
        label1.setLabelFor(accountInput);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}

