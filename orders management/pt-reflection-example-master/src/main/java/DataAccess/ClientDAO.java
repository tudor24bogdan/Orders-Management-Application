package DataAccess;

import connection.ConnectionFactory;
import model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (idclient,nume,email,adresa)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM client WHERE idclient= ?";
    private final static String deleteStatementString = "DELETE FROM client WHERE idclient = ?";
    private final static String editedStatementString = "UPDATE client " +
            "SET nume=?, email=?, adresa=? " +
            "WHERE idclient=?";

    /***
     * Method to find client by id
     * @param idclient the id to be searched
     * @return return the Client with the givenid clientid
     */
    public static Client findById(int idclient) {
        Client toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idclient);
            rs = findStatement.executeQuery();
            rs.next();
            Integer id = rs.getInt("idclient");
            String name = rs.getString("nume");
            String address = rs.getString("email");
            String email = rs.getString("adresa");

            toReturn = new Client(id, name, email, address);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /***
     * Method to insert a new client in a database
     * @param client the client to be inserted
     * @return return the id of the inserted client
     */

    public static int insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getIdClient());
            insertStatement.setString(2, client.getNume());
            insertStatement.setString(4, client.getAdresa());
            insertStatement.setString(3, client.getEmail());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    /***
     * Method to delete a client from a database
     * @param idclient the id of the client to be deleted
     * @return return if the client will be deleted or not
     */
    public static int deleteClient(int idclient) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        int deleted = 0;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, idclient);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected > 0) {
                deleted = 1;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:deleteClient " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deleted;
    }

    /***
     * Method that edit columns of a client
     * @param client the client to be edited
     */
    public static void edit(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editedStatement = null;

        try {
            editedStatement = dbConnection.prepareStatement(editedStatementString);
            editedStatement.setInt(4, client.getIdClient());
            editedStatement.setString(1, client.getNume());
            editedStatement.setString(3, client.getAdresa());
            editedStatement.setString(2, client.getEmail());
            editedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(editedStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
