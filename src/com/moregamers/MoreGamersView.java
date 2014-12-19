package com.moregamers;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MoreGamersView extends WebView {
	public MoreGamersView(Context context, AttributeSet attrs) {
		super(context, attrs);

		Display d = ((Activity)context).getWindowManager().getDefaultDisplay();
                getSettings().setJavaScriptEnabled(true);
                setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(140 * (d.getWidth() / 525))));
                loadUrl("http://app.moregamers.com/ad/frame?id=" + attrs.getAttributeValue(null, "game") + "&sdk=android");
	}
}
