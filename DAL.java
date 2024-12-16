import java.sql.Connection;
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
}
