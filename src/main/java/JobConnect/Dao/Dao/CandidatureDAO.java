package JobConnect.Dao.Dao;

import JobConnect.Dao.Model.Candidature;
import JobConnect.Dao.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO {

    public void AjouterCondidature(Candidature condidature) {
        String SQl = "insert into Condidature(LettreDeMotivation , OffreEmploi_id , Condidat_id ) value(?,?,?)";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            preparedStatement.setString(1 , condidature.getLettreMotivation());
            preparedStatement.setInt(2 , condidature.getOffreEmploiId());
            preparedStatement.setInt(3 , condidature.getCandidatId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Candidature> GetAllCondidatures(){
        String SQl = "select * from Condidature";
        List<Candidature> Condidatures = new ArrayList<Candidature>();
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQl);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 Condidatures.add(mapCondidature(resultSet));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Condidatures;
    }
    public Candidature getCondidature(int condidaturId) {
        String SQL ="Select * from Condidature where Condidat_id=?";

        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1 , condidaturId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                 Candidature condidature =  mapCondidature(resultSet);
                 return condidature;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void DeleteCondidature(int condidaturId) {
        String SQL ="Delete from Condidature where Condidat_id=?";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1 , condidaturId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateCondidature(Candidature condidature) {
        String SQL = "Update  Condidature set LettreDeMotivation = ? , Condidat_id = ? , OffreEmploi_id = ? , Statut = ?  where id =? ";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1 , condidature.getLettreMotivation());
            preparedStatement.setInt(2 , condidature.getOffreEmploiId());
            preparedStatement.setInt(3 , condidature.getCandidatId());
            preparedStatement.setString(4 , condidature.getStatut() );
            preparedStatement.setInt(5 , condidature.getId());
            preparedStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public Candidature mapCondidature(ResultSet rs) throws SQLException {
        Candidature condidature = new Candidature();
        condidature.setId(rs.getInt("id"));
        condidature.setCandidatId(rs.getInt("Condidat_id"));
        condidature.setOffreEmploiId(rs.getInt("OffreEmploi_id"));
        condidature.setStatut(rs.getString("Statut"));
        condidature.setLettreMotivation(rs.getString("LettreDeMotivation"));
        condidature.setDateCandidature(rs.getDate("DateCandidature"));
        return condidature;
    }
}
