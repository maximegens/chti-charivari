package com.maximegens.chticharivari.asyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class RetreiveJsonOnline extends AsyncTask<Void, Integer, Void> {
    Context context;

    public RetreiveJsonOnline(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Début du traitement asynchrone", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values){
    }

    @Override
    protected void onPostExecute(Void result) {
        Toast.makeText(context, "Le traitement asynchrone est terminé", Toast.LENGTH_SHORT).show();
    }
}
