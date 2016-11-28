package jonathancaryl.org.materialdrawertinttest;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class MainActivity extends AppCompatActivity {
    protected static final int A = 1;
    protected static final int B = 2;
    protected static final int C = 3;
    protected static final int D = 4;
    Drawer result;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        Resources.Theme theme = getTheme();
        Drawable android1
                = VectorDrawableCompat.create(res, R.drawable.ic_android_black_24dp, theme);
        Drawable android2 = VectorDrawableCompat.create(res, R.drawable.ic_android_black_24dp, theme);
        Drawable android3 = VectorDrawableCompat.create(res, R.drawable.ic_android_black_24dp, theme);
        Drawable android4 = VectorDrawableCompat.create(res, R.drawable.ic_android_black_24dp, theme);

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withIdentifier(A)
                                .withName(R.string.drawer_a)
                                .withIconTintingEnabled(true)
                                .withIconColorRes(R.color.tint)
                                .withIcon(android1),
                        new PrimaryDrawerItem()
                                .withIdentifier(B)
                                .withName(R.string.drawer_b)
                                .withIconTintingEnabled(true)
                                .withIconColorRes(R.color.tint)
                                .withIcon(android2),
                        new PrimaryDrawerItem()
                                .withIdentifier(C)
                                .withName(R.string.drawer_c)
                                .withIconTintingEnabled(true)
                                .withIconColorRes(R.color.tint)
                                .withIcon(android3),
                        new PrimaryDrawerItem()
                                .withIdentifier(D)
                                .withName(R.string.drawer_d)
                                .withIconTintingEnabled(true)
                                .withIconColorRes(R.color.tint)
                                .withIcon(android4))
                .build();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.openDrawer();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        result.setSelection(A);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                result.setSelection(B);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        result.setSelection(C);
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                result.setSelection(D);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);

                            }
                        }, 1000);
                    }
                }, 1000);
            }
        });
    }
}
