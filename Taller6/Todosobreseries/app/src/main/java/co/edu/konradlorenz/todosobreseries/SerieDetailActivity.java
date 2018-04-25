package co.edu.konradlorenz.todosobreseries;

import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class SerieDetailActivity extends AppCompatActivity implements FragmentoCapitulos.OnFragmentInteractionListener {

    public TextView name, gender, actors, titulo;
    public ImageView thumbnail;
    private Serie serieItem;

    private RecyclerView temporadasRecyclerView;
    private List<Temporada> temporadaList;
    private TemporadasAdapter adapter;

    private RecyclerView capitulosRecyclerView;
    private List<Capitulo> capituloList;
    private CapitulosAdapter adapterCapitulos;

    private FragmentoCapitulos fragmentoCapitulos;

    public SerieDetailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_detail);

        temporadasRecyclerView = (RecyclerView) findViewById(R.id.seasons_recycler_view);
        temporadaList = new ArrayList<>();

        capitulosRecyclerView = (RecyclerView) findViewById(R.id.chapters_recycler_view);
        capituloList = new ArrayList<>();

        fragmentoCapitulos = new FragmentoCapitulos();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmento_capitulos,fragmentoCapitulos);

        Bundle parameters = getIntent().getExtras();
        if(parameters != null){
            serieItem = (Serie) parameters.get("serieItem");
            temporadaList = serieItem.getTemporadaList();
            name = (TextView) findViewById(R.id.nameTextView);
            titulo = (TextView) findViewById(R.id.tituloDetalle);
            gender = (TextView) findViewById(R.id.genderTextView);
            actors = (TextView) findViewById(R.id.actorsTextView);
            thumbnail = (ImageView) findViewById(R.id.imagenDetalle);
            capituloList = temporadaList.get(0).getCapituloList();
            name.setText(serieItem.getNombre());
            titulo.setText(serieItem.getNombre());
            String generos = "";
            ArrayList<String> generosSerie = serieItem.getGenero();
            for (int i=0; i< generosSerie.size();i++){
                if(i >= generosSerie.size()-1){
                    generos = generos + generosSerie.get(i);
                }else{
                    generos = generos + generosSerie.get(i)+", ";
                }
            }
            gender.setText(generos);

            String actores = "";
            ArrayList<String> actoresSerie = serieItem.getActores();
            for (int i=0; i< actoresSerie.size();i++){
                if(i >= actoresSerie.size()-1){
                    actores = actores + actoresSerie.get(i);
                }else{
                    actores = actores + actoresSerie.get(i)+", ";
                }
            }
            actors.setText(actores);

            Glide.with(this).load(serieItem.getThumbnail()).into(thumbnail);
        }

        adapter = new TemporadasAdapter(this,temporadaList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 4);
        temporadasRecyclerView.setLayoutManager(mLayoutManager);
        temporadasRecyclerView.addItemDecoration(new SerieDetailActivity.GridSpacingItemDecoration(4, dpToPx(10), true));
        temporadasRecyclerView.setItemAnimator(new DefaultItemAnimator());
        temporadasRecyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapterCapitulos = new CapitulosAdapter(this,capituloList);


        final RecyclerView.LayoutManager mLayoutManager2 = new GridLayoutManager(this, 1);
        capitulosRecyclerView.setLayoutManager(mLayoutManager2);
        capitulosRecyclerView.addItemDecoration(new SerieDetailActivity.GridSpacingItemDecoration(1, dpToPx(10), true));
        capitulosRecyclerView.setItemAnimator(new DefaultItemAnimator());
        capitulosRecyclerView.setAdapter(adapterCapitulos);


        adapterCapitulos.notifyDataSetChanged();

        final GestureDetector mGestureDetector = new GestureDetector(SerieDetailActivity.this, new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        temporadasRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                try {
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                    if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {

                        int position = recyclerView.getChildAdapterPosition(child);
                        setCapituloList(temporadaList.get(position).getCapituloList());
                        position += 1;
                        Toast.makeText(SerieDetailActivity.this,"Temporada: "+ position ,Toast.LENGTH_SHORT).show();
                        capitulosRecyclerView = (RecyclerView) findViewById(R.id.chapters_recycler_view);

                        adapterCapitulos = new CapitulosAdapter(SerieDetailActivity.this,capituloList);
                        //RecyclerView.LayoutManager mLayoutManager2 = new GridLayoutManager(SerieDetailActivity.this, 1);
                        capitulosRecyclerView.setLayoutManager(mLayoutManager2);
                        //capitulosRecyclerView.addItemDecoration(new SerieDetailActivity.GridSpacingItemDecoration(1, dpToPx(1), true));
                        capitulosRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        capitulosRecyclerView.setAdapter(adapterCapitulos);

                        adapterCapitulos.notifyDataSetChanged();


                        return true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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

    public CapitulosAdapter getAdapterCapitulos() {
        return adapterCapitulos;
    }

    public void setAdapterCapitulos(CapitulosAdapter adapterCapitulos) {
        this.adapterCapitulos = adapterCapitulos;
    }

    public List<Capitulo> getCapituloList() {
        return capituloList;
    }

    public void setCapituloList(List<Capitulo> capituloList) {
        this.capituloList = capituloList;
    }
}
