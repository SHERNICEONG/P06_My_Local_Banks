package sg.edu.rp.c346.id22017424.p06_my_local_banks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvD;
    TextView tvO;
    TextView tvU;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvD = findViewById(R.id.textViewDbs);
        registerForContextMenu(tvD);

        tvO = findViewById(R.id.textViewOcbc);
        registerForContextMenu(tvO);

        tvU = findViewById(R.id.textViewUob);
        registerForContextMenu(tvU);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvD.setText("DBS");
            tvO.setText("OCBC");
            tvU.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvD.setText("星展银行");
            tvO.setText("华侨银行");
            tvU.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact bank");
        menu.add(0, 2,2, "Toggle Favourite");

        if(v == tvD){
            wordClicked = "dbs";
        } else if (v == tvO) {
            wordClicked = "ocbc";
        } else {
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111L));
                startActivity(intent);
            } else if (item.getItemId()==2) {
                if (tvD.getCurrentTextColor()== Color.RED){
                    tvD.setTextColor(Color.BLACK);
                } else {
                    tvD.setTextColor(Color.RED);
                };
            }

        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333L));
                startActivity(intent);
            } else if (item.getItemId()==2) {
                if (tvO.getCurrentTextColor()== Color.RED){
                    tvO.setTextColor(Color.BLACK);
                } else {
                    tvO.setTextColor(Color.RED);
                };
            }

        } else {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18002222121L));
                startActivity(intent);
            } else if (item.getItemId()==2) {
                if (tvU.getCurrentTextColor()== Color.RED){
                    tvU.setTextColor(Color.BLACK);
                } else {
                    tvU.setTextColor(Color.RED);
                };
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}