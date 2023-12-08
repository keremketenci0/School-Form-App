package Forms;

import Models.Course;
import Services.FileService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CourseForm extends JFrame{
    private JPanel CourseForm;
    private JTextField tfCourseCode;
    private JTextField tfCourseName;
    private JLabel lbStatusCourseCode;
    private JButton btnClear;
    private JButton btnOk;
    private JLabel lbStatusCourseName;
    private JComboBox cbCourseDepartmant;
    private JLabel lbStatusCourseDepartment;
    private JLabel lbStatusCourseFaculty;
    private JComboBox cbCourseFaculty;
    Course course = new Course();
    String courseCode = course.CourseCode;
    String courseName = course.CourseName;
    String courseFaculty = course.CourseFaculty;
    String courseDepartment = course.CourseDepartment;
    FileService fileService = new FileService();
    private int id = Integer.parseInt(String.valueOf(fileService.getLargestCourseCode("src/Data/Course.json")));

    public CourseForm() {
        tfCourseCode.setText(String.valueOf(id + 1));

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseCode = tfCourseCode.getText();
                courseName = tfCourseName.getText();
                courseFaculty = (String) cbCourseFaculty.getSelectedItem();
                courseDepartment = (String) cbCourseDepartmant.getSelectedItem();

                lbStatusCourseCode.setText("courseCode: " + courseCode);
                lbStatusCourseName.setText("courseName: " + courseName);
                lbStatusCourseFaculty.setText("courseFaculty: " + courseFaculty);
                lbStatusCourseDepartment.setText("courseDepartment: " + courseDepartment);

                if (courseCode.isEmpty() || courseName.isEmpty() || courseFaculty == null || courseDepartment == null){
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }else {
                    // JSON verilerini hazırla
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("courseCode", courseCode);
                    jsonObject.put("courseName", courseName);
                    jsonObject.put("courseFaculty", courseFaculty);
                    jsonObject.put("courseDepartment", courseDepartment);
                    jsonArray.put(jsonObject);

                    fileService.WriteToFile("src/Data","Course.json", jsonArray);

                    int newId = Integer.parseInt(fileService.getLargestCourseCode("src/Data/Course.json")) + 1;

                    tfCourseCode.setText(String.valueOf(id));
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCourseName.setText("");
                cbCourseFaculty.setSelectedIndex(-1);
                cbCourseDepartmant.setSelectedIndex(-1);
                cbCourseDepartmant.removeAllItems();
                cbCourseDepartmant.setEnabled(false);

                lbStatusCourseCode.setText("");
                lbStatusCourseName.setText("");
                lbStatusCourseFaculty.setText("");
                lbStatusCourseDepartment.setText("");
            }
        });
        cbCourseFaculty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseFaculty = (String) cbCourseFaculty.getSelectedItem();
                if(courseFaculty != null){
                    List<String> departmentList = fileService.getDepartmentsFromFile("src/Data/"+courseFaculty+".txt");
                    if (departmentList != null) {
                        cbCourseDepartmant.setEnabled(true);
                        cbCourseDepartmant.removeAllItems(); // Clear existing items before adding new ones
                        for (String department : departmentList) {
                            cbCourseDepartmant.addItem(department);
                        }
                        cbCourseDepartmant.setSelectedIndex(-1);
                    }
                }
            }
        });

        setContentPane(CourseForm);
        setTitle("Course Form");
        setMinimumSize(new Dimension(600,500));
        setLocation(100,500);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args){
        CourseForm courseForm = new CourseForm();
    }
    /*
 */
}

