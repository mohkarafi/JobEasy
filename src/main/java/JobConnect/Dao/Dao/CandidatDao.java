package JobConnect.Dao.Dao;

import JobConnect.Dao.Model.Candidat;
import JobConnect.Dao.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class CandidatDao {
    public void AddCondidat(Candidat candidat) {
        String sql = "INSERT INTO candidat (nom, prenom, email, telephone, cv_path) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, candidat.getNom());
            preparedStatement.setString(2, candidat.getPrenom());
            preparedStatement.setString(3, candidat.getEmail());
            preparedStatement.setString(4, candidat.getTelephone());
            preparedStatement.setString(5, candidat.getCvPath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Candidat getondidat(int id ){
        String sql = "SELECT * FROM candidat WHERE id = ?";
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
                return mapCondidat(resultSet);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;
    }

    public void UpdateCondidat(Candidat candidat) {
        String sql = " Update Condidat Set nom  = ? , prenom = ?  , email = ? , telephone = ? , cvPath = ? , id = ?  VALUES (?, ?, ?, ?, ? , ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, candidat.getNom());
            preparedStatement.setString(2, candidat.getPrenom());
            preparedStatement.setString(3, candidat.getEmail());
            preparedStatement.setString(4, candidat.getTelephone());
            preparedStatement.setString(5, candidat.getCvPath());
            preparedStatement.setInt(6, candidat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeleteCondidat(int id) {
        String SQL = "Delete FROM candidat WHERE id = ?";
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Candidat> getAllCondidats(){
        String SQL = "SELECT * FROM candidat";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet resultSet = ps.executeQuery();
            List<Candidat> candidats = (List<Candidat>) mapCondidat(resultSet);
            return candidats;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Candidat mapCondidat(ResultSet rs) throws SQLException {
        Candidat candidat = new Candidat();
        candidat.setNom(rs.getString("nom"));
        candidat.setPrenom(rs.getString("prenom"));
        candidat.setEmail(rs.getString("email"));
        candidat.setTelephone(rs.getString("telephone"));
        candidat.setCvPath(rs.getString("cvPath"));
        return candidat;
    }
}
