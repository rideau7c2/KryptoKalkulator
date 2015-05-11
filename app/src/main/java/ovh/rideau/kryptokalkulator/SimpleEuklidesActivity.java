package ovh.rideau.kryptokalkulator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class SimpleEuklidesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_euklides);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_simple_euklides, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    public void onClickCalculateSimpleButton(View v){
        int rowNumber = 0;
        TableLayout tl = (TableLayout) findViewById(R.id.resultTable);
        tl.removeViews(1, tl.getChildCount()-1);
        int a1 = getIntFromEditTextId(R.id.aVal);
        int b1 = getIntFromEditTextId(R.id.bVal);
        int q, r;
        do{
            q = a1/b1;
            r = a1%b1;
            tl.addView(buildRow(a1, b1, q, r), new TableLayout.LayoutParams());
            a1 = b1;
            b1 = r;
        }while(r > 0);
        int resultRowNum = tl.getChildCount()-2;
        if(resultRowNum > 0){
            TableRow resultRow = (TableRow) tl.getChildAt(resultRowNum);
            resultRow.getChildAt(3).setBackgroundResource(R.drawable.result_cell_shape);
        }else{
            TableRow resultRow = (TableRow) tl.getChildAt(1);
            resultRow.getChildAt(1).setBackgroundResource(R.drawable.result_cell_shape);
        }
    }
    private TableRow buildRow(int... values){
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
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
}
