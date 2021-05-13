/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.dao;

import java.sql.Connection;
import br.senac.petfeliz.pi3.Conexao;
import br.senac.sp.petfeliz.pi3.model.Venda;
import br.senac.sp.petfeliz.pi3.model.Cliente;
import br.senac.sp.petfeliz.pi3.model.Funcionario;
import br.senac.sp.petfeliz.pi3.model.Produto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathalia
 */
public class VendaDAO {
    Connection conexao;
    
        public VendaDAO(Connection conexao) {
        
            this.conexao = conexao;
    }
        public static void inserirVenda(Venda venda) throws SQLException, Exception {
            String sqlInserir =
            "INSERT INTO VENDA(ID_CLIENTE, ID_FUNCIONARIO, ID_PRODUTO, QUANTIDADE, DT_VENDA)"
            + " VALUES (?,?,?,?, NOW())";
            
            Connection connection = null;
            
            PreparedStatement preparedStatement = null;
            
            try {
                //Abre uma conexão com o banco de dados
                connection = Conexao.getConexao();
                //Cria um statement para execução de instruções SQL
                preparedStatement = connection.prepareStatement(sqlInserir);
                
                preparedStatement.setLong(1, venda.getId_cliente());
                preparedStatement.setLong(2, venda.getId_funcionario());
                preparedStatement.setLong(3, venda.getId_produto());
                preparedStatement.setInt(4, venda.getQuantidade());
                
                preparedStatement.execute();
            }
                finally {
                  
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
                }
                
                if (connection != null && !connection.isClosed()) {
                connection.close();
                }
            }
        }
        
        public static List<Venda> listarVendas() {        
        List<Venda> vendas = new ArrayList<Venda>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
                
        try {           
            connection = Conexao.getConexao();           
            String sql = "SELECT * FROM VENDA";
            java.sql.Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);            

            while (rs.next()) {
                
                Venda venda = new Venda();

                long codigo = rs.getLong("ID");
                long id_cliente = rs.getLong("ID_CLIENTE");
                long id_funcionario = rs.getLong("ID_FUNCIONARIO");
                long id_produto = rs.getLong("ID_PRODUTO");
                int quantidade = rs.getInt("QUANTIDADE");              
                Date dataVenda = rs.getDate("DT_VENDA");

                venda.setId(codigo);
                venda.setId_cliente(id_cliente);
                venda.setId_funcionario(id_funcionario);
                venda.setId_produto(id_produto);
                venda.setQuantidade(quantidade);
                venda.setDt_venda(dataVenda);
                
                vendas.add(venda);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        
        }
        return vendas;
    }
}
