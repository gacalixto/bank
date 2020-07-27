package br.unesp.banco.system.account;

import br.unesp.banco.core.db.operation.Entity;
import br.unesp.banco.core.db.operation.QueryMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements QueryMapper<Account> {
    @Override
    public Account toEntity(ResultSet rs) throws SQLException {
        Account account = new Account();

        account.setId(rs.getLong("id"));
        account.setNumber(rs.getString("number"));
        account.setPassword("protected");
        account.setBalance(rs.getDouble("balance"));

        return account;
    }

    @Override
    public String toQuery(Account account) {
        return String.format("INSERT INTO %s (number, password) VALUES ('%s', '%s')", Account.class.getAnnotation(Entity.class).table(), account.getNumber(), account.getPassword());
    }
}
