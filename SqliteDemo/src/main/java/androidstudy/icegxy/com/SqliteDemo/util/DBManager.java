package androidstudy.icegxy.com.SqliteDemo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by icegxy on 2017/3/19.
 */

public class DBManager {
    public static SqliteHelper helper;

    public static SqliteHelper getHelper(Context context) {
        if (helper == null) {
            helper = new SqliteHelper(context);
        }
        return helper;
    }

    public static void excuteSql(SQLiteDatabase database,String sql){
        if (database!=null){
            if (sql!=null && !"".equals(sql)){
                database.execSQL(sql);
            }
        }
    }
}
