package model;

import java.sql.SQLException;

public class User {
    //Atributos
    private int userCod;
    private String userName;
    private String userPass;
    private String userCpf;
    
    //Método construtor
    public User(){}
    
    public User(String user, String pass) {
        this.userName = user;
        this.userPass = pass;
    }
    
    //Getters & Setters

    public int getUserCod() {
        return userCod;
    }

    public void setUserCod(int userCod) {
        this.userCod = userCod;
    }
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }
    
    //toString - método para representação geral do objeto
    @Override
    public String toString() {
        return "<hr>Nome: " + userName +
                "<br>CPF: " + userCpf +
                "<br>Senha: " + userPass;
    }
    
    //Métodos gerais
    public boolean isLogged() throws ClassNotFoundException, SQLException {
        UserDAO udao = new UserDAO();
        User uBanco = udao.listOneUser(this.userName);
        
        if(uBanco.getUserName() != null && uBanco.getUserName().equals(this.userName)){
            //Aqui, o nome de usuário foi encontrado
            //e verificamos a senha
            return (this.userPass.equals(uBanco.getUserPass()));
        } else {
            //Aqui, o nome de usuário não foi encontrado
            return false;
        }
    }
    
} //Fim da classe
