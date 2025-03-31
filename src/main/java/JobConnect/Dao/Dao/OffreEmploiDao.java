package JobConnect.Dao.Dao;

import JobConnect.Dao.Model.OffreEmploi;
import JobConnect.Dao.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreEmploiDao {
    public void addOffreEmploi(OffreEmploi offreEmploi)  {
        String sql = "INSERT INTO offre_emploi (titre, description, date_publication, entreprise) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setDate(3, new java.sql.Date(offreEmploi.getDatePublication().getTime()));
            statement.setString(4, offreEmploi.getEntreprise());
            statement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public OffreEmploi getOffreEmploi(int id) {
        String sql = "SELECT * FROM offre_emploi WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapOffreEmploi(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OffreEmploi> getAllOffreEmplois()  {
        List<OffreEmploi> offreEmplois = new ArrayList<>();
        String sql = "SELECT * FROM offre_emploi";
        try {
            Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    offreEmplois.add(mapOffreEmploi(resultSet));
                }
             }catch(Exception e){
            e.printStackTrace();
            }
        return offreEmplois;
    }

    public void updateOffreEmploi(OffreEmploi offreEmploi)  {
        String sql = "UPDATE offre_emploi SET titre = ?, description = ?, date_publication = ?, entreprise = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, offreEmploi.getTitre());
            statement.setString(2, offreEmploi.getDescription());
            statement.setDate(3, new java.sql.Date(offreEmploi.getDatePublication().getTime()));
            statement.setString(4, offreEmploi.getEntreprise());
            statement.setInt(5, offreEmploi.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    public void deleteOffreEmploi(int id)  {
        String sql = "DELETE FROM offre_emploi WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private OffreEmploi mapOffreEmploi(ResultSet resultSet) throws SQLException {
        OffreEmploi offreEmploi = new OffreEmploi();
        offreEmploi.setId(resultSet.getInt("id"));
        offreEmploi.setTitre(resultSet.getString("titre"));
        offreEmploi.setDescription(resultSet.getString("description"));
        offreEmploi.setDatePublication(resultSet.getDate("date_publication"));
        offreEmploi.setEntreprise(resultSet.getString("entreprise"));
        offreEmploi.setStatut(resultSet.getString("statut")); // Assuming statut is a String
        return offreEmploi;
    }
}
