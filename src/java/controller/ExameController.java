package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exame;
import model.ExameDAO;

@WebServlet(name = "ExameController", urlPatterns = {"/ExameController"})
public class ExameController extends HttpServlet {

    private int cod;
    private String exame;
    private double valor;
    private String especialidade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Verificando a existência de um código
        if (request.getParameter("cod") != null) {
            this.cod = Integer.parseInt(request.getParameter("cod"));
        }

        //Recebendo dados do formulário de cadastro
        this.exame = request.getParameter("exame");
        this.valor = Double.parseDouble(request.getParameter("valor"));
        this.especialidade = request.getParameter("especialidade");

        try {
            if (request.getParameter("cod") == null) {
                Exame exame = new Exame(
                        this.exame,
                        this.valor,
                        this.especialidade
                );

                ExameDAO exDao = new ExameDAO();
                exDao.insertExame(exame);
                response.sendRedirect("lista.jsp");
            } else {
                Exame exame = new Exame(
                        this.cod,
                        this.exame,
                        this.valor,
                        this.especialidade
                );

                ExameDAO exDao = new ExameDAO();
                exDao.updateExame(exame);
                response.sendRedirect("lista.jsp");
            }
        } catch (SQLException | ClassNotFoundException erro) {

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exames</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Ocorreu um erro :(</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
