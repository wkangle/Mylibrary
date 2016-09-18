package com.kangle.library.subActivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kangle.library.R;

import java.util.ArrayList;
import java.util.List;

import kangle.pullloadview.PullCallback;
import kangle.pullloadview.PullToLoadView;


/**
 * 下拉刷新，上拉无限加载的RecycView
 */
public class A04Activity extends BaseActivity {
    private PullToLoadView mPullToLoadView;
    private SimpleAdapter mAdapter;
    private boolean isLoading = false;
    private boolean isHasLoadedAll = false;
    private int nextPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a04);
        mPullToLoadView = (PullToLoadView) findViewById(R.id.pullToLoadView);
        RecyclerView mRecyclerView = mPullToLoadView.getRecyclerView();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new SimpleAdapter();
        mAdapter.setOnItemClickLitener(new SimpleAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(A04Activity.this,mAdapter.getItemDetaByPosition(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mPullToLoadView.isLoadMoreEnabled(true);
        mPullToLoadView.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {
                loadData(nextPage);
            }

            @Override
            public void onRefresh() {
                mAdapter.clear();
                isHasLoadedAll = false;
                loadData(1);
            }

            @Override
            public boolean isLoading() {
                Log.e("main activity", "main isLoading:" + isLoading);
                return isLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return isHasLoadedAll;
            }
        });

        mPullToLoadView.initLoad();

    }


    private void loadData(final int page) {
        isLoading = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isHasLoadedAll) {
                    Toast.makeText(A04Activity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
                if (page > 10) {
                    isHasLoadedAll = true;
                    return;
                }
                for (int i = 0; i <= 30; i++) {
                    mAdapter.add("page:" + page + "-----item :" + i);
                }
                mPullToLoadView.setComplete();
                isLoading = false;
                nextPage = page + 1;
            }
        }, 1500);
    }

    private static class SimpleAdapter extends RecyclerView.Adapter<CellHolder> {
        /**
         * 条目点击监听接口
         */
        public interface OnItemClickLitener {
            void onItemClick(View view, int position);
            void onItemLongClick(View view, int position);
        }
        private OnItemClickLitener mOnItemClickLitener = null;
        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }


        private List<String> mList;

        public SimpleAdapter() {
            mList = new ArrayList<>();
        }

        @Override
        public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_simple_pullto_load_view, viewGroup, false);
            return new CellHolder(view);
        }

        @Override
        public void onBindViewHolder(final CellHolder holder, int i) {
            holder.text.setText(mList.get(i));
            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }


        }


        /**
         * 新增数据
         * @param s
         */
        public void add(String s) {
            mList.add(s);
            notifyDataSetChanged();
        }
        /**
         * 获取某一条目的数据
         * @param position
         * @return
         */
        public String getItemDetaByPosition(int position){
          return   mList.get(position);
        }


        /**
         * 清除数据
         */
        public void clear() {
            mList.clear();
            notifyDataSetChanged();
        }

        /**
         * 获取数据个数
         * @return
         */
        @Override
        public int getItemCount() {
            return mList.size();
        }

    }

    private static class CellHolder extends RecyclerView.ViewHolder {
        TextView text;
        public CellHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
