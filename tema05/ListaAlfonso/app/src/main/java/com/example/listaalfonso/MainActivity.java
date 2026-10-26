package com.example.listaalfonso;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Los datos: al menos 8 elementos
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego("The Legend of Zelda", "Nintendo Switch", R.drawable.icono_mando));
        videojuegos.add(new Videojuego("FIFA 23", "PlayStation 5", R.drawable.icono_mando));
        videojuegos.add(new Videojuego("Halo Infinite", "Xbox Series X", R.drawable.icono_mando));
        videojuegos.add(new Videojuego("Counter-Strike 2", "PC", R.drawable.icono_pc));
        videojuegos.add(new Videojuego("Minecraft", "PC", R.drawable.icono_pc));
        videojuegos.add(new Videojuego("Clash Royale", "Móvil", R.drawable.icono_movil));
        videojuegos.add(new Videojuego("Candy Crush", "Móvil", R.drawable.icono_movil));
        videojuegos.add(new Videojuego("Monopoly", "Varias plataformas", R.drawable.icono_dinero));

        // 2. La lista: cómo se colocan las filas y quién las pinta
        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvLista.setAdapter(new AdaptadorVideojuegos(videojuegos));
    }
}