/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.dao.servlet.venda;

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
@WebServlet(name = "RelatorioVenda", urlPatterns = {"/RelatorioVenda"})
public class RelatorioVenda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Venda> vendas = null;
        
        try {
            vendas = VendaDAO.listarVendas();               
            
        } catch (Exception e) {
            response.sendRedirect("erro.jsp");
        }
        
        request.setAttribute("vendas", vendas);
        request.getRequestDispatcher("WEB-INF/Venda/relatorioVenda.jsp").forward(request, response);
    }
}
