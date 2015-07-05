package com.sdf.ezsgws;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 *
 * @author itsdf
 * @since 2015.7.5
 *
 */
public class MainActivity extends Activity {

	final List<MenuItem> datas = new ArrayList<MenuItem>();

	private GridView mGvMenu;

	private MenuAdapter mMenuAdapter;

	/**
	 * 功能列表菜单项
	 *
	 * @author itsdf
	 * @since 2015.7.5
	 *
	 */
	abstract class MenuItem {
		public MenuItem(int textId, int imageId) {
			this.drawableId = imageId;
			this.textId = textId;
		}

		/**
		 * MenuItem点击事件
		 */
		public abstract void onItemClick();

		int textId;

		int drawableId;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initMenuItem();
	}

	/** 初始化页面的菜单列表 */
	private void initMenuItem() {
		mGvMenu = (GridView) findViewById(R.id.gv_home_items_id);
		datas.add(new MenuItem(R.string.tx_item_figure, R.drawable.ic_launcher) {

			@Override
			public void onItemClick() {
			}
		});
		datas.add(new MenuItem(R.string.tx_item_prop, R.drawable.ic_launcher) {

			@Override
			public void onItemClick() {
			}
		});
		datas.add(new MenuItem(R.string.tx_item_equip, R.drawable.ic_launcher) {

			@Override
			public void onItemClick() {
			}
		});
		datas.add(new MenuItem(R.string.tx_item_bug, R.drawable.ic_launcher) {

			@Override
			public void onItemClick() {
			}
		});
		datas.add(new MenuItem(R.string.tx_item_author, R.drawable.ic_launcher) {

			@Override
			public void onItemClick() {
			}
		});
		mMenuAdapter = new MenuAdapter(this, datas);
		mGvMenu.setAdapter(mMenuAdapter);
		mGvMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d("sdf", "[MainActivity] initMenuItem : setOnItemClickListener position = " + position);
				datas.get(position).onItemClick();
			}
		});
	}

	/**
	 * 设置TextView需要有上方的图标
	 *
	 * @param tv
	 * @param drawableID
	 */
	private void setTextDrawableTop(TextView tv, int drawableID) {
		Drawable drawable;
		drawable = getResources().getDrawable(drawableID);
		// 调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		tv.setCompoundDrawables(null, drawable, null, null); // 设置左图标
		int padding = (int) getResources().getDimension(R.dimen.textview_top_drawable_padding);
		tv.setCompoundDrawablePadding(padding);// 设置图片和text之间的间距
	}

	/**
	 * 菜单适配器：GridView
	 *
	 * @author itsdf
	 *
	 */
	private class MenuAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private List<MenuItem> datas;
		private Context mContext;

		public MenuAdapter(Context context, List<MenuItem> datas) {
			this.datas = datas;
			this.mContext = context;
			mInflater = LayoutInflater.from(mContext);
		}

		@Override
		public int getCount() {
			if (datas != null) {
				return datas.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int index) {
			if (datas != null && datas.size() > index) {
				return datas.get(index);
			}
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.item_home_menu, null);
				holder = new ViewHolder();
				holder.text = (TextView) convertView.findViewById(R.id.item_text);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			final MenuItem item = datas.get(position);
			holder.text.setText(item.textId);
			setTextDrawableTop(holder.text, item.drawableId);
			return convertView;
		}

		class ViewHolder {
			TextView text;
		}
	}
}
