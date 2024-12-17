import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAL {

    
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
 /********************ADD CHAMBRE******************** */

public static boolean addChambre(int numero, String type, String statut) {
    String sql = "INSERT INTO chambre (numero, type, statut) VALUES (?, ?, ?)";
    boolean isAdded = false;

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, numero);                    
        pstmt.setString(2, type);                
        pstmt.setString(3, statut);        

        int rowsAffected = pstmt.executeUpdate();   
        isAdded = (rowsAffected > 0);               

    } catch (Exception e) {
        System.out.println("Error occurred while adding the chambre!");
        e.printStackTrace();
    }

    return isAdded;
}

/********************ADD PERSONNEL ADMINISTRATIF******************** */

public static boolean addPersonnelAdministratif(int id, String nom, String prenom, double salaire, int horaireDeTravail, String responsabilite, int numeroBureau) {
    String sql = "INSERT INTO personnel_administratif (id, nom, prenom, salaire, horaire_de_travail, responsabilite, numero_bureau) VALUES (?, ?, ?, ?, ?, ?, ?)";
    boolean isAdded = false;

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.setString(2, nom);                    
        pstmt.setString(3, prenom);                
        pstmt.setDouble(4, salaire);        
        pstmt.setInt(5, horaireDeTravail);
        pstmt.setString(6, responsabilite);
        pstmt.setInt(7, numeroBureau);

        int rowsAffected = pstmt.executeUpdate();   
        isAdded = (rowsAffected > 0);               

    } catch (Exception e) {
        System.out.println("Error occurred while adding the personnel administratif!");
        e.printStackTrace();
    }

    return isAdded;
}

/********************ADD PERSONNEL MENAGE******************** */

public static boolean addPersonnelMenage(int id, String nom, String prenom, double  salaire, int horaireDeTravail, String tache) {
    String sql = "INSERT INTO personnel_menage (id, nom, prenom, salaire, horaire_de_travail, tache) VALUES (?, ?, ?, ?, ?, ?)";
    boolean isAdded = false;

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.setString(2, nom);                    
        pstmt.setString(3, prenom);                
        pstmt.setDouble(4, salaire);        
        pstmt.setInt(5, horaireDeTravail);
        pstmt.setString(6, tache);

        int rowsAffected = pstmt.executeUpdate();   
        isAdded = (rowsAffected > 0);               

    } catch (Exception e) {
        System.out.println("Error occurred while adding the personnel menage!");
        e.printStackTrace();
    }

    return isAdded;
}

/********************ADD PERSONNEL SANTE******************** */

public static boolean addPersonnelSante(int id, String nom, String prenom, double salaire, int horaireDeTravail, String specialite) {
    String sql = "INSERT INTO personnel_sante (id, nom, prenom, salaire, horaire_de_travail, specialite) VALUES (?, ?, ?, ?, ?, ?)";
    boolean isAdded = false;

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id);
        pstmt.setString(2, nom);                    
        pstmt.setString(3, prenom);                
        pstmt.setDouble(4, salaire);        
        pstmt.setInt(5, horaireDeTravail);
        pstmt.setString(6, specialite);

        int rowsAffected = pstmt.executeUpdate();   
        isAdded = (rowsAffected > 0);               

    } catch (Exception e) {
        System.out.println("Error occurred while adding the personnel sante!");
        e.printStackTrace();
    }

    return isAdded;
}

/********************ADD SERVICE******************** */

public static boolean addService(String service, int duree) {
    String sql = "INSERT INTO service (service, duree) VALUES (?, ?)";
    boolean isAdded = false;

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, service);                    
        pstmt.setInt(2, duree);        

        int rowsAffected = pstmt.executeUpdate();   
        isAdded = (rowsAffected > 0);               

    } catch (Exception e) {
        System.out.println("Error occurred while adding the service!");
        e.printStackTrace();
    }

    return isAdded;
}

/********************REMOVE CHAMBRE**************************** */

public static boolean removeChambre(int numero) {
    String sql = "DELETE FROM chambre WHERE numero = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, numero); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the chambre!");
        e.printStackTrace();
        return false; 
    }
}
/********************REMOVE PERSONNEL ADMINISTRATIF**************************** */

public static boolean removePersonnelAdministratif(int id) {
    String sql = "DELETE FROM personnel_administratif WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the personnel administratif!");
        e.printStackTrace();
        return false; 
    }
}



/********************REMOVE PERSONNEL MENAGE**************************** */


public static boolean removePersonnelMenage(int id) {
    String sql = "DELETE FROM personnel_menage WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the personnel menage!");
        e.printStackTrace();
        return false; 
    }
}


/********************REMOVE PERSONNEL SANTE**************************** */

public static boolean removePersonnelSante(int id) {
    String sql = "DELETE FROM personnel_sante WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, id); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the personnel sante!");
        e.printStackTrace();
        return false; 
    }
}


/********************REMOVE SERVICE**************************** */


public static boolean removeService(String serviceName) {
    String sql = "DELETE FROM service WHERE service = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, serviceName); 
        int affectedRows = pstmt.executeUpdate();

        return affectedRows > 0; 

    } catch (Exception e) {
        System.out.println("Error occurred while removing the service!");
        e.printStackTrace();
        return false; 
    }
}

/*******************SELECT ALL PERSONNEL ADMINISTRATIF*****************************/

public static List<Administratif> selectAllPersonnelAdministratif() {
    String nomTab = "personnel_administratif"; 
    String sql = "SELECT * FROM " + nomTab;

    List<Administratif> personnel = new ArrayList<>();

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
    
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            double salaire = rs.getDouble("salaire");
            int horaireDeTravail = rs.getInt("horaire_de_travail");
            String responsabilite = rs.getString("responsabilite");
            int numeroBureau = rs.getInt("numero_bureau");

            personnel.add(new Administratif(id,nom,prenom,horaireDeTravail,responsabilite,numeroBureau,salaire));
        }

    } catch (Exception e) {
        System.out.println("Error occurred while fetching personnel administratif data!");
        e.printStackTrace();
    }

    return personnel;  
}

/*******************SELECT ALL PERSONNEL MENAGE*****************************/


public static List<Menage> selectAllPersonnelMenage() {
    String nomTab = "personnel_menage"; 
    String sql = "SELECT * FROM " + nomTab;

    List<Menage> personnel = new ArrayList<>();

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
    
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Double salaire = rs.getDouble("salaire");
            int horaireDeTravail = rs.getInt("horaire_de_travail");
            String tache = rs.getString("tache");

            personnel.add(new Menage(id,nom,prenom,horaireDeTravail,tache,salaire));
        }

    } catch (Exception e) {
        System.out.println("Error occurred while fetching personnel menage data!");
        e.printStackTrace();
    }

    return personnel;  
}


/*******************SELECT ALL PERSONNEL SANTE*****************************/

public static List<Sante> selectAllPersonnelSante() {
    String nomTab = "personnel_sante"; 
    String sql = "SELECT * FROM " + nomTab;

    List<Sante> personnel = new ArrayList<>();

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
    
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Double salaire = rs.getDouble("salaire");
            int horaireDeTravail = rs.getInt("horaire_de_travail");
            String specialite = rs.getString("specialite");

            personnel.add(new Sante(id,nom,prenom,horaireDeTravail,specialite,salaire));
        }

    } catch (Exception e) {
        System.out.println("Error occurred while fetching personnel sante data!");
        e.printStackTrace();
    }

    return personnel;  
}

/*******************SELECT ALL SERVICE****************************/

public static List<Service> selectAllServices() {
    String nomTab = "service"; 
    String sql = "SELECT * FROM " + nomTab;

    List<Service> services = new ArrayList<>();

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
    
        while (rs.next()) {
            String service = rs.getString("service");
            int duree = rs.getInt("duree");

            services.add(new Service(service, duree));
        }

    } catch (Exception e) {
        System.out.println("Error occurred while fetching service data!");
        e.printStackTrace();
    }

    return services;  
}

 /*******************************UPDATE CHAMBRE******************************** */

public static boolean updateChambre(int numero, String newStatut) {
    String sql = "UPDATE chambre SET statut = ? WHERE numero = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, newStatut); 
        pstmt.setInt(2, numero);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating chambre statut!");
        e.printStackTrace();
        return false;
    }
}
 /*******************************UPDATE PERSONNEL ADMINISTRATIF******************************** */

public static boolean updatePersonnelAdministratif(int id, double newSalaire) {
    String sql = "UPDATE personnel_administratif SET salaire = ? WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setDouble(1, newSalaire); 
        pstmt.setInt(2, id);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating personnel administratif salaire!");
        e.printStackTrace();
        return false;
    }
}


 /*******************************UPDATE PERSONNEL MENAGE******************************** */

public static boolean updatePersonnelMenage(int id, String newTache) {
    String sql = "UPDATE personnel_menage SET tache = ? WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, newTache); 
        pstmt.setInt(2, id);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating personnel menage tache!");
        e.printStackTrace();
        return false;
    }
}

 /*******************************UPDATE PERSONNEL SANTE******************************** */

public static boolean updatePersonnelSante(int id, double newSalaire) {
    String sql = "UPDATE personnel_sante SET salaire = ? WHERE id = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setDouble(1, newSalaire); 
        pstmt.setInt(2, id);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating personnel sante specialite!");
        e.printStackTrace();
        return false;
    }
}


 /*******************************UPDATE SERVICE******************************** */


public static boolean updateService(String serviceName, int newDuree) {
    String sql = "UPDATE service SET duree = ? WHERE service = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, newDuree); 
        pstmt.setString(2, serviceName);          
        int lignes = pstmt.executeUpdate();
        
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Error occurred while updating service duree!");
        e.printStackTrace();
        return false;
    }
}


public static void main(String[] args) {
        try {
            // Check if the database connection is successful
            if (DBConnection.connect() != null) {
                System.out.println("Database connection successful!");
                
                // Fetch all rooms and pass them to the frontend
                List<Resident> y = selectAllResidents();
                
                // You can print the list or pass it to the frontend (e.g., JavaFX)
                /*for (Resident x : y) {
                    System.out.println(x);  // This is just for testing, can be removed for production
                }*/
               System.out.println(updatePersonnelMenage(1,"neetoiage saale d'acceuil"));
                
            }
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

}
