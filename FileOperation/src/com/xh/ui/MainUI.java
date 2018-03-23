package com.xh.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpanel;
	private JFileChooser fileChooser;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JList<File> list;
	private JPanel panel;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setTitle("文件操作");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		jpanel = new JPanel();
		contentPane.add(jpanel, BorderLayout.NORTH);
		jpanel.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		textField.setToolTipText("或者手动输入文件夹地址");
		jpanel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		list = new JList<File>();
		scrollPane.setViewportView(list);

		btnNewButton = new JButton("选择文件夹");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 每次选择都清空list选中
				if (!textField.getText().equals("") && new File(textField.getText()).isDirectory()) {
					fileChooser = new JFileChooser(textField.getText());
				} else {
					fileChooser = new JFileChooser("D:/");
				}
				list.clearSelection();
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("选择文件");
				/*
				 * 
				 */
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					/*
					 * 日志文件 保存到项目同目录下
					 */
					saveLogFile();
					/*
					 * 
					 */
					File file = fileChooser.getSelectedFile();
					String filePath = file.getAbsolutePath();
					System.out.println(filePath);
					textField.setText(filePath);
					File[] files = file.listFiles();
					if (files.length == 0) {
						JOptionPane.showMessageDialog(jpanel, "此路径下没有文件");
					} else {
						list.setListData(files);
						list.addListSelectionListener(listener);
					}
				}
			}
		});
		jpanel.add(btnNewButton, BorderLayout.EAST);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		textField_1 = new JTextField();
		textField_1.setToolTipText("保存的文件夹地址");
		panel.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				panel.grabFocus();
				fileChooser = new JFileChooser("d:/");
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("选择文件");
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String filePath = file.getAbsolutePath();
					System.out.println("保存的路径：" + filePath);
					textField_1.setText(filePath);
				}
				fileChooser.setVisible(true);
			}
		});

		btnNewButton_1 = new JButton("开始");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 检查是否都符合规则
				String chooseFolder = textField.getText();
				String toSaveFolder = textField_1.getText();
				File file1 = new File(chooseFolder);
				File file2 = new File(toSaveFolder);
				if (!file1.isDirectory()) {
					JOptionPane.showMessageDialog(jpanel, "不能选择文件");
					textField.requestFocus();
					return;
				}
				if (!file2.isDirectory()) {
					textField_1.requestFocus();
					return;
				}
				File[] files = file1.listFiles();
				if (files.length != 1 || files[0].isDirectory()) {
					JOptionPane.showMessageDialog(jpanel, "此路径下必须有且只有一个文件");
					return;
				}
				System.out.println("1：" + file1.getAbsolutePath());
				System.out.println("文件下：" + files[0].getName());
				System.out.println("2：" + file2.getAbsolutePath());
			}
		});
		panel.add(btnNewButton_1, BorderLayout.EAST);
	}

	protected void saveLogFile() {
		
	}

	// 点击列表的时候
	ListSelectionListener listener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedValue() != null) {
				String filePath = list.getSelectedValue().getAbsolutePath();
				textField.setText(filePath);
			}
		}
	};

}
