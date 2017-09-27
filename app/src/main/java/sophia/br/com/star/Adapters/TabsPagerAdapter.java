package sophia.br.com.star.Adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sophia.br.com.star.Fragments.FragmentIngles;
import sophia.br.com.star.Fragments.FragmentMatematica;


/**
 * Created by cledson.alves on 27/09/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_TABS = 4;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch(position){
            case 0:
                return FragmentMatematica.newInstance();
            case 1:
                return FragmentIngles.newInstance();
            case 2:
                return FragmentMatematica.newInstance();
            default:
                return FragmentMatematica.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0){
            return "Matematica";
        }
        if (position == 1){
            return "Inglês";
        }
        if (position == 2){
            return "Espanhol";
        }

        return "Logica";
    }
}