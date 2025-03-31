package JobConnect.Dao.Servlet;

import JobConnect.Dao.Dao.CandidatureDAO;
import JobConnect.Dao.Model.Candidature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Candidature")
public class CandidatureServlet extends HttpServlet {
    private CandidatureDAO condidatureDao ;

    @Override
    public void init() throws ServletException {
        condidatureDao = new CandidatureDAO();
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
                case "delete": DeleteCondidature(req, resp);
                    break;
                case "view":viewCondidature(req, resp);
                    break;
                case "list":
                default: ListCondidature(req, resp);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("ListOfCandidatures.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
      try{
          switch (action) {
              case "insert": AddCondidature(req, resp);
                  break;
              case "update":UpdateCondidature(req, resp);
                  break;
              case "list":
              default: ListCondidature(req, resp);
                  break;
          }
      } catch (Exception e) {
          e.printStackTrace();
          req.getRequestDispatcher("ListOfCandidatures.jsp").forward(req, resp);
      }
    }

    public void ShowNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddCandidature.jsp").forward(req, resp);
    }
    public void ShowEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidature condidature = new Candidature();
        int id = Integer.parseInt(req.getParameter("id"));
        condidature = condidatureDao.getCondidature(id);
        req.setAttribute("candidature", condidature);
        req.getRequestDispatcher("EditCandidature.jsp").forward(req, resp);
    }
    public void viewCondidature(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidature condidature = new Candidature();
        int id = Integer.parseInt(req.getParameter("id"));
        condidature = condidatureDao.getCondidature(id);
        req.setAttribute("candidature", condidature);
        req.getRequestDispatcher("ViewCandidature.jsp").forward(req, resp);
    }
    public void ListCondidature(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidature> listCondidatures= condidatureDao.GetAllCondidatures();
        req.setAttribute("listCandidatures" , listCondidatures);
        req.getRequestDispatcher("ListOfCandidatures.jsp").forward(req, resp);
    }
    public void DeleteCondidature(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id = Integer.valueOf(req.getParameter("id"));
        condidatureDao.DeleteCondidature(id);
        resp.sendRedirect("Condidature?action=list");
    }

    public void AddCondidature(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidature condidature = new Candidature();
        int OffreEmploiId = Integer.parseInt(req.getParameter("OffreEmploi_id"));
        int CondidatID = Integer.parseInt(req.getParameter("Condidat_id"));
        String statut = req.getParameter("statut");
        condidature.setLettreMotivation(req.getParameter("LettreDeMotivation"));
        condidature.setOffreEmploiId(OffreEmploiId);
        condidature.setCandidatId(CondidatID);
        condidature.setStatut(statut);
        condidatureDao.AjouterCondidature(condidature);
        resp.sendRedirect("Candidature?action=list");
    }

    public void UpdateCondidature (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidature condidature = new Candidature();
        int OffreEmploiId = Integer.parseInt(req.getParameter("OffreEmploi_id"));
        int CondidatID = Integer.parseInt(req.getParameter("Condidat_id"));
        condidature.setLettreMotivation(req.getParameter("LettreDeMotivation"));
        condidature.setOffreEmploiId(OffreEmploiId);
        condidature.setCandidatId(CondidatID);
        condidatureDao.AjouterCondidature(condidature);
        resp.sendRedirect("Candidature?action=list");
    }
}
