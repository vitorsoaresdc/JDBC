import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListaProdutos {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Statement stmt = factory.criaConexao().createStatement();

        stmt.execute("select id, nome, descricao from produtos");

        ResultSet rst = stmt.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("id");
            System.out.print(id+" ");
            String nome = rst.getString("nome");
            System.out.print(nome+" | ");
            String descricao = rst.getString("descricao");
            System.out.println(descricao);
        }

        stmt.close();
    }
}
