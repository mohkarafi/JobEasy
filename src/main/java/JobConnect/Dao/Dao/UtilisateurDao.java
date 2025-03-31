package JobConnect.Dao.Dao;

import JobConnect.Dao.Model.Utilisateur;
import JobConnect.Dao.Util.DatabaseConnection;
import JobConnect.Dao.Util.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDao {
    public Utilisateur getUserByUsername(String username) {
        String sql = "SELECT * FROM utilisateur WHERE username = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery() ;
                if (resultSet.next()) {
                    return mapUtilisateur(resultSet);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Utilisateur getUserByEmail(String email)  {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql) ;
             statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapUtilisateur(resultSet);
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }


    public void registerUser(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (username, password, role, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, utilisateur.getUsername());
            statement.setString(2, PasswordUtils.hashPassword(utilisateur.getPassword())); // Hash the password
            statement.setString(3, utilisateur.getRole());
            statement.setString(4, utilisateur.getEmail());
            statement.executeUpdate();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    private Utilisateur mapUtilisateur(ResultSet resultSet) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(resultSet.getInt("id"));
        utilisateur.setUsername(resultSet.getString("username"));
        utilisateur.setPassword(resultSet.getString("password"));
        utilisateur.setRole(resultSet.getString("role"));
        utilisateur.setEmail(resultSet.getString("email"));
        return utilisateur;
    }
}
