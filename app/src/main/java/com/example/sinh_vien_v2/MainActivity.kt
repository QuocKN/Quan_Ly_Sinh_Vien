package com.example.sinh_vien_v2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val studentList = mutableListOf<Student>()
    private lateinit var studentAdapter: StudentAdapter
    private val ADD_STUDENT_REQUEST = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Danh sách sinh viên"
        val recyclerView = findViewById<RecyclerView>(R.id.list_students)
        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add_student) {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, ADD_STUDENT_REQUEST)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_STUDENT_REQUEST && resultCode == RESULT_OK) {
            val name = data?.getStringExtra("student_name") ?: return
            val mssv = data.getStringExtra("student_mssv") ?: return

            // Thêm sinh viên vào danh sách
//            studentList.add(Student(name, mssv))
            studentAdapter.addStudent(Student(name, mssv))
            // Cập nhật RecyclerView
            studentAdapter.notifyDataSetChanged()
        }
    }
}
