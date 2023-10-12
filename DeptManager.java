package weel1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DeptManager extends JFrame implements ActionListener{
	//선언부
	String header[] = {"부서번호","부서명", "지역"};
	String datas[][] = new String[0][0];
	//2차 배열. 2쌍의 대괄호.
	//생성자의 파라미터를 통해 서로 다른 클래스가 의존관계를 맺고 하나의 기능을 서비스할 수 있다.
	//생성자도 파라미터를 여럿 가질수 있다 -> 메소드 오버로딩
	DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); //<table> 양식 자바가 있어야 dataset이 구성됨
	JTable jt_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jt_dept);
	JButton jbtnSelect = new JButton("조회");
	JButton jbtnAdd = new JButton("행 추가");
	JButton jbtnRemove = new JButton("행 삭제");
	JButton jbtnexit =new JButton("종료");
	JPanel jp_north = new JPanel();
	JPanel jp_south = new JPanel();
	JTextField deptno = new JTextField();
	JTextField deptname = new JTextField();
	JTextField loc = new JTextField();
	//생성자
	DeptManager(){
		initDisplay();
	}
	//화면처리부

	public void initDisplay() {
		jbtnSelect.addActionListener(this);
		jbtnAdd.addActionListener(this);
		jbtnRemove.addActionListener(this);
		jbtnexit.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtnSelect);
		jp_north.add(jbtnAdd);
		jp_north.add(jbtnRemove);
		jp_north.add(jbtnexit);
		jp_south.add(deptname);
		jp_south.add(deptno);
		jp_south.add(loc);
		this.add("North",jp_north);
		this.add("Center", jsp_dept);
		this.add("South", jp_south);
		deptname.setPreferredSize(new Dimension(100, 25));
	    deptno.setPreferredSize(new Dimension(100, 25));
	    loc.setPreferredSize(new Dimension(100, 25));
		this.setSize(500,400);//this:DeptManager. jframe을 상속받았으므로
		
		//자바는 단일 상속만 가능함. 다중상속은 불가하며, 이 단점을 보완하기 위해 인터페이스가 제공됨
		//추상클래스와 인터페이스는 설계 관점에서 중요하다. 인터페이스는 여러가지 implement가 가능하다.
		this.setVisible(true);
	}
	public void removeSelectedRow() {
	    int selectedRow = jt_dept.getSelectedRow(); // 현재 선택된 행 인덱스를 가져옵니다.
	    
	    if (selectedRow >= 0) {
	        dtm_dept.removeRow(selectedRow); // 선택된 행을 삭제합니다.
	    } else {
	        // 선택된 행이 없을 경우에 대한 처리를 추가할 수 있습니다.
	        System.out.println("선택된 행이 없습니다.");
	    }
	}
	private void exit() {
		System.exit(0);
	}
	//메인 메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		DeptManager dm = new DeptManager();//new JFrame 호출
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == jbtnSelect) {//조회버튼 확인
			System.out.println("조회버튼 확인"); //로그. 히스토리 이력 등을 보관
		
		String sample[][] = {
				{"10","영업부","부산"}	
			   ,{"20","개발부","대전"}	
			   ,{"30","운영부","인천"}	
		};
		this.getContentPane().remove(jsp_dept);
		dtm_dept = null;
		jt_dept = null;
		jsp_dept = null;
		dtm_dept = new DefaultTableModel(sample, header);
		jt_dept = new JTable(dtm_dept);
		jsp_dept = new JScrollPane(jt_dept);
		this.add("Center", jsp_dept);
		this.revalidate();
		this.repaint();
		}
		else if(obj == jbtnAdd) {
			String Row[] = { deptno.getText(), deptname.getText(), loc.getText() };
		    dtm_dept.addRow(Row);

		    // 텍스트 필드 값을 추가한 후 텍스트 필드 초기화
		    deptno.setText("");
		    deptname.setText("");
		    loc.setText("");
		}
		else if(obj == jbtnRemove) {
			removeSelectedRow();
		}
		else if(obj == jbtnexit) {
			exit();
		}
	}
	

}
