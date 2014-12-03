android-sdk
===========

Android SDK for MoreGamers.com.

Installation
============

Merge the src folder of this repo into the src folder of your game.

Make sure your AndroidManifest.xml file includes the Internet permission.

    <uses-permission android:name="android.permission.INTERNET" />

You have two options for integrating MoreGamers into your game.  

Method 1
========

Add the following code to your layout xml file.  Replace XX with your game ID.

    <com.moregamers.MoreGamersView
        android:id="@+id/moregamers"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        game="XX" />

Method 2
========

If your game does not use native UI layouts, you will need to use this method to display a banner on your screen.

1. You will need to import the MoreGamers class into any file that uses it.

    
    import com.moregamers.MoreGamers;
    

2. In the onCreate function of your Primary activity, initialize MoreGamers, where XX is your game id

    
    MoreGamers.init(this, XX);
    

This must be at the END of your onCreate function.  It will create an AbsoluteLayout and stack it on top of your other Views.

3. Display a banner 

    
    MoreGamers.banner(x, y, width, height);
    

4. Hide the banner

    
    MoreGamers.hide();
    
