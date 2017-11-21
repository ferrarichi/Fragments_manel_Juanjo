package mviel.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager fm;
    private FragmentTransaction ft;




    public Fragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);


        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getContext(),"Has fet click en Fragment1",Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.canto_superior_dret,Fragment2.newInstance("",""));
                ft.commit();




            }
        });

        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                FragmentManager fm;
                FragmentTransaction ft;

                Fragment2 f2;
                Fragment3 f3;

                if((f3 = (Fragment3)getFragmentManager().findFragmentById(R.id.canto_inferior_dret)) != null){

                    fm = getFragmentManager();
                    ft = fm.beginTransaction();



                    ft.remove(getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
                    ft.remove(getFragmentManager().findFragmentById(R.id.canto_superior_dret));
                    ft.commit();

                    Toast.makeText(getActivity().getBaseContext(),"Se ha eliminado el fragment 2 y el 3",Toast.LENGTH_LONG).show();



                }

                if((f2 = (Fragment2)getFragmentManager().findFragmentById(R.id.canto_superior_dret)) != null){

                    fm = getFragmentManager();
                    ft = fm.beginTransaction();

                    ft.remove(getFragmentManager().findFragmentById((R.id.canto_superior_dret)));
                    ft.commit();

                    Toast.makeText(getActivity().getBaseContext(),"Se ha eliminado el fragment 3",Toast.LENGTH_LONG).show();

                }

                    return false;
            }
        });
        return v;


    }


}
