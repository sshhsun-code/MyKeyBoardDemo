package com.demo.baidu.sunqi13.mykeyboarddemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText edittext1;
    PopupKeyboardUtil smallKeyboardUtil;
    private View viewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //local_branch push tests

        // local branch push test 2
        // local branch push test 2
        // local_branch conflit test
        // this is local_branch
        // this is local_branch

        //冲突测试 2 from main branch

        //confit test2 from local_branch
        edittext1 = (EditText) findViewById(R.id.edittext1);

        smallKeyboardUtil = new PopupKeyboardUtil(self());
        smallKeyboardUtil.attachTo(edittext1, false);
        //smallKeyboardUtil.setAutoShowOnFocs(false);
    }

    public void onClickView(View view) {
        if (view.getId() == R.id.btn1)
            smallKeyboardUtil.showSoftKeyboard();
        if (view.getId() == R.id.btn2)
            smallKeyboardUtil.hideSoftKeyboard();

    }

    private Activity self() {
        return this;
    }
}
