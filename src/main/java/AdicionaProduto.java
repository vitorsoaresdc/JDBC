import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdicionaProduto {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Statement stmt = factory.criaConexao().createStatement();

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite um nome: ");
        String nome = entrada.nextLine();
        System.out.print("Digite uma descricao: ");
        String descricao = entrada.nextLine();
        System.out.print(" Salvo com SUCESSO!");
        entrada.close();

        String sql = "INSERT INTO produtos(nome, descricao) values(?, ?)";

        PreparedStatement ps = factory.criaConexao().prepareStatement(sql);
        ps.setString(1,nome);
        ps.setString(2,descricao);
        ps.execute();
        Integer imprimeLinhasAfetadas = ps.getUpdateCount();
        System.out.println("\n Numero de linhas afetadas: "+imprimeLinhasAfetadas);

        ps.close();
        stmt.close();

    }
}
