/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.chart;

import business.Business;
import business.enterprise.Enterprise;
import business.network.Network;
import business.parentnetwork.ParentNetwork;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Skull
 */
public class CityLevelChart {
    
    private Business business;
    private ArrayList<JFreeChart> chartList;
    
    public CityLevelChart(Business business){
        chartList = new ArrayList<JFreeChart>();
        
        this.business = business;
        
        addRevenueBarChart();
        addCustomerPieChart();
    }

    public ArrayList<JFreeChart> getChartList() {
        return chartList;
    }
    
    private void addRevenueBarChart(){
        CategoryDataset dataset = createRevenueBarChartDataset();
        chartList.add(createRevenueBarChart(dataset));
    }
    
    private CategoryDataset createRevenueBarChartDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(ParentNetwork parentNetwork: business.getParentNetworkDirectory().getParentNetworkList()){
            for(Network network: parentNetwork.getNetworkDirectory().getNetworkList()){
                float totalRevenue = 0;
                float totalIncome = 0;
                float totalExpenses = 0;
                for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
                    totalRevenue += enterprise.getOrganizationDirectory().getAccounting().calculateEnterpriseRevenue(1);
                    totalIncome += enterprise.getOrganizationDirectory().getAccounting().calculateEnterpriseIncome();
                    totalExpenses += enterprise.getOrganizationDirectory().getAccounting().calculateEnterpriseExpenses();
                }
                dataset.addValue(totalRevenue, network.getCity(), "Total Revenue");
                dataset.addValue(totalIncome, network.getCity(), "Total Income");
                dataset.addValue(totalExpenses, network.getCity(), "Total Expense");
            }
        }

        return dataset;
    }
    
    private JFreeChart createRevenueBarChart(CategoryDataset dataset){
         JFreeChart barChart = ChartFactory.createBarChart(
         "Revenues by City",           
         "Category",            
         "Value",            
         dataset,          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
         return barChart;
    }
    
    private void addCustomerPieChart(){
        PieDataset dataset = createCustomerPieChartDataset();
        chartList.add(createCustomerPieChart(dataset));
    }
    
    private PieDataset createCustomerPieChartDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(ParentNetwork parentNetwork: business.getParentNetworkDirectory().getParentNetworkList()){
            for(Network network: parentNetwork.getNetworkDirectory().getNetworkList()){
                int totalCustomers = 0;
                for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
                    totalCustomers += enterprise.getCustomerDirectory().getCustomerList().size();
                }
                dataset.setValue(network.getCity(), totalCustomers);
            }
        }
        
        return dataset;
    }
    
    private JFreeChart createCustomerPieChart(PieDataset dataset){
        JFreeChart chart = ChartFactory.createPieChart(      
         "Customers by City",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);
        
        return chart;
    }
}
