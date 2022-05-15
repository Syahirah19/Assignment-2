package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.ItemProduct;
import Model.Order;
import Model.OrderItem;
import Controller.UserController;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierFrame extends JFrame {
	
	UserController controller = new UserController();
	
	double totalPrice = 0;

	private JPanel contentPane;
	private JTable tableOrder;
	private JTable tableCart;
	private JSpinner spinner;
	private JTextField textTotalPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierFrame frame = new CashierFrame();
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
	public CashierFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 89, 363, 289);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Product", null, panel, null);
		tabbedPane.setFont(new Font("04b", Font.PLAIN, 12));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 358, 262);
		panel.add(scrollPane);
		
		tableOrder = new JTable();
		tableOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableOrder);
		
		tableOrder.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "LABEL NAME", "PRICE"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(433, 112, 313, 174);
		contentPane.add(scrollPane_1);
		
		tableCart = new JTable();
		tableCart.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "QUANTITY", "PRICE"
			}
		));
		tableCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tableCart);
		
		spinner = new JSpinner();
		spinner.setBounds(227, 411, 57, 20);
		contentPane.add(spinner);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = tableOrder.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Select an item");
				}else {
				
				int qty = (int) spinner.getValue();
				
				if(qty>0) {
					int id;
					double price;
					String name;
						id = (int)tableOrder.getValueAt(row, 0);
						name = (String) tableOrder.getValueAt(row, 1);
						price =(double) tableOrder.getValueAt(row, 3);
					
					DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
					model.addRow(new Object[] {id,name,qty,(qty*price)});
					totalPrice += qty*price;
					textTotalPrice.setText(totalPrice+"");
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter quantity");
				}
				}
				
			}
		});
		btnAdd.setBounds(317, 410, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int row = tableCart.getSelectedRow();
				
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Select an item");
				}else {
					DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
					double price = (double)tableCart.getValueAt(row, 3);
					model.removeRow(row);
					tableCart.revalidate();
					totalPrice -= price;
					textTotalPrice.setText(totalPrice+"");
				}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Select an item"+ex);
				}
			}
		});
		btnRemove.setBounds(552, 296, 85, 21);
		contentPane.add(btnRemove);
		
		JButton btnPay = new JButton("PAY CASH");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderItem orderitem = new OrderItem();
				orderitem.setSubTotalAmount(totalPrice);
				PaymentFrame frame = new PaymentFrame(orderitem);
				frame.setVisible(true);
				dispose();
			}
		});
		btnPay.setBounds(552, 410, 85, 21);
		contentPane.add(btnPay);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(660, 410, 85, 21);
		contentPane.add(btnCancel);
		
		textTotalPrice = new JTextField();
		textTotalPrice.setText("0");
		textTotalPrice.setEditable(false);
		textTotalPrice.setBounds(625, 359, 121, 19);
		contentPane.add(textTotalPrice);
		textTotalPrice.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY : ");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(132, 402, 85, 33);
		contentPane.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("TOTAL PRICE : ");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(500, 350, 121, 33);
		contentPane.add(lblTotal);
		
		loadItemProduct();
	}
	
	private void loadItemProduct() {
		DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
		try {
			for(ItemProduct item : controller.getAllItems()) {
				model.addRow(new Object[] {item.getItemProductId(), item.getName(),
						item.getLabelName(), item.getPrice()});
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}