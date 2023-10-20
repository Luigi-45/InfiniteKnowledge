package Utilities.BCRYPT;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptManagement {
    
    public static String encriptarContrasenia(String password){
        // Hash a password for the first time
	String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

	// gensalt's log_rounds parameter determines the complexity
	// the work factor is 2**log_rounds, and the default is 10
	//


        return hashed;
    }
    
    public static boolean verificarContrasenia(String password, String hashed){
        return BCrypt.checkpw(password,hashed);
    }
}
