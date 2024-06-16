package com.appzeto.status.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.appzeto.status.fragment.KChinFrag;
import com.appzeto.status.fragment.KMitronFrag;
import com.appzeto.status.fragment.KMojFrag;
import com.appzeto.status.fragment.KRopoFrag;
import com.appzeto.status.fragment.KZiliFrag;
import com.appzeto.status.fragment.LikeeFrag;
import com.appzeto.status.fragment.MxTakFrag;
import com.appzeto.status.fragment.PinFrag;
import com.appzeto.status.fragment.SChatFrag;
import com.appzeto.status.fragment.SnackFrag;
import com.appzeto.status.fragment.TweatFrag;
import com.appzeto.status.fragment.VimeoFrag;
import com.appzeto.status.fragment.WABusFrag;
import com.appzeto.status.fragment.WAppFrag;
import com.appzeto.status.fragment.FBFrag;
import com.appzeto.status.fragment.InsFrag;
import com.appzeto.status.fragment.TikFrag;

public class GalleryPagerAdapter extends FragmentPagerAdapter {


    public GalleryPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WAppFrag();
        }else if (position == 1) {
            return new WABusFrag();
        } else if (position == 2){
            return new InsFrag();
        }  else if (position == 3){
            return new TikFrag();
        }else if (position == 4){
            return new TweatFrag();
        }else if (position == 5){
            return new FBFrag();
        }else if (position == 6){
            return new VimeoFrag();
        }else if (position == 7){
            return new LikeeFrag();
        }else if (position == 8){
            return new SnackFrag();
        }else if (position == 9){
            return new SChatFrag();
        }else if (position == 10){
            return new KRopoFrag();
        } else if (position == 11){
            return new KChinFrag();
        } else if (position == 12) {
            return new KMojFrag();
        } else if (position == 13) {
            return new PinFrag();
        } else if (position == 14){
            return new MxTakFrag();
        } else if (position == 15) {
            return new KMitronFrag();
        } else {
            return new KZiliFrag();
        }
    }

    @Override
    public int getCount() {
        return 14;
    }


}
