/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author chris
 */
public interface DAO {
    
    public boolean cadastrar(Object obj);
    public boolean atualizar(Object obj);
    public boolean deletar(Object obj);
    public Object buscar(int chave);
    
}
