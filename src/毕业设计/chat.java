package 毕业设计;

import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;
 class chat{
 
	public static void showChart(String c,double a,double b){
System.out.println("1");
String title="图表统计结果";
DefaultPieDataset piedata = new DefaultPieDataset();
piedata.setValue("select:"+a+"%",a);
piedata.setValue("The rest:"+b+"%",b);
//piedata.setValue("初级职称及其他",33.4);
JFreeChart chart =ChartFactory.createPieChart(title,piedata,true,true,true);
chart.setTitle(new TextTitle(title,new Font("宋体",Font.ITALIC,25)));
chart.addSubtitle(new TextTitle(c,new Font("宋体",Font.ITALIC,20)));
chart.setBackgroundPaint(Color.white);
try{
ChartUtilities.saveChartAsJPEG(new File("D:\\PieChart.jpg"),chart,600,600);

JFrame jf =new JFrame("图表绘制");


JButton button=new JButton("ds");
ImageIcon bg = new ImageIcon("D:\\PieChart.jpg"); 
JLabel label = new JLabel(bg);
System.out.println(bg.getIconHeight());
System.out.println(bg.getIconWidth());
jf.setSize(bg.getIconHeight()+20, bg.getIconWidth()+80);
//label.setSize(new Dimension(800, 800));
label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());

jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
JPanel jp=(JPanel)jf.getContentPane(); jp.setOpaque(false);

JLabel bq=new JLabel(c+"在规定范围的数据记录占比："+a+"%");
JPanel panel=new JPanel(); 
JPanel mb=new JPanel();
mb.add(bq);
panel.setOpaque(false);
panel.setLayout(null);
button.setSize(300, 300); 
button.setLocation(100, 50);  
//panel.add(button);  
jf.add(panel);
jf.add(mb,"South");
jf.setVisible(true);
jf.setResizable(false);
System.out.println("11");
} catch (IOException exz)

{
System.out.print("Can't Creat image File");
}
		
	}
	
	
	public static void showChart2(String c,double a,double b){
System.out.println("柱状图");
		String title="图表统计结果";
		DefaultCategoryDataset piedata = new DefaultCategoryDataset();
		piedata.addValue(a, "select", "select");
		piedata.addValue(b, "the rest", "the rest");
		//piedata.setValue("初级职称及其他",33.4);
		JFreeChart chart =ChartFactory.createBarChart("统计结果", "select:"+a+"%","The rest:"+b+"%", piedata, PlotOrientation.VERTICAL, true, false, false);
		chart.setTitle(new TextTitle(title,new Font("宋体",Font.ITALIC,25)));
		chart.addSubtitle(new TextTitle(c,new Font("宋体",Font.ITALIC,20)));
		chart.setBackgroundPaint(Color.white);
		try{
		ChartUtilities.saveChartAsJPEG(new File("D:\\PieChart1.jpg"),chart,600,600);

		JFrame jf =new JFrame("图表绘制");


		JButton button=new JButton("ds");
		ImageIcon bg = new ImageIcon("D:\\PieChart1.jpg"); 
		JLabel label = new JLabel(bg);
		System.out.println(bg.getIconHeight());
		System.out.println(bg.getIconWidth());
		jf.setSize(bg.getIconHeight()+20, bg.getIconWidth()+80);
		//label.setSize(new Dimension(800, 800));
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());

		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)jf.getContentPane(); jp.setOpaque(false);

		JLabel bq=new JLabel(c+"在规定范围的数据记录占比："+a+"%");
		JPanel panel=new JPanel(); 
		JPanel mb=new JPanel();
		mb.add(bq);
		panel.setOpaque(false);
		panel.setLayout(null);
		button.setSize(300, 300); 
		button.setLocation(100, 50);  
		//panel.add(button);  
		jf.add(panel);
		jf.add(mb,"South");
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(200,0);
		System.out.println("11");
		} catch (IOException exz)

		{
		System.out.print("Can't Creat image File");
		}
				
			}
	
	
	
	public static void showChart5(String c,int a,int b,int c1,int d,int e,double first,double sec,double th,double fort,double fif,double six){
		System.out.println("柱状图");
		
		int all=a+b+c1+d+e;
		
		int aa=(a/all)*1000;
		double aaa=aa/100;
		
		int bb=(b/all)*1000;
		double bbb=bb/100;
		
		int cc=(c1/all)*1000;
		double ccc=cc/100;
		
		int dd=(d/all)*1000;
		double ddd=dd/100;
		
		int ee=(e/all)*1000;
		double eee=ee/100;
		
		
		
				String title="图表统计结果";
				DefaultCategoryDataset piedata = new DefaultCategoryDataset();
//				piedata.addValue(aa, "查询的", "1");
//				piedata.addValue(b, "其余", "2");
				System.out.println("tu:"+aaa+","+bbb+","+ccc+","+ddd+","+eee);
				piedata.addValue(a, "1", (int)first+"-"+(int)sec);
				piedata.addValue(b, "2", (int)sec+"-"+(int)th);
				piedata.addValue(c1, "3", (int)th+"-"+(int)fort);
				piedata.addValue(d, "4", (int)fort+"-"+(int)fif);
				piedata.addValue(e, "5", (int)fif+"-"+(int)six);
				
				//piedata.setValue("初级职称及其他",33.4);
				JFreeChart chart =ChartFactory.createBarChart("统计结果", "","The rest:"+b+"%", piedata, PlotOrientation.VERTICAL, true, false, false);
				chart.setTitle(new TextTitle(title,new Font("宋体",Font.ITALIC,25)));
				chart.addSubtitle(new TextTitle(c,new Font("宋体",Font.ITALIC,20)));
				chart.setBackgroundPaint(Color.white);
				try{
				ChartUtilities.saveChartAsJPEG(new File("D:\\PieChart2.jpg"),chart,600,600);

				JFrame jf =new JFrame("图表绘制");


				JButton button=new JButton("ds");
				ImageIcon bg = new ImageIcon("D:\\PieChart2.jpg"); 
				JLabel label = new JLabel(bg);
				System.out.println(bg.getIconHeight());
				System.out.println(bg.getIconWidth());
				jf.setSize(bg.getIconHeight()+20, bg.getIconWidth()+80);
				//label.setSize(new Dimension(800, 800));
				label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());

				jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
				JPanel jp=(JPanel)jf.getContentPane(); jp.setOpaque(false);

				JLabel bq=new JLabel(c+"在各范围的数据记录统计结果");
				JPanel panel=new JPanel(); 
				JPanel mb=new JPanel();
				mb.add(bq);
				panel.setOpaque(false);
				panel.setLayout(null);
				button.setSize(300, 300); 
				button.setLocation(100, 50);  
				//panel.add(button);  
				jf.add(panel);
				jf.add(mb,"South");
				jf.setVisible(true);
				jf.setResizable(false);
				jf.setLocation(500, 0);
				System.out.println("11");
				} catch (IOException exz)

				{
				System.out.print("Can't Creat image File");
				}
						
					}
	
	
	
	

}