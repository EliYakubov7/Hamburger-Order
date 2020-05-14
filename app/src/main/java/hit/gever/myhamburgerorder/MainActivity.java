package hit.gever.myhamburgerorder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private SeekBar seek_bar;
    private TextView quantity;
    int rem_price = 0;
    int rem_price2=0;

    public void init() {
        button = findViewById(R.id.leave_feedback_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LeaveFeedbackActivity.class);
                startActivity(intent);
            }

        });
    }

    Hamburger hamburger;
    TextView total;
    //double total_price;
    TextView delivery;
    CheckBox fried_egg;
    CheckBox fried_onion;
    CheckBox chili_pineapple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();

        hamburger = new Hamburger();
        delivery = findViewById(R.id.deliveryNote);
        fried_egg = findViewById(R.id.Fried_Egg);
        fried_onion = findViewById(R.id.Fried_Onion);
        chili_pineapple = findViewById(R.id.Chili_Pineapple);


        seekbar();

        button.setClickable(false);
        button.setBackgroundResource(R.drawable.rounded_button2);


        Button reset = findViewById(R.id.button_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                fried_egg.setChecked(false);
                fried_onion.setChecked(false);
                chili_pineapple.setChecked(false);
//                fried_egg.setEnabled(true);
//                fried_onion.setEnabled(true);
//                chili_pineapple.setEnabled(true);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton small_hamburger = findViewById(R.id.Small_Hamburger);
                RadioButton medium_hamburger = findViewById(R.id.Medium_Hamburger);
                RadioButton big_hamburger = findViewById(R.id.Big_Hamburger);
                radioGroup.clearCheck();
                small_hamburger.setEnabled(true);
                medium_hamburger.setEnabled(true);
                big_hamburger.setEnabled(true);

                TextView quantity = findViewById(R.id.quantity);
                quantity.setEnabled(true);
                SeekBar seekBar = findViewById(R.id.seekBar);
                seekBar.setProgress(0);
                seekBar.setEnabled(true);

                seekBar.setEnabled(false);
                HorizontalScrollView horizon = findViewById(R.id.horizonScrollView);
                horizon.removeAllViews();
                LinearLayout ll11;
                ll11 = findViewById(R.id.linear1);
                ll11.setVisibility(View.VISIBLE);
                quantity = findViewById(R.id.quantity);
                quantity.setVisibility(View.VISIBLE);
                seekBar = findViewById(R.id.seekBar);
                seekBar.setVisibility(View.VISIBLE);

                Switch switch1 = findViewById(R.id.yes);
                switch1.setTextColor(getResources().getColor(R.color.colorSwitchBefore));
                switch1.setClickable(false);
                switch1.setChecked(false);
                switch1.setEnabled(true);

                delivery.setVisibility(View.INVISIBLE);

                //delivery.setText("");

                button.setBackgroundResource(R.drawable.rounded_button2);
                button.setClickable(false);


                if (Locale.getDefault().getLanguage().equals("en")) {
                    total = findViewById(R.id.total_price);
                    total.setText("");
                    total.setText("Total Price");
                }
                else
                {
                    total = findViewById(R.id.total_price);
                    total.setText("");
                    total.setText("מחיר כולל");
                }
            }
        });

        fried_egg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                @SuppressLint("CutPasteId") SeekBar seekBar1 = findViewById(R.id.seekBar);
                @SuppressLint("CutPasteId")  Switch switch1 = findViewById(R.id.yes);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int price, addExtra1;
                price = addExtra1 = 0;
                int price2, addExtra2;
                price2 = addExtra2 = 0;


                if (radioGroup.getCheckedRadioButtonId() == R.id.Small_Hamburger) {
                    price = 14;
                    price2 = 48;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);

                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Medium_Hamburger) {
                    price = 17;
                    price2 = 59;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Big_Hamburger) {
                    price = 20;
                    price2 = 69;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }

                CheckBox cb1 = findViewById(R.id.Fried_Egg);
                CheckBox cb2 = findViewById(R.id.Fried_Onion);
                CheckBox cb3 = findViewById(R.id.Chili_Pineapple);

                if (Locale.getDefault().getLanguage().equals("en")) {
                    if (cb1.isChecked())
                        addExtra1 += 2;

                    if (cb2.isChecked())
                        addExtra1 += 2;

                    if (cb3.isChecked())
                        addExtra1 += 2;

                }
                else {

                    if (cb1.isChecked())
                    addExtra2 += 7;


                    if (cb2.isChecked())
                    addExtra2 += 7;


                    if (cb3.isChecked())
                    addExtra2 += 7;
                }

                if (Locale.getDefault().getLanguage().equals("en")) {
                    addExtra1 += price;
                    total = findViewById(R.id.total_price);
                    rem_price = addExtra1;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra1 = addExtra1 * (seekBar.getProgress() + 1);
                    String str = (getString(R.string.total_price2) + " " + addExtra1 + "$");
                    total.setText(str);
                }

                else {
                    addExtra2 += price2;
                    total = findViewById(R.id.total_price);
                    rem_price2 = addExtra2;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra2 = addExtra2 * (seekBar.getProgress() + 1);
                    String str2 = (getString(R.string.total_price2) + " " + "₪" + addExtra2);
                    total.setText(str2);
                }
                }
        });

        fried_onion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                @SuppressLint("CutPasteId") SeekBar seekBar1 = findViewById(R.id.seekBar);
                Switch switch1 = findViewById(R.id.yes);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int price, addExtra1;
                price = addExtra1 = 0;
                int price2, addExtra2;
                price2 = addExtra2 = 0;


                if (radioGroup.getCheckedRadioButtonId() == R.id.Small_Hamburger) {
                    price = 14;
                    price2 = 48;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Medium_Hamburger) {
                    price = 17;
                    price2 = 59;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Big_Hamburger) {
                    price = 20;
                    price2 = 69;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }

                CheckBox cb1 = findViewById(R.id.Fried_Egg);
                CheckBox cb2 = findViewById(R.id.Fried_Onion);
                CheckBox cb3 = findViewById(R.id.Chili_Pineapple);

                if (Locale.getDefault().getLanguage().equals("en")) {
                    if (cb1.isChecked())
                        addExtra1 += 2;

                    if (cb2.isChecked())
                        addExtra1 += 2;



                    if (cb3.isChecked())
                        addExtra1 += 2;

                }
                else {
                    if (cb1.isChecked())
                    addExtra2 += 7;

                    if (cb2.isChecked())
                    addExtra2 += 7;


                    if (cb3.isChecked())
                    addExtra2 += 7;

                }

                if (Locale.getDefault().getLanguage().equals("en")) {
                    addExtra1 += price;
                    total = findViewById(R.id.total_price);
                    rem_price = addExtra1;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra1 = addExtra1 * (seekBar.getProgress() + 1);
                    String str = (getString(R.string.total_price2) + " " + addExtra1 + "$");
                    total.setText(str);
                }
                else {
                    addExtra2 += price2;
                    total = findViewById(R.id.total_price);
                    rem_price2 = addExtra2;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra2 = addExtra2 * (seekBar.getProgress() + 1);
                    String str2 = (getString(R.string.total_price2) + " "  + "₪" + addExtra2);
                    total.setText(str2);
                }
            }
        });

        chili_pineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                @SuppressLint("CutPasteId") SeekBar seekBar1 = findViewById(R.id.seekBar);
                Switch switch1 = findViewById(R.id.yes);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int price, addExtra1;
                price = addExtra1 = 0;
                int price2, addExtra2;
                price2 = addExtra2 = 0;

                if (radioGroup.getCheckedRadioButtonId() == R.id.Small_Hamburger) {
                    price = 14;
                    price2 = 48;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Medium_Hamburger) {
                    price = 17;
                    price2 = 59;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.Big_Hamburger) {
                    price = 20;
                    price2 = 69;
                    seekBar1.setEnabled(true);
                    switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                    switch1.setClickable(true);
                }

                CheckBox cb1 = findViewById(R.id.Fried_Egg);
                CheckBox cb2 = findViewById(R.id.Fried_Onion);
                CheckBox cb3 = findViewById(R.id.Chili_Pineapple);

                if (Locale.getDefault().getLanguage().equals("en")) {
                    if (cb1.isChecked())
                        addExtra1 += 2;

                    if (cb2.isChecked())
                        addExtra1 += 2;


                    if (cb3.isChecked())
                        addExtra1 += 2;
                }

                else
                {
                    if (cb1.isChecked())
                    addExtra2 += 7;


                    if (cb2.isChecked())
                    addExtra2 += 7;


                    if (cb3.isChecked())
                    addExtra2 += 7;
                }

                if (Locale.getDefault().getLanguage().equals("en"))
                {
                    addExtra1 += price;
                    total = findViewById(R.id.total_price);
                    rem_price = addExtra1;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra1 = addExtra1 * (seekBar.getProgress()+1);
                    String str = (getString(R.string.total_price2) + " " + addExtra1 + "$");
                    total.setText(str);

                }
                else
                {
                    addExtra2 += price2;
                    total = findViewById(R.id.total_price);
                    rem_price2 = addExtra2;
                    @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
                    seekBar.getProgress();
                    addExtra2 = addExtra2 * (seekBar.getProgress()+1);
                    String str2 = (getString(R.string.total_price2) + " "  +  "₪" + addExtra2);
                    total.setText(str2);
                }
            }
        });
    }

    public void radioButtonClicked(View view) {
        @SuppressLint("CutPasteId") SeekBar seekBar1 = findViewById(R.id.seekBar);
        Switch switch1 = findViewById(R.id.yes);
        boolean checked = ((RadioButton) view).isChecked();
        int total_pay = 0;
        int addExtra = 0;
        int total_pay2 = 0;
        int addExtra2 = 0;


        switch (view.getId()) {
            case R.id.Small_Hamburger: {
                total_pay = 14;
                total_pay2 = 48;
                button.setClickable(true);
                button.setBackgroundResource(R.drawable.rounded_button);
                seekBar1.setEnabled(true);
                switch1.setClickable(true);
                switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                break;
            }

            case R.id.Medium_Hamburger: {
                total_pay = 17;
                total_pay2 = 59;
                button.setClickable(true);
                button.setBackgroundResource(R.drawable.rounded_button);
                seekBar1.setEnabled(true);
                switch1.setClickable(true);
                switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                break;
            }
            case R.id.Big_Hamburger: {
                total_pay = 20;
                total_pay2 = 69;
                button.setClickable(true);
                button.setBackgroundResource(R.drawable.rounded_button);
                seekBar1.setEnabled(true);
                switch1.setClickable(true);
                switch1.setTextColor(getResources().getColor(R.color.colorSwitchAfter));
                break;

            }
        }
        CheckBox cb1 = findViewById(R.id.Fried_Egg);
        CheckBox cb2 = findViewById(R.id.Fried_Onion);
        CheckBox cb3 = findViewById(R.id.Chili_Pineapple);

        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        switch1.setEnabled(true);

        if (Locale.getDefault().getLanguage().equals("en")) {
            if (cb1.isChecked())
                addExtra += 2;

            if (cb2.isChecked())
                addExtra += 2;


            if (cb3.isChecked())
                addExtra += 2;

        }
        else {

            if (cb1.isChecked())
            addExtra2 += 7;

            if (cb2.isChecked())
            addExtra2 += 7;

            if (cb3.isChecked())
            addExtra2 += 7;
        }
        if (Locale.getDefault().getLanguage().equals("en"))
        {
            addExtra += total_pay;
            total = findViewById(R.id.total_price);
            rem_price=addExtra;
            @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
            seekBar.getProgress();
            addExtra = addExtra * (seekBar.getProgress()+1);
            String str = (getString(R.string.total_price2) + " " + addExtra + "$");
            total.setText(str);

        }
        else {

            addExtra2 += total_pay2;
            total = findViewById(R.id.total_price);
            rem_price2=addExtra2;
            @SuppressLint("CutPasteId") SeekBar seekBar = findViewById(R.id.seekBar);
            seekBar.getProgress();
            addExtra2 = addExtra2 * (seekBar.getProgress()+1);
            String str2 = (getString(R.string.total_price2)  + " " + "₪" + addExtra2);
            total.setText(str2);
        }
    }



/*

    public void checkBoxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.Fried_Egg:
                if (checked)
                    hamburger.setFried_egg_price(2);
                else
                    hamburger.setFried_egg_price(0);
                break;

            case R.id.Fried_Onion:
                if (checked)
                    hamburger.setFried_onion_price(2);
                else
                    hamburger.setFried_onion_price(0);
                break;

            case R.id.Chili_Pineapple:
                if (checked)
                    hamburger.setChili_pineapple_price(2);
                else
                    hamburger.setChili_pineapple_price(0);
                break;

        }

        total.setText("Total Price : "  + String.format("%.02f", calculate_total()) + "$");

    }
*/

/*    private double calculate_total()

    {
      total_price = hamburger.getHamburger_size_price() +
      hamburger.getFried_egg_price() + hamburger.getFried_onion_price() + hamburger.getChili_pineapple_price();

      return total_price;
    }*/

    public void onSwitchClicked(View view) {

        //String note = "Your delivery is on it's way";
        Switch swButton = (Switch) view;

        button.findViewById(R.id.leave_feedback_button);
        RadioButton button1 = findViewById(R.id.Small_Hamburger);
        RadioButton button2 = findViewById(R.id.Medium_Hamburger);
        RadioButton button3 = findViewById(R.id.Big_Hamburger);
        TextView quantity = findViewById(R.id.quantity);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView delivery = findViewById(R.id.deliveryNote);

        HorizontalScrollView horizon = findViewById(R.id.horizonScrollView);
        if (swButton.isChecked()) {


            //button.setBackgroundResource(R.drawable.rounded_button);
//          button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            //button.setClickable(true);

            swButton.setEnabled(false);
            fried_egg.setEnabled(false);
            fried_onion.setEnabled(false);
            chili_pineapple.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            quantity.setEnabled(false);
            seekBar.setEnabled(false);

            delivery.setVisibility(View.VISIBLE);

        } else {
            delivery.setText("");
        }

            horizon.removeAllViews();

            LinearLayout ll11;
            ll11 = findViewById(R.id.linear1);
            ll11.setVisibility(View.GONE);
            quantity = findViewById(R.id.quantity);
            quantity.setVisibility(View.INVISIBLE);
            seekBar = findViewById(R.id.seekBar);
            seekBar.setVisibility(View.INVISIBLE);


            int width, height;
            int inLine = 10;
            int amount = seekBar.getProgress()+1;
            int rows = (amount/inLine)+1;

            if(amount>=1 && amount<31) {
                width = height = 128;
            }
            else if(amount>=31 && amount<41) {
                width = height = 114;
            }
            else
                width = height = 100;

        LinearLayout verticalLayout = new LinearLayout(MainActivity.this);
        verticalLayout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        if(amount>=1 && amount<=10)
        {
            inLine = amount;
            rows=1;
        }
            for (int i = 0; i < rows; i++) {
              LinearLayout linearLayout = new LinearLayout(MainActivity.this);
              linearLayout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
              linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                for (int j = 0; j < inLine; j++) {
                    ImageView iv = new ImageView(MainActivity.this);
                    iv.setImageResource(R.drawable.hamburger2);
                    iv.setPadding(0,0,5,0);
                    linearLayout.addView(iv, width, height);
            }
                if (i+2== rows) {
                    inLine = amount - inLine * (rows - 1);
                }
                verticalLayout.addView(linearLayout);
            }
            horizon.addView(verticalLayout);
    }

    @SuppressLint("SetTextI18n")
    public void seekbar() {

        if (Locale.getDefault().getLanguage().equals("en")) {
            seek_bar = findViewById(R.id.seekBar);
            quantity = findViewById(R.id.quantity);
            quantity.setText("Quantity :" + " " + (seek_bar.getProgress() + 1));
        }
        else {
            seek_bar = findViewById(R.id.seekBar);
            quantity = findViewById(R.id.quantity);
            quantity.setText("כמות :" + " " + (seek_bar.getProgress() + 1));
        }

//        RadioGroup radioGroup = findViewById(R.id.radioGroup);
//        RadioButton small_hamburger = findViewById(R.id.Small_Hamburger);
//        RadioButton medium_hamburger = findViewById(R.id.Medium_Hamburger);
//        RadioButton big_hamburger = findViewById(R.id.Big_Hamburger);
//        CheckBox cb1 = findViewById(R.id.Fried_Egg);
//        CheckBox cb2 = findViewById(R.id.Fried_Onion);
//        CheckBox cb3 = findViewById(R.id.Chili_Pineapple);

        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @SuppressLint("CutPasteId")
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        if (Locale.getDefault().getLanguage().equals("en"))
                        {
                        quantity.setText("Quantity :" + " " + (seek_bar.getProgress()+1));
                       // Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
                        @SuppressLint("CutPasteId") TextView textview = findViewById(R.id.total_price);
                        total = findViewById(R.id.total_price);
                        int temp = rem_price;
                        temp = rem_price*(seek_bar.getProgress()+1);
                        String str = (getString(R.string.total_price2) + " " + temp + "$");
                        total.setText(str);
                        }

                        else
                        {
                            quantity.setText("כמות :" + " " + (seek_bar.getProgress()+1));
                            // Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
                            @SuppressLint("CutPasteId") TextView textview = findViewById(R.id.total_price);
                            total = findViewById(R.id.total_price);
                            int temp2 = rem_price2;
                            temp2 = rem_price2*(seek_bar.getProgress()+1);
                            String str2 = (getString(R.string.total_price2) + " " + "₪" + temp2);
                            total.setText(str2);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                       // Toast.makeText(MainActivity.this, "SeekBar in StartTracking", Toast.LENGTH_LONG).show();
                    }


                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        if (Locale.getDefault().getLanguage().equals("en"))

                        {

                            quantity.setText("Quantity :" + " " + (seek_bar.getProgress()+1));

                            // Toast.makeText(MainActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                        }

                        else {
                            quantity.setText("כמות :" + " " + (seek_bar.getProgress() + 1));

                            // Toast.makeText(MainActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }
}