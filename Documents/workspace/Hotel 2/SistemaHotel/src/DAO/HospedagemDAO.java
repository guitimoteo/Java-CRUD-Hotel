/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import banco.Banco;
import VO.Hospedagem;
import java.util.Vector;

/**
 *
 * @author Line
 */
public class HospedagemDAO implements DAO{
    
     private Banco banco;
     private Hospedagem hospedagemVO;
    
    public HospedagemDAO(Banco banco) {
        this.banco = banco;
    }


 
    public boolean cadastrar(Object obj) {
        
         if (obj instanceof Hospedagem) {
          hospedagemVO = (Hospedagem) obj;
        } else {
            return false;
        }
try {
            banco.abrir();
            //Incluindo um registro em hospedagem (Quarto e Hospede)
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "INSERT INTO Pagamento (codHospedagem, dataEntrada, dataSaida, hora ) VALUES ("
                    
                    + hospedagemVO.getCodHospedagem() + ", "
                    + hospedagemVO.getDataEntrada() + ", "
                    + hospedagemVO.getDataSaida() + ", "
                    + hospedagemVO.getHora() + ") ";

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
            System.out.println("Nao foi possivel cadastrar a hospedagem: " + ex.getMessage());
            return false;
        }

    }

    public boolean atualizar(Object obj) {
        if (obj instanceof Hospedagem) {
            hospedagemVO = (Hospedagem) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //atualizando registros de hospedagem
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "UPDATE Hospedagem SET dataEntrada = " + hospedagemVO.getDataEntrada()
                    + ", dataSaida = " + hospedagemVO.getDataSaida()
                    + ", hora = " + hospedagemVO.getHora()
                    + " WHERE codHospedagem = " + hospedagemVO.getCodHospedagem();

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
            System.out.println("Nao foi possivel atualizar o registro de hospedagem: " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(Object obj) {
        if (obj instanceof Hospedagem) {
            hospedagemVO = (Hospedagem) obj;
        } else {
            return false;
        }

        try {
            banco.abrir();
            //deletando um cadastro na hospedagem
            java.sql.Statement stm = banco.getConexao().createStatement();
            String sql = "DELETE FROM hospedagem WHERE codHospedagem = "
                    + hospedagemVO.getCodHospedagem();

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
            System.out.println("Nao foi possivel deletar o registro de hospedagem: " + ex.getMessage());
            return false;
        }
    }

    public Object buscar(int pk) {

        //Vector contas = new Vector(1);

        try {
            banco.abrir();
            //buscando registro na hospedagem
            java.sql.Statement stm = banco.getConexao().createStatement();
            java.sql.ResultSet rs = null;
            String sql = "SELECT * FROM hospedagem WHERE codHospedagem = "
                    + pk;

            //Lendo os dados
            rs = stm.executeQuery(sql);
            if (rs.next() == true) {
                //informar o quarto e o hospede dessa hospedagem.
                
                hospedagemVO = new Hospedagem();
                hospedagemVO.setCodHospedagem(rs.getInt("codHospedagem"));
                hospedagemVO.setDataEntrada(rs.getString("dataEntrada"));
                hospedagemVO.setDataSaida(rs.getString("dataSaida"));
                hospedagemVO.setHora(rs.getTime("time"));
                
                                
                return hospedagemVO;
            } else
                return null; //não achou hospedagem

        } catch (Exception ex) {
            System.out.println("Não foi possivel buscar registro de hospedagem: " + ex.getMessage());
            return null;
        } finally {
            banco.fechar();
        }
    }
    
}
