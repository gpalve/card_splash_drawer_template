package com.focusx.farsaa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private GridLayout cardContainer;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        cardContainer = findViewById(R.id.cardContainer);



        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_about_us:
                    displayAboutUs();
                    return true;
                case R.id.nav_terms:
                    displayTermsAndConditions();
                    return true;
                case R.id.nav_contact_us:
                    displayContactUs();
                    return true;
                case R.id.nav_settings:
                    displaySetting();
                    return true;
                case R.id.nav_share:
                    shareLink();
                    return true;
                // Handle other menu items as needed
                default:
                    return false;
            }
        });

        setupCardViews();
    }

    private void setupCardViews() {
        List<CardData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardData(R.drawable.registered, "Registration"));
        cardDataList.add(new CardData(R.drawable.rupee, "Apply"));
        cardDataList.add(new CardData(R.drawable.checklist, "Prospectus"));
        cardDataList.add(new CardData(R.drawable.profile, "My Account"));

        for (CardData data : cardDataList) {
            CardView cardView = (CardView) getLayoutInflater().inflate(R.layout.card_layout, cardContainer, false);

            ImageView cardImage = cardView.findViewById(R.id.card_image);
            TextView cardText = cardView.findViewById(R.id.card_text);

            cardImage.setImageResource(data.getImageResource());
            cardText.setText(data.getText());

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = 0;
            layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            layoutParams.setMargins(15, 15, 15, 15);
            cardView.setLayoutParams(layoutParams);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Class<?> targetActivity = cardActivityMap.get(data.getText());
                    if (targetActivity != null) {
                        Intent intent = new Intent(MainActivity.this, targetActivity);
                        intent.putExtra("card_name", data.getText());
                        startActivity(intent);
                    }
                }
            });

            cardContainer.addView(cardView);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayAboutUs(){
        // You can create a new activity for displaying "About Us" or use a Dialog or AlertDialog.
        // Let's create a simple AlertDialog for demonstration.

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("About Us");
        builder.setMessage("Affordable housing through the registered developer program \"Faarsa\" is an initiative aimed at addressing the critical issue of housing accessibility for low and middle-income individuals and families. By partnering with registered developers, the program seeks to make quality housing options more affordable and accessible to a broader segment of the population. Through this collaborative effort, potential homebuyers can benefit from reduced costs and streamlined processes, making homeownership a reality for many who might have otherwise been priced out of the market. \"Faarsa\" not only promotes affordability but also ensures that the properties meet established quality and safety standards, giving individuals the confidence to invest in their future without compromising on the quality of their homes.");

        // You can customize the dialog further if needed, such as adding an OK button.
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayTermsAndConditions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Terms and Condition");
        builder.setMessage("Affordable housing through the registered developer program \"Faarsa\" is an initiative aimed at addressing the critical issue of housing accessibility for low and middle-income individuals and families. By partnering with registered developers, the program seeks to make quality housing options more affordable and accessible to a broader segment of the population. Through this collaborative effort, potential homebuyers can benefit from reduced costs and streamlined processes, making homeownership a reality for many who might have otherwise been priced out of the market. \"Faarsa\" not only promotes affordability but also ensures that the properties meet established quality and safety standards, giving individuals the confidence to invest in their future without compromising on the quality of their homes.");

        // You can customize the dialog further if needed, such as adding an OK button.
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayContactUs() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contact Us");
        builder.setMessage("If you have any questions or need assistance, feel free to contact us at APPS.FOCUSX@GMAIL.COM We care about our customers and are available 24/7 to assist you.");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displaySetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Settings");
        builder.setMessage("Feature is coming soon.");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void shareLink() {
        String appLink = "https://play.google.com/store/apps/details?id=com.focusx.stockswala";

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Check out the StocksWala app: " + appLink);

        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }




    // Define a HashMap to map card text to activity classes
    private HashMap<String, Class<?>> cardActivityMap = new HashMap<String, Class<?>>() {{
        put("Registration", Registeration.class);
        put("Apply", Registeration.class);
        put("Prospectus", Registeration.class);
        put("My Account", Registeration.class);

        // Add mappings for other cards as needed
    }};
}
