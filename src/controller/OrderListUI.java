package controller;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.RoomDaoImpl;
import model.Member;
import model.Order;
import model.Room;
import service.impl.OrderServiceImpl;
import service.impl.RoomServiceImpl;
import util.Tool;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class OrderListUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderListUI frame = new OrderListUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderListUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 61);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 101, 416, 152);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 194, 97);
		panel_1.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(223, 9, 170, 67);
		panel_1.add(scrollPane_1);
		
		JTextArea output = new JTextArea();
		scrollPane_1.setViewportView(output);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = list.getSelectedIndex();
				if( idx == -1 ) {
					return;
				}
				String text = (String) list.getSelectedValue();
				// orderId:3:member:2:root:2:金額:2000
				output.setText(output.getText()+"\n"+text);
				String[] value_list = text.split(":");
		
				int order_id = Integer.parseInt(value_list[1]);
				int member_id = Integer.parseInt(value_list[3]);
				int room_id = Integer.parseInt(value_list[5]);
				
				List<Room> room = new RoomDaoImpl().selectById(room_id);
			    String room_name = room.get(0).getName();
			    
				int price = Integer.parseInt(value_list[7]);
				String msg = "您所選擇的包廂是"+ room_name + "字號,消費金額為 "+ price;
				output.setText(msg);
			}
		});
		scrollPane.setViewportView(list);

		Member member=(Member)Tool.read("member.txt");
		List<Order> allorder = new OrderServiceImpl().selectOrderByMember(member);
		Tool.initOrderList(list, allorder);
		
		JLabel lblNewLabel = new JLabel("我的訂單");
		lblNewLabel.setBounds(10, 10, 103, 25);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("刪除訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = list.getSelectedIndex();
				if( idx == -1 ) {
					output.setText("請選擇訂單");
					return;
				}
				String text = (String) list.getSelectedValue();
				// orderId:3:member:2:root:2:金額:2000
				output.setText(output.getText()+"\n"+text);
				String[] value_list = text.split(":");
		
				int order_id = Integer.parseInt(value_list[1]);
				int member_id = Integer.parseInt(value_list[3]);
				int room_id = Integer.parseInt(value_list[5]);
				
				List<Room> room = new RoomDaoImpl().selectById(room_id);
			    String room_name = room.get(0).getName();
			    
				int price = Integer.parseInt(value_list[7]);
				
				String msg = "您所選擇的包廂是"+ room_name + "字號\n消費金額為 "+ price+",正在刪除...\n";
				output.setText(msg);
				
				new OrderServiceImpl().deleteOrder(order_id);

				msg = "刪除完畢, refresh...";
				output.setText(output.getText()+msg);

				List<Order> allorder = new OrderServiceImpl().selectOrderByMember(member);
				Tool.initOrderList(list, allorder);
			}
		});
		btnNewButton.setBounds(239, 86, 85, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回主功能表");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoMenuUI();
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(239, 119, 111, 23);
		panel_1.add(btnNewButton_1);
		
		
		
		
	}
}
