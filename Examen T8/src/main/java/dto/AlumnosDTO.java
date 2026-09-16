package dto;

import databese.DBConector;
import model.Alumnos;
import utils.ExcepcionNota;
import utils.SchemDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnosDTO {
    private static Scanner scanner;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public int registrarAlumno(Alumnos alumno) throws SQLException {
        connection = DBConector.getConnection();

        String query = String.format(
                "INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?)",
                SchemDB.TAB_ALUMNOS,
                SchemDB.COL_NOMBRE,
                SchemDB.COL_APELLIDO,
                SchemDB.COL_CORREO,
                SchemDB.COL_NOTA,
                SchemDB.COL_CALIFICADO,
                SchemDB.COL_ID_CURSO
        );

        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, alumno.getNombre());
        preparedStatement.setString(2, alumno.getApellido());
        preparedStatement.setString(3, alumno.getCorreo());
        preparedStatement.setInt(4, 0);
        preparedStatement.setBoolean(5, false);
        preparedStatement.setInt(6, alumno.getId_curso());

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate")) {
                throw new SQLException("Correo ya existente, introduce uno diferente");
            }
        }

        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            alumno.setId(id);
            return id;
        }
        return -1;
    }



    public Alumnos buscarCorreo(String correo) throws SQLException {
        connection = DBConector.getConnection();

        String query = String.format("SELECT * FROM %s WHERE %s = ? ",SchemDB.TAB_ALUMNOS,SchemDB.COL_CORREO);

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        if (resultSet.next()){

            return new Alumnos(
                resultSet.getInt(SchemDB.COL_ID),
                resultSet.getString(SchemDB.COL_NOMBRE),
                resultSet.getString(SchemDB.COL_APELLIDO),
                resultSet.getString(SchemDB.COL_CORREO),
                resultSet.getInt(SchemDB.COL_NOTA),
                resultSet.getBoolean(SchemDB.COL_CALIFICADO),
                resultSet.getInt(SchemDB.COL_ID_CURSO)
            );
        }
        return null;
    }


    public void calificaAlumno(String correo, int nota) throws SQLException {
        if (nota > 1 || nota < 10) {
            Alumnos alumnos = buscarCorreo(correo);

            if (alumnos == null){
                throw new SQLException("Alumno no esta registrado en Base de Datos");
            }
            connection = DBConector.getConnection();

            String query = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?",SchemDB.TAB_ALUMNOS,
                    SchemDB.COL_NOTA, SchemDB.COL_CALIFICADO, SchemDB.COL_CORREO);

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, nota);
            preparedStatement.setBoolean(5, true);
            preparedStatement.executeUpdate();

        } else {
            throw new ExcepcionNota("La nota debe ser entre 1 y 10");
        }
    }

    public List<Alumnos> sacarDatos() throws SQLException {
        connection = DBConector.getConnection();

        Alumnos alumnos = new Alumnos();
        List<Alumnos> lista = new ArrayList<>();

        String query = String.format("SELECT * FROM %s WHERE %s = true", SchemDB.TAB_ALUMNOS, SchemDB.COL_CALIFICADO);

        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);

        if (resultSet.next()){

             lista.add(new Alumnos(
                    resultSet.getInt(SchemDB.COL_ID),
                    resultSet.getString(SchemDB.COL_NOMBRE),
                    resultSet.getString(SchemDB.COL_APELLIDO),
                    resultSet.getString(SchemDB.COL_CORREO),
                    resultSet.getInt(SchemDB.COL_NOTA),
                    resultSet.getBoolean(SchemDB.COL_CALIFICADO),
                    resultSet.getInt(SchemDB.COL_ID_CURSO))
            );
            System.out.println("ID " + alumnos.getId() + ", Nombre " + alumnos.getNombre() + ", Apellido " +
                    alumnos.getApellido() + ", Correo" + alumnos.getCorreo() + ", Nota " +
                    alumnos.getNota() + ", Calificado " + alumnos.isCalificado() +
                    ", ID Ciclo " + alumnos.getId_curso());
        }
        return lista;
    }

}
