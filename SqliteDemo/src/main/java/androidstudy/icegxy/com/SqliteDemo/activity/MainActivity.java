package androidstudy.icegxy.com.SqliteDemo.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidstudy.icegxy.com.SqliteDemo.R;
import androidstudy.icegxy.com.SqliteDemo.util.Constant;
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

    public void createTable(View view){
        SQLiteDatabase db = helper.getReadableDatabase();
        String createTable = "create table person(id Integer primary key,name varchar(10),age Integer)";
        DBManager.excuteSql(db,createTable);
        Log.i("tag","-----------------数据表创建成功----------");
    }

    /**
     * 增
     */
    public void insertData(View view){
        //调用sql方式
        SQLiteDatabase db = helper.getReadableDatabase();
//        String insertData = "insert into person values(1,'gxy',20)";
//        DBManager.excuteSql(db,insertData);

        //调用api
        ContentValues content = new ContentValues();
        content.put("id",2);
        content.put("name","gxy");
        content.put("age",30);
        db.insert(Constant.TABLE_NAME,null,content);
    }

    /**
     * 删
     */
    public void deleteData(View view){
        //调用sql方式
        SQLiteDatabase db = helper.getReadableDatabase();
//        String delData = "delete from person where id = 2";
//        db.execSQL(delData);

        //调用api
        db.delete(Constant.TABLE_NAME,"id=?",new String[]{"1"});
    }

    public void updateData(View view){
        //调用sql
        SQLiteDatabase db = helper.getReadableDatabase();
//        String updateData = "update person set name = 'icegxy' where id=2";
//        db.execSQL(updateData);

        //调用api
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","icegxy");
        db.update(Constant.TABLE_NAME,contentValues,"id=?",new String[]{"2"});
    }

    /**
     * 查
     */
    public void selectData(View view){
        SQLiteDatabase db = helper.getReadableDatabase();
        //第一种实现方式，调用sql
        String selectData = "select * from person where id = ?";
        Cursor cursor = db.rawQuery(selectData,new String[]{"1"});
        while (cursor.moveToNext()){//按照行循环取值
            int id = cursor.getInt(0);//获取第一列的值，索引序列从0开始
            String name = cursor.getString(1);//获取第二列的值
            Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG);
            Log.i("tag",name);
            int age = cursor.getInt(2);//获取第三列的值
        }

        //第二种实现方式，调用api
        Cursor cursor1 = db.query(false,Constant.TABLE_NAME,new String[]{"id","name","age"},null,null,null,null,null,null);
        while(cursor1.moveToNext()){
            String name = cursor1.getString(1);
            Log.i("tag",name);
        }
    }
}
