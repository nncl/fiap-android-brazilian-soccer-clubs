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
import cauealmeida.com.braziliansoccerclubs.listener.OnClickListener;
import cauealmeida.com.braziliansoccerclubs.models.Team;

/**
 * Created by cauealmeida on 11/22/16.
 */

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamsViewHolder> {

    private List<Team> teamsList;
    private Context context;
    private OnClickListener clickListener;

    public TeamListAdapter(Context c, List<Team> teams, OnClickListener clickListener) {
        this.context = c;
        this.teamsList = teams; // that's our f data, and now we bind this information
        this.clickListener = clickListener; // What that screen has to do with that info
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
        holder.tName.setText(team.getName());
        holder.description.setText(team.getState());

        Picasso
                .with(context)
                .load(team.getLogo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.image);

        holder.progressBar.setVisibility(View.VISIBLE);

        // TODO remove it
        if (clickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    public Team getItem(int pos) {
        return teamsList.get(pos);
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public static class TeamsViewHolder extends RecyclerView.ViewHolder {
        public TextView tName;
        ImageView image;
        ProgressBar progressBar;
        TextView description;

        public TeamsViewHolder(View v) {
            super(v);
            tName = (TextView) v.findViewById(R.id.tvName);
            image = (ImageView) v.findViewById(R.id.ivImage);
            progressBar = (ProgressBar) v.findViewById(R.id.progressImg);
            description = (TextView) v.findViewById(R.id.tvDesc);
        }
    }

}
