package Services;

import org.json.JSONArray;

import java.util.List;

public interface IFileService
{
    public void CreateFile(String Path,String FileName);
    public void WriteToFile(String path, String FileName, JSONArray jsonObject);
    public List<String> getDepartmentsFromFile(String filePath);
    public List<String> getCourseNamesByDepartment(String filePath, String department);
    public String getLargestStudentNo(String filePath);
    public String getLargestCourseCode(String filePath);
}
