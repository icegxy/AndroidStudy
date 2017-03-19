package androidstudy.icegxy.com.SqliteDemo.util;

import android.content.Context;

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

}
