package com.example.mytry32.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytry32.R;
import com.example.mytry32.bean.Student;
import com.example.mytry32.using;
import com.example.mytry32.util.StudentDbHelper;

import java.util.LinkedList;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    EditText etStuName,etMajor,etPhone,etQq,etAddress;
    String name;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        name= using.userid;

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TextView tvStuNumber = getView().findViewById(R.id.tv_stu_number);

        tvStuNumber.setText(name);
        etStuName = getView().findViewById(R.id.et_stu_name);
        etMajor = getView().findViewById(R.id.et_stu_major);
        etPhone = getView().findViewById(R.id.et_stu_phone);
        etQq = getView().findViewById(R.id.et_stu_qq);
        etAddress = getView().findViewById(R.id.et_stu_address);
        StudentDbHelper dbHelper = new StudentDbHelper(getContext(),StudentDbHelper.DB_NAME,null,1);
        LinkedList<Student> students = dbHelper.readStudents(tvStuNumber.getText().toString());
        //如果查找到的学生信息不为空
        if(students != null) {
            for(Student student : students) {
                etStuName.setText(student.getStuName());
                etMajor.setText(student.getStuMajor());
                etPhone.setText(student.getStuPhone());
                etQq.setText(student.getStuQq());
                etAddress.setText(student.getStuAddress());
            }
        }
        Button btnSaveInfo = getView().findViewById(R.id.btn_save_info);
        btnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先判断输入不为空
                if(CheckInput()) {
                    StudentDbHelper dbHelper = new StudentDbHelper(getContext(),StudentDbHelper.DB_NAME,null,1);
                    Student student = new Student();
                    student.setStuNumber(tvStuNumber.getText().toString());
                    student.setStuName(etStuName.getText().toString());
                    student.setStuMajor(etMajor.getText().toString());
                    student.setStuPhone(etPhone.getText().toString());
                    student.setStuQq(etQq.getText().toString());
                    student.setStuAddress(etAddress.getText().toString());
                    dbHelper.saveStudent(student);
                    Toast.makeText(getContext(),"用户信息保存成功!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //检查输入是否为空
    public boolean CheckInput() {
        String StuName = etStuName.getText().toString();
        String StuMajor = etMajor.getText().toString();
        String StuPhone = etPhone.getText().toString();
        String StuQq = etQq.getText().toString();
        String StuAddress = etAddress.getText().toString();
        if(StuName.trim().equals("")) {
            Toast.makeText(getActivity(),"姓名不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(StuMajor.trim().equals("")) {
            Toast.makeText(getActivity(),"专业不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(StuPhone.trim().equals("")) {
            Toast.makeText(getActivity(),"联系方式不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(StuQq.trim().equals("")) {
            Toast.makeText(getActivity(),"QQ号不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(StuAddress.trim().equals("")) {
            Toast.makeText(getActivity(),"地址不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}