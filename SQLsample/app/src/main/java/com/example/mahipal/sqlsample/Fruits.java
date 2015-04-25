package com.example.mahipal.sqlsample;

//this is where Fruits.db is pulled and queried

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Fruits {

    public static final String KEY_NAME = "name_of_fruit";
    public static final String KEY_COLOR = "color_of_fruit";
    public static final String KEY_VITAMINS = "vitamins_in_fruit";
    public static final String KEY_LOCATION = "location_of_fruit";

    private static final String DATABASE_NAME = "fruits database";
    private static final String DATABASE_TABLE = "fruits";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    private static class DbHelper extends SQLiteOpenHelper {

        // the "null" value is a stand-in for CursorFactory

       public DbHelper (Context context){
           super(context, DATABASE_NAME, null, DATABASE_VERSION);
       }


       @Override
        public void onCreate(SQLiteDatabase db){

       db.execSQL(

   "CREATE TABLE " + DATABASE_TABLE + " (" +
           KEY_NAME + " TEXT NOT NULL, " +
           KEY_COLOR + "TEXT NOT NULL, " +
           KEY_VITAMINS + "TEXT NOT NULL, " +
           KEY_LOCATION + "TEXT NOT NULL); "



       );



       }




        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
onCreate(db);


        }




    }


   public Fruits(Context seeFruits){ourContext = seeFruits;}

public Fruits open(){
    ourHelper = new DbHelper(ourContext);
    ourDatabase = ourHelper.getWritableDatabase();
    return this;
}

    public void close(){

       ourHelper.close();
    }

    public long createEntry(String name, String color, String vitamins, String location){

        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_COLOR, color);
        cv.put(KEY_VITAMINS, vitamins);
        cv.put(KEY_LOCATION, location);

return ourDatabase.insert(DATABASE_TABLE, null, cv);

    }

public String getData() {

    String[] columns = new String[]{ KEY_NAME, KEY_COLOR, KEY_VITAMINS, KEY_LOCATION};
    Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
    String result = "";
    int iName = c.getColumnIndex(KEY_NAME);
    int iColor = c.getColumnIndex(KEY_COLOR);
    int iVitamins = c.getColumnIndex(KEY_VITAMINS);
    int iLocation = c.getColumnIndex(KEY_LOCATION);

    for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

    result = result + c.getString(iName) + " " + c.getString(iColor) + " " + c.getString(iVitamins) + " " +
            c.getString(iLocation) + " " + "\n";

    }

    return result;}
}
