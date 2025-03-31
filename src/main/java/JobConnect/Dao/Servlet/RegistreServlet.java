package JobConnect.Dao.Servlet;

import JobConnect.Dao.Dao.UtilisateurDao;
import JobConnect.Dao.Model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registre")
public class RegistreServlet extends HttpServlet {
    private UtilisateurDao utilisateurDao ;

    @Override
    public void init() throws ServletException {
        utilisateurDao = new UtilisateurDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registre.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        utilisateur.setEmail(email);
        utilisateur.setRole(role);
        try{
            utilisateurDao.registerUser(utilisateur);
            resp.sendRedirect("login.jsp");
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("registre.jsp").forward(req, resp);
        }
    }
}
