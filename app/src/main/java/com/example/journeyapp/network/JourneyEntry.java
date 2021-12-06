package com.example.journeyapp.network;

import com.example.journeyapp.R;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JourneyEntry {

    private static final String TAG = JourneyEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String location;

    public JourneyEntry(String title, String dynamicUrl, String url, String location) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.location = location;
    }

    public static List<JourneyEntry> initJourneyEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.journeys);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try{
            Reader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException e){
            Log.e(TAG,"Error al leer o escribir el archivo JSON.", e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error al terminar la conexión.",exception);
            }
        }
        String jsonJourneysString = writer.toString();
        Gson gson = new Gson();
        Type journeyListType = new TypeToken<ArrayList<JourneyEntry>>() {
        }.getType();
        return gson.fromJson(jsonJourneysString, journeyListType);
    }


}
