/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Banco {
    private String usuario, senha, servidor, dataBase;
    private int porta;
    private java.sql.Connection conexao = null;

    public Banco () { }

    public Banco (String usuario, String senha, String servidor,
            String dataBase, int porta) {
        setUsuario(usuario);
        setSenha(senha);
        setServidor(servidor);
        setDataBase(dataBase);
        setPorta(porta);
    }

    public void abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(
                "jdbc:mysql://" + 
                getServidor() + ":" +
                getPorta() + "/" +
                getDataBase(), getUsuario(), getSenha());
            System.out.println("BANCO CONECTADO!");
        } catch (SQLException ex) {
            System.out.println("Erro de SQL \n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe nao encontrada... ERRO");
        }
    }

    public void fechar() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public java.sql.Connection getConexao() {
        return conexao;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the dataBase
     */
    public String getDataBase() {
        return dataBase;
    }

    /**
     * @param dataBase the dataBase to set
     */
    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * @return the porta
     */
    public int getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }

    
}
