package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame{
    private JPanel MenuForm;
    private JButton btnCourseForm;
    private JButton btnStudentForm;

    public MenuForm() {
        btnCourseForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseForm courseForm = new CourseForm();
                courseForm.setVisible(true);
            }
        });
        btnStudentForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentForm studentForm = new StudentForm();
                studentForm.setVisible(true);
            }
        });

        setContentPane(MenuForm);
        setTitle("Menu Form");
        setMinimumSize(new Dimension(500,100));
        setLocation(713,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
/*
    public static void main(String[] args){
        MenuForm menuForm = new MenuForm();
    }
 */
}
