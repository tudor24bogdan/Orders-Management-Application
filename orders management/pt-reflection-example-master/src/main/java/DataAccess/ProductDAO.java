package DataAccess;

import connection.ConnectionFactory;

import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO product (idprodus,nume,cantitate)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM product WHERE idprodus = ?";
    private final static String deleteStatementString = "DELETE FROM product WHERE idprodus = ?";
    private final static String editedStatementString = "UPDATE product " +
            "SET nume=?, cantitate=? " +
            "WHERE idprodus=?";

    /***
     * Method to find product by id
     * @param idprodus the id to be searched
     * @return return the product with the givenid productid
     */
    public static Produs findById(int idprodus) {
        Produs toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, idprodus);
            rs = findStatement.executeQuery();
            rs.next();
            Integer id = rs.getInt("idprodus");
            String name = rs.getString("nume");
            Integer cantitate = rs.getInt("cantitate");


            toReturn = new Produs(id, name, cantitate);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
    /***
     * Method to insert a new client in a database
     * @param produs the product to be inserted
     * @return return the id of the inserted product
     */
    public static int insertProduct(Produs produs) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, produs.getIdPprodus());
            insertStatement.setString(2, produs.getNume());
            insertStatement.setInt(3, produs.getCantitate());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    /***
     * Method to delete a client from a database
     * @param produsId the id of the product to be deleted
     * @return return if the product will be deleted or not
     */
    public static int deleteProduct(int produsId) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        int deleted = 0;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, produsId);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected > 0) {
                deleted = 1;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:deleteClient " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deleted;
    }
    /***
     * Method that edit columns of a client
     * @param produs the product to be edited
     */

    public static void editProduct(Produs produs) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editedStatement = null;

        try {
            editedStatement = dbConnection.prepareStatement(editedStatementString);
            editedStatement.setInt(3, produs.getIdPprodus());
            editedStatement.setString(1, produs.getNume());
            editedStatement.setInt(2, produs.getCantitate());
            editedStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProdusDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(editedStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
