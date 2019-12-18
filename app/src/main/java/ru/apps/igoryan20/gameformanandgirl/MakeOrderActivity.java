package ru.apps.igoryan20.gameformanandgirl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

import ru.apps.igoryan20.gameformanandgirl.dummy.DummyContent;

public class MakeOrderActivity extends AppCompatActivity implements DrinkFragment.OnListFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ItemFragment mItemFragment;
    private DrinkFragment mDrinkFragment;
    private ImageButton mImageButton;
    private static ArrayList<String> mOrders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        mImageButton = findViewById(R.id.buy);
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeOrderActivity.this, OrderActivity.class);
                intent.putStringArrayListExtra("Content", mOrders);
                startActivity(intent);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ItemFragment(), "Блюда");
        adapter.addFragment(new DrinkFragment(), "Напитки");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Intent intent = new Intent(MakeOrderActivity.this, NewOrderItemActivity.class);
        intent.putExtra("Content", item.content);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK){
            mOrders.add(data.getStringExtra("Content"));
        }
    }
}
