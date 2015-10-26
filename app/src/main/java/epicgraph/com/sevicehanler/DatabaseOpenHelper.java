package epicgraph.com.sevicehanler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Midhun on 29-09-2015.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper{

//    public final static String TABLE_NAME = "artists";
//    public final static String _ID="_id";
    public final static String SYS="sys";
    public final static String DIA="dia";
    public final static String PULSE="pulse";
    public final static String HEART_BEAT="heart_beat";
    public final static String HAND="hand";
    public final static String NOTE="note";
    public final static String DATE="date";
    public final static String TIME="time";

//    public final static String[] columns = { _ID,NOTE };
//    //public final static String[] columns = { _ID,SYS,DIA,PULSE,HEART_BEAT,HAND,NOTE,DATE,TIME};
//
//    final private static String CREATE_CMD ="CREATE TABLE artists (" + _ID
//            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//            + NOTE + " TEXT NOT NULL)";

//            "CREATE TABLE mytable2(_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
//            "sys INTEGER NOT NULL,dia INTEGER NOT NULL,pulse INTEGER NOT NULL," +
//            "heart_beat INTEGER NOT NULL,HAND INTEGER NOT NULL,note TEXT NOT NULL," +
//            "date TEXT NOT NULL,time TEXT NOT NULL)";

    public final static String TABLE_NAME = "data_table12";
    public final static String ARTIST_NAME = "name";
    public final static String _ID = "_id";
    public final static String[] columns = { _ID,SYS,DIA,PULSE,HEART_BEAT,HAND,DATE,TIME,NOTE};

    final private static String CREATE_CMD =

            "CREATE TABLE "+TABLE_NAME+" (" + _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + SYS+" INTEGER,"+ DIA+" INTEGER,"+ PULSE+
                    " INTEGER,"+ HEART_BEAT+" INTEGER,"+ HAND+" INTEGER,"+ DATE+" INTEGER,"+ TIME+" INTEGER,"+ NOTE + " TEXT NOT NULL)";

    final private static String NAME = "mee12";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // N/A
    }

    void deleteDatabase() {
        mContext.deleteDatabase(NAME);
    }
}
