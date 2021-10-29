package com.example.lesson13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{

    String[] classes = {"Choose Class","Cyber","Electronix","Chemistry","Teachers"};
    String[][] names = {{"paz","etay","yakir","harel", "yuval","noa","harel","ilai","keren","agam"},
            {"yakir", "ilai", "amit", "ilan","sean","roni","hila","drimi","agam","dingus"},
            {"roni","roni","ori","shaked","agam","keren","liron","eden","may","liron"},
            {"izik","albert","marina","eyal","yotam","hanan","sergio","eli","edna","lea"}};
    Student[][] students_info = {{new Student("paz", "malul", "065-1128-856", "20.8.2005"),
            new Student("etay", "sabag", "01-1465-698", "10.11.2005"),
            new Student("yakir", "biton", "04-4664-369", "21.1.2005"),
            new Student("harel", "navon", "074-9974-959", "13.2.2005"),
            new Student("yuval", "navon", "062-9801-777", "1.12.2005"),
            new Student("noa", "shitrit", "013-4394-497", "21.6.2005"),
            new Student("harel", "leivo", "06-9165-570", "11.11.2005"),
            new Student("ilai", "shimoni", "03-9448-356", "2.5.2005"),
            new Student("keren", "vaintrov", "050-4846-514", "30.2.2005"),
            new Student("agam", "tal", "052-4836-534", "20.3.2325")},
            {new Student("yakir", "biton", "067-1380-162", "23.2.2005"),
            new Student("ilai", "dahan", "091-5218-461", "10.2.2005"),
            new Student("amit", "barel", "026-5990-508", "8.1.2005"),
            new Student("ilan", "keren","043-4901-895", "3.1.2005"),
            new Student("sean", "leivo", "010-1757-238", "28.2.2005"),
            new Student("roni", "levin", "043-3150-592", "3.6.2005"),
            new Student("hila", "lugasi", "084-6163-875", "14.3.2005"),
            new Student("drimi", "shai", "077-857-254", "27.10.2005"),
            new Student("agam", "abukarat", "087-8516-277", "6.0.2005"),
            new Student("dingus", "head", "074-6019-960", "30.5.2005")},
            {new Student("roni", "rosh", "067-1380-162", "23.2.2005"),
            new Student("roni", "ashuri", "091-5218-461", "10.2.2005"),
            new Student("ori", "tzarfati", "026-5990-508", "8.1.2005"),
            new Student("shaked", "harush", "043-4901-895", "3.1.2005"),
            new Student("agam", "tal", "010-1757-238", "28.2.2005"),
            new Student("keren", "vaintruv", "043-3150-592", "3.6.2005"),
            new Student("liron", "cohen", "084-6163-875", "14.3.2005"),
            new Student("eden", "boker", "077-857-254", "27.10.2005"),
            new Student("may", "tuizer", "087-8516-277", "6.0.2005"),
            new Student("liron", "shemtov", "074-6019-960", "30.5.2005")},
            {new Student("itzik", "ben-shitrit", "04-1057-1", "12.5.2005"),
            new Student("albert", "levi", "013-3628-518", "27.0.2005"),
            new Student("marina", "grishkin", "041-8251-839", "0.9.2005"),
            new Student("eyal", "shlomo", "084-6198-34", "1.8.2005"),
            new Student("yotam", "noyman", "030-8812-89", "16.7.2005"),
            new Student("hanan", "meifo li", "012-2780-475", "16.2.2005"),
            new Student("sergio", "meifo li", "020-9452-649", "18.8.2005"),
            new Student("eli", "shushan", "020-5465-182", "4.7.2005"),
            new Student("edna", "shamir", "083-4669-821", "24.11.2005"),
            new Student("lea", "lotan", "089-3901-441", "4.1.2005")}};
    Spinner choose_class;
    ListView name_list;
    TextView tv1,tv2,tv3,tv4;
    int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choose_class = (Spinner) findViewById(R.id.spn1);
        name_list = (ListView) findViewById(R.id.l1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        selected = 0;

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,classes);
        choose_class.setAdapter(adp);

        choose_class.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, names[position-1]);
            name_list.setAdapter(adp2);
            name_list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            name_list.setOnItemClickListener(this);
            selected = position-1;
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)
                    name_list.getLayoutParams();
            params.weight = 35;
            name_list.setLayoutParams(params);
        }
        else{
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)
                    name_list.getLayoutParams();
            params.weight = 0;
            name_list.setLayoutParams(params);
            tv1.setText("Name");
            tv2.setText("Surname");
            tv3.setText("Phone number");
            tv4.setText("Birth date");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setText(students_info[selected][position].name);
        tv2.setText(students_info[selected][position].surname);
        tv3.setText(students_info[selected][position].phone);
        tv4.setText(students_info[selected][position].birth);
    }
}