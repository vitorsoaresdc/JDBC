import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeletaProduto {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Statement stmt = factory.criaConexao().createStatement();

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite um id para excluir? ");
        Integer id = entrada.nextInt();
        entrada.close();

       String sql = "DELETE FROM produtos WHERE id = ?";

       PreparedStatement ps = factory.criaConexao().prepareStatement(sql);
       ps.setInt(1, id);
       ps.execute();

       Integer linhasModificadas = ps.getUpdateCount();
        System.out.println("numero de linhas afetadas "+linhasModificadas);

       stmt.close();
       ps.close();
    }
}
