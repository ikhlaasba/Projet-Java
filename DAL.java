import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAL {

    public static void main(String[] args) {
        try {
            // Check if the database connection is successful
            if (DBConnection.connect() != null) {
                System.out.println("Database connection successful!");
                
                // Fetch all rooms and pass them to the frontend
                List<Chambre> chambres = selectAllChambres();
                
                // You can print the list or pass it to the frontend (e.g., JavaFX)
                for (Chambre chambre : chambres) {
                    System.out.println(chambre);  // This is just for testing, can be removed for production
                }
                System.out.println(updateResident(1, "bonne sante"));
                System.out.println(removeResident(1));
                System.out.println(addResident(1,"flen","fleni",LocalDate.parse("2024-12-16"),"bonne sante"));
            }
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    //********************SELECT ALL Chambres******************* */
    
    public static List<Chambre> selectAllChambres() {
        String nomTab = "chambre"; 
        String sql = "SELECT * FROM " + nomTab;

        List<Chambre> chambres = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
    
            while (rs.next()) {
                int numero = rs.getInt("numero");
                String type = rs.getString("type");
                String statut = rs.getString("statut");

                chambres.add(new Chambre(numero, type, statut));
            }

        } catch (Exception e) {
            System.out.println("Error occurred while fetching data!");
            e.printStackTrace();
        }

        return chambres;  
    }

    /********************SELECT ALL RESIDENTS******************** */
    
    public static List<Resident> selectAllResidents() {
        String nomTab = "resident";  
        String sql = "SELECT * FROM " + nomTab;

        List<Resident> Residents = new ArrayList<>();  

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int id_resident = rs.getInt("id_resident");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                LocalDate date_naissance= rs.getObject("date_naissance", LocalDate.class);
                String  dossier_medical = rs.getString("dossier_medical");
                
                Residents.add(new Resident(id_resident,nom,prenom,date_naissance,dossier_medical));
            }

        } catch (Exception e) {
            System.out.println("Error occurred while fetching data!");
            e.printStackTrace();
        }

        return Residents; 
    }

     /********************Update residents******************** */


    public static boolean updateResident(int idResident, String newDossierMedical) {
    String sql = "UPDATE resident SET dossier_medical = ? WHERE id_resident = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        
        pstmt.setString(1, newDossierMedical); 
        pstmt.setInt(2, idResident);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating dossier_medical!");
        e.printStackTrace();
        return false;
    }
}

 /********************REMOVE RESIDENTS******************** */

public static boolean removeResident(int idResident) {
    String sql = "DELETE FROM resident WHERE id_resident = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, idResident); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the resident!");
        e.printStackTrace();
        return false; 
    }
}
/********************add RESIDENTS******************** */
public static boolean addResident(int id_resident, String nom, String prenom, LocalDate date_naissance, String dossier_medical) {
    String sql = "INSERT INTO resident (id_resident, nom, prenom, date_naissance, dossier_medical) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, id_resident); // Set the id_resident
        pstmt.setString(2, nom);
        pstmt.setString(3, prenom);
        pstmt.setObject(4, date_naissance); // Pass LocalDate directly
        pstmt.setString(5, dossier_medical);

        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0; // Returns true if the insert was successful

    } catch (Exception e) {
        System.out.println("Error occurred while adding the resident!");
        e.printStackTrace();
        return false;
    }
}


}
