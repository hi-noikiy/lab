package com.f.testsmali;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;

import java.util.Iterator;

import static android.content.pm.PackageManager.GET_SIGNATURES;

/**
 * @author ltf
 * @since 17/11/25, 上午11:51
 */

public class TestInjectPackageManager {

    public static final byte[] SIGS_TEST = {
            48, -126, 3, 13, 48, -126, 1, -11, -96, 3, 2, 1, 2, 2, 4, 78, -94, 124, 95, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 55, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49,
            16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 65, 110, 100, 114, 111, 105, 100, 49, 22, 48, 20, 6, 3, 85, 4, 3, 19, 13, 65, 110, 100, 114, 111, 105, 100, 32, 68, 101, 98, 117, 103, 48, 30, 23, 13, 49, 51, 48, 55, 49,
            50, 49, 49, 48, 54, 50, 51, 90, 23, 13, 52, 51, 48, 55, 48, 53, 49, 49, 48, 54, 50, 51, 90, 48, 55, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 85, 83, 49, 16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 65,
            110, 100, 114, 111, 105, 100, 49, 22, 48, 20, 6, 3, 85, 4, 3, 19, 13, 65, 110, 100, 114, 111, 105, 100, 32, 68, 101, 98, 117, 103, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3,
            -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -63, -23, -56, -75, -73, -105, -109, 90, 47, -92, -53, -54, 52, 82, 23, 95, -82, 6, -127, 58, -107, 100, -54, -45, 24, 40, -26, 66, -23, 96, -72, 91, 93, 62, -1, -81, 58,
            -64, -51, -57, 112, 83, 123, 125, 31, -86, -65, -116, 104, -24, 69, 109, 110, 50, -60, -49, -2, 3, -119, 0, -83, 117, 112, 23, 10, 76, -71, 8, -93, 53, -70, -105, 91, 78, 71, -85, 47, 71, 3, -41, -118, -93, 92, -87, -73, -29, 94,
            74, 108, -52, -59, -101, 62, -48, -76, -117, 89, -37, 113, -38, -128, -90, -57, -71, -27, 21, 5, -14, 42, -40, -24, -98, -17, -55, 96, -36, -16, -11, -21, -91, 87, 73, 124, -64, 115, 73, 65, 123, 19, 69, -93, 30, -78, 55, 114, 63, 48,
            102, 0, -75, -47, -47, 82, -103, -17, 48, -9, -49, -36, 87, 29, 23, -27, 2, 55, 48, 13, -93, -31, -49, -111, 15, -7, 95, -76, -90, 121, 8, -77, -51, 27, 106, -74, -11, 107, 50, 28, 76, -59, -86, 38, -84, -102, 118, 125, 69, 53,
            20, -35, -60, -8, -54, -76, -18, -48, 91, 40, 55, -100, 54, -54, -26, 53, 32, 56, -100, 106, 92, -117, -40, -34, -70, 79, 72, 70, -59, -122, -34, -44, 78, -95, 0, 91, -30, 52, -53, 77, -101, 57, -18, -80, 124, 4, 106, 48, -43, -55,
            -126, 5, -94, 127, 31, -80, -47, 124, -122, -110, -49, 14, 35, 8, -124, 14, -98, 24, 109, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 40, -111, 120, 103, 127, 32, 67, -119, -25, 62, 67,
            64, -99, -47, 25, -26, -13, 51, 31, 7, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 68, 107, -72, 73, 8, -119, -45, -26, 78, 84, 83, -51, 94, 73, -59, 91, -61, 50, -82, -77, 60,
            -108, 9, 40, -114, 109, 26, 13, 119, -60, -122, 10, 78, -4, 102, -52, -38, 56, -83, 121, 9, -71, 92, -108, 86, -67, 60, -18, 66, -4, -80, -79, -83, 36, 39, -99, -31, 86, -87, -117, 49, -72, 114, -58, -57, -91, -65, -70, 2, 37, 69,
            -9, 85, 24, 69, 57, 42, 89, -41, -112, 83, -6, 11, 54, 76, -127, 19, -108, -104, -69, 23, -61, 123, -113, -77, -117, 81, 8, -37, -117, -39, 29, -38, -74, -119, -24, 115, -27, 79, -57, 107, -64, -78, 90, -16, -10, 55, -38, 78, -5, 107,
            44, -36, -39, 65, -6, 12, 3, 1, 80, 75, -87, 37, -28, -123, -83, -123, -99, 28, -89, -121, 64, 115, -43, 80, -81, -75, 28, -63, -120, 7, -68, -52, -113, -76, 115, -122, -79, -115, 78, -75, -46, -111, -102, 82, -39, -119, -95, -94, -15, -117,
            -96, -118, 35, 98, 90, 54, -93, -46, 67, 11, 36, 7, 2, -16, 110, 37, -103, -90, -38, -91, 45, -14, -85, -88, 96, 125, -25, 117, -18, 95, -39, 91, -65, 40, 93, 13, -104, 118, -17, 1, 21, -61, -98, -74, 99, 101, -122, 59, -8, -111,
            -78, 57, -18, -31, 118, 21, -45, -75, 94, 91, -70, 35, 31, -20, 57, 20, 66, -72, -79, 40, -118, 110, 56, -75, 21, -23, 116, 117, -34, 45, -2, -70, 67, -48, -88};


    public static String getMySig(Context paramContext, String paramString) {
        Signature sig = new Signature(SIGS_TEST);
        Iterator<PackageInfo> it = paramContext.getPackageManager().getInstalledPackages(GET_SIGNATURES).iterator();
        while (it.hasNext()) {
            PackageInfo localPackageInfo = (PackageInfo) it.next();
            if (localPackageInfo.packageName.equals(paramString)) {
                if (sig.equals(localPackageInfo.signatures[0]))
                    System.out.println(" == ");
                else
                    System.out.println(" != ");

                return localPackageInfo.signatures[0].toCharsString();
            }
        }
        return null;
    }

    public static String getSig(Context paramContext, String fn) {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageArchiveInfo(fn, GET_SIGNATURES);


        return localPackageInfo.signatures[0].toCharsString();
    }

}
