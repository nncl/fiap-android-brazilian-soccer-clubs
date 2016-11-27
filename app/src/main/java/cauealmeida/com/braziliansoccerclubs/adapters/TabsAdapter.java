package cauealmeida.com.braziliansoccerclubs.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cauealmeida.com.braziliansoccerclubs.fragments.TeamsFragment;

/**
 * Created by cauealmeida on 11/22/16.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    public static final int total_tabs = 1;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        // TODO remove it
        // Pass information between fragments
        Bundle b = new Bundle();
        b.putString("type", "classicos");

        Fragment f = new TeamsFragment();
        f.setArguments(b);
        return f;
    }

    @Override
    public int getCount() {
        return total_tabs;
    }
}
