package com.example.sundriyal.whether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button, button2;
    String APIKey = "P6eflaANHkOikO2vBjlId8H4XcQGc3YP";
    String latLog = "28.6924683,77.3156835";
    String language = "en-us";
    Boolean details = false;
    Boolean toplevel = false;
    Boolean isButtonOneClicked = false;
    TextView textView;

    String locatioKey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isButtonOneClicked = true;

                Call<Model> call = APIClient.getClient().getKey(APIKey, latLog, language, details, toplevel);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Location Key: " + response.body().getKey(), Toast.LENGTH_SHORT).show();
                            locatioKey = response.body().getKey();
                            API.WETHER += locatioKey;
                        } else {
                            Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonOneClicked) {

                    Call<Model2> call = APIClient.getClient().getWether(API.WETHER, APIKey, language, details);
                    call.enqueue(new Callback<Model2>() {
                        @Override
                        public void onResponse(Call<Model2> call, Response<Model2> response) {

                            textView.setText("The Weather is: " + response.body().getWeatherText());
                            if (response.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Model2> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Click above button first", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}