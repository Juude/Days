package net.juude.quotes;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * Created by juude on 16/5/3.
 */
public class RxJavaDemoTest extends AndroidTestCase{
    @SmallTest
    public void testJust() {
        new RxJavaDemo().justDemo();
    }
}
