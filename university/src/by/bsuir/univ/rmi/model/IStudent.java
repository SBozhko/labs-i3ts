package by.bsuir.univ.rmi.model;

import by.bsuir.univ.model.StudentStatus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStudent extends Remote {

    public long getId() throws RemoteException;

    public void setId(long id) throws RemoteException;

    public String getFullName() throws RemoteException;

    public void setFullName(String fullName) throws RemoteException;

    public String getEmail() throws RemoteException;

    public void setEmail(String email) throws RemoteException;

    public String getPassword() throws RemoteException;

    public void setPassword(String password) throws RemoteException;

    public String addOneBadMark() throws RemoteException;

    public StudentStatus getStudentStatus() throws RemoteException;

    public void setStudentStatus(StudentStatus studentStatus) throws RemoteException;
}
