package br.unesp.banco.screens.main;


import br.unesp.banco.core.ui.JFrameLoader;
import br.unesp.banco.core.ui.JFrameManager;
import br.unesp.banco.core.ui.Screen;
import br.unesp.banco.screens.deposit.DepositScreen;
import br.unesp.banco.screens.login.LoginScreen;
import br.unesp.banco.screens.statement.StatementScreen;
import br.unesp.banco.screens.withdraw.WithdrawScreen;

import javax.swing.*;


public class MainAccountScreen extends Screen {
    private JButton bankStatementButton;
    private JPanel bodyPanel;
    private JPanel PainelInfo;
    private JLabel welcome;
    private JPanel mainPanel;
    private JPanel painelBts;
    private JButton exitButton;
    private JButton transferButton;
    private JButton withdrawButton;
    private JButton depositButton;

    public final static int WIDTH = 700;
    public final static int HEIGHT = 450;

    public MainAccountScreen(JFrameManager frameManager) {
        super(frameManager);

        exitButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), LoginScreen.class, "Login"));
        bankStatementButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), StatementScreen.class, "Extrato"));

        withdrawButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), WithdrawScreen.class, 700, 500,  "Saque"));
        depositButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), DepositScreen.class, 700, 500,  "Deposito"));
    }

    @Override
    public void addStyle() {
    }

    @Override
    public JPanel getMainPanel() {
        return bodyPanel;
    }

}
