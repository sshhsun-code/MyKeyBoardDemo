package com.demo.baidu.sunqi13.androidime;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import java.util.List;

/**
 * Created by sunqi13 on 2018/12/17.
 */

public class IMEService extends InputMethodService {

    private static final String TAG = IMEService.class.getSimpleName();

    private KeyboardView mKeyboardView;

    private Keyboard mLetterKey;// 字母键盘
    private Keyboard mNumberKey;// 数字键盘

    public boolean mIsNum = false;// 是否数据键盘
    public boolean mIsUpper = false;// 是否大写

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public View onCreateInputView() {
        Log.e(TAG, "onCreateInputView");
        mKeyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);

        mLetterKey = new Keyboard(this, R.xml.qwerty);
        mNumberKey = new Keyboard(this, R.xml.symbols);

        mKeyboardView.setKeyboard(mLetterKey);
        mKeyboardView.setPreviewEnabled(true);
        mKeyboardView.setEnabled(true);
        mKeyboardView.setOnKeyboardActionListener(mKeyBoardActListener);


        return mKeyboardView;
    }

    @Override
    public View onCreateCandidatesView() {
        return super.onCreateCandidatesView();
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);
        Log.e(TAG, "onStartInput");
        InputTypeUtils.dumpFlags(attribute.inputType);
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        super.onStartInputView(info, restarting);
        Log.e(TAG, "onStartInputView");
    }

    @Override
    public void onFinishInput() {
        super.onFinishInput();
        Log.e(TAG, "onFinishInput");
    }

    @Override
    public void onFinishInputView(boolean finishingInput) {
        super.onFinishInputView(finishingInput);
        Log.e(TAG, "onFinishInputView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    /**
     * 键盘大小写切换
     */
    private void changeKey() {
        List<Keyboard.Key> keylist = mLetterKey.getKeys();
        if (mIsUpper) {//大写切换小写
            mIsUpper = false;
            for (Keyboard.Key key : keylist) {
                if (key.label != null && isWord(key.label.toString().toLowerCase())) {
                    key.label = key.label.toString().toLowerCase();
                    key.codes[0] = key.codes[0] + 32;
                }
            }
        } else {//小写切换大写
            mIsUpper = true;
            for (Keyboard.Key key : keylist) {
                if (key.label != null && isWord(key.label.toString().toLowerCase())) {
                    key.label = key.label.toString().toUpperCase();
                    key.codes[0] = key.codes[0] - 32;
                }
            }
        }
    }

    private boolean isWord(String str) {
        String wordStr = "abcdefghijklmnopqrstuvwxyz";
        if (wordStr.indexOf(str.toLowerCase()) > -1) {
            return true;
        }
        return false;
    }

    private KeyboardView.OnKeyboardActionListener mKeyBoardActListener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int i) {

        }

        @Override
        public void onRelease(int i) {

        }

        @Override
        public void onKey(int primaryCode, int[] ints) {
            InputConnection inputConnection = getCurrentInputConnection();

            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    inputConnection.deleteSurroundingText(1, 0);
                    break;
                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));

                    break;
                case Keyboard.KEYCODE_MODE_CHANGE:// 数字键盘切换
                    if (mIsNum) {
                        mIsNum = false;
                        mKeyboardView.setKeyboard(mLetterKey);
                    } else {
                        mIsNum = true;
                        mKeyboardView.setKeyboard(mNumberKey);
                    }
                    break;
                case Keyboard.KEYCODE_SHIFT:// 大小写切换
                    changeKey();
                    mKeyboardView.setKeyboard(mLetterKey);
                    break;
                case 57419:// go left
                    if (inputConnection.getTextBeforeCursor(1, InputConnection.GET_TEXT_WITH_STYLES) != null) {
                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT));
                    }
                    break;
                case 57421:// go right
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT));
                    break;
                default:
                    char code = (char) primaryCode;
                    inputConnection.commitText(String.valueOf(code), 1);
                    break;
            }


        }

        @Override
        public void onText(CharSequence charSequence) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };
}
