/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.dao.servlet.venda;

import br.senac.sp.petfeliz.pi3.dao.ClienteDAO;
import br.senac.sp.petfeliz.pi3.dao.FuncionarioDAO;
import br.senac.sp.petfeliz.pi3.dao.ProdutoDAO;
import br.senac.sp.petfeliz.pi3.dao.VendaDAO;
import br.senac.sp.petfeliz.pi3.model.Cliente;
import br.senac.sp.petfeliz.pi3.model.Funcionario;
import br.senac.sp.petfeliz.pi3.model.Produto;
import br.senac.sp.petfeliz.pi3.model.Venda;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Nathalia
 */

@WebServlet(name = "CadastrarVenda", urlPatterns = {"/CadastrarVenda"})
public class CadastrarVenda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> produtos = null;
        List<Funcionario> funcionarios = null;
        List<Cliente> clientes = null;
        
        try {
           produtos = ProdutoDAO.listarProdutos();
           funcionarios = FuncionarioDAO.listarFuncionarios();
           clientes = ClienteDAO.listarClientes();
        } catch (Exception e) {
            response.sendRedirect("erro.jsp");
        }
        
        request.setAttribute("produtos", produtos);
        request.setAttribute("funcionarios", funcionarios);
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("WEB-INF/Venda/cadastrarVenda.jsp").forward(request, response); 
    }
    
    @Override
        protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            
        Long id_funcionario = Long.parseLong(request.getParameter("id_funcionario"));
        Long id_cliente = Long.parseLong(request.getParameter("id_cliente"));
        Long id_produto = Long.parseLong(request.getParameter("id_produto"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
        Funcionario funcionario = null;
        Cliente cliente = null;
        Produto produto = null;
        
        try {
            if(FuncionarioDAO.obter(id_funcionario) == null){
                                response.sendRedirect("func_nao_encontrado.jsp");

            }else if(ClienteDAO.pesquisar(id_cliente) == null) {
                                response.sendRedirect("cliente_nao_encontrado.jsp");
            } else if(ProdutoDAO.obter(id_produto) == null) {
                                response.sendRedirect("produto_nao_encontrado.jsp");
            } else {
                
                Venda venda = new Venda(id_funcionario, id_cliente, id_produto, quantidade);
                VendaDAO.inserirVenda(venda);
                                response.sendRedirect("venda_cadastrada.jsp");
            }
            
        } catch (Exception e) {
                                response.sendRedirect("venda_nao_cadastrada.jsp");
        }
        
   
   }
}
