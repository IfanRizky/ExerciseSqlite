import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBNAME.db";
    public static final String TABLE_NAME = "daftarKontak";
    public static final String NAMA = "nama";
    public static final String NO_TELEPON = "nomorTelepon";
    public static final String EMAIL = "email";
    public static final String ALAMAT = "alamat";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Auto-generated method stub
        db.execSQL(
                "Create table daftarKontak" +
                        "(nama string primary key, nomorTelepon text, email text, alamat text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS daftarKontak");
        onCreate(db);
    }

    public boolean insertContact (String nomorTelepon, String email, String alamat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomorTelepon", nomorTelepon);
        contentValues.put("email",email);
        contentValues.put("alamat",alamat);

        db.insert("daftarKontak", null, contentValues);
        return true;
    }

    public Cursor getData(String nama) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from daftarKontak where nama="+nama+"", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public ArrayList<String> getAllContact() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new Hashmap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from daftarKontak", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(NAMA)));
            res.moveToNext();
        }
        return array_list;
    }
}


