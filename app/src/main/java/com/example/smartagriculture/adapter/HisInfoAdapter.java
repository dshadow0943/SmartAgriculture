package com.example.smartagriculture.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.HisDataItemEntity;
import com.example.smartagriculture.interfaces.AdapterListener;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        holder.drawTheChart(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
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

    public class HolderView extends RecyclerView.ViewHolder {

        private LinearLayout chartLyt;
        private List<Float> yLists;
        private List<String> xList;
        private HisDataItemEntity dataList;

        public HolderView(@NonNull View view) {
            super(view);
            chartLyt = (LinearLayout) view.findViewById(R.id.info_chart);
        }

        public void drawTheChart(HisDataItemEntity dataList) {

            this.dataList = dataList;

            XYMultipleSeriesRenderer mRenderer = getXYMulSeriesRenderer();

            XYSeriesRenderer renderer = getXYSeriesRenderer();

            mRenderer.addSeriesRenderer(renderer);

            yLists = HisDataToValue(dataList.getHisData());
            xList = HisDataTimeToString(dataList.getHisData());

            XYMultipleSeriesDataset dataset = getDataSet();

            GraphicalView chartView = ChartFactory.getLineChartView(context, dataset, mRenderer);

            chartLyt.addView(chartView, 0);
            //chartLyt.invalidate();
        }

        public XYSeriesRenderer getXYSeriesRenderer() {
            XYSeriesRenderer renderer = new XYSeriesRenderer();
            //设置折线宽度
            renderer.setLineWidth(2);
            //设置折线颜色
            renderer.setColor(Color.GRAY);
            renderer.setDisplayBoundingPoints(true);
            //点的样式
            renderer.setPointStyle(PointStyle.CIRCLE);
            //设置点的大小
            renderer.setPointStrokeWidth(3);
            //设置数值显示的字体大小
            renderer.setChartValuesTextSize(30);
            //显示数值
            renderer.setDisplayChartValues(true);
            return renderer;
        }

        public XYMultipleSeriesDataset getDataSet() {
            XYMultipleSeriesDataset barDataset = new XYMultipleSeriesDataset();
            CategorySeries barSeries = new CategorySeries("2021年");

            for (int i = 0; i < yLists.size(); i++) {
                barSeries.add(yLists.get(i));
            }

            barDataset.addSeries(barSeries.toXYSeries());
            return barDataset;
        }

        public XYMultipleSeriesRenderer getXYMulSeriesRenderer() {
            XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
            renderer.setMarginsColor(Color.argb(0x00, 0xF3, 0xF3, 0xF3));

            // 设置背景颜色
            renderer.setApplyBackgroundColor(true);
            renderer.setBackgroundColor(Color.WHITE);

            //设置Title的内容和大小
            renderer.setChartTitle(dataList.getTitle());
            renderer.setChartTitleTextSize(50);

            //图表与四周的边距
            renderer.setMargins(new int[]{80, 80, 50, 50});

            //设置X,Y轴title的内容和大小
            renderer.setXTitle("日期");
            renderer.setYTitle(dataList.getType() + "(" + dataList.getUnit() + ")");
            renderer.setAxisTitleTextSize(30);
            //renderer.setAxesColor(Color.WHITE);
            renderer.setLabelsColor(Color.BLACK);

            //图例文字的大小
            renderer.setLegendTextSize(20);

            // x、y轴上刻度颜色和大小
            renderer.setXLabelsColor(Color.BLACK);
            renderer.setYLabelsColor(0, Color.BLACK);
            renderer.setLabelsTextSize(20);
            renderer.setYLabelsPadding(30);

            // 设置X轴的最小数字和最大数字，由于我们的数据是从1开始，所以设置为0.5就可以在1之前让出一部分
            // 有兴趣的童鞋可以删除下面两行代码看一下效果
            renderer.setPanEnabled(false, false);

            //显示网格
            renderer.setShowGrid(true);

            //X,Y轴上的数字数量
            renderer.setXLabels(12);
            renderer.setYLabels(10);

            // 设置X轴的最小数字和最大数字
//            renderer.setXAxisMin(1);
//            renderer.setXAxisMax(20);
            // 设置Y轴的最小数字和最大数字
//            renderer.setYAxisMin(0);
//            renderer.setYAxisMax(100);

            // 设置渲染器显示缩放按钮
            renderer.setZoomButtonsVisible(true);
            // 设置渲染器允许放大缩小
            renderer.setZoomEnabled(true);
            // 消除锯齿
            renderer.setAntialiasing(true);

            // 刻度线与X轴坐标文字左侧对齐
            renderer.setXLabelsAlign(Paint.Align.LEFT);
            // Y轴与Y轴坐标文字左对齐
            renderer.setYLabelsAlign(Paint.Align.LEFT);

            // 允许左右拖动,但不允许上下拖动.
            renderer.setPanEnabled(true, false);

            return renderer;
        }
    }

    private List<Float> HisDataToValue(List<HisDataEntity> hisDatas){
        List<Float> list = new ArrayList<>();
        for (HisDataEntity hisData: hisDatas){
            list.add(hisData.getValue());
        }
        return list;
    }

    private List<String> HisDataTimeToString(List<HisDataEntity> hisDatas){
        List<String> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        for (HisDataEntity hisData: hisDatas){
            if (new Date().getTime() - hisData.getcTime().getTime() > 12*60*60*1000){
                break;
            }
            list.add(0, simpleDateFormat.format(hisData.getcTime()));
        }
        return list;
    }

}
