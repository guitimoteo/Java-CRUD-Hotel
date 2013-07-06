/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Conta;
import java.util.Vector;

/**
 *
 * @author chris
 */
public class ContaDAO implements DAO{
    
    private Banco banco;
    private Conta contaVO;
    
    public ContaDAO(Banco banco) {
        this.banco = banco;
    }


    @Override
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Conta) {
            contaVO = (Conta) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro na conta
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO conta (codConta, periodoHospedagem,valorConsumo, "
                    + "valorHospedagem) VALUES ("
                    + contaVO.getCodConta() + ", "
                    + contaVO.getDataEntrada() + ", "
                    + contaVO.getDataSaida() + ", "
                    + contaVO.getValorConsumo() + ", "
                    + contaVO.getValorHospedagem() + ")";

            //Faz a atualizacao na tabela Eixo
 //           EixoDAO eixoDAO = new EixoDAO(banco);;;
 //           Eixo eixoVO;
 //           for(int x=0; x < chassiVO.getEixos().size(); x++) {
 //               eixoVO = (Eixo)chassiVO.getEixos().get(x);
 //               eixoDAO.alterar(eixoVO);
 //           }

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel cadastrar a conta: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Conta) {
            contaVO = (Conta) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando registro da conta
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE conta SET dataEntrada = " + contaVO.getDataEntrada()
                    + ", dataSaida = " + contaVO.getDataSaida()
                    + ", valorConsumo = " + contaVO.getValorConsumo()
                    + ", valorHospedagem = " + contaVO.getValorHospedagem()
                    + " WHERE codConta = " + contaVO.getCodConta();

            //Faz a atualizacao na tabela Eixo
//            EixoDAO eixoDAO = new EixoDAO(banco);
//            Eixo eixoVO;
//            for(int x=0; x < chassiVO.getEixos().size(); x++) {
//                eixoVO = (Eixo)chassiVO.getEixos().get(x);
//                eixoDAO.alterar(eixoVO);
//            }

            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel atualizar conta: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Conta) {
            contaVO = (Conta) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um registro da conta
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM conta WHERE codConta = "
                    + contaVO.getCodConta();

            //Faz a atualizacao na tabela Eixo
//            EixoDAO eixoDAO = new EixoDAO(banco);
//            Eixo eixoVO;
//            for(int x=0; x < chassiVO.getEixos().size(); x++) {
//            eixoVO = (Eixo)chassiVO.getEixos().get(x);
//             eixoVO.setChassi(null);
//             eixoDAO.alterar(eixoVO);
//            }
            if (stm.executeUpdate(sql) == 0) {
                banco.fechar();
                return false;
            } else {
                banco.fechar();
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Nao foi possivel deletar a conta: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        Vector hospedagens = new Vector(1);

        try {
            banco.abrir();
            //buscando registro da conta
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM conta WHERE codConta = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar registro de hospedagem da conta
    
    /**
     *  hospedagens = (Vector) new HospedagemDAO(banco).listar("codConta = " +
                        rs.getInt("codConta"));
     */         
   
                contaVO = new Conta();
                contaVO.setCodConta(rs.getInt("codConta"));
                contaVO.setDataEntrada(rs.getString("dataEntrada"));
                contaVO.setDataSaida(rs.getString("dataSaida"));
                contaVO.setValorConsumo(rs.getDouble("valorConsumo"));
                contaVO.setValorHospedagem(rs.getDouble("valorHospedagem"));
                
                return contaVO;
            } else
                return null; //não achou conta

        } catch (Exception ex) {
            System.out.println("Nao foi possviel realizar a busca na conta: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    
    }

}