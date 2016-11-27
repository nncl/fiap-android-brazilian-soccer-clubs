package cauealmeida.com.braziliansoccerclubs.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cauealmeida.com.braziliansoccerclubs.R;
import cauealmeida.com.braziliansoccerclubs.models.Team;

/**
 * Created by cauealmeida on 11/22/16.
 */

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamsViewHolder> {

    private List<Team> teamsList;
    private Context context;

    public TeamListAdapter(Context c, List<Team> teams) {
        this.context = c;
        this.teamsList = teams; // that's our f data, and now we bind this information
    }

    // Inflates/creates our view - it's linking to what we've created before: XML file
    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(context)
                .inflate(R.layout.item_team, parent, false);
        return new TeamsViewHolder(v);
    }

    // Bind list items/information
    @Override
    public void onBindViewHolder(final TeamsViewHolder holder, final int position) {
        Team team = teamsList.get(position);
        holder.clubName.setText(team.getName());
        holder.clubState.setText(team.getState());
        holder.clubBirth.setText(String.valueOf(team.getBirth()));
        holder.progressBar.setVisibility(View.VISIBLE);

        Picasso
                .with(context)
                .load(team.getLogo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.clubLogo, new com.squareup.picasso.Callback() {

                    // Remove loading from view when image loaded,
                    // either response being error or success one

                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }

    public Team getItem(int pos) {
        return teamsList.get(pos);
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public static class TeamsViewHolder extends RecyclerView.ViewHolder {
        TextView clubName;
        TextView clubState;
        TextView clubBirth;
        ImageView clubLogo;
        ProgressBar progressBar;

        public TeamsViewHolder(View v) {
            super(v);
            clubName = (TextView) v.findViewById(R.id.tvName);
            clubLogo = (ImageView) v.findViewById(R.id.ivImage);
            progressBar = (ProgressBar) v.findViewById(R.id.progressImg);
            clubState = (TextView) v.findViewById(R.id.tvState);
            clubBirth = (TextView) v.findViewById(R.id.tvBirth);
        }
    }

}
