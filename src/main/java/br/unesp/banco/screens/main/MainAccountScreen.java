package br.unesp.banco.screens.main;


import br.unesp.banco.core.ui.JFrameLoader;
import br.unesp.banco.core.ui.JFrameManager;
import br.unesp.banco.core.ui.Screen;
import br.unesp.banco.screens.login.LoginScreen;
import br.unesp.banco.screens.statement.StatementScreen;

import javax.swing.*;

public class MainAccountScreen extends Screen {
    private JButton bankStatementButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JPanel bodyPanel;
    private JPanel PainelInfo;
    private JLabel contaNameLabel;
    private JPanel mainPanel;
    private JPanel painelBts;
    private JButton exitButton;

    public MainAccountScreen(JFrameManager frameManager) {
        super(frameManager);
        contaNameLabel.setText(String.format("Conta: %s", this.getFrameManager().getUserCredentials().getAccountNumber()));

        exitButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), LoginScreen.class, "Login"));
        bankStatementButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), StatementScreen.class, "Extrato"));
    }

    @Override
    public void addStyle() {

    }

    @Override
    public JPanel getMainPanel() {
        return bodyPanel;
    }

}
