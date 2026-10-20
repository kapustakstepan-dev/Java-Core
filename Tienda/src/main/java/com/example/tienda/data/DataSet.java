package com.example.tienda.data;

import com.example.tienda.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSet {

    private static List<User> listUser = new ArrayList<>();

    public static void initListUser(){
        listUser.add(new User("Stepan","Kapustiak", "correo@gmail.com", "1234", 1));
    }

    public static boolean addUser(User user){
        //en caso de tener un correo ya en la lista -> return false
        //en caso de no tener un correo en la lista -> aniado y return true


        return false;
    }

    public static List<User> getList(){
        return listUser;
    }

    public static boolean getLogin (String mail, String pass){
        //si en la lista hay algun user con el mail y el pass-> return false
        //si en la lista no hay algun user con el mail y el pass-> return true
        //int-> -1 no login, 0 user, 1 admin
        return false;
    }



}
