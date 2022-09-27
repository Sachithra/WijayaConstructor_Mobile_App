package com.example.wijaya_constructions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DHandler {
    private Context con;
    private DConnection dcon;
    private SQLiteDatabase db;


    public DHandler(Context con){ this.con=con;}

    public DHandler openDB(){
        this.dcon=new DConnection(con);
        this.db=dcon.getWritableDatabase();
        return this;
    }
        public ArrayList<Supervisor>getAllSupervisor(){
        return null;
      }
//      public boolean CheckSupervisor(Supervisor supervisor)throws Exception{
//
//          Cursor cursor=db.rawQuery("select * from supervisor where username='"+supervisor.getUname()+",'"+supervisor.getPassword()+"'",null);
//          if (cursor.moveToFirst()){
//              return true;
//          }
//          return false;
//
//
//      }
      //LOGIN VALIDATION
      public boolean CheckSupervisorLogin(String username,String password){
        Cursor cursor=db.rawQuery("SELECT * FROM supervisor WHERE username=? and password=?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;

        }else {
            return false;
        }
      }


      public boolean CheckAdminLogin(String username,String password){
        Cursor cursor=db.rawQuery("SELECT * FROM admin WHERE username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
      }
//      public boolean CheckWorker(Worker worker)throws Exception{
//
//        Cursor cursor=db.rawQuery("select * from worker where username='"+worker.getFirstname()+"'",null);
//        if (cursor.moveToFirst()){
//            return true;
//        }
//        return false;
//      }







    //REGISTER,UPDATE AND DELETE PART

public void RegisterAdmin(Admin admin){
        ContentValues contentValues=new ContentValues();
        contentValues.put("firstname",admin.getFirstname());
        contentValues.put("lastname",admin.getLastname());
        contentValues.put("email",admin.getEmail());
        contentValues.put("username",admin.getUsername());
        contentValues.put("password",admin.getPassword());

        db.insert("admin",null,contentValues);
}


      public void RegisterS(Supervisor supervisor){
          ContentValues contentValues=new ContentValues();
          contentValues.put("firstname",supervisor.getFirstname());
          contentValues.put("lastname",supervisor.getLastname());
          contentValues.put("email",supervisor.getEmail());
          contentValues.put("password",supervisor.getPassword());
          contentValues.put("site",supervisor.getSite());
          contentValues.put("username",supervisor.getUname());

          db.insert("supervisor",null,contentValues);


      }
      public void UpdateSupervisor(Supervisor supervisor){

          ContentValues contentValues=new ContentValues();
          contentValues.put("firstname",supervisor.getFirstname());
          contentValues.put("lastname",supervisor.getLastname());
          contentValues.put("email",supervisor.getEmail());
          contentValues.put("password",supervisor.getPassword());
          contentValues.put("site",supervisor.getSite());
          contentValues.put("username",supervisor.getUname());


        db.update("supervisor",contentValues,"site=?",new String[]{supervisor.getSite()});


      }


      public void RegisterW(Worker worker){
        ContentValues contentValues=new ContentValues();
        contentValues.put("firstname",worker.getFirstname());
        contentValues.put("lastname",worker.getLastname());
        contentValues.put("phone",worker.getPhone());
        contentValues.put("site",worker.getSite());
        contentValues.put("id",worker.getId());
        contentValues.put("username",worker.getUsername());

       db.insert(" worker",null,contentValues);


      }

    public void UpdateWorker(Worker worker){


        ContentValues contentValues=new ContentValues();
        contentValues.put("firstname",worker.getFirstname());
        contentValues.put("lastname",worker.getLastname());
        contentValues.put("phone",worker.getPhone());
        contentValues.put("site",worker.getSite());
        contentValues.put("id",worker.getId());
        contentValues.put("username",worker.getUsername());



        db.update("worker",contentValues,"id=?",new String[]{worker.getSite()});

    }


      public void AddSite(Site site){
        ContentValues contentValues=new ContentValues();
        contentValues.put("sitename",site.getSitename());
        contentValues.put("siteid",site.getSiteid());
        contentValues.put("handoverDate",site.getHandover());
        contentValues.put("handoutDate",site.getHandOut());
        contentValues.put("cost",site.getCost());

        db.insert("addsite",null,contentValues);


      }


    public Integer DeleteData(String firstname){
        this.db=dcon.getWritableDatabase();
        return db.delete("supervisor","firstname=?",new String[]{firstname});

    }

    public Integer DeleteWorkerData(String firstname){
        this.db=dcon.getWritableDatabase();
        return db.delete("worker","firstname=?",new String[]{firstname});

    }
public Cursor getAllSupervisorData(){

        Cursor ve=db.rawQuery("select * from supervisor",null);

        return ve;

  }
    public Cursor getAllWorkersData(){

        Cursor ve=db.rawQuery("select * from worker",null);

        return ve;

    }

    public void MarkAttendance(Attendance attendance){

        ContentValues contentValues=new ContentValues();
        contentValues.put("username",attendance.getUsername());
        contentValues.put("presentdate",attendance.getPresent());
        contentValues.put("absentdate",attendance.getAbsent());

        db.insert("MarkAtendance",null,contentValues);


    }


}
