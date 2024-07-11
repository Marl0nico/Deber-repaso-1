import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/estudiantes2024a";
        String usuario="root";
        String contraseña="";
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre=scanner.nextLine();
        System.out.print("Ingrese la cédula del estudiante: ");
        String cedula=scanner.nextLine();
        System.out.print("Ingrese la nota del bimestre 1: ");
        Double b1=scanner.nextDouble();
        System.out.print("Ingrese la nota del bimestre 2: ");
        Double b2=scanner.nextDouble();
        String sql="INSERT INTO estudiantes(cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";
        try (Connection connection= DriverManager.getConnection(url, usuario, contraseña)){
            PreparedStatement cadenaPreparada=connection.prepareStatement(sql);
            cadenaPreparada.setString(1, cedula);
            cadenaPreparada.setString(2, nombre);
            cadenaPreparada.setDouble(3, b1);
            cadenaPreparada.setDouble(4, b2);
            cadenaPreparada.executeUpdate();
            System.out.println("Dato insertado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}