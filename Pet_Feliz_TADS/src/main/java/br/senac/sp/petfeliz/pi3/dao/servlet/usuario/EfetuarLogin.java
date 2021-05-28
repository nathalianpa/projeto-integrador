/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.petfeliz.pi3.dao.servlet.usuario;

import br.senac.sp.petfeliz.pi3.dao.UsuarioDAO;
import br.senac.sp.petfeliz.pi3.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "EfetuarLogin", urlPatterns = {"/EfetuarLogin"})
public class EfetuarLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
       
        String usuario = null;
        try {
            if(UsuarioDAO.verificar(login, senha) == null){
                JOptionPane.showMessageDialog(null, "Usuario não existe ou login inválido.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                usuario = UsuarioDAO.verificar(login, senha);
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            }                        
        } catch (Exception e) {
            Logger.getLogger(EfetuarLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
