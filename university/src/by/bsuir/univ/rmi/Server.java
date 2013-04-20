package by.bsuir.univ.rmi;

import by.bsuir.univ.rmi.model.Student;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class Server {

    private static final String SERVER_NAME = "Server";
    private static final String PORT = "7711";

    public void runServer() throws IllegalArgumentException, NotBoundException, RemoteException {
        Student student = Initializer.getListOfStudents().get(0);
        Registry registry = LocateRegistry.createRegistry(Integer.parseInt(PORT, 10));
        registry.rebind(SERVER_NAME, student);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.runServer();
        System.out.println("Server started on port " + PORT);

    }
}