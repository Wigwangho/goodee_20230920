package com.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView implements ActionListener{
	JFrame jf = new JFrame();
	JTextField jtf_display = new JTextField("0");
	JPanel jp = new JPanel();
	JButton jbtnOne = new JButton("1");
	JButton jbtnTwo = new JButton("2");
	JButton jbtnThree = new JButton("3");
	JButton jbtnFour = new JButton("4");
	JButton jbtnFive = new JButton("5");
	JButton jbtnSix	= new JButton("6");
	JButton jbtnSeven = new JButton("7");
	JButton jbtnEight = new JButton("8");
	JButton jbtnNine = new JButton("9");
	JButton jbtnZero = new JButton("0");
	JButton jbtnPlus = new JButton("+");
	JButton jbtnMinus = new JButton("-");
	JButton jbtnDivide = new JButton("/");
	JButton jbtnMulti = new JButton("*");
	JButton jbtnEqual = new JButton("=");
	JButton jbtnBack = new JButton("<=");
	JButton jbtnClear = new JButton("C");//0-9까지의 숫자. 4개의 연산자. = 연산자 버튼
	double firstVal= 0;
	double secVal = 0;
	double result = 0;
	String operator = "";
	public void initDisplay() {
		//이벤트 처리를 담당하는 핸들러 클래스의 인스턴스변수를 준다.
		jbtnOne.addActionListener(this);
		jbtnTwo.addActionListener(this);
		jbtnThree.addActionListener(this);
		jbtnFour.addActionListener(this);
		jbtnFive.addActionListener(this);
		jbtnSix.addActionListener(this);
		jbtnSeven.addActionListener(this);
		jbtnEight.addActionListener(this);
		jbtnNine.addActionListener(this);
		jbtnZero.addActionListener(this);
		jbtnDivide.addActionListener(this);
		jbtnMulti.addActionListener(this);
		jbtnMinus.addActionListener(this);
		jbtnPlus.addActionListener(this);
		jbtnEqual.addActionListener(this);
		jbtnBack.addActionListener(this);
		jbtnClear.addActionListener(this);//각 버튼에 값 부여
		jp.add(jbtnOne);
		jp.add(jbtnTwo);
		jp.add(jbtnThree);
		jp.add(jbtnFour);
		jp.add(jbtnFive);
		jp.add(jbtnSix);
		jp.add(jbtnSeven);
		jp.add(jbtnEight);
		jp.add(jbtnNine);
		jp.add(jbtnZero);
		jp.add(jbtnPlus);
		jp.add(jbtnMinus);
		jp.add(jbtnMulti);
		jp.add(jbtnDivide);
		jp.add(jbtnEqual);
		jp.add(jbtnBack);
		jp.add(jbtnClear);// 모든 버튼 JFrame에 추가가
		jf.add("North",jtf_display);
		jf.add("Center",jp);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		CalcView cv = new CalcView();
		cv.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("1".equals(command)) {//너 숫자 1 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"1");//숫자 버튼을 누르면 화면에 해당 수가 추가된다.
		}
		else if("2".equals(command)) {//너 숫자 2 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"2");			
		}
		else if("3".equals(command)) {//너 숫자 3 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"3");			
		}
		else if("4".equals(command)) {//너 숫자 4 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"4");			
		}
		else if("5".equals(command)) {//너 숫자 5 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"5");			
		}
		else if("6".equals(command)) {//너 숫자 6 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"6");			
		}
		else if("7".equals(command)) {//너 숫자 7 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"7");			
		}
		else if("8".equals(command)) {//너 숫자 8 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"8");			
		}
		else if("9".equals(command)) {//너 숫자 9 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"9");			
		}
		else if("0".equals(command)) {//너 숫자 0 버튼 누른거야?
			jtf_display.setText(jtf_display.getText()+"0");			
		}
		else if("+".equals(command)) {//너 + 버튼 누른거야?
			System.out.println("더하기 버튼");
			firstVal = Double.parseDouble(jtf_display.getText());
			jtf_display.setText("");
			operator = "+";//연산자를 입력하면, 기존 수는 사라지고 그 수는 변수 firstval에 저장된다. 다음 수를 얻어 계산을 계속하기 위해
		}
		else if("-".equals(command)) {//너 + 버튼 누른거야?
			System.out.println("빼기 버튼");
			firstVal = Double.parseDouble(jtf_display.getText());
			jtf_display.setText("");
			operator = "-";
		}
		else if("/".equals(command)) {//너 + 버튼 누른거야?
			System.out.println("더하기 버튼");
			firstVal = Double.parseDouble(jtf_display.getText());
			jtf_display.setText("");
			operator = "/";
		}
		else if("*".equals(command)) {//너 + 버튼 누른거야?
			System.out.println("더하기 버튼");
			firstVal = Double.parseDouble(jtf_display.getText());
			jtf_display.setText("");
			operator = "*";
		}
		else if("=".equals(command)) {//너 = 버튼 누른거야?
			System.out.println("계산 결과는 얼마");			
			secVal = Double.parseDouble(jtf_display.getText());
			if(operator.equals("+")) {
			result = firstVal + secVal; }
			else if(operator.equals("-")) {
				result = firstVal - secVal;
			}
			else if(operator.equals("/")) {
				result = firstVal/secVal;
			}
			else if(operator.equals("*")) {
				result = firstVal*secVal;
			}
			
			String sumStr = Double.toString(result);
			jtf_display.setText(sumStr);
      //첫 번째로 받은 firstval과 연산자 이후 받은 secval을, 연산자에 맞춰 계산한다.
		}		
		else if("<=".equals(command)) {//너 = 버튼 누른거야?
			System.out.println("한글자씩 지우기 구현");		
			String now = jtf_display.getText();
			try {
				String deleted = now.substring(0, now.length() - 1);
				jtf_display.setText(deleted);
				}
			catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("--ArrayIndexOutOfBoundsException 발생--");
				System.out.println("기존 코드를 체크해 주세요!!");
			}// 한 글자씩 기존 textbox에서 제거한다다
			
			
		}
		else if("C".equals(command)) {
			System.out.println("클리어");		
			jtf_display.setText("");
		}
	}

}
