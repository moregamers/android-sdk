package com.moregamers;

import java.lang.System;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.webkit.WebView;
import android.os.Handler;
import android.app.Activity;

public class MoreGamers {
	private static Activity       _context;
	private static AbsoluteLayout _layout;
	private static Handler        _handler;
	private static WebView        _web;

	private static int _id;
	private static int _sw;
	private static int _sh;

	private static long _last = 0;

	public static void init(Activity context, int id) {
		_context = context;
		_id = id;
		_handler = new Handler();

		WindowManager w = _context.getWindowManager();
		Display d = w.getDefaultDisplay();
		_sw = d.getWidth();
		_sh = d.getHeight();

		_layout = new AbsoluteLayout(_context);
		_context.addContentView(_layout, new ViewGroup.LayoutParams(_sw, _sh));
	}

	public static void banner(final int x, final int y, final int width, final int height) {
		_handler.post(new Runnable() {
			@Override public void run() {
				long now = System.currentTimeMillis();

				if(_web == null) {
					_web = new WebView(_context);
					_web.getSettings().setJavaScriptEnabled(true);
					_web.loadUrl("http://app.moregamers.com/ad/frame?id=" + _id);
					_layout.addView(_web);
				}

				_web.setLayoutParams(new AbsoluteLayout.LayoutParams(width, height, x, y));
				_web.setVisibility(View.VISIBLE);

				if(now - _last > 60000) {
					_web.reload();
					_last = now;
				}

			}
		});
	}

	public static void hide() {
		_handler.post(new Runnable() {
			@Override public void run() {
				if(_web != null) _web.setVisibility(View.GONE);
			}
		});
	}
}
