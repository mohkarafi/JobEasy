package JobConnect.Dao.Servlet;

import JobConnect.Dao.Dao.UtilisateurDao;
import JobConnect.Dao.Model.Utilisateur;
import JobConnect.Dao.Util.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UtilisateurDao utilisateurDao;

    @Override
    public void init() throws ServletException {
        utilisateurDao = new UtilisateurDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try{
            Utilisateur utilisateur = utilisateurDao.getUserByUsername(username);
            if(utilisateur != null && PasswordUtils.checkPassword(password , utilisateur.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("userID", utilisateur.getId());
                session.setAttribute("userRole", utilisateur.getRole());
                session.setAttribute("username", utilisateur.getUsername());

                if ("RECRUTEUR".equals(utilisateur.getRole())) {
                    resp.sendRedirect(req.getContextPath() + "list");
                } else if ("CONDIDAT".equals(utilisateur.getRole())) {
                   resp.sendRedirect(req.getContextPath() + "list");
                } else {
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("erreurMessage" , "Username or password incorrect");
                req.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
