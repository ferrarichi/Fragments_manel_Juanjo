package mviel.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements Fragment2.Comunicador, Fragment2.OnFragmentInteractionListener2,Fragment3.OnFragmentInteractionListener3 {


    public static int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction2(Uri uri) {

    }

    @Override
    public boolean estaFragment3EnActivity() {
       Fragment3 f3= (Fragment3)getFragmentManager().findFragmentById(R.id.canto_inferior_dret);
        if(f3==null)
            return false;
        else
            return true;
    }

    @Override
    public void onFragmentInteraction3(Uri uri) {

    }

    public void onBackPressed(){

         FragmentManager fm;
         FragmentTransaction ft;

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if(estaFragment3EnActivity()==true){

            ft.remove(getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
            ft.commit();
            Toast.makeText(getApplicationContext(),"Se ha eliminado el fragment 3",Toast.LENGTH_LONG).show();

        }else{

            ft.remove(getFragmentManager().findFragmentById(R.id.canto_superior_dret));
            ft.commit();
            Toast.makeText(getApplicationContext(), "Se ha eliminado el fragment 2", Toast.LENGTH_LONG).show();
        }
    }


    public void comunica(int cont){
        contador = cont;
    }
}
