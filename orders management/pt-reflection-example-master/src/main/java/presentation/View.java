package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import connection.ConnectionFactory;
import model.Client;
import model.Produs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class View {
    private JFrame frame = new JFrame("Orders Management");
    private JButton buttonClientOperation = new JButton("Client Operations");
    private JButton buttonProductOperation = new JButton("Product Operations");
    private JButton buttonCreateProductOrders = new JButton("Create Product Orders");

    private JFrame frameClient = new JFrame("Clients");
    private JFrame frameProduct = new JFrame("Products");
    private JFrame frameCreateOrders = new JFrame("Create Product Orders");

    private JButton buttonShowClients = new JButton("Show Clients");
    private JButton buttonDeleteClients = new JButton("Delete Clients");
    private JButton buttonInsertClient = new JButton("Insert Clients");
    private JButton buttonEditClients = new JButton("Edit Clients");
    private JButton buttonDeletefromView = new JButton("Delete View");

    private JButton buttonShowProducts = new JButton("Show Products");
    private JButton buttonDeleteProducts = new JButton("Delete Products");
    private JButton buttonInsertProducts = new JButton("Insert Products");
    private JButton buttonEditProducts = new JButton("Edit Products");
    private JButton buttonDeletefromView2 = new JButton("Delete View");

    private JButton buttonShowOrders = new JButton("Show Orders");
    private JButton buttonDeleteOrder = new JButton("Delete Orders");
    private JButton buttonDoneOrder = new JButton("Done Order");

    private JTable tableClients = new JTable();
    private JTable tableProducts = new JTable();
    private JTable tableOrders = new JTable();

    private JTextArea textOrderId = new JTextArea();
    private JTextArea textProductId = new JTextArea();
    private JTextArea textClientId = new JTextArea();
    private JTextArea textQuantity = new JTextArea();
    private JTextArea message = new JTextArea();

    private JTextArea textidC=new JTextArea();
    private JTextArea textnameC=new JTextArea();
    private JTextArea textemailC=new JTextArea();
    private JTextArea textadressC=new JTextArea();

    private JTextArea textidP=new JTextArea();
    private JTextArea textnameP=new JTextArea();
    private JTextArea textcantitateP=new JTextArea();

    public View() {
        initializeFrames();
        addActionListeners();
    }

    private void initializeFrames() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        frameClient.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameClient.setSize(800, 600);
        frameClient.setLayout(null);

        frameProduct.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameProduct.setSize(800, 600);
        frameProduct.setLayout(null);

        frameCreateOrders.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameCreateOrders.setSize(800, 600);
        frameCreateOrders.setLayout(null);

        frame.add(buttonClientOperation);
        frame.add(buttonProductOperation);
        frame.add(buttonCreateProductOrders);

        buttonClientOperation.setBounds(25, 50, 250, 50);
        buttonProductOperation.setBounds(25, 150, 250, 50);
        buttonCreateProductOrders.setBounds(25, 250, 250, 50);

        setupClientFrame();
        setupProductFrame();
        setupOrderFrame();
    }

    private void setupClientFrame() {
        frameClient.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameClient.setSize(850, 600);
        frameClient.setLayout(null);

        // Labels for clarity
        JLabel labelIdC = new JLabel("ID:");
        JLabel labelNameC = new JLabel("Name:");
        JLabel labelEmailC = new JLabel("Email:");
        JLabel labelAddressC = new JLabel("Address:");

        // Setting bounds for labels
        labelIdC.setBounds(20, 30, 160, 25);
        labelNameC.setBounds(20, 65, 160, 25);
        labelEmailC.setBounds(20, 100, 160, 25);
        labelAddressC.setBounds(20, 135, 160, 25);

        // Setting bounds for text fields
        textidC.setBounds(180, 30, 160, 25);
        textnameC.setBounds(180, 65, 160, 25);
        textemailC.setBounds(180, 100, 160, 25);
        textadressC.setBounds(180, 135, 160, 25);

        // Adding labels and text fields to the frame
        frameClient.add(labelIdC);
        frameClient.add(labelNameC);
        frameClient.add(labelEmailC);
        frameClient.add(labelAddressC);
        frameClient.add(textidC);
        frameClient.add(textnameC);
        frameClient.add(textemailC);
        frameClient.add(textadressC);

        // Buttons for client operations
        buttonShowClients.setBounds(360, 30, 160, 25);
        buttonInsertClient.setBounds(360, 65, 160, 25);
        buttonDeleteClients.setBounds(360, 100, 160, 25);
        buttonEditClients.setBounds(360, 135, 160, 25);
        buttonDeletefromView.setBounds(360, 170, 160, 25);

        // Adding buttons to frame
        frameClient.add(buttonShowClients);
        frameClient.add(buttonInsertClient);
        frameClient.add(buttonDeleteClients);
        frameClient.add(buttonEditClients);
        frameClient.add(buttonDeletefromView);

        // Table setup with JScrollPane
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Email", "Address"});
        tableClients.setModel(model);
        JScrollPane scrollPane = new JScrollPane(tableClients);
        scrollPane.setBounds(20, 210, 800, 350);
        frameClient.add(scrollPane);
    }

    private void setupProductFrame() {
        frameProduct.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameProduct.setSize(850, 600);
        frameProduct.setLayout(null);

        JLabel labelIdP = new JLabel("ID:");
        JLabel labelNameP = new JLabel("Name:");
        JLabel labelQuantityP = new JLabel("Quantity:");

        labelIdP.setBounds(20, 30, 160, 25);
        labelNameP.setBounds(20, 65, 160, 25);
        labelQuantityP.setBounds(20, 100, 160, 25);

        textidP.setBounds(180, 30, 160, 25);
        textnameP.setBounds(180, 65, 160, 25);
        textcantitateP.setBounds(180, 100, 160, 25);

        frameProduct.add(labelIdP);
        frameProduct.add(labelNameP);
        frameProduct.add(labelQuantityP);
        frameProduct.add(textidP);
        frameProduct.add(textnameP);
        frameProduct.add(textcantitateP);


        frameProduct.add(buttonShowProducts);
        frameProduct.add(buttonInsertProducts);
        frameProduct.add(buttonDeleteProducts);
        frameProduct.add(buttonEditProducts);
        frameProduct.add(buttonDeletefromView2);
        frameProduct.add(new JScrollPane(tableProducts));

        buttonShowProducts.setBounds(20, 140, 160, 25);
        buttonInsertProducts.setBounds(190, 140, 160, 25);
        buttonDeleteProducts.setBounds(360, 140, 160, 25);
        buttonEditProducts.setBounds(530, 140, 160, 25);
        buttonDeletefromView2.setBounds(700, 140, 160, 25);
        tableProducts.setBounds(20, 180, 800, 380);

        // Table setup with JScrollPane
        DefaultTableModel modelProduct = new DefaultTableModel();
        modelProduct.setColumnIdentifiers(new String[]{"ID", "Name", "Quantity"});
        tableProducts.setModel(modelProduct);
        JScrollPane scrollPaneProduct = new JScrollPane(tableProducts);
        scrollPaneProduct.setBounds(20, 210, 800, 350);
        frameProduct.add(scrollPaneProduct);
    }

    private void setupOrderFrame() {
        frameCreateOrders.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameCreateOrders.setSize(850, 600);
        frameCreateOrders.setLayout(null);

        // Labels for clarity
        JLabel labelOrderId = new JLabel("Order ID:");
        JLabel labelProductId = new JLabel("Product ID:");
        JLabel labelClientId = new JLabel("Client ID:");
        JLabel labelQuantity = new JLabel("Quantity:");

        // Setting bounds for labels
        labelOrderId.setBounds(20, 30, 160, 25);
        labelProductId.setBounds(20, 65, 160, 25);
        labelClientId.setBounds(20, 100, 160, 25);
        labelQuantity.setBounds(20, 135, 160, 25);

        // Setting bounds for text fields
        textOrderId.setBounds(180, 30, 160, 25);
        textProductId.setBounds(180, 65, 160, 25);
        textClientId.setBounds(180, 100, 160, 25);
        textQuantity.setBounds(180, 135, 160, 25);

        // Adding components to frame
        frameCreateOrders.add(labelOrderId);
        frameCreateOrders.add(labelProductId);
        frameCreateOrders.add(labelClientId);
        frameCreateOrders.add(labelQuantity);
        frameCreateOrders.add(textOrderId);
        frameCreateOrders.add(textProductId);
        frameCreateOrders.add(textClientId);
        frameCreateOrders.add(textQuantity);

        // Buttons for order operations
        buttonShowOrders.setBounds(20, 170, 160, 25);
        buttonDoneOrder.setBounds(190, 170, 160, 25);
        buttonDeleteOrder.setBounds(360, 170, 160, 25);

        frameCreateOrders.add(buttonShowOrders);
        frameCreateOrders.add(buttonDoneOrder);
        frameCreateOrders.add(buttonDeleteOrder);

        // Message area
        message.setBounds(20, 210, 800, 30);
        frameCreateOrders.add(message);

        // Table for displaying orders
        tableOrders.setBounds(20, 250, 800, 320);
        JScrollPane scrollPane = new JScrollPane(tableOrders);
        scrollPane.setBounds(20, 250, 800, 320);
        frameCreateOrders.add(scrollPane);
    }

    private void addActionListeners() {
        buttonClientOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameClient.dispose();
                frameClient.setSize(850,550);
                frameClient.setResizable(false);
                frameClient.setLayout(null);
                frameClient.getContentPane().setBackground(new Color(149, 217, 148));
                frameClient.setVisible(true);
            }
        });
        buttonProductOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProduct.dispose();
                frameProduct.setSize(850,550);
                frameProduct.setResizable(false);
                frameProduct.setLayout(null);
                frameProduct.getContentPane().setBackground(new Color(149, 217, 148));
                frameProduct.setVisible(true);

            }
        });
        buttonCreateProductOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCreateOrders.dispose();
                frameCreateOrders.setSize(850,550);
                frameCreateOrders.setResizable(false);
                frameCreateOrders.setLayout(null);
                frameCreateOrders.getContentPane().setBackground(new Color(149, 217, 148));
                frameCreateOrders.setVisible(true);
            }
        });
        buttonShowClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from client";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String nume, email, adresa;
                    String client_id;
                    while (rs.next()) {
                        client_id = rs.getString(1);
                        nume = rs.getString(2);
                        email = rs.getString(3);
                        adresa = rs.getString(4);
                        String[] row = {client_id, nume, email, adresa};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeletefromView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableClients.setModel(new DefaultTableModel());

            }
        });
        buttonShowProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from product";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String produs_id, nume, cantitate;
                    while (rs.next()) {
                        produs_id = rs.getString(1);
                        nume = rs.getString(2);
                        cantitate = rs.getString(3);
                        String[] row = {produs_id, nume, cantitate};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeletefromView2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableProducts.setModel(new DefaultTableModel());

            }
        });
        buttonShowOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from comanda";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) tableOrders.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String order_id, produs_id, client_id;
                    while (rs.next()) {
                        order_id = rs.getString(1);
                        produs_id = rs.getString(2);
                        client_id = rs.getString(3);
                        String[] row = {order_id, produs_id, client_id};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableOrders.setModel(new DefaultTableModel());

            }
        });

        buttonDoneOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection dbConnection = ConnectionFactory.getConnection();
                try {
                    int productId = Integer.parseInt(textProductId.getText().trim());
                    int clientId = Integer.parseInt(textClientId.getText().trim());
                    int orderId = Integer.parseInt(textOrderId.getText().trim());
                    int quantity = Integer.parseInt(textQuantity.getText().trim());

                    // Checking product availability
                    PreparedStatement checkStmt = dbConnection.prepareStatement("SELECT cantitate FROM product WHERE idProdus = ?");
                    checkStmt.setInt(1, productId);
                    ResultSet rs = checkStmt.executeQuery();
                    int currentStock = 0;
                    if (rs.next()) {
                        currentStock = rs.getInt("cantitate");
                    }
                    if (currentStock < quantity) {
                        message.setText("Sorry, not enough products in stock.");
                        return; // Exit if not enough stock
                    }

                    // Inserting the order
                    PreparedStatement insertStmt = dbConnection.prepareStatement("INSERT INTO comanda (idcomanda, idClient, idProdus) VALUES (?, ?, ?)");
                    insertStmt.setInt(1, orderId);
                    insertStmt.setInt(2, clientId);
                    insertStmt.setInt(3, productId);
                    //insertStmt.setInt(4, quantity);
                    insertStmt.executeUpdate();

                    // Updating the product stock
                    PreparedStatement updateStmt = dbConnection.prepareStatement("UPDATE product SET cantitate = cantitate - ? WHERE idProdus = ?");
                    updateStmt.setInt(1, quantity);
                    updateStmt.setInt(2, productId);
                    updateStmt.executeUpdate();

                    message.setText("Order successfully placed.");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    message.setText("Error placing order: " + e1.getMessage());
                } catch (NumberFormatException e2) {
                    message.setText("Invalid input format.");
                } finally {
                    ConnectionFactory.close(dbConnection);
                }
            }
        });

        buttonEditClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                String name=textnameC.getText();
                String email=textemailC.getText();
                String adress=textadressC.getText();
                Client client=new Client(client_id,name,email,adress);
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.editClient(client);
            }
        });
        buttonDeleteClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.findById(client_id);
                clientBLL.deleteClient(client_id);

            }
        });
        buttonInsertClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                String name=textnameC.getText();
                String email=textemailC.getText();
                String adress=textadressC.getText();
                Client client=new Client(client_id,name,email,adress);
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.insertClient(client);

            }
        });
        buttonEditProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int product_id=Integer.parseInt(textidP.getText());
                String name=textnameP.getText();
                int cantitate=Integer.parseInt(textcantitateP.getText());
                Produs produs=new Produs(product_id,name,cantitate);
                ProductBLL productBLL=new ProductBLL();
                productBLL.editProdus(produs);
            }
        });
        buttonDeleteProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int produs_id=Integer.parseInt(textidP.getText());
                ProductBLL productBLL=new ProductBLL();
                productBLL.findById(produs_id);
                productBLL.deleteProdus(produs_id);

            }
        });
        buttonInsertProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int product_id=Integer.parseInt(textidP.getText());
                String name=textnameP.getText();
                int cantitate=Integer.parseInt(textcantitateP.getText());
                Produs produs=new Produs(product_id,name,cantitate);
                ProductBLL productBLL=new ProductBLL();
                productBLL.insertProdus(produs);
            }
        });
    }

}
