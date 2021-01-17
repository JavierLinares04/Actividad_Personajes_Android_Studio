package com.javierlinares.act_personajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView i_central, i_fondo;
    int cont_color, cont_fondo, cont_escala;
    float altura, anchura;
    HorizontalScrollView s_person, s_botones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i_central = (ImageView) findViewById(R.id.I_central);
        i_fondo = (ImageView) findViewById(R.id.I_fondo);
        s_botones = (HorizontalScrollView)findViewById(R.id.Scroll_botones);
        s_person = (HorizontalScrollView)findViewById(R.id.Scroll_person);

        altura = 1.0f;
        anchura = 1.0f;

        cont_color=0;
        cont_escala=0;
        cont_fondo=0;
    }



    //BOTONES

    public void funcion_original(View view) {
        cont_escala++;

        switch (cont_escala) {
            case 1:
                i_central.setScaleType(ImageView.ScaleType.CENTER);
                Toast.makeText(this, "Escala - center", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                i_central.setScaleType(ImageView.ScaleType.MATRIX);
                Toast.makeText(this, "Escala - matrix", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                i_central.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Toast.makeText(this, "Escala - center crop", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                i_central.setScaleType(ImageView.ScaleType.FIT_START);
                Toast.makeText(this, "Escala - fit start", Toast.LENGTH_SHORT).show();
                cont_escala = 0;
                break;
        }
    }

    public void funcion_color(View view) {
        cont_color++;

        switch (cont_color) {
            case 1:
                ColorFilter filtro = new LightingColorFilter(Color.LTGRAY, Color.BLUE);
                i_central.setColorFilter(filtro);
                break;
            case 2:
                ColorFilter filtro_2 = new LightingColorFilter(Color.LTGRAY, Color.RED);
                i_central.setColorFilter(filtro_2);
                break;
            case 3:
                ColorFilter filtro_3 = new LightingColorFilter(Color.LTGRAY, Color.YELLOW);
                i_central.setColorFilter(filtro_3);
                break;
            case 4:
                ColorFilter filtro_4 = new LightingColorFilter(Color.LTGRAY, Color.GREEN);
                i_central.setColorFilter(filtro_4);
                break;
            case 5:
                ColorFilter filtro_5 = new LightingColorFilter(Color.LTGRAY, Color.CYAN);
                i_central.setColorFilter(filtro_5);
                break;
            case 6:
                i_central.clearColorFilter();
                cont_color = 0;
                break;
        }
    }

    public void funcion_suma_altura(View view) {
        if(altura<=1.5f){
            altura+=0.1f;
            i_central.setScaleY(altura);
        }
        else {
            Toast.makeText(this, "La altura excedido", Toast.LENGTH_SHORT).show();
        }


    }

    public void funcion_resta_altura(View view) {
        if(altura>=0.0f){
            altura-=0.1f;
            i_central.setScaleY(altura);
        }
        else {
            Toast.makeText(this, "La altura excedido", Toast.LENGTH_SHORT).show();
        }


    }



    public void funcion_suma_anchura(View view) {
        if (anchura<=1.5f){
            anchura+=0.1f;
            i_central.setScaleX(anchura);
        }
        else {
            Toast.makeText(this, "La anchura excedido", Toast.LENGTH_SHORT).show();
        }
    }

    public void funcion_resta_anchura(View view) {
        if (anchura>=0.0f ){
            anchura-=0.1f;
            i_central.setScaleX(anchura);
        }
        else {
            Toast.makeText(this, "La anchura excedido", Toast.LENGTH_SHORT).show();
        }
    }

    public void funcion_info(View view) {
        Intent info = new Intent(this, Info.class);
        startActivity(info);
    }

    public void funcion_personaje(View view) {
        Intent personaje = new Intent(this, Personajes.class);
        startActivity(personaje);
    }



    //PERSONAJES

    public void funcion_logo(View view) {
        i_central.setImageResource(R.drawable.street0);
    }

    public void funcion_Ruy(View view) {
        i_central.setImageResource(R.drawable.street2);
    }

    public void funcion_Vega(View view) {
        i_central.setImageResource(R.drawable.street3);
    }

    public void funncion_mbison(View view) {
        i_central.setImageResource(R.drawable.street4);
    }

    public void funcion_chun_li(View view) {
        i_central.setImageResource(R.drawable.street5);
    }

    public void funcion_ken(View view) {
        i_central.setImageResource(R.drawable.ken);
    }


    //OPCIONES

    public void funcion_flecha(View view) {
        s_person.setVisibility(View.VISIBLE);
        s_botones.setVisibility(View.INVISIBLE);
    }

    public void funcion_lupa(View view) {
        s_botones.setVisibility(View.VISIBLE);
        s_person.setVisibility(View.INVISIBLE);
    }

    public void funcion_rueda(View view) {
        cont_fondo++;

        switch (cont_fondo) {
            case 1:
                i_fondo.setImageResource(R.drawable.fondo1);
                break;
            case 2:
                i_fondo.setImageResource(R.drawable.fondomovil);
                break;
            case 3:
                i_fondo.setImageResource(R.drawable.fondo2);
                cont_fondo = 0;
                break;
        }
    }


}