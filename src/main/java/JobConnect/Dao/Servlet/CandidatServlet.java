package JobConnect.Dao.Servlet;

import JobConnect.Dao.Dao.CandidatDao;
import JobConnect.Dao.Model.Candidat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Condidat")
public class CandidatServlet extends HttpServlet {
    private CandidatDao condidatDao ;

    @Override
    public void init() {
        condidatDao = new CandidatDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try{
            switch (action) {
                case "new": ShowNewForm(req, resp);
                    break;
                case "edit": ShowEditForm(req, resp);
                    break;
                case "delete": DeleteCondidat(req, resp);
                    break;
                case "view":ViewCondidat(req, resp);
                    break;
                case "list":
                default: ListOfCondidat(req, resp);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("ListOfCandidat.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try{
            switch (action) {
                case "insert": InsertCondidat(req, resp);
                    break;
                case "update":UpdateCondidat(req, resp);
                    break;
                case "list":
                default: ListOfCondidat(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("ListOfCandidat.jsp").forward(req, resp);
        }
    }

private void InsertCondidat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidat candidat = new Candidat();
        candidat.setId(Integer.parseInt(req.getParameter("id")));
        candidat.setNom(req.getParameter("nom"));
        candidat.setPrenom(req.getParameter("prenom"));
        candidat.setEmail(req.getParameter("email"));
        candidat.setTelephone(req.getParameter("telephone"));
        candidat.setCvPath(req.getParameter("cvPath"));
        condidatDao.AddCondidat(candidat);
        req.getRequestDispatcher("ListOfCandidat.jsp").forward(req , resp );
    }

    private void UpdateCondidat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidat candidat = new Candidat();
        candidat.setId(Integer.parseInt(req.getParameter("id")));
        candidat.setNom(req.getParameter("nom"));
        candidat.setPrenom(req.getParameter("prenom"));
        candidat.setEmail(req.getParameter("email"));
        candidat.setTelephone(req.getParameter("telephone"));
        candidat.setCvPath(req.getParameter("cvPath"));
        condidatDao.UpdateCondidat(candidat);
        req.getRequestDispatcher("ListOfCandidat.jsp").forward(req , resp );
    }
    private void ListOfCondidat(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Candidat> candidats = condidatDao.getAllCondidats();
        request.setAttribute("candidats", candidats);
        request.getRequestDispatcher("ListOfCandidat.jsp").forward(request , response );
    }
    private  void ViewCondidat(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Candidat candidat = condidatDao.getondidat(id);
        request.setAttribute("candidat", candidat);
        request.getRequestDispatcher("ViewCandidat.jsp").forward(request , response );
    }
    private void ShowNewForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("AddCandidat.jsp").forward(request , response );
    }

    private  void ShowEditForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Candidat candidat = condidatDao.getondidat(id);
        request.setAttribute("candidat", candidat);
        request.getRequestDispatcher("EditCandidat.jsp").forward(request , response );
    }

    private void DeleteCondidat(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        condidatDao.DeleteCondidat(id);
        response.sendRedirect("condidat?action=list");
    }


}
