package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sdut.opreation.Book;

public class Add {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	//定义字体（类型，风格，字号）
//  Font.PLAIN（普通）
//  Font.BOLD（加粗）
	JLabel id1,name1,nature1,value1,number1,title;
	JButton end,jb1,jb2;
	final JTextField str1 = new JTextField();
	final JTextField str2 = new JTextField();
	final JTextField str3 = new JTextField();
	final JTextField str4 = new JTextField();
	final JTextField str5 = new JTextField();
	public Add()
	{
		f = new Frame("上架商品",600,600);
		f.setSize(600, 600);     //设置窗口的大小
		init();
		f.setVisible(false);
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					deal();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str1.setText("");
				str2.setText("");
				str3.setText("");
				str4.setText("");
				str5.setText("");
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("请输入商品信息",JLabel.CENTER);
		id1 = new JLabel("编号:",JLabel.LEFT);
		name1 = new JLabel("名字:",JLabel.LEFT);
		nature1 = new JLabel("类别:",JLabel.LEFT);
		value1 = new JLabel("价格:",JLabel.LEFT);
		number1 = new JLabel("库存:",JLabel.LEFT);
		title.setFont(fo);
		id1.setFont(fo2);
		name1.setFont(fo2);
		nature1.setFont(fo2);
		value1.setFont(fo2);
		number1.setFont(fo2);
		str1.setFont(fo2);
		str2.setFont(fo2);
		str3.setFont(fo2);
		str4.setFont(fo2);
		str5.setFont(fo2);
		title.setBounds(200, 20, 200, 50);
		id1.setBounds(200,90,50,50);
		name1.setBounds(200,170,50,50);
		nature1.setBounds(200,250,50,50);
		value1.setBounds(200,330,50,50);
		number1.setBounds(200,410,50,50);
		str1.setBounds(250, 90, 150, 50);
		str2.setBounds(250, 170, 150, 50);
		str3.setBounds(250, 250, 150, 50);
		str4.setBounds(250, 330, 150, 50);
		str5.setBounds(250, 410, 150, 50);
		jb1 = new JButton("返回菜单");
		jb2 = new JButton("确认添加");
		end.setBounds(450, 480, 100, 50);
		jb1.setBounds(250, 480, 100, 50);
		jb2.setBounds(50, 480, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				First.f.setVisible(true);
				f.setVisible(false);
				str1.setText("");
				str2.setText("");
				str3.setText("");
				str4.setText("");
				str5.setText("");
			}
		});
		f.add(title);
		f.add(id1);
		f.add(name1);
		f.add(nature1);
		f.add(value1);
		f.add(number1);
		f.add(str1);
		f.add(str2);
		f.add(str3);
		f.add(str4);
		f.add(str5);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		String id,name,nature;
		double value;
		long number;
		if(str1.getText().equals("")||str2.getText().equals("")||str3.getText().equals("")||str4.getText().equals("")||str5.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "请输入正确信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
			return;
		}
		String str;
		str = str4.getText();
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
			{
				JOptionPane.showMessageDialog(null, "请输入正确信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
				return;
			}
		str = str5.getText();
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
			{
				JOptionPane.showMessageDialog(null, "请输入正确信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
				return;
			}
		id = str1.getText();
		name = str2.getText();
		nature = str3.getText();
		value = Double.parseDouble(str4.getText());
		number = Long.parseLong(str5.getText());
		if(f.mo.judge(id))
		{
			JOptionPane.showMessageDialog(null, "请确认编号唯一！", "编号重复",JOptionPane.ERROR_MESSAGE);//报错的消息框
			return;
		}
		Book book = new Book(id,name,nature,value,number);
		f.mo.addBook(book);
		JOptionPane.showMessageDialog(null, "上架成功！","上架商品",JOptionPane.PLAIN_MESSAGE); //普通的消息框 
		First.f.setVisible(true);
		f.setVisible(false);
	}
}
