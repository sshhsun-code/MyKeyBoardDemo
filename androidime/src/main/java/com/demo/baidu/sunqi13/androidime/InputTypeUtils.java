package com.demo.baidu.sunqi13.androidime;

import android.text.InputType;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sunqi13 on 2019/1/11.
 */

public class InputTypeUtils {

    private static final String TAG = IMEService.class.getSimpleName();

    public static void dumpFlags(final int inputType) {
        final int inputClass = inputType & InputType.TYPE_MASK_CLASS;
        final String inputClassString = toInputClassString(inputClass);
        final String variationString2 = toVariationString2(inputType & InputType.TYPE_MASK_CLASS);
        final String variationString = toVariationString(
                inputClass, inputType & InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        final String flagsString = toFlagsString(inputType & InputType.TYPE_MASK_FLAGS);
        Log.i(TAG, "inputType: " + inputType);
        Log.i(TAG, "Input class: " + inputClassString);
        Log.i(TAG, "Variation: " + variationString);
        Log.i(TAG, "Variation2: " + variationString2);
        Log.i(TAG, "Flags: " + flagsString);
    }

    private static String toInputClassString(final int inputClass) {
        switch (inputClass) {
            case InputType.TYPE_CLASS_TEXT:
                return "TYPE_CLASS_TEXT";
            case InputType.TYPE_CLASS_PHONE:
                return "TYPE_CLASS_PHONE";
            case InputType.TYPE_CLASS_NUMBER:
                return "TYPE_CLASS_NUMBER";
            case InputType.TYPE_CLASS_DATETIME:
                return "TYPE_CLASS_DATETIME";
            default:
                return String.format("unknownInputClass<0x%08x>", inputClass);
        }
    }

    private static String toVariationString(final int inputClass, final int variation) {
        switch (inputClass) {
            case InputType.TYPE_CLASS_TEXT:
                return toTextVariationString(variation);
            case InputType.TYPE_CLASS_NUMBER:
                return toNumberVariationString(variation);
            case InputType.TYPE_CLASS_DATETIME:
                return toDatetimeVariationString(variation);
            default:
                return "";
        }
    }

    private static String toVariationString2(final int variation) {
        switch (variation) {
            case InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                return " TYPE_TEXT_VARIATION_EMAIL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT:
                return "TYPE_TEXT_VARIATION_EMAIL_SUBJECT";
            case InputType.TYPE_TEXT_VARIATION_FILTER:
                return "TYPE_TEXT_VARIATION_FILTER";
            case InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE:
                return "TYPE_TEXT_VARIATION_LONG_MESSAGE";
            case InputType.TYPE_TEXT_VARIATION_NORMAL:
                return "TYPE_TEXT_VARIATION_NORMAL";
            case InputType.TYPE_TEXT_VARIATION_PASSWORD:
                return "TYPE_TEXT_VARIATION_PASSWORD";
            case InputType.TYPE_TEXT_VARIATION_PERSON_NAME:
                return "TYPE_TEXT_VARIATION_PERSON_NAME";
            case InputType.TYPE_TEXT_VARIATION_PHONETIC:
                return "TYPE_TEXT_VARIATION_PHONETIC";
            case InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS:
                return "TYPE_TEXT_VARIATION_POSTAL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE:
                return "TYPE_TEXT_VARIATION_SHORT_MESSAGE";
            case InputType.TYPE_TEXT_VARIATION_URI:
                return "TYPE_TEXT_VARIATION_URI";
            case InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:
                return "TYPE_TEXT_VARIATION_VISIBLE_PASSWORD";
            case InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT:
                return "TYPE_TEXT_VARIATION_WEB_EDIT_TEXT";
            case InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS:
                return "TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD:
                return "TYPE_TEXT_VARIATION_WEB_PASSWORD";
            default:
                return String.format("unknownVariation<0x%08x>", variation);
        }
    }

    private static String toTextVariationString(final int variation) {
        switch (variation) {
            case InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                return " TYPE_TEXT_VARIATION_EMAIL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT:
                return "TYPE_TEXT_VARIATION_EMAIL_SUBJECT";
            case InputType.TYPE_TEXT_VARIATION_FILTER:
                return "TYPE_TEXT_VARIATION_FILTER";
            case InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE:
                return "TYPE_TEXT_VARIATION_LONG_MESSAGE";
            case InputType.TYPE_TEXT_VARIATION_NORMAL:
                return "TYPE_TEXT_VARIATION_NORMAL";
            case InputType.TYPE_TEXT_VARIATION_PASSWORD:
                return "TYPE_TEXT_VARIATION_PASSWORD";
            case InputType.TYPE_TEXT_VARIATION_PERSON_NAME:
                return "TYPE_TEXT_VARIATION_PERSON_NAME";
            case InputType.TYPE_TEXT_VARIATION_PHONETIC:
                return "TYPE_TEXT_VARIATION_PHONETIC";
            case InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS:
                return "TYPE_TEXT_VARIATION_POSTAL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE:
                return "TYPE_TEXT_VARIATION_SHORT_MESSAGE";
            case InputType.TYPE_TEXT_VARIATION_URI:
                return "TYPE_TEXT_VARIATION_URI";
            case InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:
                return "TYPE_TEXT_VARIATION_VISIBLE_PASSWORD";
            case InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT:
                return "TYPE_TEXT_VARIATION_WEB_EDIT_TEXT";
            case InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS:
                return "TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS";
            case InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD:
                return "TYPE_TEXT_VARIATION_WEB_PASSWORD";
            default:
                return String.format("unknownVariation<0x%08x>", variation);
        }
    }

    private static String toNumberVariationString(final int variation) {
        switch (variation) {
            case InputType.TYPE_NUMBER_VARIATION_NORMAL:
                return "TYPE_NUMBER_VARIATION_NORMAL";
            case InputType.TYPE_NUMBER_VARIATION_PASSWORD:
                return "TYPE_NUMBER_VARIATION_PASSWORD";
            default:
                return String.format("unknownVariation<0x%08x>", variation);
        }
    }

    private static String toDatetimeVariationString(final int variation) {
        switch (variation) {
            case InputType.TYPE_DATETIME_VARIATION_NORMAL:
                return "TYPE_DATETIME_VARIATION_NORMAL";
            case InputType.TYPE_DATETIME_VARIATION_DATE:
                return "TYPE_DATETIME_VARIATION_DATE";
            case InputType.TYPE_DATETIME_VARIATION_TIME:
                return "TYPE_DATETIME_VARIATION_TIME";
            default:
                return String.format("unknownVariation<0x%08x>", variation);
        }
    }

    private static String toFlagsString(final int flags) {
        final ArrayList<String> flagsArray = new ArrayList<>();
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS))
            flagsArray.add("TYPE_TEXT_FLAG_NO_SUGGESTIONS");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_MULTI_LINE))
            flagsArray.add("TYPE_TEXT_FLAG_MULTI_LINE");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE))
            flagsArray.add("TYPE_TEXT_FLAG_IME_MULTI_LINE");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_CAP_WORDS))
            flagsArray.add("TYPE_TEXT_FLAG_CAP_WORDS");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_CAP_SENTENCES))
            flagsArray.add("TYPE_TEXT_FLAG_CAP_SENTENCES");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS))
            flagsArray.add("TYPE_TEXT_FLAG_CAP_CHARACTERS");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_AUTO_CORRECT))
            flagsArray.add("TYPE_TEXT_FLAG_AUTO_CORRECT");
        if (0 != (flags & InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE))
            flagsArray.add("TYPE_TEXT_FLAG_AUTO_COMPLETE");
        return flagsArray.isEmpty() ? "" : Arrays.toString(flagsArray.toArray());
    }

}
