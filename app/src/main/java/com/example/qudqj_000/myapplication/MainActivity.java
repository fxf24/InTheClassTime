package com.example.qudqj_000.myapplication;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        program();
    }

    void program(){
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.general_toast:
                Toast.makeText(this, "일반 메세지 창입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_toast:
                Toast toastView = Toast.makeText(this,"위치 지정 메세지 창입니다.", Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.LEFT|Gravity.TOP, 10, 20);
                toastView.show();
                break;
            case R.id.custom_toast:
                custom_toast();
                break;
            case R.id.snackbar:
                Snackbar.make(v,"스낵바입니다.", 1000).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
            case R.id.general_dialog:
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);

                dlg.setTitle("제목")
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "확인을 눌렀습니다.", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
            case R.id.radio_dialog:
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(this);

                String data[] = {"치킨", "피자"};
                dlg1.setTitle("제목")
                        .setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "확인을 눌렀습니다.", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
            case R.id.checkbox_dialog:
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(this);

                final String data1[] = {"치킨", "피자", "짜장", "탕슉"};
                final boolean checked[] = {true, false, true, false};

                dlg2.setTitle("먹고싶은 메뉴는?")
                        .setMultiChoiceItems(data1, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String s="";
                                for(int i =0; i<data1.length;i++){
                                    if(checked[i]==true){
                                        s+=", " + data1[i];
                                    }
                                }
                                Toast.makeText(getApplicationContext(), s.substring(1), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
            case R.id.custom_dialog:
                View view = getLayoutInflater().inflate(R.layout.dialog1, null);
                final EditText et = (EditText)view.findViewById(R.id.data);

                AlertDialog.Builder dlg3 = new AlertDialog.Builder(this);
                dlg3.setTitle("먹고싶은 메뉴는?")
                        .setView(view)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),et.getText().toString() + "입니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
        }
    }

    void custom_toast(){
        View view = getLayoutInflater().inflate(R.layout.mytoast, null);

        TextView msg = (TextView)view.findViewById(R.id.msg);
        msg.setText("레이아웃으로 만든 토스트 창입니다.");

        Toast toast = new Toast(this);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,100);
        toast.setView(view);
        toast.show();
    }

}
