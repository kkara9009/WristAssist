package net.devemperor.wristassist.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.devemperor.wristassist.BuildConfig;
import net.devemperor.wristassist.R;
import net.devemperor.wristassist.util.Util;


public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView aboutText = findViewById(R.id.version_tv);
        aboutText.setText(getString(R.string.wristassist_about, BuildConfig.VERSION_NAME));
        aboutText.setTextSize(16 * Util.getFontMultiplier(this));

        ImageView icon = findViewById(R.id.icon);
        icon.setOnLongClickListener(v -> {
            Toast.makeText(v.getContext(), getSharedPreferences("net.devemperor.wristassist", MODE_PRIVATE)
                    .getString("net.devemperor.wristassist.userid", "null"), Toast.LENGTH_LONG).show();
            return true;
        });
    }
}