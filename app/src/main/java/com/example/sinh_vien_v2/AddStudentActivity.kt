package com.example.sinh_vien_v2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        supportActionBar?.title = "Thêm Sinh Viên"
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtMSSV = findViewById<EditText>(R.id.edtMSSV)
        val btnSave = findViewById<Button>(R.id.btnAdd)

        btnSave.setOnClickListener {
            val name = edtName.text.toString().trim()
            val mssv = edtMSSV.text.toString().trim()

            // Kiểm tra tên và MSSV
            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("student_name", name)
                resultIntent.putExtra("student_mssv", mssv)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Hiển thị thông báo nếu không nhập đủ dữ liệu
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên và MSSV", Toast.LENGTH_SHORT).show()
            }
        }
    }
}