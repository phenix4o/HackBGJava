public class DatabaseCorruptedException extends RuntimeException{
    @Override 
    public String getMessage() {
        return "The username  must not be blank/empty! Please fill it, before you use this database! "; 
    } 
} 