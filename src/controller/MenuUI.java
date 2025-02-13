package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import util.Tool;
import util.myClock;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
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
	public MenuUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(146, 140, 118));
		panel.setBounds(39, 10, 354, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcome = new JLabel("New label");
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setBounds(21, 10, 164, 36);
		panel.add(welcome);
				
		Member member=(Member)Tool.read("member.txt");
		welcome.setText("歡迎光臨 "+ member.getName()+member.getId());
		
		JLabel clock_label = new JLabel("New label");
		clock_label.setBounds(224, 31, 93, 15);
		panel.add(clock_label);
		myClock clock = new myClock(clock_label);
		clock.start();
		
		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoAddOrderUI();
				dispose();
			}
		});
		btnNewButton.setBounds(39, 104, 85, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("管理訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoOrderListUI();
				dispose();
			}
		});
		btnNewButton_1.setBounds(222, 104, 85, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("新增會員");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoAddMemberUI();
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(127, 104, 85, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("關閉程式");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_1.setBounds(308, 104, 85, 48);
		contentPane.add(btnNewButton_1_1_1);
	}
}
