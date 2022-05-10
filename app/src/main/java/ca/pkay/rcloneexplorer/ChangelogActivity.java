package ca.pkay.rcloneexplorer;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ca.pkay.rcloneexplorer.util.MarkdownView;

public class ChangelogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelper.applyTheme(this);
        try {
            setContentView(R.layout.activity_changelog);
        } catch (Exception e) {
            MarkdownView.closeOnMissingWebView(this, e);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        MarkdownView markdownView = findViewById(R.id.markdownView);
        markdownView.loadAsset("changelog.md");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
