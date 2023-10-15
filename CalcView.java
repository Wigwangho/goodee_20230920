package com.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{
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
		Calculator cv = new Calculator();
		cv.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	    if (Character.isDigit(command.charAt(0))) { // 숫자 버튼이 눌린 경우. 간결하게 변경하고 0만 있을 때 숫자를 뒤에 붙이지 않고 0을 제거함.
	    	 String currentText = jtf_display.getText();
	         if (currentText.equals("0")) {
	             jtf_display.setText(command);
	         } else {
	             jtf_display.setText(currentText + command);
	         }
	    } else if ("+-*/".contains(command)) { // 연산자 버튼이 눌린 경우
	        System.out.println(command + " 버튼");
	        firstVal = Double.parseDouble(jtf_display.getText());
	        jtf_display.setText("");
	        operator = command;
	    } else if ("=".equals(command)) { // 등호 버튼이 눌린 경우
	        System.out.println("계산 결과는 얼마");
	        secVal = Double.parseDouble(jtf_display.getText());
	        switch (operator) {
	            case "+":
	                result = firstVal + secVal;
	                break;
	            case "-":
	                result = firstVal - secVal;
	                break;
	            case "*":
	                result = firstVal * secVal;
	                break;
	            case "/":
	                result = firstVal / secVal;
	                break;
	        }
	        jtf_display.setText(Double.toString(result));
	    } else if ("<=".equals(command)) { // 지우기 버튼이 눌린 경우
	        System.out.println("한 글자씩 지우기 구현");
	        String now = jtf_display.getText();
	        if (!now.isEmpty()) {
	            String deleted = now.substring(0, now.length() - 1);
	            jtf_display.setText(deleted);
	        }
	    } else if ("C".equals(command)) { // 클리어 버튼이 눌린 경우
	        System.out.println("클리어");
	        jtf_display.setText("");
	    }
	}

}
