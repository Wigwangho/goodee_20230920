package com.week3;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class ExTableAddBtn extends JFrame {

    private Object[] objColNms = new Object[] { "이름", "출근", "퇴근", "출근버튼", "퇴근버튼" };
    private Object[][] datas = null;

    public static void main(String[] args) {
        new ExTableAddBtn();
    }

    private JFrame jf;
    private DefaultTableModel dtm;
    private JTable jtable;
    private JScrollPane jsp;

    public ExTableAddBtn() {
        jf = new JFrame("JTable Add Delete Button");
        jf.setLocationRelativeTo(null);
        jf.setSize(400, 300); // 크기 조정
        datas = new Object[][] { { "나신입", "08:59:00", "17:00:00", null, null },
                { "나일등", "08:57:00", "17:00:00", null, null }, { "나초보", "08:55:00", "17:00:00", null, null } };
        dtm = new DefaultTableModel(datas, objColNms);
        jtable = new JTable(dtm);
        jsp = new JScrollPane(jtable);

        jtable.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(3).setCellEditor(new TableCell());
        jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());

        jf.add(jsp);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
    }

    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton checkInButton; // 출근버튼
        JButton checkOutButton; // 퇴근버튼

        public TableCell() {
            checkInButton = new JButton("출근버튼");
            checkInButton.addActionListener(e -> handleCheckInButtonClick());

            checkOutButton = new JButton("퇴근버튼");
            checkOutButton.addActionListener(e -> handleCheckOutButtonClick());
        }

        private void handleCheckInButtonClick() {
            int selectedRow = jtable.getSelectedRow();
            if (selectedRow >= 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());

                // 출근버튼 클릭 시 현재 시간 업데이트
                dtm.setValueAt(currentTime, selectedRow, 1);
            }
        }

        private void handleCheckOutButtonClick() {
            int selectedRow = jtable.getSelectedRow();
            if (selectedRow >= 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());

                // 퇴근버튼 클릭 시 현재 시간 업데이트
                dtm.setValueAt(currentTime, selectedRow, 2);
            }
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (column == 3) {
                return checkInButton; // 출근버튼 컬럼
            } else if (column == 4) {
                return checkOutButton; // 퇴근버튼 컬럼
            } else {
                return null;
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            if (column == 3) {
                return checkInButton; // 출근버튼 컬럼
            } else if (column == 4) {
                return checkOutButton; // 퇴근버튼 컬럼
            } else {
                return null;
            }
        }
    }
}
