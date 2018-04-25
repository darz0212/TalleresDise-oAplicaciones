package co.edu.konradlorenz.todosobreseries;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SeriesAdapter adapter;
    private List<Serie> serieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.serie_recycler_view);
        serieList = new ArrayList<>();
        adapter = new SeriesAdapter(this, serieList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareSeries();

    }

    private void prepareSeries() {
        int[] imagenes = new int[]{
                R.drawable.serie1,
                R.drawable.serie2,
                R.drawable.serie3,
                R.drawable.serie4,
                R.drawable.serie5};

        List<Capitulo> capituloList;
        capituloList = new ArrayList<>();

        List<Temporada> temporadaList;
        temporadaList = new ArrayList<>();

     /////// SERIE 1
        Capitulo cap = new Capitulo("Al principio", 1,"Descripcion capitulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Exodo", 2,"Descripcion capitulo 2");
        capituloList.add(cap);
        cap = new Capitulo("La tierra prometida", 3,"Descripcion capitulo 3");
        capituloList.add(cap);
        cap = new Capitulo("Reino", 4,"Descripcion capitulo 4");
        capituloList.add(cap);
        cap = new Capitulo("Reino2", 5,"Descripcion capitulo 5");
        capituloList.add(cap);
        cap = new Capitulo("La persecución", 6,"Descripcion capitulo 6");
        capituloList.add(cap);
        cap = new Capitulo("La visita", 7, "Descripcion capitulo 7");
        capituloList.add(cap);
        cap = new Capitulo("El camino a Damasco", 8,"Descripcion capitulo 8");
        capituloList.add(cap);
        cap = new Capitulo("El regreso de Saul", 9,"Descripcion capitulo 9");
        capituloList.add(cap);
        cap = new Capitulo("Camaradas", 10,"Descripcion capitulo 10");
        capituloList.add(cap);
        cap = new Capitulo("La ascensión", 11,"Descripcion capitulo 11");
        capituloList.add(cap);
        cap = new Capitulo("La aversión", 12,"Descripción capítulo 12");
        capituloList.add(cap);

        Temporada temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 1");
        temporadaList.add(temp);

        List<String> generos;
        generos = new ArrayList<>();
        generos.add("Drama");

        List<String> actores;
        actores = new ArrayList<>();
        actores.add("Adam Levy");
        actores.add("Andrew Gower");
        actores.add("Babou Ceesa");

        Serie a = new Serie((ArrayList<Temporada>) temporadaList,"A.D. La biblia continua",
                (ArrayList<String>)generos, (ArrayList<String>)actores, imagenes[0]);
        serieList.add(a);

     //////SERIE 2
        temporadaList = new ArrayList<>();
        capituloList = new ArrayList<>();
        cap = new Capitulo("Días pasados", 1,"Descripción capítulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Tripas", 2,"Descripción capítulo 2");
        capituloList.add(cap);
        cap = new Capitulo("Díselos a las ranas", 3,"Descripción capítulo 3");
        capituloList.add(cap);
        cap = new Capitulo("Chicos", 4,"Descripción capítulo 4");
        capituloList.add(cap);
        cap = new Capitulo("Wildfire", 5,"Descripción capítulo 5");
        capituloList.add(cap);
        cap = new Capitulo("TS-19", 6,"Descripción capítulo 6");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 1");
        temporadaList.add(temp);
////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("La que se avecina", 1,"Descripción capítulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Baño de sangre", 2,"Descripción capítulo 2");
        capituloList.add(cap);
        cap = new Capitulo("Guarda la última", 3,"Descripción capítulo 3");
        capituloList.add(cap);
        cap = new Capitulo("¿A quién estas buscando?", 4,"Descripción capítulo 4");
        capituloList.add(cap);
        cap = new Capitulo("Rosa Cheroke", 5, "Descripción capítulo 5");
        capituloList.add(cap);
        cap = new Capitulo("Chupacabra", 6,"Descripción capítulo 6");
        capituloList.add(cap);
        cap = new Capitulo("El oscuro defensor", 7,"Descripción capítulo 7");
        capituloList.add(cap);
        cap = new Capitulo("Secretos", 8,"Descripción capítulo 8");
        capituloList.add(cap);
        cap = new Capitulo("Prácticamente muertos", 9,"Descripción capítulo 9");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 2");
        temporadaList.add(temp);
////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("Semillaa", 1,"Descripción capítulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Enfermo", 2,"Descripción capítulo 2");
        capituloList.add(cap);
        cap = new Capitulo("Sintomas de ser 3", 3,"Descripción capítulo 3");
        capituloList.add(cap);
        cap = new Capitulo("Camina con migo", 4,"Descripción capítulo 4");
        capituloList.add(cap);
        cap = new Capitulo("El asesino que lleva dentro", 5,"Descripción capítulo 5");
        capituloList.add(cap);
        cap = new Capitulo("Dí la palabra", 6,"Descripción capítulo 6");
        capituloList.add(cap);
        cap = new Capitulo("Acosado", 7,"Descripción capítulo 7");
        capituloList.add(cap);
        cap = new Capitulo("Cuando la muerte viene llamando", 8,"Descripción capítulo 8");
        capituloList.add(cap);
        cap = new Capitulo("Hecha para sufrir", 9,"Descripción capítulo 9");
        capituloList.add(cap);
        cap = new Capitulo("El rey suicida", 10,"Descripción capítulo 10");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 3");
        temporadaList.add(temp);
///////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("30 días sin accidentes", 1,"Descripción capítulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Infectado", 2,"Descripción capítulo 2");
        capituloList.add(cap);
        cap = new Capitulo("Aislamiento", 3,"Descripción capítulo 3");
        capituloList.add(cap);
        cap = new Capitulo("Indiferencia", 4,"Descripción capítulo 4");
        capituloList.add(cap);
        cap = new Capitulo("Internamiento", 5,"Descripción capítulo 5");
        capituloList.add(cap);
        cap = new Capitulo("Cebo vivo", 6,"Descripción capítulo 6");
        capituloList.add(cap);
        cap = new Capitulo("Lastre", 7,"Descripción capítulo 7");
        capituloList.add(cap);
        cap = new Capitulo("Demasiado tarde", 8,"Descripción capítulo 8");
        capituloList.add(cap);
        cap = new Capitulo("Después", 9,"Descripción capítulo 9");
        capituloList.add(cap);
        cap = new Capitulo("Presos", 10,"Descripción capítulo 10");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 4");
        temporadaList.add(temp);

        generos = new ArrayList<>();
        generos.add("Drama");
        generos.add("Acción");
        generos.add("Aventura");

        actores = new ArrayList<>();
        actores.add("Alanna Masterson");
        actores.add(" Andrew Lincoln");
        actores.add("Austin Amelio");

        a = new Serie((ArrayList<Temporada>) temporadaList,"The walking dead",
                (ArrayList<String>)generos, (ArrayList<String>)actores, imagenes[1]);
        serieList.add(a);

        /////// SERIE 3
        temporadaList = new ArrayList<>();
        capituloList = new ArrayList<>();
        cap = new Capitulo("Piloto", 1,"Descripción capítulo 1");
        capituloList.add(cap);
        cap = new Capitulo("Honra a tu padre", 2,"Descripción capítulo 2");
        capituloList.add(cap);
        cap = new Capitulo("Pistoleros solitarios", 3,"Descripción capítulo 3");
        capituloList.add(cap);
        cap = new Capitulo("Un hombre inocente", 4,"Descripción capítulo 4");
        capituloList.add(cap);
        cap = new Capitulo("Mercancía estropeada", 5,"Descripción capítulo 5");
        capituloList.add(cap);
        cap = new Capitulo("Legado", 6,"Descripción capítulo 6");
        capituloList.add(cap);
        cap = new Capitulo("La visita", 7,"Descripción capítulo 7");
        capituloList.add(cap);
        cap = new Capitulo("Musa de fuego", 8,"Descripción capítulo 8");
        capituloList.add(cap);
        cap = new Capitulo("Vendeta", 9,"Descripción capítulo 9");
        capituloList.add(cap);
        cap = new Capitulo("Fin de año", 10,"Descripción capítulo 10");
        capituloList.add(cap);
        cap = new Capitulo("Quemado", 11,"Descripción capítulo 11");
        capituloList.add(cap);
        cap = new Capitulo("Confia pero verifica", 12,"Descripción capítulo 12");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 1");
        temporadaList.add(temp);
    /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("Ciudad de héroes", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("A un mono dos pistolas", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Identidad", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Muñecas rotas", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Crisol", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Liga de asesinos", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Manten a tus enemigos cerca", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El estado contra Queen", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El científico", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Tres fantasmas", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Punto ciego", 11,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Temblores", 12,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 2");
        temporadaList.add(temp);

        /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("La calma", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Sara", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Corto Maltés", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El mago", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Culpables", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Tensa tu arco", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El valiente y el rapido", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El ascenso", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Abandonado", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Ciudad de medianoche", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Levantamiento", 11,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Canarios", 12,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 3");
        temporadaList.add(temp);


        generos = new ArrayList<>();
        generos.add("Acción");
        generos.add("Aventura");
        generos.add("Ciencia ficción");
        generos.add("Crimen");

        actores = new ArrayList<>();
        actores.add("Katie Cassidy");
        actores.add("Stephen Amell");

        a = new Serie((ArrayList<Temporada>) temporadaList,"Arrow",
                (ArrayList<String>)generos, (ArrayList<String>)actores, imagenes[2]);
        serieList.add(a);


        /////// SERIE 4
        temporadaList = new ArrayList<>();
        capituloList = new ArrayList<>();
        cap = new Capitulo("Piloto", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Sobrevivir en la tierra", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Morir en la tierra", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("La ley de murphy", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El último destello del crepúsculo", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El custodio de su hermana", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Contenido bajo presión", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Excursión de un día", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El día de la unidad", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Me he convertido en la muerte", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("La calma", 11,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Somos terrestres", 12,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 1");
        temporadaList.add(temp);
        /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("Los 48", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Inclemencias", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Siega y cocecha", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Felices reencuentros", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Pruebas con humanos", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Niebla de guerra", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Muy profundo en el abismo", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Caminante espacial", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Recuerdame", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("La supervivencia del mas fuerte", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Golpe de gracia", 11,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Rubicón", 12,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 2");
        temporadaList.add(temp);

        /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("Wanheda", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Los que entran aquí", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Viendo los tronos", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Hakeldama", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Cosecha Amarga", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Trece", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Términos y condiciones", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Robando fuego", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Caída", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Nunca más", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Demonios", 11,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Unirse o morir", 12,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 3");
        temporadaList.add(temp);


        generos = new ArrayList<>();
        generos.add("Acción");
        generos.add("Aventura");
        generos.add("Ciencia ficción");
        generos.add("Crimen");

        actores = new ArrayList<>();
        actores.add("Katie Cassidy");
        actores.add("Stephen Amell");

        a = new Serie((ArrayList<Temporada>) temporadaList,"Los 100 - The Hundred",
                (ArrayList<String>)generos, (ArrayList<String>)actores, imagenes[3]);
        serieList.add(a);


        /////// SERIE 5
        temporadaList = new ArrayList<>();
        capituloList = new ArrayList<>();
        cap = new Capitulo("Se acerca el invierno", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Una sombra lo rodea", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El camino real", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Lord nieve", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Tullidos, bastardos y cosas rotas", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El lobo y el león", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Una corona de oro", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Ganas o mueres", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Por el lado de la punta", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Baelor", 10,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Fuego y sangre", 11,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 1");
        temporadaList.add(temp);
        /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("El norte no olvida", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Las tierras de la noche", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Lo que esta muerto no puede morir", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Jardín de huesos", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El fantasma de Harrenhal", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Los dioses antiguos y nuevos", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Un hombre sin honor", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Un princpe de invernalia", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Aguasnegras", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Valar morghulis", 10,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 2");
        temporadaList.add(temp);

        /////////////////
        capituloList = new ArrayList<>();
        cap = new Capitulo("Valar Dohaeris", 1,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Alas negras, palabras negras", 2,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El camino del castigo", 3,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Y ahora su guardia ha terminado", 4,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Besada por el fuego", 5,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El ascenso", 6,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("El oso y la doncella", 7,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Los segundos hijos", 8,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Las lluvias de Castamere", 9,"Descripción capítulo");
        capituloList.add(cap);
        cap = new Capitulo("Mhysa", 10,"Descripción capítulo");
        capituloList.add(cap);

        temp = new Temporada((ArrayList<Capitulo>) capituloList,"Temporada 3");
        temporadaList.add(temp);


        generos = new ArrayList<>();
        generos.add("Acción");
        generos.add("Aventura");
        generos.add("Ciencia ficción");
        generos.add("Drama");

        actores = new ArrayList<>();
        actores.add("Aidan Gillen");
        actores.add("Alfie Allen");
        actores.add("Carice van Hout");

        a = new Serie((ArrayList<Temporada>) temporadaList,"Juego de Tronos",
                (ArrayList<String>)generos, (ArrayList<String>)actores, imagenes[4]);
        serieList.add(a);


        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
