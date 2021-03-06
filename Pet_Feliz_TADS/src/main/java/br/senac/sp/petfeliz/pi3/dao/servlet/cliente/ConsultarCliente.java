/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.dao.servlet.cliente;

import br.senac.sp.petfeliz.pi3.dao.ClienteDAO;
import br.senac.sp.petfeliz.pi3.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "ConsultarCliente", urlPatterns = {"/ConsultarCliente"})
public class ConsultarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = null;

        try {
            clientes = ClienteDAO.listarClientes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("WEB-INF/Cliente/pesquisarCliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Variavel do id
        long id = Long.parseLong(request.getParameter("id"));

        Cliente cliente = null;
        try {
            if (ClienteDAO.pesquisar(id) == null) {
                       response.sendRedirect("cliente_encontrado_sucesso.jsp");
            } else {
                cliente = ClienteDAO.pesquisar(id);
            }
        } catch (Exception e) {
                       response.sendRedirect("cliente_encontrado_sucesso.jsp");
        }
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("WEB-INF/Cliente/resultadoConsulta.jsp").forward(request, response);
    }
}
