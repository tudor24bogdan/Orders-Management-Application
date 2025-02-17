package test;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import model.Client;
import start.Reflection;

import java.util.ArrayList;

public class ReflectionTest {

    @Test
    public void testGenerateClientTable() {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "John Doe", "john.doe@example.com","Bucuresti,88"));
        clients.add(new Client(2, "Jane Doe", "jane.doe@example.com","Bucuresti,87"));

        String[] expectedFieldNames = {"idClient", "nume", "email","adresa"};
        String[] fieldNames = Reflection.generateClientTable(clients);

        assertArrayEquals("Field names should match expected names.", expectedFieldNames, fieldNames);
    }
}
