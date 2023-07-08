import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
   public Connection criaConexao() throws SQLException {

       String url = "jdbc:mysql://localhost:8889/jdbc";
       String user = "root";
       String password = "root";

       return DriverManager.getConnection(url, user, password);

        }
    }