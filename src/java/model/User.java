package model;

public class User {
    //Atributos
    private String userName;
    private String userPass;
    private String userCpf;
    
    //Método construtor
    public User(String user, String pass) {
        this.userName = user;
        this.userPass = pass;
    }
    
    //Getters & Setters
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
    public boolean isLogged() {
        return (this.userName.equals("user")
                   && this.userPass.equals("1234"));
    }
    
} //Fim da classe
