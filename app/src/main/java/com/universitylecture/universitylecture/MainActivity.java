package com.universitylecture.universitylecture;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import static android.view.Window.FEATURE_NO_TITLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 我的讲座的fragment
    private MyLectureFragment myLectureFragment;
    // 讲座列表的fragment
    private LectureListFragment lectureListFragment;
    // 讲座圈的fragment
    private LectureCircleFragment lectureCircleFragment;

    // 底部对应的ImageButton
    private ImageButton myLectureImageButton;
    private ImageButton lectureListImageButton;
    private ImageButton lectureCircleImageButton;


    // fragment管理器
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        fragmentManager = getFragmentManager();

        setTabSelection(0);
    }

    private void initView() {
        myLectureImageButton = (ImageButton) findViewById(R.id.my_lecture_image_button);
        myLectureImageButton.setOnClickListener(this);
        lectureListImageButton = (ImageButton) findViewById(R.id.lecture_list_image_button);
        lectureListImageButton.setOnClickListener(this);
        lectureCircleImageButton = (ImageButton) findViewById(R.id.lecture_circle_image_button);
        lectureCircleImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_lecture_image_button:
                setTabSelection(0);
                break;

            case R.id.lecture_list_image_button:
                setTabSelection(1);
                break;

            case R.id.lecture_circle_image_button:
                setTabSelection(2);
                break;

        }
    }

    private void setTabSelection(int index) {

        // 开启一个fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // 隐藏所有fragment
        hideFragments(transaction);

        switch (index) {
            case 0:
                if (myLectureFragment == null) {
                    myLectureFragment = new MyLectureFragment();
                    transaction.add(R.id.content,  myLectureFragment);
                } else {
                    transaction.show(myLectureFragment);
                }
                break;
            case 1:
                if (lectureListFragment == null) {
                    lectureListFragment = new LectureListFragment();
                    transaction.add(R.id.content, lectureListFragment);
                } else {
                    transaction.show(lectureListFragment);
                }
                break;

            case 2:
                if (lectureCircleFragment == null) {
                    lectureCircleFragment = new LectureCircleFragment();
                    transaction.add(R.id.content, lectureCircleFragment);
                } else {
                    transaction.show(lectureCircleFragment);
                }
                break;
        }

        transaction.commit();

    }

    private void hideFragments(FragmentTransaction transaction) {
        if (myLectureFragment != null)
            transaction.hide(myLectureFragment);
        if (lectureListFragment != null)
            transaction.hide(lectureListFragment);
        if (lectureCircleFragment != null)
            transaction.hide(lectureCircleFragment);
    }


}
