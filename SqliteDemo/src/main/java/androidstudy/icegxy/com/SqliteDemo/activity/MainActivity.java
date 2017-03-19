package androidstudy.icegxy.com.SqliteDemo.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidstudy.icegxy.com.SqliteDemo.R;
import androidstudy.icegxy.com.SqliteDemo.util.DBManager;
import androidstudy.icegxy.com.SqliteDemo.util.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    public SqliteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = DBManager.getHelper(this);
    }

    /**
     * 点击创建数据库
     * @param view
     */
    public void createDB(View view){
        SQLiteDatabase db = helper.getReadableDatabase();
    }
}
