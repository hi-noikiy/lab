package com.f.testsmali;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ltf
 * @since 16/5/31, 下午3:48
 */
public class MainActivity extends Activity {
    private static final String ID = "111";

    protected String xxxId;
    protected String xxxId2;
    protected String xxxId3;

    public String getId() {
        return "222";
    }

    public String getConstId() {
        return ID;
    }

    public void initXXXId() {
        xxxId = ID;
        xxxId2 = "123123";
        String tmp = ID;
        xxxId3 = tmp;
    }

    public void testLoadPic() {
        byte[] x = file2Array();
    }


    public byte[] file2Array() {
        try {
            FileInputStream in = new FileInputStream("/sdcard/x.jpg");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024 * 12];
            int len = 0;
            while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
            return out.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
//        new File("/sdcard/Android/data/com.f.testsmali/x").mkdirs();
//        Log.e("sig-0", TestInjectPackageManager.getMySig(this, "com.f.testsmali"));
//        Log.e("sig-1", TestInjectPackageManager.getSig(this, "/mnt/shell/emulated/0/Android/data/com.f.testsmali/app-debug.apk"));
//        Log.e("sig-2", TestInjectPackageManager.getSig(this, "/mnt/shell/emulated/0/Android/data/com.f.testsmali/liulishuo.apk"));
    }
}
