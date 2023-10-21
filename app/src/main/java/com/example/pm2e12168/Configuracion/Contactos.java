package com.example.pm2e12168.Configuracion;

public class Contactos
{
    // Nombre de la base de datos
    public static final String namedb = "PM2E12168";

    //Tablas de la base de datos Contactos
    public static final String Tabla_Contacto = "contactos";

    // Campos de la tabla
    public static final String id = "id";
    public static final String pais = "pais";
    public static final String nombre = "nombre";

    public static final String telefono = "telefono";
    public static final String nota = "nota";




    // Consultas de Base de datos

    public static final String CreateTableContactos = "CREATE TABLE contactos "+
            "( id INTEGER PRIMARY KEY AUTOINCREMENT, pais TEXT, nombre TEXT, telefono INTEGER, " +
            "nota TEXT, foto BLOB)";

    public static final String DropTableContactos = "DROP TABLE IF EXISTS contactos";

    //dml
    public static final String SelectTableContactos = "SELECT * FROM " + Contactos.Tabla_Contacto;



    //Tablas de la base de datos paises
    public static final String Tabla_paises = "paises";

    // Campos de la tabla
    public static final String compo_id_pais = "id_pais";
    public static final String campo_nombre_pais = "nombre_pais";

    public static final String CreateTablePais = "CREATE TABLE paises "+
            "( id_pais INTEGER PRIMARY KEY AUTOINCREMENT, nombre_pais TEXT)";

    public static final String DropTablePais = "DROP TABLE IF EXISTS paises";

    public static final String SelectTablePais = "SELECT * FROM " + Contactos.Tabla_paises;

}
