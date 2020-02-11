package com.example.mytry32.ui.share;

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
import com.example.mytry32.bean.User;
import com.example.mytry32.using;
import com.example.mytry32.util.UserDbHelper;

import java.util.LinkedList;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    TextView tvStuNumber;
    EditText etOriginPwd,etNewPwd,etConfirmPwd;
    String name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);

        name = using.userid;
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvStuNumber = getView().findViewById(R.id.tv_stu_number);
        tvStuNumber.setText(name);
        etOriginPwd = getView().findViewById(R.id.et_original_pwd);
        etNewPwd = getView().findViewById(R.id.et_new_pwd);
        etConfirmPwd =getView().findViewById(R.id.et_confirm_new_pwd);
        Button btnModify = getView().findViewById(R.id.btn_modify_pwd);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //首先保证输入合法
                if(CheckInput()) {
                    String stuNumber = tvStuNumber.getText().toString();
                    UserDbHelper dbHelper = new UserDbHelper(getContext(),UserDbHelper.DB_NAME,null,1);
                    LinkedList<User> users = dbHelper.readUsers();
                    for(User user : users) {
                        //首先找到用户名
                        if(user.getUsername().equals(stuNumber)) {
                            if(!etOriginPwd.getText().toString().equals(user.getPassword())) {
                                //提示初始密码输入错误
                                Toast.makeText(getContext(),"初始密码输入错误!",Toast.LENGTH_SHORT).show();
                            }else {
                                //执行修改密码操作
                                user.setPassword(etNewPwd.getText().toString());
                                boolean flag = dbHelper.updateUser(tvStuNumber.getText().toString(),etNewPwd.getText().toString());
                                if(flag) {
                                    Toast.makeText(getContext(),"修改密码成功!",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getContext(),"修改密码失败!",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public boolean CheckInput() {
        String OriginalPwd = etOriginPwd.getText().toString();
        String NewPwd = etNewPwd.getText().toString();
        String NewConfirmPwd = etConfirmPwd.getText().toString();
        if(OriginalPwd.trim().equals("")) {
            Toast.makeText(getActivity(),"原始密码不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(NewPwd.trim().equals("")) {
            Toast.makeText(getActivity(),"新密码不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(NewConfirmPwd.trim().equals("")) {
            Toast.makeText(getActivity(),"确认新密码不能为空!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!NewPwd.trim().equals(NewConfirmPwd.trim())) {
            Toast.makeText(getActivity(),"两次密码输入不一致!",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}