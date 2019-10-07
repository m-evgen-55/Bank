package bank.application.dao;

import bank.application.model.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        String FIO = resultSet.getString("FIO");
        int age = resultSet.getInt("Age");
        Client client = new Client();
        client.setAge(age);
        client.setFIO(FIO);
        return client;
    }
}
