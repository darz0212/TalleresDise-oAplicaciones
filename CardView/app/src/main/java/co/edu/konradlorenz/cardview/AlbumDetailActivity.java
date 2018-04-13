package co.edu.konradlorenz.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AlbumDetailActivity extends AppCompatActivity {

    public TextView title, count;
    public ImageView thumbnail;

    private Album albumItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        Bundle parameters = getIntent().getExtras();

        if(parameters != null){
            albumItem = (Album) parameters.get("albumItem");

            title = (TextView) findViewById(R.id.album_name);
            count = (TextView) findViewById(R.id.count);
            thumbnail = (ImageView) findViewById(R.id.imageView);

            title.setText(albumItem.getName());
            count.setText(albumItem.getNumOfSongs()+"");

            Glide.with(this).load(albumItem.getThumbnail()).into(thumbnail);
        }
    }


}
