package ajaymehta.jsonfromassetsgsonglide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ajaymehta.jsonfromassetsgsonglide.Profile;
import ajaymehta.jsonfromassetsgsonglide.R;
import ajaymehta.jsonfromassetsgsonglide.Utils;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Ajay Mehta on 12/11/2016.
 */

public class CustomAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Context context;


    public CustomAdapter(LayoutInflater inflater,Context mContext) {
        mInflater = inflater;
        context = mContext;

    }


    @Override
    public int getCount() {
        return Utils.loadProfiles(context).size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {


            convertView = mInflater.inflate(R.layout.custom_adapter, parent, false);
        }
        ImageView profilePic = (ImageView) convertView.findViewById(R.id.iv_profilepic);
        TextView nameAge = (TextView) convertView.findViewById(R.id.tv_nameage);
        TextView location = (TextView) convertView.findViewById(R.id.tv_location);

        List<Profile> arraylist = Utils.loadProfiles(context);

        for(int i=0; i<arraylist.size();i++){

            String imageUrl = arraylist.get(position).getImageUrl();

            glide(imageUrl, profilePic);

            nameAge.setText(arraylist.get(position).getName()+","+arraylist.get(position).getAge());
            location.setText(arraylist.get(position).getLocation()+"");

        }

// see above i used normal for loop ..m not getting how do i use position with for each loop ..
        // you can use it ..but i find normal for loop better...
       /* for(Profile profile : Utils.loadProfiles(context)){

            glide(profile, profilePic);

          nameAge.setText(profile.getName()+","+profile.getAge());
            location.setText(profile.getLocation()+"");

        }
*/

        return convertView;
    }

    // it will take bit of time to load image .....so i m letting you know ......
    //=============Dont forget to put the INTERNET permission in manifest otherwise glide will not work=========
    public void glide(String url , ImageView profilePic){

            Glide.with(context).load(url)
                    .bitmapTransform(new RoundedCornersTransformation(context, Utils.dpToPx(7), 0,
                            RoundedCornersTransformation.CornerType.TOP))
                    .into(profilePic);
            }
}
