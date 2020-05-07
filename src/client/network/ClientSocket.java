package client.network;

import data.Packet;
import data.User;

import data.Cofee;
import data.Packet;
import data.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket = null;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public ClientSocket(){
        try{
            socket = new Socket("localhost", 1999);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        }
        catch(Exception e){e.printStackTrace();}
    }
    public void disconnect(){
        try{
            oos.close();
            ois.close();
            socket.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public boolean toRegister(User user){
        String code = "";

        try{
            Packet packet = new Packet("REG", user);
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            code = answerPacket.getCode();
        }
        catch(Exception e){e.printStackTrace();}

        if(code.equals("SUCCESS"))
            return true;

        return false;
    }
    public User toLogin(User user){
        User authUser = null;
        try{
            Packet packet = new Packet("LOGIN", user);
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            authUser = (User)answerPacket.getData();
        }
        catch(Exception e){e.printStackTrace();}

        return authUser;
    }

    public ArrayList<Cofee> getAllCoffee(){
        ArrayList<Cofee> books=null;
        Packet packet=new Packet("LIST_BOOKS", null);
        try {
            oos.writeObject(packet);
            Packet response=(Packet)ois.readObject();
            books=(ArrayList<Cofee>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    public void addCoffee(Cofee cofee){
        Packet packet=new Packet("ADD_BOOK", cofee);
        try {
            oos.writeObject(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean removeCoffee(Cofee book){
        Packet packet=new Packet("DEL_BOOK", book);
        String code = "";
        try {
            oos.writeObject(packet);
            Packet answerPacket = (Packet)ois.readObject();
            code = (String)answerPacket.getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(code.equals("SUCCESS"))
            return true;

        return false;
    }

}


