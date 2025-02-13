package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Order;
import model.Room;
import service.impl.OrderServiceImpl;
import service.impl.RoomServiceImpl;
import util.Tool;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;

public class AddOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrderUI frame = new AddOrderUI();
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
	public AddOrderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 92, 134, 66);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		List<Room> allroom = new RoomServiceImpl().getAvailable();
		Tool.initRoomList(list, allroom);
		
		JLabel welcome = new JLabel("New label");
		welcome.setBounds(29, 25, 129, 15);
		contentPane.add(welcome);
		Member member=(Member)Tool.read("member.txt");
		welcome.setText("歡迎光臨 "+ member.getName());
		
		JTextArea output = new JTextArea();
		output.setBounds(29, 201, 253, 143);
		contentPane.add(output);
		
		JLabel lblNewLabel = new JLabel("請選擇包廂");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 84, 142, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("確定");  // 訂單確定
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = list.getSelectedIndex();
				if( idx == -1 ) {
					output.setText("請選擇包廂");
					return;
				}
				String text = (String) list.getSelectedValue();
				String[] value_list = text.split(":");
				int room_id = Integer.parseInt(value_list[0]);
				String room_name = value_list[1];
				int price = Integer.parseInt(value_list[3]);
				String msg = "您所選擇的包廂是"+ room_name + "字號,消費金額為 "+ price;
				output.setText(msg);
			}
		});
		btnNewButton.setBounds(329, 95, 85, 23);
		contentPane.add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("回主功能畫面");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoMenuUI();
				dispose();
			}
		});
				btnNewButton_1.setBounds(107, 380, 134, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("列印");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(306, 269, 85, 44);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("結帳");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = list.getSelectedIndex();
				if( idx == -1 ) {
					output.setText("請選擇包廂");
					return;
				}
				String text = (String) list.getSelectedValue();
				String[] value_list = text.split(":");
				int room_id = Integer.parseInt(value_list[0]);
				String room_name = value_list[1];
				int price = Integer.parseInt(value_list[3]);
				
				Member member = (Member) Tool.read("member.txt");
				Order order = new Order(member.getId(), room_id,price);
				
				new OrderServiceImpl().addOrder(order);
				String msg = "\n=====================================\n"
						+ "帳單已完成";
				output.setText(output.getText()+msg);
			}
		});
		btnNewButton_1_1_1.setBounds(306, 203, 85, 44);
		contentPane.add(btnNewButton_1_1_1);
		
		
	}
}
