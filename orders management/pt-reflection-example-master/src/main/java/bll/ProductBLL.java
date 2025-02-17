package bll;
import DataAccess.ProductDAO;
import model.Client;
import model.Produs;

public class ProductBLL {

    /**
     * Inserts a product into the Product Table
     * @param produs Product Object
     * @return ID of the product inserted
     */
    public int insertProdus(Produs produs)
    {
        return ProductDAO.insertProduct(produs);
    }
    /**
     * Deletes a product from the Product Table
     * @param product_id Product object
     */

    public int deleteProdus(int product_id)
    {
        return ProductDAO.deleteProduct(product_id);
    }


    /**
     * Updates a product from the Product Table
     * @param produs Product object
     */

    public void editProdus(Produs produs)
    {
        ProductDAO.editProduct(produs);
    }


    /**
     * Finds a product by its ID Primary Key
     * @param productId Primary Key
     * @return The product corresponding to the given ID
     */
    public  Produs findById(int productId)
    {
        return ProductDAO.findById(productId);
    }
}

