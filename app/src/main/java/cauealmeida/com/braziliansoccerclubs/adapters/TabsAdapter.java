package cauealmeida.com.braziliansoccerclubs.adapters;

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
        Fragment f = new TeamsFragment();
        return f;
    }

    @Override
    public int getCount() {
        return total_tabs;
    }
}
