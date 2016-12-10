/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Skull
 */
public class Chart {
    
    public enum chartType{
        BarChart, XYLineChart, PieChart;
    }
    private chartType type;
    private JFreeChart chart;
    
    public Chart(chartType type, Object o){
        this.type = type;
        if(type.toString().equals("BarChart")){
            CategoryDataset dataset = createBarChartDataset();
            this.chart = createBarChart(dataset);
        }else if(type.toString().equals("XYLineChart")){
            XYDataset dataset = createXYLineDataset();
            this.chart = createXYLineChart(dataset);
        }else if(type.toString().equals("PieChart")){
            PieDataset dataset = createPieChartDataset();
            this.chart = createPieChart(dataset);
        }
        
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setDomainZoomable(true);
//        chartPanel.setVisible(true);
//        jPanel1.add(chartPanel, BorderLayout.CENTER);
    }

    private CategoryDataset createBarChartDataset() {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        dataset.addValue(1.0, fiat, speed);
        dataset.addValue(3.0, fiat, userrating);
        dataset.addValue(5.0, fiat, millage);
        dataset.addValue(5.0, fiat, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, millage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, millage);
        dataset.addValue(6.0, ford, safety);

        return dataset;
    }
    
    private JFreeChart createBarChart(CategoryDataset dataset){
         JFreeChart barChart = ChartFactory.createBarChart(
         "Cars Overview",           
         "Category",            
         "Score",            
         dataset,          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
         return barChart;
    }

    private PieDataset createPieChartDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(20));
        dataset.setValue("SamSung Grand", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia", new Double(10));
        return dataset;
    }
    
    private JFreeChart createPieChart(PieDataset dataset){
        JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);
        
        return chart;
    }

    private XYDataset createXYLineDataset() {
        final XYSeries firefox = new XYSeries("Firefox");
        firefox.add(1.0, 1.0);
        firefox.add(2.0, 4.0);
        firefox.add(3.0, 3.0);
        final XYSeries chrome = new XYSeries("Chrome");
        chrome.add(1.0, 4.0);
        chrome.add(2.0, 5.0);
        chrome.add(3.0, 6.0);
        final XYSeries iexplorer = new XYSeries("InternetExplorer");
        iexplorer.add(3.0, 4.0);
        iexplorer.add(4.0, 5.0);
        iexplorer.add(5.0, 4.0);
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(firefox);
        dataset.addSeries(chrome);
        dataset.addSeries(iexplorer);
        return dataset;
    }
    
    private JFreeChart createXYLineChart(XYDataset dataset){
        JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Series Demo",
                "iterácie",
                "%",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        return chart;
    }

    public JFreeChart getChart() {
        return chart;
    }
}
