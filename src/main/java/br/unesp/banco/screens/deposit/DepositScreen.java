package br.unesp.banco.screens.deposit;

import br.unesp.banco.app.account.Account;
import br.unesp.banco.app.account.AccountFacade;
import br.unesp.banco.app.primitives.money.Money;
import br.unesp.banco.app.transaction.TransactionFacade;
import br.unesp.banco.core.ui.JFrameLoader;
import br.unesp.banco.core.ui.JFrameManager;
import br.unesp.banco.core.ui.Popup;
import br.unesp.banco.core.ui.Screen;
import br.unesp.banco.screens.login.LoginScreen;
import br.unesp.banco.screens.main.MainAccountScreen;

import javax.swing.*;


    public class DepositScreen extends Screen {
        private JPanel bodyPanel;
        private JPanel painelBts;
        private JPanel mainPanel;
        private JTextField valueInput;
        private JLabel withdrawLabel;
        private JButton backButton;
        private JLabel errorMessage;
        private JButton confirmButton;

        public final static int WIDTH = 700;
        public final static int HEIGHT = 450;

        public DepositScreen(JFrameManager frameManager) {
            super(frameManager);
            AccountFacade accountFacade = (AccountFacade) getFrameManager().getFacades().get("account");

            confirmButton.addActionListener(e -> {
                Double val;
                try {
                    if (valueInput.getText().isEmpty() || valueInput.getText().matches(".*[a-zA-Z]+.*"))
                        val = -1.0;
                    else
                        val =  Double.valueOf(valueInput.getText().replace(',','.'));

                    TransactionFacade transactionFacade = (TransactionFacade) getFrameManager().getFacades().get("transaction");
                    Account account = accountFacade.getAccount(frameManager.getUserCredentials().getId());

                    transactionFacade.makeDeposit(account.getId(), new Money(val));
                    Popup.show("Depósito","Depósito aprovado!","Ok",null);
                    JFrameLoader.load(getFrameManager(), MainAccountScreen.class,700, 500, "Banco");

                }
                catch (Exception ex){
                    errorMessage.setText(ex.getMessage());
                }
            });
            backButton.addActionListener(e -> JFrameLoader.load(getFrameManager(), MainAccountScreen.class, 700, 500, "Banco"));
        }

        @Override
        public void addStyle() {
            valueInput.setSize(valueInput.getWidth(), 100);
            valueInput.setBorder(BorderFactory.createCompoundBorder(
                    valueInput.getBorder(),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        }

        @Override
        public JPanel getMainPanel() {
            return bodyPanel;
        }
}

