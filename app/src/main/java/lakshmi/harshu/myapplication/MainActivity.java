package lakshmi.harshu.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textspeech_obj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textspeech_obj.setLanguage(Locale.US);
                }
            }
        });

        gridView = (GridView) findViewById(mycom.example.harshu.brainykidzapp.R.id.gridView);

        listItem = getResources().getStringArray(mycom.example.harshu.brainykidzapp.R.array.alphabet_array);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                mycom.example.harshu.brainykidzapp.R.layout.grid_buttons, listItem);
        gridView.setAdapter(adapter);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                textspeech_obj.speak(value, TextToSpeech.QUEUE_FLUSH, null);


            }
        });


    }
}
