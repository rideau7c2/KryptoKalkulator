package ovh.rideau.kryptokalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class AlgChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alg_chooser);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alg_chooser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()){
            case R.id.action_simpleEuklides:
                onClickSimpleEuklidesButton(null);
                return true;
            case R.id.action_fastModExp:
                onClickFastModExpButton(null);
                return true;
            case R.id.action_extendedEuklides:
                onClickExtendedEuklidesButton(null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onClickFastModExpButton(View v){
        Intent intent = new Intent(this,FastModExpActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Wprowadz dane i wciśnij /'Policz/'", Toast.LENGTH_LONG).show();
    }
    public void onClickSimpleEuklidesButton(View v){
        Intent intent = new Intent(this,SimpleEuklidesActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Wprowadz dane i wciśnij /'Policz/'", Toast.LENGTH_LONG).show();
    }

    public void onClickExtendedEuklidesButton(View v){
        Intent intent = new Intent(this,ExtendedEuklidesActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Wprowadz dane i wciśnij /'Policz/'", Toast.LENGTH_LONG).show();
    }
}
