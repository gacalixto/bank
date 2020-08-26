package br.unesp.banco.app.account;

import br.unesp.banco.core.db.operation.QueryMapper;
import br.unesp.banco.core.db.operation.Repository;
import br.unesp.banco.core.db.stereotype.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountRepository extends Repository<Long, Account> {

    public AccountRepository(Connection connection, QueryMapper<Account> mapper) {
        super(connection, Account.class.getAnnotation(Entity.class).table(), mapper);
    }

    public Account findByAccountNumber(String number) throws SQLException {
        String tableName = Account.class.getAnnotation(Entity.class).table();
        String query = String.format("SELECT * FROM %s WHERE number = %s", tableName, number);
        List<Account> result = this.findAllByQuery(query);
        if (result.size() == 0) {
            throw new SQLException("Conta não encontrada");
        }
        return result.get(0);
    }

    public List<Account> findAllLikeAccountNumber(String selfNumber, String number) throws SQLException {
        String tableName = Account.class.getAnnotation(Entity.class).table();

        number = "'%" + number + "%'";
        String query = String.format("SELECT * FROM %s WHERE number LIKE %s AND number <> %s LIMIT 10", tableName, number, selfNumber);
        return this.findAllByQuery(query);
    }
}
