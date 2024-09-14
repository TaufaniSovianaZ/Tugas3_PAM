package com.example.tugas3_pam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double angPertama;
    String operasional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.btn_0);
        Button num1 = findViewById(R.id.btn_1);
        Button num2 = findViewById(R.id.btn_2);
        Button num3 = findViewById(R.id.btn_3);
        Button num4 = findViewById(R.id.btn_4);
        Button num5 = findViewById(R.id.btn_5);
        Button num6 = findViewById(R.id.btn_6);
        Button num7 = findViewById(R.id.btn_7);
        Button num8 = findViewById(R.id.btn_8);
        Button num9 = findViewById(R.id.btn_9);

        Button on = findViewById(R.id.btn_on);
        Button off = findViewById(R.id.btn_off);
        Button restart = findViewById(R.id.btn_ac);
        Button hapus = findViewById(R.id.btn_hapus);
        Button bagi = findViewById(R.id.btn_bagi);
        Button kali = findViewById(R.id.btn_kali);
        Button kurang = findViewById(R.id.btn_kurang);
        Button tambah = findViewById(R.id.btn_tambah);
        Button hitung = findViewById(R.id.btn_hitung);
        Button koma = findViewById(R.id.btn_dec);

        TextView layar = findViewById(R.id.tv_hasil);

        off.setOnClickListener(view -> layar.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            layar.setVisibility(View.VISIBLE);
            layar.setText("0");
        });

        ArrayList<Button> number = new ArrayList<>();
        number.add(num0);
        number.add(num1);
        number.add(num2);
        number.add(num3);
        number.add(num4);
        number.add(num5);
        number.add(num6);
        number.add(num7);
        number.add(num8);
        number.add(num9);

        for (Button angka : number) {
            angka.setOnClickListener(view -> {
                if (!layar.getText().toString().equals("0")) {
                    layar.setText(layar.getText().toString() + angka.getText().toString());
                } else {
                    layar.setText(angka.getText().toString());
                }
            });
        }

        ArrayList<Button> operasi = new ArrayList<>();
        operasi.add(bagi);
        operasi.add(kali);
        operasi.add(kurang);
        operasi.add(tambah);
        for (Button op : operasi) {
            op.setOnClickListener(view -> {
                angPertama = Double.parseDouble(layar.getText().toString());
                operasional = op.getText().toString();
                layar.setText(layar.getText().toString() + " " + operasional + " ");
            });
        }

        koma.setOnClickListener(view -> {
            if (!layar.getText().toString().contains(".")) {
                layar.setText(layar.getText().toString() + ".");
            }
        });

        hapus.setOnClickListener(view -> {
            String ang = layar.getText().toString();
            if (ang.length() > 1) {
                layar.setText(ang.substring(0, ang.length() - 1));
            } else if (ang.length() == 1 && ang.equals("0")) {
                layar.setText("0");
            }
        });

        hitung.setOnClickListener(view -> {
            String layarTeks = layar.getText().toString();
            if (!layarTeks.contains(" ")) {
                layar.setText("0");
                return;
            }
            String[] parts = layarTeks.split(" ");
            double angKedua = Double.parseDouble(parts[2]);
            double hasil;
            switch (operasional) {
                case "/":
                    hasil = angPertama / angKedua;
                    break;
                case "X":
                    hasil = angPertama * angKedua;
                    break;
                case "-":
                    hasil = angPertama - angKedua;
                    break;
                case "+":
                    hasil = angPertama + angKedua;
                    break;
                default:
                    hasil = angPertama + angKedua;
            }

            layar.setText(String.valueOf(hasil));
            angPertama = hasil;
        });

        restart.setOnClickListener(view -> {
            angPertama = 0;
            layar.setText("0");
        });
    }
}