package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class SlotMachineGUI extends JFrame {

	private JPanel w_panel;
	private JTextField txtKullaniciAdi;
	JPanel panelKullaniciBilgileri = new JPanel();
	JLabel lblKullaniciBilgileri = new JLabel("Oyuncu Bilgileri");
	JLabel lblOyuncuAdi = new JLabel("Ad\u0131n\u0131n\u0131z\u0131 Giriniz:");
	JButton btnBasla = new JButton("Baþla");
	JPanel panelOyunAlani = new JPanel();
	JLabel lblOyunAlan = new JLabel("Oyun Alan\u0131");
	JButton btnSlot3 = new JButton("");
	JButton btnSlot2 = new JButton("");
	JButton btnSlot1 = new JButton("");
	JButton btnKol = new JButton("");
	JLabel lblDurum = new JLabel("Durum");
	JLabel lblWinOrLose = new JLabel("");
	JPanel panelSkorJlist = new JPanel();
	JLabel lblSkorlar = new JLabel("Skorlar");
	JList list = new JList();
	JPanel panelPuanDurumu = new JPanel();
	JLabel lblPuanDurumu = new JLabel("Puan Durumu");
	JLabel lblPuanOyuncuAdi = new JLabel("Oyuncu");
	JLabel lblPuanOyuncuSkor = new JLabel("0");
	JButton btnYenidenOyna = new JButton("Yeniden Oyna");
	JButton btnCik = new JButton("Çýk");
	int money = 100;
	String[] skorData = new String[10];
	static int i;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotMachineGUI frame = new SlotMachineGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void RandomBTN() {
		int random_1 = 1, random_2 = 1, random_3 = 1;
		try {// Oyunu Yavaþlatýyor
			Thread.sleep(400);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		random_1 = (int) (Math.random() * 7 + 1);
		random_2 = (int) (Math.random() * 7 + 1);
		random_3 = (int) (Math.random() * 7 + 1);

		btnSlot1.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/" + random_1 + ".png")));
		btnSlot2.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/" + random_2 + ".png")));
		btnSlot3.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/" + random_3 + ".png")));
		lblDurum.setVisible(true);
		if (random_1 == random_2 && random_3 == random_2) {
			money += 300;
			lblWinOrLose.setText(
					"Tebrikler " + lblPuanOyuncuAdi.getText().toUpperCase() + " 300$ Kazandin Güncel Paran " + money);
			lblWinOrLose.setForeground(new Color(0, 128, 0));
		} else if (random_1 == random_2 || random_3 == random_2 || random_3 == random_1) {
			money += 100;
			lblWinOrLose.setText(
					"Tebrikler " + lblPuanOyuncuAdi.getText().toUpperCase() + " 100$ Kazandin Güncel Paran " + money);
			lblWinOrLose.setForeground(new Color(59, 134, 255));
		} else if (random_1 != random_2 || random_3 != random_2 || random_1 != random_3) {
			money -= 50;
			lblWinOrLose.setText(
					"Üzgünüm " + lblPuanOyuncuAdi.getText().toUpperCase() + " 50$ Kaybettin Güncel Paran " + money);
			lblWinOrLose.setForeground(new Color(255, 0, 110));
		}
		lblPuanOyuncuSkor.setText(String.valueOf(money));
	}

	public void OyunKapali() {
		panelOyunAlani.setVisible(false);
		panelPuanDurumu.setVisible(false);
		panelSkorJlist.setVisible(false);
		lblDurum.setVisible(false);
		money = 100;
		lblPuanOyuncuAdi.setText("Oyuncu");
		lblPuanOyuncuSkor.setText("100");
		lblWinOrLose.setText("");

	}

	public void OyunAcik() {
		panelOyunAlani.setVisible(true);
		panelPuanDurumu.setVisible(true);
		panelSkorJlist.setVisible(true);
	}

	public SlotMachineGUI() {
		setResizable(false);
		setTitle("Slot Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 723);
		w_panel = new JPanel();
		w_panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		w_panel.setBackground(new Color(123, 31, 162));
		w_panel.setBorder(null);
		setContentPane(w_panel);
		w_panel.setLayout(null);

		OyunKapali();

		panelKullaniciBilgileri.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelKullaniciBilgileri.setBackground(new Color(210, 183, 229));
		panelKullaniciBilgileri.setBounds(35, 20, 706, 137);
		w_panel.add(panelKullaniciBilgileri);
		panelKullaniciBilgileri.setLayout(null);

		lblKullaniciBilgileri.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblKullaniciBilgileri.setForeground(new Color(0, 204, 0));
		lblKullaniciBilgileri.setBounds(10, 10, 157, 29);
		panelKullaniciBilgileri.add(lblKullaniciBilgileri);

		lblOyuncuAdi.setForeground(new Color(255, 0, 0));
		lblOyuncuAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblOyuncuAdi.setBounds(20, 49, 157, 46);
		panelKullaniciBilgileri.add(lblOyuncuAdi);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		txtKullaniciAdi.setBounds(180, 51, 233, 43);
		panelKullaniciBilgileri.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		btnBasla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtKullaniciAdi.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Kullancýdý Adý Griniz!!", "Uyari",
							JOptionPane.WARNING_MESSAGE);
				} else {
					OyunAcik();
					lblPuanOyuncuAdi.setText(txtKullaniciAdi.getText());
					txtKullaniciAdi.setText("");
					txtKullaniciAdi.setEnabled(false);
					btnBasla.setEnabled(false);
				}
			}
		});

		btnBasla.setForeground(Color.WHITE);
		btnBasla.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnBasla.setBorder(null);
		btnBasla.setBackground(new Color(144, 202, 249));
		btnBasla.setBounds(461, 49, 215, 46);
		panelKullaniciBilgileri.add(btnBasla);

		panelOyunAlani.setBorder(new LineBorder(new Color(240, 248, 255), 3));
		panelOyunAlani.setBackground(new Color(210, 183, 229));
		panelOyunAlani.setBounds(10, 181, 758, 495);
		w_panel.add(panelOyunAlani);
		panelOyunAlani.setLayout(null);

		lblOyunAlan.setForeground(new Color(0, 0, 204));
		lblOyunAlan.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblOyunAlan.setBounds(10, 10, 157, 29);
		panelOyunAlani.add(lblOyunAlan);

		btnSlot3.setBorder(null);
		btnSlot3.setBackground(Color.WHITE);
		btnSlot3.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/1.png")));
		btnSlot3.setBounds(525, 49, 157, 170);
		panelOyunAlani.add(btnSlot3);

		btnSlot2.setBorder(null);
		btnSlot2.setBackground(Color.WHITE);
		btnSlot2.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/2.png")));
		btnSlot2.setBounds(300, 49, 157, 170);
		panelOyunAlani.add(btnSlot2);
		btnSlot1.setBorder(null);
		btnSlot1.setBackground(Color.WHITE);
		btnSlot1.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/3.png")));
		btnSlot1.setBounds(69, 49, 157, 170);
		panelOyunAlani.add(btnSlot1);
		btnKol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomBTN();
			}
		});

		btnKol.setBackground(Color.WHITE);
		btnKol.setBorder(null);
		btnKol.setIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/of.png")));
		btnKol.setPressedIcon(new ImageIcon(SlotMachineGUI.class.getResource("/Img/on.png")));
		btnKol.setBounds(337, 229, 91, 197);
		panelOyunAlani.add(btnKol);

		lblDurum.setForeground(Color.white);
		lblDurum.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblDurum.setBounds(10, 439, 77, 46);
		panelOyunAlani.add(lblDurum);

		lblWinOrLose.setForeground(new Color(255, 255, 255));
		lblWinOrLose.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblWinOrLose.setBounds(107, 439, 575, 46);
		panelOyunAlani.add(lblWinOrLose);

		panelSkorJlist.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelSkorJlist.setBackground(new Color(210, 183, 229));
		panelSkorJlist.setBounds(778, 20, 259, 346);
		w_panel.add(panelSkorJlist);
		panelSkorJlist.setLayout(null);

		lblSkorlar.setForeground(new Color(204, 0, 0));
		lblSkorlar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblSkorlar.setBounds(10, 10, 157, 29);
		panelSkorJlist.add(lblSkorlar);
		list.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));

		list.setBounds(20, 49, 217, 274);
		panelSkorJlist.add(list);

		panelPuanDurumu.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelPuanDurumu.setBackground(new Color(210, 183, 229));
		panelPuanDurumu.setBounds(778, 376, 259, 236);
		w_panel.add(panelPuanDurumu);
		panelPuanDurumu.setLayout(null);

		lblPuanDurumu.setForeground(new Color(255, 153, 0));
		lblPuanDurumu.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 18));
		lblPuanDurumu.setBounds(10, 10, 157, 29);
		panelPuanDurumu.add(lblPuanDurumu);

		lblPuanOyuncuAdi.setBackground(new Color(255, 255, 255));
		lblPuanOyuncuAdi.setForeground(new Color(0, 0, 0));
		lblPuanOyuncuAdi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblPuanOyuncuAdi.setBounds(10, 68, 94, 46);
		panelPuanDurumu.add(lblPuanOyuncuAdi);

		lblPuanOyuncuSkor.setForeground(Color.BLACK);
		lblPuanOyuncuSkor.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblPuanOyuncuSkor.setBackground(Color.WHITE);
		lblPuanOyuncuSkor.setBounds(131, 68, 94, 46);
		panelPuanDurumu.add(lblPuanOyuncuSkor);
		btnYenidenOyna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 8) {// Listeleme
					i = 0;
				} else {
				}
				String str = lblPuanOyuncuAdi.getText() + "  " + lblPuanOyuncuSkor.getText();
				skorData[i++] = str;
				list.setListData(skorData);
				OyunKapali();
				txtKullaniciAdi.setEnabled(true);
				btnBasla.setEnabled(true);
			}
		});

		btnYenidenOyna.setForeground(Color.WHITE);
		btnYenidenOyna.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnYenidenOyna.setBorder(null);
		btnYenidenOyna.setBackground(new Color(181, 228, 140));
		btnYenidenOyna.setBounds(20, 162, 215, 46);
		panelPuanDurumu.add(btnYenidenOyna);
		btnCik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnCik.setBorder(null);
		btnCik.setForeground(new Color(255, 255, 255));
		btnCik.setBackground(new Color(198, 40, 40));
		btnCik.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnCik.setBounds(778, 635, 259, 41);
		w_panel.add(btnCik);
	}
}
