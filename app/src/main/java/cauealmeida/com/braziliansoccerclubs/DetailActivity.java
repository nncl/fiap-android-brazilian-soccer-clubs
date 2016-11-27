package cauealmeida.com.braziliansoccerclubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cauealmeida.com.braziliansoccerclubs.models.Team;

public class DetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private ImageView thumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.dtlDesc);
        description = (TextView) findViewById(R.id.dtlDesc);
        thumb = (ImageView) findViewById(R.id.dtlImagem);

        if (getIntent() != null) {
            Team team = getIntent().getParcelableExtra("team");
            name.setText(team.getName());
            description.setText(team.getState());

            Picasso
                    .with(this)
                    .load(team.getLogo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(thumb);
        }
    }

}
