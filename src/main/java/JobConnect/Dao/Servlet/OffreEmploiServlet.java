package JobConnect.Dao.Servlet;

import JobConnect.Dao.Dao.OffreEmploiDao;
import JobConnect.Dao.Model.OffreEmploi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OffreEmploiServlet extends HttpServlet {
    private static   final SimpleDateFormat FormatDate =  new SimpleDateFormat("yyyy/mm/dd");
    private OffreEmploiDao offreEmploiDao;
    @Override
    public void init() throws ServletException {
        offreEmploiDao = new OffreEmploiDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action == null){
            action = "List";
        }
        try{
            switch (action){
                case("/new") :
                    ShowNewForm(req, resp);
                    break;
                case("/edit") :
                    ShowEditForm(req, resp);
                    break;
                case("view") :
                    ViewOffreEmploi(req, resp);
                    break;
                case("/delete") :
                    DeleteOffreEmploi(req, resp);
                    break;
                case("/list"):
                default:
                    ListOfOffres(req, resp);
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("ListCandidats.jsp").forward(req , resp );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "insert";
            switch(action){
                case("insert"):
                    AddOffreEmploi(req, resp);
                    break;
                case("update")  :
                    UpdateOffreEmploi(req, resp);
                    break;
                case("list") :
                default:
                    ListOfOffres(req, resp);
                    break;

            }
        }
    }


    public void ShowNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddOffreEmploi.jsp").forward(req , resp);
    }
    public void ShowEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        OffreEmploi offreEmploi = offreEmploiDao.getOffreEmploi(id);
        req.setAttribute("offreEmploi", offreEmploi);
        req.getRequestDispatcher("EditOffreEmploi.jsp").forward(req , resp);
    }
    public void ViewOffreEmploi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        OffreEmploi offreEmploi = offreEmploiDao.getOffreEmploi(id);
        req.setAttribute("offreEmploi", offreEmploi);
        req.getRequestDispatcher("viewOffreEmploi.jsp").forward(req , resp);
    }

    public void DeleteOffreEmploi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        offreEmploiDao.deleteOffreEmploi(id);
        resp.sendRedirect(req.getContextPath() + "/list");
    }
    public void ListOfOffres(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OffreEmploi> OffreEmploiList = offreEmploiDao.getAllOffreEmplois();
        req.setAttribute("OffreEmploiList", OffreEmploiList);
        req.getRequestDispatcher("ListOffreEmploi.jsp").forward(req , resp);
    }
    public void AddOffreEmploi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OffreEmploi offreEmploi = new OffreEmploi();
        String titre = req.getParameter("title");
        String description = req.getParameter("description");
        String datePublication = req.getParameter("datePublication");
        String entreprise = req.getParameter("entreprise");
        String statut = req.getParameter("statut");
        try{
            Date DateDEPublication = FormatDate.parse(datePublication);
            offreEmploi.setDatePublication(DateDEPublication);
            offreEmploi.setEntreprise(entreprise);
            offreEmploi.setStatut(statut);
            offreEmploi.setTitre(titre);
            offreEmploi.setDescription(description);
            offreEmploiDao.addOffreEmploi(offreEmploi);
            resp.sendRedirect(req.getContextPath() + "list");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateOffreEmploi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OffreEmploi offreEmploi = new OffreEmploi();
        String titre = req.getParameter("title");
        String description = req.getParameter("description");
        String datePublication = req.getParameter("datePublication");
        String entreprise = req.getParameter("entreprise");
        String statut = req.getParameter("statut");
        try{
            Date DateDEPublication = FormatDate.parse(datePublication);
            offreEmploi.setDatePublication(DateDEPublication);
            offreEmploi.setEntreprise(entreprise);
            offreEmploi.setStatut(statut);
            offreEmploi.setTitre(titre);
            offreEmploi.setDescription(description);
            offreEmploiDao.addOffreEmploi(offreEmploi);
            resp.sendRedirect(req.getContextPath() + "/list");
        } catch (ParseException e) {
          e.printStackTrace();
          req.getRequestDispatcher("editOffreEmploi.jsp").forward(req , resp);
        }
    }
}
