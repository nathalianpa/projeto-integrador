package br.senac.sp.petfeliz_pi3.servlet;

import br.senac.sp.petfeliz.pi3.dao.ProdutoDAO;
import br.senac.sp.petfeliz.pi3.model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "ConsultaProduto", urlPatterns = {"/ConsultaProduto"})
public class ConsultaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Produto> produtos = null;

        try {
            produtos = ProdutoDAO.listarProdutos();
        } catch (Exception e) {
            response.sendRedirect("erro.jsp");
        }

        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("WEB-INF/Produto/pesquisaProduto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Variavel do id
        long id = Long.parseLong(request.getParameter("id"));

        Produto produto = null;
        try {
            if (ProdutoDAO.obter(id) == null) {
                response.sendRedirect("sucesso.jsp");
            } else {
                produto = ProdutoDAO.obter(id);
            }
        } catch (Exception e) {
            response.sendRedirect("erro.jsp");
        }
        request.setAttribute("prod", produto);

        //Request diretorio
        request.getRequestDispatcher("WEB-INF/Produto/exibirProduto.jsp").forward(request, response);
    }
}
