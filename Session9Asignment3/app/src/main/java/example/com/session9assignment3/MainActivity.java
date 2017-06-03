package example.com.session9assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.BaseAdapter;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> namelist=new ArrayList<>();
    private ArrayList<String> phlist=new ArrayList<>();
    private MyAdapter adapter;
    ListView listView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the Array for names
        namelist.add("Ruturaj B.");
        namelist.add("Reshma M.");
        namelist.add("Rishita S.");
        namelist.add("Ankita T.");
        namelist.add("Mayuresh H.");
        namelist.add("Vidya B.");
        namelist.add("Renu K.");
        namelist.add("Rakshanda S.");

        //Initializing the Array for phone numbers
        phlist.add("9881402001");
        phlist.add("9881402002");
        phlist.add("9881402003");
        phlist.add("9881402004");
        phlist.add("9881402005");
        phlist.add("9881402006");
        phlist.add("9881402007");
        phlist.add("9881402008");

        listView1=(ListView)findViewById(R.id.numberList);

        //Creating the custom adapter
        MyAdapter adapter=new MyAdapter(this,namelist,phlist);
        listView1.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView1);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}
