package hit.gever.myhamburgerorder;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import com.hsalf.smilerating.SmileRating;

import java.util.Locale;

import static com.hsalf.smilerating.BaseRating.BAD;
import static com.hsalf.smilerating.BaseRating.GOOD;
import static com.hsalf.smilerating.BaseRating.GREAT;
import static com.hsalf.smilerating.BaseRating.OKAY;
import static com.hsalf.smilerating.BaseRating.TERRIBLE;


public class LeaveFeedbackActivity extends AppCompatActivity {

    String condition ;
    Button report;

    Spinner spinner;
    ArrayAdapter <CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_feedback);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        report = findViewById(R.id.reporting);
        report.setEnabled(false);

        report.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);


                if (spinner.getSelectedItem().toString().equals("Choose Answer") || condition == null) {
                }
                else {
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"your mail"});
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Report");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "Your satisfaction is :" + " " + condition + "\n" + "Will you order from us again ?" + " " + spinner.getSelectedItem().toString());
                        emailIntent.setType("message/rfc822");
                        startActivity(Intent.createChooser(emailIntent, "Choose email client..."));
                    } else {
                        if (spinner.getSelectedItem().toString().equals("בחר תשובה") || condition == null) {
                        } else {
                            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"your mail"});
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "דו''ח");
                            emailIntent.putExtra(Intent.EXTRA_TEXT, "שביעות הרצון היא :" + " " + condition + "\n" + "האם תזמין אצלנו שוב ?" + " " + spinner.getSelectedItem().toString());
                            emailIntent.setType("message/rfc822");
                            startActivity(Intent.createChooser(emailIntent, "Choose email client..."));
                        }
                    }
                }
            }
        });


        spinner = findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.Options,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Yes")) {
                    Toast.makeText(getBaseContext(),"Selected :" + " " + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }
                else if (parent.getItemAtPosition(position).equals("No")) {
                    Toast.makeText(getBaseContext(),"Selected :" + " " +parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }

                if(parent.getItemAtPosition(position).equals("כן")) {
                    Toast.makeText(getBaseContext(), "נבחר :" + " " + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }
                else if (parent.getItemAtPosition(position).equals("לא")) {
                    Toast.makeText(getBaseContext(),  "נבחר :" + " " + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                }

                if((!parent.getItemAtPosition(position).equals("Choose Answer") && !parent.getItemAtPosition(position).equals("בחר תשובה")))
                {
                    if( condition != null)
                        report.setEnabled(true);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });

        SmileRating smileRating = findViewById(R.id.smile_rating);

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @SuppressLint("SwitchIntDef")
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    switch (smiley) {
                        case BAD:
                            Toast.makeText(LeaveFeedbackActivity.this, "BAD", Toast.LENGTH_LONG).show();
                            condition = "Bad";
                            break;
                        case GOOD:
                            Toast.makeText(LeaveFeedbackActivity.this, "GOOD", Toast.LENGTH_LONG).show();
                            condition = "Good";
                            break;
                        case GREAT:
                            Toast.makeText(LeaveFeedbackActivity.this, "GREAT", Toast.LENGTH_LONG).show();
                            condition = "Great";
                            break;
                        case OKAY:
                            Toast.makeText(LeaveFeedbackActivity.this, "OKAY", Toast.LENGTH_LONG).show();
                            condition = "Okay";
                            break;
                        case TERRIBLE:
                            condition = "Terrible";
                            Toast.makeText(LeaveFeedbackActivity.this, "TERRIBLE", Toast.LENGTH_LONG).show();
                            break;
                    }
                } else {
                    switch (smiley) {
                        case BAD:
                            Toast.makeText(LeaveFeedbackActivity.this, "רע", Toast.LENGTH_LONG).show();
                            condition = "רע";
                            break;
                        case GOOD:
                            Toast.makeText(LeaveFeedbackActivity.this, "טוב", Toast.LENGTH_LONG).show();
                            condition = "טוב";
                            break;
                        case GREAT:
                            Toast.makeText(LeaveFeedbackActivity.this, "נהדר", Toast.LENGTH_LONG).show();
                            condition = "נהדר";
                            break;
                        case OKAY:
                            Toast.makeText(LeaveFeedbackActivity.this, "בסדר", Toast.LENGTH_LONG).show();
                            condition = "בסדר";
                            break;
                        case TERRIBLE:
                            condition = "נורא";
                            Toast.makeText(LeaveFeedbackActivity.this, "נורא", Toast.LENGTH_LONG).show();
                            break;
                    }

                    if(!spinner.getSelectedItem().toString().equals("Choose Answer") && !spinner.getSelectedItem().toString().equals("בחר תשובה"))
                    {
                        report.setEnabled(true);
                    }

                }
            }
        });

        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                if (Locale.getDefault().getLanguage().equals("en")) {
                    Toast.makeText(LeaveFeedbackActivity.this, "Selected : Rating " + " " + level, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(LeaveFeedbackActivity.this, "נבחר : דירוג" + " " + level, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
