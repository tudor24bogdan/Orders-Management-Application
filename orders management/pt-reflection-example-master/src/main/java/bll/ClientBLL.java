package bll;

import DataAccess.ClientDAO;
import bll.validators.ClientEmailValidator;
import bll.validators.Validator;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class ClientBLL {
    public List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL(){
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientEmailValidator());

        this.clientDAO = new ClientDAO();
    }
    /**
     * Validates client entries (email)
     * @param client
     */
    private void validateClient(Client client){
        for(Validator<Client> validator : validators){
            validator.validate(client);
        }
    }
    /**
     * Inserts the client into the Clients table
     * @param client
     * @return ID of the client inserted into the table
     */
    public int insertClient(Client client)
    {
        validateClient(client);
        return ClientDAO.insert(client);
    }

    public int deleteClient(int client_id)
    {
        return ClientDAO.deleteClient(client_id);
    }

    public void editClient(Client client)
    {
        ClientDAO.edit(client);
    }

    public Client findById(int clientId){
        Client client =  clientDAO.findById(clientId);
        if(client == null){
            throw new NoSuchElementException("Client with id = " + clientId + " can't be found");
        }
        return ClientDAO.findById(clientId);
    }
}

