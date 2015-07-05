package com.sdf.ezsgws.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.Toast;

import com.sdf.ezsgws.R;

/**
 *
 * @author itsdf
 * @since 2015.7.5
 */
public class Tool {
	public static Tool instance;

	public Context mContext;

	public static Tool getTool() {
		if (instance == null) {
			instance = new Tool();
		}
		return instance;
	}

	public void setApplicationContext(Context context) {
		mContext = context;
	}

	public Context getApplicationContext() {
		return mContext;
	}

	/**
	 * 设置TextView需要有上方的图标
	 *
	 * @param tv
	 * @param drawableID
	 */
	public void setTextDrawableTop(TextView tv, int drawableID) {
		Drawable drawable;
		drawable = mContext.getResources().getDrawable(drawableID);
		setTextDrawable(tv, null, drawable, null, null);
		// // 调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
		// drawable.setBounds(0, 0, drawable.getMinimumWidth(),
		// drawable.getMinimumHeight());
		// tv.setCompoundDrawables(null, drawable, null, null); // 设置左图标
		// int padding = (int)
		// mContext.getResources().getDimension(R.dimen.textview_top_drawable_padding);
		// tv.setCompoundDrawablePadding(padding);// 设置图片和text之间的间距
	}

	/**
	 *
	 * @param tv
	 * @param l
	 * @param t
	 * @param r
	 * @param b
	 */
	private void setTextDrawable(TextView tv, Drawable l, Drawable t, Drawable r, Drawable b) {
		Drawable drawable = null;
		if (l != null) {
			drawable = l;
		} else if (t != null) {
			drawable = t;
		} else if (r != null) {
			drawable = r;
		} else if (b != null) {
			drawable = b;
		} else {
			Toast.makeText(mContext, "文本图标设置失败，请检查传入的图片...", Toast.LENGTH_SHORT).show();
			return;
		}
		// 调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		tv.setCompoundDrawables(l, t, r, b); // 设置图标
		int padding = (int) mContext.getResources().getDimension(R.dimen.textview_top_drawable_padding);
		tv.setCompoundDrawablePadding(padding);// 设置图片和text之间的间距
	}

}
