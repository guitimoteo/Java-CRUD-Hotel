/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Quarto;
import VO.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class QuartoDAO {
    
    private Banco banco = null;
    private Quarto quartoVO = null;

    public QuartoDAO(Banco banco) {
        this.banco = banco;
    }

    
    public boolean cadastrar(Object obj) {
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //Incluindo um cadastro no quarto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO quarto (numero, tipo, localizacao, caracteristica, "
                    + "qtdReservado, qtdOcupado, qtdVago, qtdTotal, preco) "
                    + " VALUES ("
                    + quartoVO.getNumero() + ", '"
                    + quartoVO.getTipo() + "', '"
                    + quartoVO.getLocalizacao() + "', '"
                    + quartoVO.getCaracteristica() + "', "
                    + quartoVO.getQtdReservado() + ", "
                    + quartoVO.getQtdOcupado() + ", "
                    + quartoVO.getQtdVago() + ", "
                    + quartoVO.getQtdTotal() + ", "
                    + quartoVO.getPreco() + ") ";
            /*if (quartoVO.getReserva() == null)
                sql += " null)";
            else
                sql += quartoVO.getReserva().getCodReserva() + ")"; */

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Não foi possível cadastrar o quarto: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //Atualizando um cadastro no quarto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE quarto SET tipo = '" + quartoVO.getTipo()
                    + "', localizacao = '" + quartoVO.getLocalizacao()
                    + "', caracteristica = '" + quartoVO.getCaracteristica()
                    + "', qtdReservado = " + quartoVO.getQtdReservado()
                    + ", qtdOcupado = " + quartoVO.getQtdOcupado()
                    + ", qtdVago = " + quartoVO.getQtdVago()
                    + ", qtdTotal = " + quartoVO.getQtdTotal()
                    + ", preco = " + quartoVO.getPreco();
            /*
            if (quartoVO.getReserva()== null)
                sql += ", codReserva = null ";
            else
                sql += ", codReserva = " + quartoVO.getReserva().getCodReserva();
                */
            sql += " WHERE Numero = " + quartoVO.getNumero();

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Não foi possível atualizar o registro quarto: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Quarto) {
            quartoVO = (Quarto) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //Deletando um resgistro de quarto
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM quarto WHERE Numero = "
                    + quartoVO.getNumero();

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Não foi possível deletar o registro do quarto: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        try {
            banco.abrir();
            //buscando um cadastro no quarto
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM quarto WHERE Numero = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                quartoVO = new Quarto();
                quartoVO.setNumero(rs.getInt("numero"));
                quartoVO.setTipo(rs.getString("tipo"));
                quartoVO.setLocalizacao(rs.getString("localizacao"));
                quartoVO.setCaracteristica(rs.getString("caracteristica"));
                quartoVO.setQtdReservado(rs.getInt("qtdReservado"));
                quartoVO.setQtdOcupado(rs.getInt("qtdOcupado"));
                quartoVO.setQtdVago(rs.getInt("qtdVago"));
                quartoVO.setQtdTotal(rs.getInt("qtdTotal"));
                quartoVO.setPreco(rs.getDouble("preco"));
                
                
                //quartoVO.setReserva((Reserva)new ReservaDAO(banco).buscar(rs.getInt("codReserva")));
                banco.fechar();
                return quartoVO;
            } else
                return null; //não achou o quarto

        } catch (Exception ex) {
            System.out.println("Não foi possível realizar a busca do registro do quarto: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    }

       /**
         *  public List listar(String criterio) {
        //Criar a lista do tipo Vetor que usa ARRAY
        //List dados = new Vector();
        List dados = new LinkedList();

        //abrir a conexao
        banco.abrir();
        try {
            Statement stm = banco.getConexao().createStatement();
            ResultSet rs;
            String sql;
            //Testa se existe ou nao algum criterio
            if (criterio.isEmpty()) {
                sql = "SELECT * FROM secretaria";
            } else {
                sql = "SELECT * FROM secretaria WHERE " + criterio;
            }

            rs = stm.executeQuery(sql);
            //transfere os dados da tabela para a LISTA
            while (rs.next()) {
                dados.add(new SecretariaVO(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("cpf"),
                        rs.getFloat("salario"), rs.getString("usuario"), 
                        rs.getString("senha")));
            }
            rs.close(); //fecha o resultset
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //Fecha a conexao
        banco.fechar();
        return dados; //retorna a lista de dados
    }
         */
        
    
    public List listar(String criterio) {
        try {
            banco.abrir();
            //Listando os registros do quarto
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql;
            if (criterio.length() == 0) {
                sql = "SELECT * FROM quarto ";
            } else {
                sql = "SELECT * FROM quarto WHERE " + criterio;
            }

            //Lendo os dados
            rs = stm.executeQuery(sql);
            Vector lista = new Vector(); //Lista de Quartos
            while (rs.next() == true) {
                quartoVO = new Quarto();
                quartoVO.setNumero(rs.getInt("numero"));
                quartoVO.setTipo(rs.getString("tipo"));
                quartoVO.setLocalizacao(rs.getString("localizacao"));
                quartoVO.setCaracteristica(rs.getString("caracteristica"));
                quartoVO.setQtdReservado(rs.getInt("qtdReservado"));
                quartoVO.setQtdOcupado(rs.getInt("qtdOcupado"));
                quartoVO.setQtdVago(rs.getInt("qtdVago"));
                quartoVO.setQtdTotal(rs.getInt("qtdTotal"));
                quartoVO.setPreco(rs.getDouble("preco"));
                quartoVO.setReserva((Reserva)new ReservaDAO(banco).buscar(rs.getInt("codReserva")));
                lista.addElement(quartoVO); //Adiciona o quarto na lista
            }
            return lista;
        } catch (Exception ex) {
            System.out.println("Não foi possível completar a listagem de registro de quarto: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }

    }

    
}

