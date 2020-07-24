package br.unesp.banco.system.account;

import br.unesp.banco.core.db.operation.Entity;

@Entity(table = "accounts")
public class Account  {
    private Long id;
    private String number;
    private String password;
//    private Double balance; TODO ADICIONAR SALDO

    public Long getId() {
        return id;
    }

    public Account(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public Account() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
