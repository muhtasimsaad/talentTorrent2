package com.example.talenttorrent.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONparser {



    public training parseTraining(String text)  {


      try{
          JSONObject reader = new JSONObject(text);
          training j=new training();

          int id=Integer.parseInt(reader.getJSONObject("training").getString("id"));
          String title=reader.getJSONObject("training").getString("title");
          String details  = reader.getJSONObject("training").getString("details");
          int fee=Integer.parseInt(reader.getJSONObject("training").getString("fee"));
          String location=reader.getJSONObject("training").getString("location");
          String duration=reader.getJSONObject("training").getString("duration");
          String start_date=reader.getJSONObject("training").getString("start_date");
          String created_at=reader.getJSONObject("training").getString("created_at");
          String updated_at=reader.getJSONObject("training").getString("updated_at");

          j.title=title;
          j.id=id;
          j.details=details;
          j.fee=fee;
          j.location=location;
          j.duration=duration;
          j.startDate=start_date;
          j.createdAt=created_at;
          j.updatedAt=updated_at;

          return j;
      }
      catch (Exception r){
          return null;
      }
    }

    public training[] parseTrainings(String text) {



        try {
            JSONObject reader = new JSONObject(text);
            JSONArray jsonarray=reader.getJSONObject("trainings").getJSONArray("data");

           training[] result=new training[jsonarray.length()];



            for(int i=0;i<result.length;i++){
                JSONObject readerLoop=new JSONObject(jsonarray.get(i).toString());
                training j=new training();
                j.id=Integer.parseInt(readerLoop.getString("id"));
                j.title=readerLoop.getString("title");
                j.details  = readerLoop.getString("details");
                j.fee=Integer.parseInt(readerLoop.getString("fee"));
                j.location=readerLoop.getString("location");
                j.duration=readerLoop.getString("duration");
                j.startDate=readerLoop.getString("start_date");
                j.createdAt=readerLoop.getString("created_at");
                j.updatedAt=readerLoop.getString("updated_at");

                result[i]=j;
                //Toast.makeText(this.cxt,"asd"+result[i].id,Toast.LENGTH_LONG).show();

           }

           return result;

        } catch (JSONException e) {
            Log.v("test",e.getMessage());
        }
        return  null;
    }

    public job parseJob(String text){

 try{
            JSONObject reader = new JSONObject(text);

            job j=new job();


            j.id=Integer.parseInt(reader.getJSONObject("job").getString("id"));


            j.uuid=reader.getJSONObject("job").getString("uuid");
            j.category_id= reader.getJSONObject("job").getString("category_id");
            j.budget=Double.parseDouble(reader.getJSONObject("job").getString("budget"));
            j.confirmed_budget=Double.parseDouble(reader.getJSONObject("job").getString("confirmed_budget"));
            j.formatted_budget=Double.parseDouble(reader.getJSONObject("job").getString("formatted_budget").substring(1));
            j.owner_id=reader.getJSONObject("job").getString("owner_id");
            j.assigned_to=reader.getJSONObject("job").getString("assigned_to");
            j.title=reader.getJSONObject("job").getString("title");
            j.type=reader.getJSONObject("job").getString("type");
            j.length=reader.getJSONObject("job").getString("length");
            j.status=reader.getJSONObject("job").getString("status");
            j.description=reader.getJSONObject("job").getString("description");
            j.tags=reader.getJSONObject("job").getString("tags");
            j.deleted_at=reader.getJSONObject("job").getString("deleted_at");
            j.formatted_created_at=reader.getJSONObject("job").getString("formatted_created_at");
            j.formatted_updated_at=reader.getJSONObject("job").getString("formatted_updated_at");
            j.formatted_estimated_end_date=reader.getJSONObject("job").getString("formatted_estimated_end_date");
            j.end_date=reader.getJSONObject("job").getString("end_date");

            return j;
        }
        catch (Exception r){
     return null;


        }



    }

    public job[] parseJobs(String text) {



        try {
            JSONObject reader = new JSONObject(text);
            JSONArray jsonarray=reader.getJSONObject("jobs").getJSONArray("data");

            job[] result=new job[jsonarray.length()];

             for(int i=0;i<jsonarray.length();i++){
                JSONObject readerLoop=new JSONObject(jsonarray.get(i).toString());
                job j=new job();


                j.uuid=             readerLoop.getString("uuid");
                j.category_id=      readerLoop.getString("category_id");
                j.budget=           Double.parseDouble(readerLoop.getString("budget"));
                j.confirmed_budget= Double.parseDouble(readerLoop.getString("confirmed_budget"));
                j.formatted_budget= Double.parseDouble(readerLoop.getString("formatted_budget").substring(1));
                j.owner_id=         readerLoop.getString("owner_id");
                j.assigned_to=      readerLoop.getString("assigned_to");
                j.title=            readerLoop.getString("title");
                j.type=             readerLoop.getString("type");
                j.length=           readerLoop.getString("length");
                j.status=           readerLoop.getString("status");
                j.description=      readerLoop.getString("description");
                j.tags=             readerLoop.getString("tags");
                j.deleted_at=       readerLoop.getString("deleted_at");
            j.formatted_created_at= readerLoop.getString("formatted_created_at");
            j.formatted_updated_at= readerLoop.getString("formatted_updated_at");
    j.formatted_estimated_end_date= readerLoop.getString("formatted_estimated_end_date");
                j.end_date=         readerLoop.getString("end_date");



               result[i]=j;
                //Toast.makeText(this.cxt,"asd"+result[i].id,Toast.LENGTH_LONG).show();

            }

            return result;

        } catch (JSONException e) {
           return null;
        }



    }
}
