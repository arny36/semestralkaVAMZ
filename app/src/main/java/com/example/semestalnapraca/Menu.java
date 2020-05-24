package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 *Trieda nam sluzi na vytváranie menu  prechodná trieda cez ktoru si otvaram miniaplikacie
 * Medzi triedy ktore otvaram patri kalkulacka, hubarska prirucka a pocasie
 */
public class Menu extends AppCompatActivity {

    Button BKalkulacka, BHubarskaPrirucka, BPocasie;
    private static final String KALKULACKA_WELCOME = "kalkulacka";
    private static final String PRIRUCKA_WELCOME = "prirucka";

    /**
     *konstruktor danej  triedy
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BPocasie = findViewById(R.id.pocasieBtn);
        BPocasie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorPocasie();
            }
        });
        BHubarskaPrirucka = findViewById(R.id.hubraskaPriruckaBtn);
        BHubarskaPrirucka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorHubarskuPrirucku();
            }
        });
        BKalkulacka = (Button) findViewById(R.id.kalkulackaBtn);
        BKalkulacka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorKalkulacku();
            }
        });
    }

    /**
     * metoda na otvorenie kalkulacky a notifikacia pri otvoreni kalkulacky s vlastnym symbolom
     */
    private void otvorKalkulacku () {
        Intent intent = new Intent(Menu.this, Kalkulacka.class);
        startActivity(intent);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, KALKULACKA_WELCOME)
                .setSmallIcon(R.drawable.info)
                .setContentTitle("Kalkulacka")
                .setContentText("Vitajte v kalkulacke pomocou naklikavania tlacitok pocitajte.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotify = NotificationManagerCompat.from(this);
        mNotify.notify(1, mBuilder.build());
    }

    /**
     * metoda na otvorenie prirucky a notifikacia pri otvoreni prirucky s vlastnym symbolom
     */
    private void otvorHubarskuPrirucku() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, PRIRUCKA_WELCOME)
                .setSmallIcon(R.drawable.info)
                .setContentTitle("Prirucka hub")
                .setContentText("Vitajte v prirucke hub pomocou kliknutia na polozku huby zistite ako vyzera.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotify = NotificationManagerCompat.from(this);
        mNotify.notify(1, mBuilder.build());
        Intent intent = new Intent(Menu.this, HubarskaPrirucka.class);
        startActivity(intent);
    }

    /**
     *metoda na otvorenie pocasia
     */
    private void otvorPocasie() {
        Intent intent = new Intent(Menu.this, Pocasie.class);
        startActivity(intent);

    }
}
