package br.unipar;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/projeto";
    private static final String user = "postgres";
    private static final String password = "postgres";
    public static void main(String[] args) {
        criarTabelaUsuario();

    }
    //localhost: onde esta o banco
    //5432: porta padrao do banco
    public Connection connection() throws SQLException {
       return DriverManager.getConnection(url, user, password);
    }

    public static void criarTabelaUsuario(){
        try {
            Connection conn = connection();
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "codigo serial PRIMARY KEY,"
                    + "username VARCHAR(50) UNIQUE NOT NULL,"
                    + "password VARCHAR(300)NOT NULL,"
                    + "nome VARCHAR(50)NOT NULL,"
                    + "nascimento DATE)";
            statement.executeUpdate(sql);
        }catch (SQLException exception){
            System.out.println("TABELA CRIADA");
            exception.printStackTrace();
        }
    }
}
