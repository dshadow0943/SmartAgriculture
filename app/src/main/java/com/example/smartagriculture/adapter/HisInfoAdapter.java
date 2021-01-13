package com.example.smartagriculture.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.HisDataItemEntity;
import com.example.smartagriculture.entity.MapEntity;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.utils.EntityToMap;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class HisInfoAdapter extends RecyclerView.Adapter<HisInfoAdapter.HolderView> {

    private final Context context;
    private List<HisDataItemEntity> dataList;
    private final AdapterListener<View> listener;

    public HisInfoAdapter(Context context, List<HisDataItemEntity> dataList, AdapterListener<View> listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_his_info, parent, false);
        return new HisInfoAdapter.HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        holder.setData(dataList.get(position), 12);
        holder.drawTheChartByMPAndroid();

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(HisDataItemEntity item, int position){
        dataList.add(position, item);
        notifyItemInserted(position);
        Log.e("TAG", "his-adapter-addData: " + getItemCount());
    }

    public void addData(HisDataItemEntity item){
        dataList.add(item);
        notifyItemInserted(dataList.size());
        Log.e("TAG", "his-adapter-addData: " + getItemCount());
    }

    public void removeData(int position){
        dataList.remove(position);
        notifyItemRemoved(position);


    }

    public class HolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LineChart mChart;
        private HisDataItemEntity dataList;
        List<MapEntity<Float, String>> list;
        private int intervalSize = 24;

        public HolderView(@NonNull View view) {
            super(view);
            mChart = view.findViewById(R.id.info_mp_chart);
            view.findViewById(R.id.info_time_1).setOnClickListener(this);
            view.findViewById(R.id.info_time_6).setOnClickListener(this);
            view.findViewById(R.id.info_time_12).setOnClickListener(this);
            view.findViewById(R.id.info_time_24).setOnClickListener(this);

            ((RadioButton)view.findViewById(R.id.info_time_12)).setChecked(true);

        }

        public void setData(HisDataItemEntity dataList, int intervalSize){
            this.dataList = dataList;
            this.intervalSize = intervalSize;
            list = EntityToMap.hisDataToMap(dataList.getHisData(), intervalSize);
        }

        public void drawTheChartByMPAndroid() {
            LineData lineData = getLineData();
            showChart(mChart, lineData, Color.WHITE);
        }

        private void showChart(LineChart lineChart, LineData lineData, int color) {
            lineChart.setDrawBorders(false); //在折线图上添加边框
            lineChart.setDescription(""); //数据描述
            lineChart.setNoDataTextDescription("暂无数据");

            lineChart.setDrawGridBackground(false); //表格颜色
            lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); //表格的颜色，设置一个透明度

            lineChart.setTouchEnabled(true); //可点击

            lineChart.setDragEnabled(true);  //可拖拽
            lineChart.setScaleEnabled(true);  //可缩放

            lineChart.setPinchZoom(false);

            lineChart.setBackgroundColor(color); //设置背景颜色

            lineChart.setData(lineData);  //填充数据

            Legend mLegend = lineChart.getLegend(); //设置标示，就是那个一组y的value的

            mLegend.setForm(Legend.LegendForm.CIRCLE); //样式
            mLegend.setFormSize(6f); //字体
            mLegend.setTextColor(Color.BLACK); //颜色

            lineChart.setVisibleXRange(0, 20);   //x轴可显示的坐标范围
            XAxis xAxis = lineChart.getXAxis();  //x轴的标示
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x轴位置
            xAxis.setTextColor(Color.BLACK);    //字体的颜色
            xAxis.setTextSize(10f); //字体大小
            xAxis.setGridColor(Color.BLACK);//网格线颜色
//            xAxis.setDrawGridLines(true); //不显示网格线

            YAxis axisLeft = lineChart.getAxisLeft(); //y轴左边标示
//            YAxis axisRight = lineChart.getAxisRight(); //y轴右边标示
            axisLeft.setTextColor(Color.BLACK); //字体颜色
            axisLeft.setTextSize(10f); //字体大小
//            axisLeft.setAxisMaxValue(list.get(0).getKey()+50); //最大值
//            axisLeft.setLabelCount(6, true); //显示格数
            axisLeft.setGridColor(Color.BLACK); //网格线颜色
//
//            axisRight.setDrawAxisLine(false);
//            axisRight.setDrawGridLines(false);
//            axisRight.setDrawLabels(false);

            lineChart.animateX(100);  //立即执行动画
        }

        private LineData getLineData() {
            int span = list.size()/20;
            ArrayList<String> xValues = new ArrayList<String>();
            for (int i = 0; i < list.size(); i += span) {
                // x轴显示的数据，这里默认使用数字下标显示
                xValues.add(list.get(i).getValue());
            }

            // y轴的数据
            ArrayList<Entry> yValues = new ArrayList<>();
            for (int i = 0; i < list.size(); i += span) {
                yValues.add(new Entry(list.get(i).getKey(), i));
            }
            // create a dataset and give it a type
            // y轴的数据集合
            LineDataSet lineDataSet = new LineDataSet(yValues, dataList.getTitle()+" ("+dataList.getUnit()+")");
            // mLineDataSet.setFillAlpha(110);
            // mLineDataSet.setFillColor(Color.RED);

            //用y轴的集合来设置参数
            lineDataSet.setLineWidth(1.75f); // 线宽
            lineDataSet.setCircleSize(3f);// 显示的圆形大小
            lineDataSet.setColor(Color.BLACK);// 显示颜色
            lineDataSet.setCircleColor(Color.BLACK);// 圆形的颜色
            lineDataSet.setHighLightColor(Color.BLUE); // 高亮的线的颜色
            lineDataSet.setHighlightEnabled(true);
            lineDataSet.setValueTextColor(Color.RED); //数值显示的颜色
            lineDataSet.setValueTextSize(8f);     //数值显示的大小

            ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
            lineDataSets.add(lineDataSet); // 添加数据集合

            //创建lineData
            LineData lineData = new LineData(xValues, lineDataSets);
            return lineData;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.info_time_1: setData(dataList, 1);
                    break;
                case R.id.info_time_6: setData(dataList, 6);
                    break;
                case R.id.info_time_12: setData(dataList, 12);
                    break;
                case R.id.info_time_24: setData(dataList, 24);
                    break;
            }
            drawTheChartByMPAndroid();
        }
    }
}
