package jrdcom.com.javademo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by longcheng on 17/3/2.
 */
public class JrdRecyleAdapter extends RecyclerView.Adapter<JrdRecyleAdapter.JrdRecyleViewHolder> {

    private List<JrdListBean> jrdListBeans;
    private Boolean jrdIsSmall;

    public JrdRecyleAdapter(List<JrdListBean> list) {
        jrdListBeans = list;
        jrdIsSmall = true;
    }

    @Override
    public void onBindViewHolder(JrdRecyleViewHolder holder, int position) {
        holder.jrdRecyleImage.setImageResource(jrdListBeans.get(position).getImageId());
        holder.jrdRecyleText.setText(jrdListBeans.get(position).getTitle());
        holder.jrdRecyleSubText.setText(jrdListBeans.get(position).getSubTitle());
    }

    public void setSmall(Boolean isSmall) {
        jrdIsSmall = isSmall;
    }

    @Override
    public int getItemCount() {
        return jrdListBeans.size();
    }

    //创建ViewHolder
    @Override
    public JrdRecyleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View itemView = null;
        if (true == jrdIsSmall) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyler_view_small, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyle_view_, parent, false);
        }

        JrdRecyleViewHolder viewHolder = new JrdRecyleViewHolder(itemView);
        return viewHolder;
    }

    //定义 ViewHolder
    public class JrdRecyleViewHolder extends RecyclerView.ViewHolder {
        private ImageView jrdRecyleImage;
        private TextView jrdRecyleText;
        private TextView jrdRecyleSubText;
        public JrdRecyleViewHolder(View itemView) {
            super(itemView);
            //jrdRecyleImage = (ImageView
            jrdRecyleImage = (ImageView) itemView.findViewById(R.id.list_image);
            jrdRecyleText = (TextView) itemView.findViewById(R.id.list_title);
            jrdRecyleSubText = (TextView) itemView.findViewById(R.id.list_subtitle);
        }
    }

    /**
     * 移动Item
     *
     * @param fromPosition
     * @param toPosition
     */
    public void moveItem(int fromPosition, int toPosition) {
        //做数据的交换
        if (fromPosition < toPosition) {
            for (int index = fromPosition; index < toPosition; index++) {
                Collections.swap(jrdListBeans, index, index + 1);
            }
        } else {
            for (int index = fromPosition; index > toPosition; index--) {
                Collections.swap(jrdListBeans, index, index - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    /**
     * 滑动Item
     *
     * @param position
     */
    public void removeItem(int position) {
        jrdListBeans.remove(position);//删除数据
        notifyItemRemoved(position);
    }
}
