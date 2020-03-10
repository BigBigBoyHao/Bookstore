package cn.com.bookstore.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceBorder;
import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;
import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;
import org.jvnet.substance.skin.SubstanceCremeLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceFieldOfWheatLookAndFeel;
import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMangoLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel;
import org.jvnet.substance.skin.SubstanceModerateLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaBrickWallLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;
import org.jvnet.substance.skin.SubstanceSaharaLookAndFeel;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.theme.SubstanceBarbyPinkTheme;
import org.jvnet.substance.theme.SubstanceBlendBiTheme;
import org.jvnet.substance.theme.SubstanceBottleGreenTheme;

import cn.com.bookstore.control.entry.CancelActionListener;
import cn.com.bookstore.control.entry.CertainActionListener;
import cn.com.bookstore.control.entry.LogonActionListener;

public class FrmEntry extends JFrame {
	public static final String[] identity = { "店员", "管理员" };

	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 18);
	private JLabel lblTitle = new JLabel(" 花 花 ※ 书 店");
	private JLabel lblIdentity = new JLabel("身  份");
	private JComboBox cmbIdentity = new JComboBox(identity);
	private JLabel lblUserName = new JLabel("用 户 名 ");
	private JTextField txtUserName = new JTextField(10);
	private JLabel lblPassword = new JLabel("密  码 ");
	private JPasswordField txtPassword = new JPasswordField(10);
	private JButton btnCertain = new JButton("登录");
	private JButton btnCancel = new JButton("取消");
	private JButton btnLogon = new JButton("注册");

	// private JLabel img = new JLabel(new ImageIcon("image/a.jpg"));

	public FrmEntry(String title) {
		super(title);
		init();
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JComboBox getCmbIdentity() {
		return cmbIdentity;
	}

	private void init() {
		this.setSize(320, 240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		this.lblTitle.setBounds(80, 20, 200, 30);
		this.lblTitle.setFont(font);
		this.add(lblTitle);
		this.lblIdentity.setBounds(60, 60, 80, 30);
		this.add(lblIdentity);
		this.cmbIdentity.setBounds(120, 60, 140, 25);
		this.add(cmbIdentity);

		this.lblUserName.setBounds(60, 90, 50, 30);
		this.add(lblUserName);
		this.txtUserName.setBounds(120, 90, 140, 25);
		this.add(txtUserName);

		this.lblPassword.setBounds(60, 120, 50, 30);
		this.add(lblPassword);
		this.txtPassword.setBounds(120, 120, 140, 25);
		this.add(txtPassword);

		this.btnCertain.setBounds(60, 160, 60, 30);
		this.add(btnCertain);
		this.btnCancel.setBounds(130, 160, 60, 30);
		this.add(btnCancel);
		this.btnLogon.setBounds(200, 160, 60, 30);
		this.add(btnLogon);
		/*
		 * this.img.setBounds(0, 0, 320, 240); this.add(img);
		 */
		addListener();
		this.setVisible(true);
	}

	private void addListener() {
		this.btnCertain.addActionListener(new CertainActionListener(this));
		this.btnCancel.addActionListener(new CancelActionListener(this));
		this.btnLogon.addActionListener(new LogonActionListener(this));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// new FrmEntry("书店管理系统");
		try {
			//UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
			//UIManager.setLookAndFeel(new SubstanceMangoLookAndFeel());
			//UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
			//UIManager.setLookAndFeel(new SubstanceFieldOfWheatLookAndFeel());
			UIManager.setLookAndFeel(new SubstanceCremeLookAndFeel());

		} catch (Exception e) {
			System.out.println("Substance Raven Graphite failed to initialize");
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FrmEntry("花 花 ※ 书 店");
			}
		});

	}
}