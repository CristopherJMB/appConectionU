package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 20/6/2017.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

   // public SQLite_OpenHelper(MainActivity mainActivity, String bd1, Object factory, int version) {
      //  super(mainActivity, bd1, (SQLiteDatabase.CursorFactory) factory, version);
    //}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table userprof(_ID integer primary key autoincrement, " +
                "Nombre text, Apellido text, Correo text, Password text )";
        String querya="create table useralum(_ID integer primary key autoincrement, " + //TABLA DE ALUMNO
                "Nombre text, Apellido text, Correo text, Password text )";
        String queryp="create table creargrupo(_ID integer primary key autoincrement,"+ //TABLA DE CREACION DE GRUPO
                "Materia text, Curso text )";
        String querym="create table enviarmensaje(_ID integer primary key autoincrement, "+
                "Titulo text, Mensaje text )"; //TABLA DE RECEPCION DE MENSAJE

        db.execSQL(query);
        db.execSQL(queryp);
        db.execSQL(querya);
        db.execSQL(querym);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    //METODO QUE ME PERMITE ABRIR LA BASE  DE DATOS
    public void abrir(){
        this.getWritableDatabase();
    }

    //METODO QUE ME CERRAR ABRIR LA BASE DD DATOS
    public void cerrar(){
        this.close();
    }

    //METODO QUE PERMITE INSERTAR REGISTROS EN LA TABLA USERPROF
    public void insertarReg(String nom, String ape, String mail, String pass){
        ContentValues valores = new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Apellido",ape);
        valores.put("Correo",mail);
        valores.put("Password",pass);
        this.getWritableDatabase().insert("userprof",null,valores);

    }
    //METODO PERMITE REGISTRAR EL MSN
    public void insertarMsn (String msn, String tit){
        ContentValues valoresM = new ContentValues();
        valoresM.put("Titulo",tit);
        valoresM.put("Mensaje",msn);
        this.getWritableDatabase().insert("enviarmensaje",null,valoresM);
    }

    //METODO QUE PERMITE INSERTAR REGISTRO EN LA TABLA DE ALUMNOS
    public void insertarRegA(String nom, String ape,String mail, String pass){
        ContentValues valoresA =new ContentValues();
        valoresA.put("Nombre",nom);
        valoresA.put("Apellidos",ape);
        valoresA.put("Correo",mail);
        valoresA.put("Password",pass);
        this.getWritableDatabase().insert("useralum",null,valoresA);
    }


    //METODO QUE PERMITE INGRESAR REGISTROS A LA TABLA DE GRUPOS
    public void insertRegGrup(String mat, String curs) {
        ContentValues valor=new ContentValues();
        valor.put("Materia",mat);
        valor.put("Curso",curs);
        this.getWritableDatabase().insert("creargrupo",null,valor);

    }

    //METODO QUE PERMITE VALIDAR SI EL USUARIO DE PROFESOR EXISTE
    public Cursor ConsulUsuPass(String usu, String pas) throws SQLException{
        Cursor mcursor=null;
        mcursor = this.getReadableDatabase().query("userprof",new String[]{"_ID",
        "Nombre","Apellido","Correo","Password"},"Correo like '"+usu+"' "+
        "and Password like'"+pas+"'",null,null,null,null);
        return mcursor;
    }

    //METODO QUE PERMITE VALIDAR EL USUARIO DEL ALUMNO EXISTE
    public Cursor ConsultarUsuPassA (String usua, String pasa) throws SQLException{
        Cursor mcursor=null;
        mcursor =this.getReadableDatabase().query("useralum",new String[]{"_ID",
        "Nombre","Apellido","Correo","Password"},"Correo like '"+usua+"' "+
        "and Password like'"+pasa+"'",null,null,null,null);
        return mcursor;
    }

     //METODO QUE PERMITE LISTAR USUARIO
    public Cursor listarUsuarios() throws SQLException{
        Cursor mcursor=this.getReadableDatabase().query("userprof",new String[]{"_ID","Nombre","Apellido","Correo","Password"},null,null,null,null,null);
        if (mcursor!=null){
            mcursor.moveToFirst();
        }
        return mcursor;
    }

    //METODO QUE PERMITE ENVIAR EL MENSAJE

    public Cursor mostrarMsn() throws SQLException{
        Cursor mcursor=this.getReadableDatabase().query("enviarmensaje",new String[]{"_ID","Mensaje","Titulo"},null,null,null,null,null);
        if (mcursor!=null){
            mcursor.moveToFirst();
        }
        return mcursor;
    }
}
