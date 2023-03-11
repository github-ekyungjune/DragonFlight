import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
	/* Panel */
	JPanel basePanel = new JPanel(new BorderLayout());
	JPanel centerPanel = new JPanel(new BorderLayout());
	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	/* Label */
	JLabel idL = new JLabel("���̵�");
	JLabel pwL = new JLabel("��й�ȣ");
	
	/* TextField */
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	/* Button */
	JButton loginBtn = new JButton("�α���");
	JButton joinBtn = new JButton("ȸ������");
	JButton exitBtn = new JButton("���α׷� ����");
	
	Operator o = null;
	
	LoginFrame(Operator _o){
		o = _o;
		
		setTitle("�α���");
		
		/* Panel ũ�� �۾� */
		centerPanel.setPreferredSize(new Dimension(260, 80));
		westPanel.setPreferredSize(new Dimension(210, 75));
		eastPanel.setPreferredSize(new Dimension(90, 75));
		southPanel.setPreferredSize(new Dimension(290, 40));
		
		/* Label ũ�� �۾� */
		idL.setPreferredSize(new Dimension(50, 30));
		pwL.setPreferredSize(new Dimension(50, 30));
		
		/* TextField ũ�� �۾� */
		id.setPreferredSize(new Dimension(140, 30));
		pw.setPreferredSize(new Dimension(140, 30));
		
		/* Button ũ�� �۾� */
		loginBtn.setPreferredSize(new Dimension(75, 63));
		joinBtn.setPreferredSize(new Dimension(135, 25));
		exitBtn.setPreferredSize(new Dimension(135, 25));
		
		/* Panel �߰� �۾� */
		setContentPane(basePanel);	//panel�� �⺻ �����̳ʷ� ����
		
		basePanel.add(centerPanel, BorderLayout.CENTER);
		basePanel.add(southPanel, BorderLayout.SOUTH);
		centerPanel.add(westPanel, BorderLayout.WEST);
		centerPanel.add(eastPanel, BorderLayout.EAST);
		
		westPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());
		
		/* westPanel ������Ʈ */
		westPanel.add(idL);
		westPanel.add(id);
		westPanel.add(pwL);
		westPanel.add(pw);
		
		/* eastPanel ������Ʈ */
		eastPanel.add(loginBtn);
		
		/* southPanel ������Ʈ */
		southPanel.add(exitBtn);
		southPanel.add(joinBtn);
		
		/* Button �̺�Ʈ ������ �߰� */
		ButtonListener bl = new ButtonListener();
		ButtonListener b2 = new ButtonListener();
		ButtonListener b3 = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		exitBtn.addActionListener(b2);
		joinBtn.addActionListener(b3);
		
		setSize(310, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* Button �̺�Ʈ ������ */
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b1 = (JButton)e.getSource();
			JButton b2 = (JButton)e.getSource();
			JButton b3 = (JButton)e.getSource();
			
			
			
			/* TextField�� �Էµ� ���̵�� ��й�ȣ�� ������ �ʱ�ȭ */
			String unm = id.getText();
			String uid = id.getText();
			String upass = "";
			for(int i=0; i<pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			/* �������� ��ư �̺�Ʈ */
			if(b2.getText().equals("���α׷� ����")) {
				System.out.println("���α׷� ����");
				System.exit(0);
			}
			
			/* ȸ������ ��ư �̺�Ʈ */
			else if(b3.getText().equals("ȸ������")) {
				o.jf.setVisible(true);
			}
			
			/* �α��� ��ư �̺�Ʈ */
			else if(b1.getText().equals("�α���")) {
				if(unm.equals("") || uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ ��� �Է����ּ���", "�α��� ����", JOptionPane.ERROR_MESSAGE);
					System.out.println("�α��� ���� > �α��� ���� ���Է�");
					setVisible(false);
				}
				
				else if(unm != null && uid != null && upass != null) {
					if(o.db.logincheck(unm, uid, upass)) {	//�� �κ��� �����ͺ��̽��� ������ �α��� ������ Ȯ���ϴ� �κ��̴�.
						System.out.println("�α��� ����");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
						new DragonFlight();
						setVisible(false);
					} else {
						System.out.println("�α��� ���� > �α��� ���� ����ġ");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
						setVisible(false);
					}
				}
			}
		}
	}
}