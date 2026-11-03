package com.example.tienda.data;

import com.example.tienda.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DataSet {

    private static ObservableList<User> listUser = FXCollections.observableArrayList();




    public static void initListUser(){
        listUser.add(new User("admin","admin", "admin", "1234", 0));
        listUser.add(new User("user","user", "user", "1234", 1));
    }

    public static boolean addUser(User user){
        //en caso de tener un correo ya en la lista -> return false
        //en caso de no tener un correo en la lista -> aniado y return true
        //listUser.stream().filter(i -> i.getMail().equalsIgnoreCase(user.getMail())).findAny().orElseThrow();

        Optional<User> userOptional =
                listUser.stream().filter(i -> i.getMail().equalsIgnoreCase(user.getMail())).findAny();

        if (userOptional.isEmpty()){
            listUser.add(user);
            return true;
        }

        return false;
    }

    public static boolean removeUser(User user) {
        return listUser.remove(user);
    }

    public static ObservableList<User> getList(){
        return listUser;
    }

    public static Object[] getLogin (String mail, String pass){
        //si en la lista hay algun user con el mail y el pass-> return false
        //si en la lista no hay algun user con el mail y el pass-> return true
        //int-> -1 no login, 0 user, 1 admintero lista -> if -> variable
        //i
        for (User i : listUser){
            if (i.getPass().equals(pass) && i.getMail().equals(mail)){
                return new Object[] {i.getMail(), i.getProfile()};
            }
        }
        return new Object[] {null, -1};
        /*
        return listUser.stream()
                .filter(i -> i.getPass().equals(pass)&& i.getMail().equals(mail))
                .findAny().map(User::getProfile).orElse(-1);   */
    }

    public static User getUser(String mail){
        User user = listUser.stream().filter(item -> item.getMail().equalsIgnoreCase(mail)).findAny().get();

        return user;
    }

    public static int getAdmins(){
        return listUser.stream().filter(i -> i.getProfile()==0).toList().size();
    }


}
