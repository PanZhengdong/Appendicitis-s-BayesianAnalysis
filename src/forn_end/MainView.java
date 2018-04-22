package forn_end;
/*edit by Pan zhengdong 2018.4.21 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;  
	  
	
public class MainView extends JFrame implements ActionListener{  
	//设置计算值
	double a1, b1, c1, d1, e1, f1, g1, h1, result1;
	double a2, b2, c2, d2, e2, f2, g2, h2, result2;
	double a3, b3, c3, d3, e3, f3, g3, h3, result3;
	
	JButton controlButton;
	JTextArea textA,textB,textC;
	
	public MainView() {
		this.setTitle("阑尾炎贝叶斯分析");
		this.setSize(600, 600);
		this.setLocation(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 体征，症状，化验指标
		JPanel panelOptions = new JPanel();
		
		//腹痛开始部位
		panelOptions.setLayout(new GridLayout(3, 2));
		JCheckBox checkBox1 = new JCheckBox("右下腹");
		JCheckBox checkBox2 = new JCheckBox("下腹");
		JCheckBox checkBox3 = new JCheckBox("上腹");
		JCheckBox checkBox4 = new JCheckBox("脐周");
		JCheckBox checkBox5 = new JCheckBox("全腹");
		ButtonGroup optionsGroup = new ButtonGroup();
		optionsGroup.add(checkBox1);
		optionsGroup.add(checkBox2);
		optionsGroup.add(checkBox3);
		optionsGroup.add(checkBox4);
		optionsGroup.add(checkBox5);
		panelOptions.add(checkBox1);
		panelOptions.add(checkBox2);
		panelOptions.add(checkBox3);
		panelOptions.add(checkBox4);
		panelOptions.add(checkBox5);
		panelOptions.setBorder(BorderFactory.createTitledBorder("腹痛开始部位"));

		//2.恶心呕吐情况
		JPanel panelNausea  = new JPanel();
		panelNausea.setLayout(new BoxLayout(panelNausea, BoxLayout.Y_AXIS));
		JRadioButton forButton = new JRadioButton("恶心（-）呕吐（-）");
		JRadioButton backButton = new JRadioButton("恶心（+）呕吐（+）");
		JRadioButton outuButton = new JRadioButton("呕吐（+）");
		ButtonGroup NauseaGroup = new ButtonGroup();
		NauseaGroup.add(forButton);
		NauseaGroup.add(backButton);
		NauseaGroup.add(outuButton);
		panelNausea.add(forButton);
		panelNausea.add(backButton);
		panelNausea.add(outuButton);
		panelNausea.setBorder(BorderFactory.createTitledBorder("恶心呕吐"));
	          
		//3.大便情况
		JPanel panelExcrement = new JPanel();
		panelExcrement.setLayout(new BoxLayout(panelExcrement, BoxLayout.Y_AXIS));
		JRadioButton normButton = new JRadioButton("正常");
		JRadioButton unnormButton = new JRadioButton("不正常");
		JRadioButton laxButton = new JRadioButton("腹泻");
		ButtonGroup ExcrementGroup = new ButtonGroup();
		ExcrementGroup.add(normButton);
		ExcrementGroup.add(unnormButton);
		ExcrementGroup.add(laxButton);
		panelExcrement.add(normButton);
		panelExcrement.add(unnormButton);
		panelExcrement.add(laxButton);
		panelExcrement.setBorder(BorderFactory.createTitledBorder("大便"));

		//4.压痛
		JPanel panelYaTong = new JPanel();
		panelYaTong.setLayout(new BoxLayout(panelYaTong, BoxLayout.Y_AXIS));
		JRadioButton YouXiaFuButton = new JRadioButton("右下腹");
		JRadioButton OverYouXiaFuButton = new JRadioButton("超过右下腹");
		ButtonGroup YaTongGroup = new ButtonGroup();
		YaTongGroup.add(YouXiaFuButton);
		YaTongGroup.add(OverYouXiaFuButton);
		panelYaTong.add(YouXiaFuButton);
		panelYaTong.add(OverYouXiaFuButton);
		panelYaTong.setBorder(BorderFactory.createTitledBorder("压痛"));
		
		
		//5.肌肉紧张和反跳痛
		JPanel panelMuscle = new JPanel();
		panelMuscle.setLayout(new BoxLayout(panelMuscle, BoxLayout.Y_AXIS));
		JRadioButton JiRouJingZhangButton= new JRadioButton("肌肉紧张（+）反跳痛（+）");
		JRadioButton JiRouJingZhangButton1 = new JRadioButton("肌肉紧张（-）反跳痛（+）");
		JRadioButton JiRouJingZhangButton2 = new JRadioButton("肌肉紧张（-）反跳痛（-）");
		ButtonGroup MuscleGroup = new ButtonGroup();
		MuscleGroup.add(JiRouJingZhangButton);
		MuscleGroup.add(JiRouJingZhangButton1);
		MuscleGroup.add(JiRouJingZhangButton2);
		panelMuscle.add(JiRouJingZhangButton);
		panelMuscle.add(JiRouJingZhangButton1);
		panelMuscle.add(JiRouJingZhangButton2);
		panelMuscle.setBorder(BorderFactory.createTitledBorder("肌肉紧张和反跳痛"));
		
		//6.体温
		JPanel panelTemperature = new JPanel();
		panelTemperature.setLayout(new BoxLayout(panelTemperature, BoxLayout.Y_AXIS));
		JRadioButton TemperatureButton1 = new JRadioButton("<=37.C");
		JRadioButton TemperatureButton2 = new JRadioButton(">37.C且<38。C");
		JRadioButton TemperatureButton3 = new JRadioButton(">=38。C");
		ButtonGroup TemperatureGroup = new ButtonGroup();
		TemperatureGroup.add(TemperatureButton1);
		TemperatureGroup.add(TemperatureButton2);
		TemperatureGroup.add(TemperatureButton3);
		panelTemperature.add(TemperatureButton1);
		panelTemperature.add(TemperatureButton2);
		panelTemperature.add(TemperatureButton3);
		panelTemperature.setBorder(BorderFactory.createTitledBorder("体温"));
	          
		//7.白细胞计数
		JPanel panelHemameba = new JPanel();
		panelHemameba.setLayout(new BoxLayout(panelHemameba, BoxLayout.Y_AXIS));
		JRadioButton HemamebaCountButton1 = new JRadioButton("<=10");
		JRadioButton HemamebaCountButton2 = new JRadioButton(">10且<15");
		JRadioButton HemamebaCountButton3 = new JRadioButton(">=15");
		ButtonGroup HamamebaGroup = new ButtonGroup();
		HamamebaGroup.add(HemamebaCountButton1);
		HamamebaGroup.add(HemamebaCountButton2);
		HamamebaGroup.add(HemamebaCountButton3);
		panelHemameba.add(HemamebaCountButton1);
		panelHemameba.add(HemamebaCountButton2);
		panelHemameba.add(HemamebaCountButton3);
		panelHemameba.setBorder(BorderFactory.createTitledBorder("白细胞计数"));
		
		JPanel panelDireAndScope = new JPanel();
		panelDireAndScope.setLayout(new GridLayout(1, 2));
		panelDireAndScope.add(panelNausea);
		panelDireAndScope.add(panelExcrement);
		
		
		JPanel panelYaTongandMuscle = new JPanel();
		panelYaTongandMuscle.setLayout(new GridLayout(1, 2));
		panelYaTongandMuscle.add(panelYaTong);
		panelYaTongandMuscle.add(panelMuscle);
		
		JPanel panelTemperatureAndHemameba = new JPanel();
		panelTemperatureAndHemameba.setLayout(new GridLayout(1, 2));
		panelTemperatureAndHemameba.add(panelTemperature);
		panelTemperatureAndHemameba.add(panelHemameba);
		
		textA=new JTextArea();
		textB=new JTextArea();
		textC=new JTextArea();
		controlButton=new JButton("计算概率");
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(8, 1));
		southPanel.add(panelOptions);
		southPanel.add(panelDireAndScope);
		southPanel.add(panelYaTongandMuscle);
		southPanel.add(panelTemperatureAndHemameba);
		JPanel pNorth =new JPanel();
		pNorth.setLayout(new GridLayout(4,3));
		pNorth.add(new JLabel("急性概率A:"));
		pNorth.add(textA);
		pNorth.add(new JLabel("慢性概率A:"));
		pNorth.add(textB);
		pNorth.add(new JLabel("穿孔概率A:"));
		pNorth.add(textC);
		pNorth.add(controlButton);
        southPanel.add(pNorth);
		
        //监听
		controlButton.addActionListener(this);
		checkBox1.addActionListener(this);
		checkBox2.addActionListener(this);
		checkBox3.addActionListener(this);
		checkBox4.addActionListener(this);
		checkBox5.addActionListener(this);
		forButton.addActionListener(this);
		backButton.addActionListener(this);
		outuButton.addActionListener(this);
		normButton.addActionListener(this);
		unnormButton.addActionListener(this);
		laxButton.addActionListener(this);
		YouXiaFuButton.addActionListener(this);
		OverYouXiaFuButton.addActionListener(this);
		JiRouJingZhangButton.addActionListener(this);
		JiRouJingZhangButton1.addActionListener(this);
		JiRouJingZhangButton2.addActionListener(this);
		TemperatureButton1.addActionListener(this);
		TemperatureButton2.addActionListener(this);
		TemperatureButton3.addActionListener(this);
		HemamebaCountButton1.addActionListener(this);
		HemamebaCountButton2.addActionListener(this);
		HemamebaCountButton3.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(southPanel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MainView mainView = new MainView();
	}

	//获取数据
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().equals("右下腹")) {
			a1 = 0.17;
			a2 = 0.66;
			a3 = 0.11;
		}
		else if (e.getActionCommand().equals("下腹")) {
	     	a1 = 0.04;
			a2 = 0.02;
			a3 = 0.05;
		} else if (e.getActionCommand().equals("上腹")) {
			a1 = 0.29;
			a2 = 0.15;
			a3 = 0.42;
		} else if (e.getActionCommand().equals("脐周")) {
			a1 = 0.38;
			a2 = 0.12;
			a3 = 0.26;
		} else if (e.getActionCommand().equals("全腹")) {
			a1 = 0.12;
			a2 = 0.05;
			a3 = 0.16;
		}
		
		
		if (e.getActionCommand().equals("恶心（-）呕吐（-）")) {
			b1 = 0.21;
			b2 = 0.33;
			b3 = 0.12;
		} else if (e.getActionCommand().equals("恶心（+）呕吐（+）")) {
			b1 = 0.39;
			b2 = 0.52;
			b3 = 0.28;
		} else if (e.getActionCommand().equals("呕吐（+）")) {
			b1 = 0.4;
			b2 = 0.15;
			b3 = 0.6;
		}

		if (e.getActionCommand().equals("正常")) {
			c1 = 0.74;
			c2 = 0.86;
			c3 = 0.53;
		} else if (e.getActionCommand().equals("不正常")) {
			c1 = 0.13;
			c2 = 0.11;
			c3 = 0.25;
		} else if (e.getActionCommand().equals("腹泻")) {
			c1 = 0.13;
			c2 = 0.03;
			c3 = 0.22;
		}

		if (e.getActionCommand().equals("右下腹")) {
			d1 = 0.91;
			d2 = 0.98;
			d3 = 0.61;
		} else if (e.getActionCommand().equals("超过右下腹")) {
			d1 = 0.09;
			d2 = 0.02;
			d3 = 0.39;
		}

		if (e.getActionCommand().equals("肌肉紧张（+）反跳痛（+）")) {
			f1 = 0.57;
			f2 = 0.1;
			f3 = 0.92;
		} else if (e.getActionCommand().equals("肌肉紧张（-）反跳痛（+）")) {
			f1 = 0.32;
			f2 = 0.37;
			f3 = 0.04;
		} else if (e.getActionCommand().equals("肌肉紧张（-）反跳痛（-）")) {
			f1 = 0.11;
			f2 = 0.53;
			f3 = 0.04;
		}

		if (e.getActionCommand().equals("<=37.C")) {
			g1 = 0.29;
			g2 = 0.7;
			g3 = 0.09;
		} else if (e.getActionCommand().equals(">37.C且<38。C")) {
			g1 = 0.54;
			g2 = 0.27;
			g3 = 0.32;
		} else if (e.getActionCommand().equals(">=38。C")) {
			g1 = 0.17;
			g2 = 0.03;
			g3 = 0.59;
		}
   
		if (e.getActionCommand().equals("<=10")) {
			h1 = 0.09;
            h2 = 0.7;
            h3 = 0.16;
		} else if (e.getActionCommand().equals(">10且<15")) {
			h1 = 0.41;
            h2 = 0.2;
            h3 = 0.28;
		} else if (e.getActionCommand().equals(">=15")) {
			 h1 = 0.5;
             h2 = 0.1;
             h3 = 0.56;
		}

		result1 = (a1 * b1 * c1 * d1 * f1 * g1 * h1 * 0.4) / ((a1 * b1 * c1 * d1 * f1 * g1 * h1 * 0.4)
				+ (a2 * b2 * c2 * d2 * f2 * g2 * h2 * 0.3) + (a3 * b3 * c3 * d3 * f3 * g3 * h3 * 0.3));

		result2 = (a2 * b2 * c2 * d2 * f2 * g2 * h2 * 0.3) / ((a1 * b1 * c1 * d1 * f1 * g1 * h1 * 0.4)
				+ (a2 * b2 * c2 * d2 * f2 * g2 * h2 * 0.3) + (a3 * b3 * c3 * d3 * f3 * g3 * h3 * 0.3));

		result3 = (a3 * b3 * c3 * d3 * f3 * g3 * h3 * 0.3) / ((a1 * b1 * c1 * d1 * f1 * g1 * h1 * 0.4)
				+ (a2 * b2 * c2 * d2 * f2 * g2 * h2 * 0.3) + (a3 * b3 * c3 * d3 * f3 * g3 * h3 * 0.3));
		
		if(e.getActionCommand().equals("计算概率")){
			textA.append(result1 + "\n");
			textB.append(result2 + "\n");
			textC.append(result3 + "\n");
		}
		}
}

	

