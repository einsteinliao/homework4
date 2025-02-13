package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;
import util.myClock;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginid;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 10, 426, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("my system");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(94, 23, 242, 42);
		panel.add(lblNewLabel);
		
		JLabel clock_label = new JLabel("New label");
		clock_label.setBounds(302, 62, 46, 15);
		panel.add(clock_label);
		myClock clock = new myClock(clock_label);
		clock.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(10, 107, 426, 267);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("請輸入loginid 和 password");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 21, 238, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("loginid");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(72, 76, 73, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("password");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(72, 136, 73, 35);
		panel_1.add(lblNewLabel_1_1_1);
		
		loginid = new JTextField();
		loginid.setBounds(170, 83, 96, 21);
		panel_1.add(loginid);
		loginid.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(170, 143, 96, 21);
		panel_1.add(password);
		
		JButton btnLogin = new JButton("login");//============================login button
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Loginid=loginid.getText();
				String Password=password.getText();
				
				Member member=new MemberServiceImpl().Login(Loginid, Password);
				
				if(member != null)
				{
					Tool.save(member, "member.txt");
					Tool.gotoLoginSuccessrUI();
					dispose();
				}
				else
				{
					Tool.gotoLoginErrorUI();
					dispose();
				}
			}
		});
		btnLogin.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnLogin.setBounds(181, 201, 85, 23);
		panel_1.add(btnLogin);
		
		JButton btnRegister = new JButton("註冊");  //================================= register button
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoAddMemberUI();
				dispose();
			}
		});
		btnRegister.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnRegister.setBounds(311, 201, 85, 23);
		panel_1.add(btnRegister);
	}
}
