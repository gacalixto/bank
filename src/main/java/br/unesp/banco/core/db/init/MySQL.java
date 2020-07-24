package br.unesp.banco.core.db.init;

import br.unesp.banco.core.util.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection connection;

    public MySQL() throws SQLException {
        Credential credential = new Credential();
        String url = String.format("jdbc:mysql://%s", credential.getHost());
        Logger.logDb(url);

        connection = DriverManager.getConnection(url, credential.getUser(), credential.getPassword());
        String createDatabaseIfNotExists = String.format("CREATE DATABASE IF NOT EXISTS %s", credential.getDatabase());

        connection.prepareStatement(createDatabaseIfNotExists).execute();
        Logger.logDb(createDatabaseIfNotExists);

        url += "/" + credential.getDatabase();
        connection = DriverManager.getConnection(url, credential.getUser(), credential.getPassword());
        Logger.logDb(url);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "MySQL{" +
                "connection=" + connection +
                '}';
    }
}