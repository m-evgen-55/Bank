package bank.application.dao;

import bank.application.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


@Component
public class ClientJdbcTemplateDao implements ClientDao {

    private final String SQL_FIND_CLIENT = "select FIO, Age from Clients where Id = ?";
    private final String SQL_INSERT_CLIENT = "insert into Clients (Id, FIO, Age) values (?, ?, ?)";
    private final String SQL_UPDATE_CLIENT = "update Clients set FIO = ?, Age = ?, where Id = ?";
    private final String SQL_DELETE_CLIENT = "delete from Clients where Id = ?";
    private final String SQL_FIND_ACCOUTN_REF_ID = "select AccountId from Clients where Id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static List<Client> CLIENTS = new ArrayList<>();

    @Override
    public Client insertClient(Client client) {
        jdbcTemplate.update(SQL_INSERT_CLIENT, client.getClientId(), client.getFIO(), client.getAge());
        // работа с ArayList
        CLIENTS.add(client);
        return client;
    }

    @Override
    public void updateClient(Client client) {
        jdbcTemplate.update(SQL_UPDATE_CLIENT, client.getFIO(), client.getAge(), client.getClientId());
    }

    @Override
    public void deleteClient(Client client) {
        jdbcTemplate.update(SQL_DELETE_CLIENT, client.getClientId());
    }

    @Override
    public Client findById(String id) {
        ClientMapper clientMapper = new ClientMapper();
        Client client = jdbcTemplate.queryForObject(SQL_FIND_CLIENT, clientMapper);
        return client;
        //Client client = new Client(jdbcTemplate.queryForObject(SQL_FIND_CLIENT, ));
        //return jdbcTemplate.queryForObject(SQL_FIND_CLIENT, new BeanPropertyRowMapper<Client>());
        //return jdbcTemplate.queryForObject(SQL_FIND_CLIENT, new Client());

        // работа с ArraList
//
//        for (Client c : CLIENTS) {
//            if (c.getClientId().equals(id)) {
//                return c;
//            }
//        }
//        return null;
        //образец записи stream
       /* return CLIENTS.stream()
                .filter(x -> x.getClientID().equals(id))
                .findFirst()
                .orElse(null);*/
    }

    @Override
    public List getAccountRefId(String accountId) {

            return jdbcTemplate.queryForList(SQL_FIND_ACCOUTN_REF_ID);

//        // работа с ArrayList
//        for (Client c : CLIENTS) {
//            if (c.getAccounts().equals(accountId)) {
//                return c;
//            }
//        }
//        return null;
    }




//    private Client executeStatement(final String statement) throws SQLException, ClassNotFoundException {
//
    //ручное пдключение к бд
//        Connection connection;
//        String url = "jdbc:postgresql://127.0.0.1:5432";
//        String user = "postgres";
//        String password = "";
//        Class.forName("org.postgresql.Driver");
//        connection = DriverManager.getConnection(url, user, password);
//        connection.setAutoCommit(false);
//        Statement st = connection.createStatement();
//        ResultSet rest = st.executeQuery(statement);
//        return toClient(rest);
//    }

    // посмотреть что возвращает statement и сделать так чтобы этот метод возвращал клиента
//    private Client toClient(ResultSet rs) {
//        Client client = new Client();
//
//        return client;
//    }

}
