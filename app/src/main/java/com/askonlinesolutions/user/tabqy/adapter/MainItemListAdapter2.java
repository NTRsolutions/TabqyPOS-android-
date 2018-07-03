package com.askonlinesolutions.user.tabqy.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqy.R;
import com.askonlinesolutions.user.tabqy.model.TestData;

import java.util.List;

public class MainItemListAdapter2 extends RecyclerView.Adapter<MainItemListAdapter2.ProductViewHolder> {
    Activity mContext;
    private List<TestData>testDataList ;
    Listener mListener;


    private Interface_MainItemListAdapter2 click;

    public MainItemListAdapter2(Activity mContext, List<TestData> testDataList, Listener mListener,
                                Interface_MainItemListAdapter2 click) {
        this.mContext = mContext;
        this.testDataList = testDataList;
        this.mListener = mListener;
        this.click = click;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cardview_expandable;
        ConstraintLayout constraintLayout ;
        TextView txtPrice;
        public ProductViewHolder(View itemView) {
            super(itemView);
            cardview_expandable=itemView.findViewById(R.id.cardview_expandable);
            txtPrice = itemView.findViewById(R.id.item_price);
            constraintLayout = itemView.findViewById(R.id.cardview_expandable_view);

            constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);

                    click.method(getAdapterPosition());

                    return true;
                }
            });

        }
    }





    public interface Listener{
        void setEmptyList(boolean visibility);
    }

    @NonNull
    @Override
    public MainItemListAdapter2.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_itemlistmain, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemListAdapter2.ProductViewHolder holder, int position) {

        holder.constraintLayout.setTag(position);
        holder.txtPrice.setText("$ "+position);
       /* holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        holder.constraintLayout.setOnDragListener(new DragListener(mListener));*/
    }


    public List<TestData> getCustomList() {
        return testDataList;
    }

    public void updateCustomList(List<TestData> customList) {
        this.testDataList = customList;
    }

    @Override
    public int getItemCount() {
        return testDataList.size();
    }




   /* public class DragListener implements View.OnDragListener {
        boolean isDropped = false;

        Listener mListener;

        public DragListener(Listener mListener) {
            this.mListener = mListener;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                  //  v.setBackgroundColor(Color.LTGRAY);
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                   // v.setBackgroundColor(Color.YELLOW);
                    break;

                case DragEvent.ACTION_DROP:

                    Toast.makeText(mContext, "droped", Toast.LENGTH_SHORT).show();

                   *//* isDropped = true;
                    int positionSource = -1;
                    int positionTarget = -1;

                    View viewSource = (View) event.getLocalState();

                    if (v.getId() == R.id.cardview_expandable_view || v.getId() == R.id.textEmptyList) {
                        //RecyclerView target = (RecyclerView) v.getParent();
                        RecyclerView target;
                        if (v.getId() == R.id.textEmptyList) {
                            target = (RecyclerView)
                                    v.getRootView().findViewById(R.id.dragged_items);
                        } else {
                            target = (RecyclerView) v.getParent();
                            positionTarget = (int) v.getTag();
                        }

                        RecyclerView source = (RecyclerView) viewSource.getParent();

                        MainItemListAdapter1 adapterSource = (MainItemListAdapter1) source.getAdapter();
                        positionSource = (int) viewSource.getTag();

                        TestData customList = (TestData) adapterSource.getCustomList().get(positionSource);
                        List<TestData> customListSource = adapterSource.getCustomList();

                        customListSource.remove(positionSource);
                        adapterSource.updateCustomList(customListSource);
                        adapterSource.notifyDataSetChanged();

                        MainItemListAdapter1 adapterTarget = (MainItemListAdapter1) target.getAdapter();
                        List<TestData> customListTarget = adapterTarget.getCustomList();
                        if (positionTarget >= 0) {
                            customListTarget.add(positionTarget, customList);
                        } else {
                            customListTarget.add(customList);
                        }
                        adapterTarget.updateCustomList(customListTarget);
                        adapterTarget.notifyDataSetChanged();
                        v.setVisibility(View.VISIBLE);

                        if (source.getId() == R.id.dragged_items
                                && adapterSource.getItemCount() < 1) {
                            mListener.setEmptyList(true);
                        }

                        if (v.getId() == R.id.textEmptyList) {
                            mListener.setEmptyList(false);
                        }
                    }*//*
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    //v.setBackgroundColor(0);
                    break;

                default:
                    break;
            }

            if (!isDropped) {
                View vw = (View) event.getLocalState();
                vw.setVisibility(View.VISIBLE);
            }

            return true;
        }

    }
*/
    public interface Interface_MainItemListAdapter2 {
        public void method(int position);
    }



}
