package ovh.rideau.kryptokalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FastModExpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_mod_exp);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fast_mod_exp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {return true;}

        return super.onOptionsItemSelected(item);
    }*/
    public void onClickCalculateFastButton(View v){
        int rowNumber = 0;
        TableLayout tl = (TableLayout) findViewById(R.id.resultTable);
        //for(TableRow rowToDel : addedRows){
            tl.removeViews(1, tl.getChildCount()-1);
        //}
        int powerBase = getIntFromEditTextId(R.id.aVal);
        int powerExp = getIntFromEditTextId(R.id.powerExponent);
        int powerModul = getIntFromEditTextId(R.id.modul);
        int x1 = 1;
        int a1 = powerBase;
        for(Integer bit : toBinary(powerExp)){
            tl.addView(buildRow(rowNumber++, x1, a1, bit), new TableLayout.LayoutParams());
            if(bit.equals(1)){
                x1 = (x1*a1)%powerModul;
            }
            a1 = (a1*a1)%powerModul;
        }
        TableRow resultRow = buildRow(rowNumber, x1, a1, 0);
        resultRow.getChildAt(1).setBackgroundResource(R.drawable.result_cell_shape);
        tl.addView(resultRow);
    }
    private TableRow buildRow(int... values){
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        for(int val : values){
            tr.addView(buildCell(val));
        }
        return tr;
    }
    private TextView buildCell(int value){
        TextView tv = new TextView(this);
        tv.setText(String.valueOf(value));
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setBackgroundResource(R.drawable.cell_shape);
        return tv;
    }
    private int getIntFromEditTextId(int id){
        return Integer.parseInt(
                ((EditText) findViewById(id))
                        .getText()
                        .toString());
    }

    private List<Integer> toBinary(int number) {
        List<Integer> bits = new ArrayList<>();
        bits.add(number%2);
        if(number > 1) {
            bits.addAll(toBinary(number / 2));
            return bits;
        }else{
            return bits;
        }
    }
}
