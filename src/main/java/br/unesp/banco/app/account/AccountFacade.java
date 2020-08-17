package br.unesp.banco.app.account;

import br.unesp.banco.core.log.Logger;

import java.sql.SQLException;
import java.util.*;

public class AccountFacade {

    private final AccountRepository accountRepository;

    public AccountFacade(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account login(String number, String password) throws Exception {
        if (number.isEmpty() || password.isEmpty())
            throw new Exception("Número da conta ou senha inválida");

        Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        params.put("password", password);

        Optional<Account> account = accountRepository.findByAnd(params);

        if (!account.isPresent())
            throw new Exception("Credenciais inválidas");

        Logger.log("Login", "Logado!");
        return account.get();
    }

    public Account createAccount(String number, String password) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("number", number);

        Boolean accountAlreadyExists = accountRepository.findByAnd(params).isPresent();
        if (accountAlreadyExists) {
            throw new Exception("Número de conta já existe");
        }

        if (number.isEmpty() || number.length() > 8) {
            throw new Exception("Número inválido");
        }
        if (password.isEmpty()) {
            throw new Exception("Senha inválida");
        }

        return accountRepository.create(new Account(number, password));
    }

    public Account getAccountByNumber(String selfNumber, String number) throws SQLException {
        return accountRepository.findByAccountNumber(number);
    }

    public List<Account> getAccountsLikeNumber(String selfNumber, String number) throws SQLException {
        if (number == null || number.isEmpty() || !number.matches("[0-9]+")) {
            return new ArrayList<>();
        }

        return accountRepository.findAllLikeAccountNumber(selfNumber, number);
    }

    public Account getAccount(Long id) throws Exception {
        return accountRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Conta não existe. ID " + id));
    }

}
